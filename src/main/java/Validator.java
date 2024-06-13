import java.util.Scanner;

/**
 * @author LamPT
 * @created 6/11/2024
 */
public class Validator {
    private static final Scanner sc = new Scanner(System.in);

    public int checkInt(String msg, int min, int max) {
        while (true) {
            try {
                System.out.print(msg);
                int input = Integer.parseInt(sc.nextLine());
                if (input < min || input > max) {
                    throw new NumberFormatException();
                }
                return input;
            } catch (NumberFormatException e) {
                System.err.println("Please enter an integer from " + min + " to " + max);
            }

        }
    }

    public String checkString(String msg) {
        while (true) {
            System.out.print(msg);
            String raw = sc.nextLine();
            if (raw == null || raw.length() == 0) {
                System.err.println("Input must not be empty.");
                continue;
            }
            return raw;
        }
    }

    public double checkDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                double input = Double.parseDouble(sc.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.err.println("Please enter a double.");
            }
        }
    }

    public double inputNumber() {
        double number = checkDouble("Enter number: ");
        return number;
    }
}
