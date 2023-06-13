package code.homework4.generics;

import code.homework4.generics.hadler.StateHandler;
import code.homework4.generics.state.State;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bot {
    private final Map<Class<? extends State>, StateHandler<? extends State>> dictionaryForHandlers;

    /**
     * Конструктор бота, которому на вход подаются хэндлеры состояний.
     * Необходимо как-то сохранить эти хэндлеры так, чтобы потом можно было вызвать нужный хэндлер из метода handleState
     * <p>
     * 1 тугрик
     */
    public Bot(List<StateHandler<State>> handlers) {
        dictionaryForHandlers = new HashMap<>();
        for (StateHandler<? extends State> handler : handlers) {
            dictionaryForHandlers.put(handler.getHandlingStateClass(), handler);
        }
    }

    /**
     * Вызывает хэндлер, предназначенный для переданного State
     * <p>
     * 1 тугрик
     */
    public void handleState(State state) {
        dictionaryForHandlers.get(state.getClass()).handle();
    }
}
