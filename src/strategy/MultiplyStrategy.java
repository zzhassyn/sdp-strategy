package strategy;

public class MultiplyStrategy implements OperationStrategy {

    @Override
    public double execute(double a, double b) {
        return a * b;
    }
}
