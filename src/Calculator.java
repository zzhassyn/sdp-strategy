import strategy.OperationStrategy;

import java.util.Objects;

public class Calculator {

    private OperationStrategy strategy;

    public Calculator(OperationStrategy strategy) {
        setStrategy(strategy);
    }

    public void setStrategy(OperationStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy, "Operation strategy must not be null");
    }

    public double calculate(double a, double b) {
        return strategy.execute(a, b);
    }
}
