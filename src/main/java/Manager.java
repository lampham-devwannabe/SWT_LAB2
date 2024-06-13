/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author lamph
 */
public class Manager {
    Validator val = new Validator();

    public void displayMenu() {
        System.out.println("\n===== Calculator Program =====");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
    }

    enum Operator {
        ADD("+"),
        SUB("-"),
        MULTIPLY("*"),
        DIVISION("/"),
        EXPONENT("^"),
        EQUALS("=");

        private final String symbol;

        private Operator(String symbol) {
            this.symbol = symbol;
        }

        public static Operator checkOp(String symbol) {
            for (Operator op : values()) {
                if (op.symbol.equals(symbol)) {
                    return op;
                }
            }
            return null; // invalid op
        }
    }

    enum BMI {
        UNDER_STANDARD("Under-standard"),
        STANDARD("Standard"),
        OVERWEIGHT("Overweight"),
        SHOULD_LOSE_WEIGHT("Fat - should lose weight"),
        SHOULD_LOSE_WEIGHT_IMMEDIATELY("Very fat - should lose weight immediately");
        private final String status;
        BMI(String status) {
            this.status = status;
        }
    }


    public void calculate(String msg) {
        double memory;
        memory = val.checkDouble("Enter number: ");
        while (true) {
            try {
                String inputOp = val.checkString("Enter an operation (+, -, * ,/, ^, =): ");
                Operator check = Operator.checkOp(inputOp);
                switch (check) {
                    case ADD -> {
                        memory += val.inputNumber();
                        System.out.println("Memory: " + memory);
                    }
                    case SUB -> {
                        memory -= val.inputNumber();
                        System.out.println("Memory: " + memory);
                    }
                    case MULTIPLY -> {
                        memory *= val.inputNumber();
                        System.out.println("Memory: " + memory);
                    }
                    case DIVISION -> {
                        double divisor = val.inputNumber();
                        if (divisor == 0) {
                            throw new ArithmeticException();
                        }
                        memory /= divisor;
                        System.out.println("Memory: " + memory);
                    }
                    case EXPONENT -> {
                        memory = Math.pow(memory, val.inputNumber());
                        System.out.println("Memory: " + memory);
                    }
                    case EQUALS -> {
                        System.out.println("Result: " + memory);
                        return;
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("Must be digit.");
            } catch (NullPointerException e) {
                System.err.println("Invalid operator.");
            } catch (ArithmeticException e) {
                System.err.println("Cannot divide by zero");
            }
        }
    }

    public void calculateBMI(String msg) {
        try {
            double weight = val.checkDouble("Enter weight (kg): ");
            if (weight <= 0) {
                throw new NumberFormatException();
            }
            double height = val.checkDouble("Enter height (cm): ");
            if (height <= 0) {
                throw new NumberFormatException();
            }
            double bmi = (weight * 10000) / (height * height);
            System.out.println("Your BMI is: " + String.format("%.2f", bmi));
            if (bmi < 19) {
                System.out.println("BMI Status: " + BMI.UNDER_STANDARD.status);
            } else if (bmi >= 19 && bmi <= 25) {
                System.out.println("BMI Status: " + BMI.STANDARD.status);
            } else if (bmi > 25 && bmi <= 30) {
                System.out.println("BMI Status: " + BMI.OVERWEIGHT);
            } else if (bmi > 30 && bmi <= 40) {
                System.out.println("BMI Status: " + BMI.SHOULD_LOSE_WEIGHT);
            } else {
                System.out.println("BMI Status: " + BMI.SHOULD_LOSE_WEIGHT_IMMEDIATELY.status);
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid input");
        }

    }
}
