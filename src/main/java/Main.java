/**
 * @author lamph
 */
public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Validator val = new Validator();
        while (true) {
            manager.displayMenu();
            int choice = val.checkInt("\nPlease choose one option: ", 1, 3);
            switch (choice) {
                case 1:
                    manager.calculate("----- Normal Calculator -----");
                    break;
                case 2:
                    manager.calculateBMI("----- BMI Calculator -----");
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid input.");
            }
        }
    }
}
