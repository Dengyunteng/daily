package cn.vvi.util;

import java.util.HashMap;
import java.util.Map;

public abstract class StateMachine<State extends Enum<State> & IState<State>, Parameter extends IParameter, Handler extends IStateHandler<State, Parameter>> {
    private Map<State, Handler> stateHandlerMap = new HashMap<>();
    private Map<State, State> allowMoveMap = new HashMap<>();
    private IMoveToState<State> moveToState = new IMoveToState<State>() {
        @Override
        public boolean moveToState(State state) {
            return true;
        }
    };
}
