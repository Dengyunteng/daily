package cn.vvi.util;

public interface IMoveToState<State extends Enum<State> & IState<State>> {
    public boolean moveToState(State state);
}
