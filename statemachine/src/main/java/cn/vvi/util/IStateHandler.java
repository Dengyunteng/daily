package cn.vvi.util;

public interface IStateHandler<State extends Enum<State> & IState<State>, Parameter extends IParameter> {
    public State getHandleState();
    public void handleState(Parameter p);
    public void setMoveToState(IMoveToState<State> moveToState);
}
