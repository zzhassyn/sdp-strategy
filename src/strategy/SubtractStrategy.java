package strategy;

public class SubtractStrategy implements OperationStrategy {

    @Override
    public double execute(double a, double b) {
        return a - b;
    }
}
