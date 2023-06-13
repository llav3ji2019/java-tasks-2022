package code.homework4.generics.hadler;

import code.homework4.generics.state.ExampleState;
import code.homework4.generics.state.State;

public class ExampleStateHandler<T extends State> implements StateHandler<ExampleState> {

    @Override
    public void handle() {
        // do nothing
    }

    /**
     * Поправить в соответствии с изменениями в StateHandler
     * <p>
     * 1 тугрик
     */
    @Override
    public Class<ExampleState> getHandlingStateClass() {
        return ExampleState.class;
    }
}
