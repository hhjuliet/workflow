/**
 * Created by hhjuliet on 2016/9/23.
 */
interface FlowTrigger{
	void next();
	void fail(int errorCode);
}
