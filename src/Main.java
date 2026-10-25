import strategy.AddStrategy;
import strategy.DivideStrategy;
import strategy.MultiplyStrategy;
import strategy.SubtractStrategy;

public class Main {

    public static void main(String[] args) {
        double a = 12;
        double b = 4;

        Calculator calculator = new Calculator(new AddStrategy());
        System.out.printf("%.2f + %.2f = %.2f%n", a, b, calculator.calculate(a, b));

        calculator.setStrategy(new SubtractStrategy());
        System.out.printf("%.2f - %.2f = %.2f%n", a, b, calculator.calculate(a, b));

        calculator.setStrategy(new MultiplyStrategy());
        System.out.printf("%.2f * %.2f = %.2f%n", a, b, calculator.calculate(a, b));

        calculator.setStrategy(new DivideStrategy());
        System.out.printf("%.2f / %.2f = %.2f%n", a, b, calculator.calculate(a, b));

        try {
            calculator.calculate(a, 0);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
