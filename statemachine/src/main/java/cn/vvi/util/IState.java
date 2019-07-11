package cn.vvi.util;

public interface IState<State extends Enum<State> & IState<State>> {
    public State getDefaultState();
}
