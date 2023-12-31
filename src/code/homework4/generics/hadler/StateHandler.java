package code.homework4.generics.hadler;

import code.homework4.generics.state.State;

/**
 * Интерфейс должен быть типизирован, в качестве типа должен быть обрабатываемый тип State
 * <p>
 * 1 тугрик за типизацию интерфейса и 1 тугрик за типизацию метода
 */
public interface StateHandler<T extends State> {
    void handle();

    /**
     * Возвращает класс State, который этот handler умеет обрабатывать.
     * Необходимо типизировать таким образом, чтобы возвращаемый класс был не любым, а наследником State.
     */
    Class<T> getHandlingStateClass();
}
