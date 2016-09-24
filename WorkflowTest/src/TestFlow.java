/**
 * Created by hhjuliet on 2016/9/23.
 */
public class TestFlow {
	public static int i=0;

	public static void main(String[] args) {
		new SimpleFlowChain() {
			@Override
			void setup() {
				addFlow(new Flow() {
					@Override
					public void run(FlowTrigger trigger){
						System.out.println("i am running "+i);
						i++;
						trigger.next();
					}

					@Override
					public void rollback(FlowRollback trigger) {
						System.out.println("i am rollbacking "+i);
						i--;
						trigger.rollback();
					}
				});

				addFlow(new Flow() {
					@Override
					public void run(FlowTrigger trigger){
						System.out.println("i am running "+i);
						i++;
						trigger.next();
					}

					@Override
					public void rollback(FlowRollback trigger) {
						System.out.println("i am rollbacking "+i);
						i--;
						trigger.rollback();
					}
				});

				addFlow(new Flow() {
					@Override
					public void run(FlowTrigger trigger){
						System.out.println("i am running "+i);

						trigger.fail(3);
					}

					@Override
					public void rollback(FlowRollback trigger) {
						System.out.println("i am rollbacking "+i);
						i--;
						trigger.rollback();
					}
				});
			}
			@Override
			void done(){
				System.out.println("done!");
			}

		}.start();
	}

}
