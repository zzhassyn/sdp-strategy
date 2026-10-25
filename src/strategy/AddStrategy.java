package strategy;

public class AddStrategy implements OperationStrategy {

    @Override
    public double execute(double a, double b) {
        return a + b;
    }
}
