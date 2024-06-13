import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author LamPT
 * @created 6/11/2024
 */
public class Algorithm {

    public boolean kiemTraSoLe(int number) {
        return number % 2 != 0;
    }

    public int tongHaiSoNguyen(int num1, int num2) {
        return num1 + num2;
    }

    public int hieuHaiSoNguyen(int num1, int num2) {
        return num1 - num2;
    }

    public int chiaHaiSoNguyen(int num1, int num2) {
        return num1 / num2;
    }

    public int nhanHaiSoNguyen(int num1, int num2) {
        return num1 * num2;
    }

    public int chiaLayDuHaiSoNguyen(int num1, int num2) {
        return num1 % num2;
    }

    public boolean kiemTraSoChan(int number) {
        return number % 2 == 0;
    }

    public String sayHello(String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }
        return "Hello, " + name;
    }

    public boolean kiemTraPalindrome(int number) {
        if (number < 0) {
            return false; // Negative numbers are not considered palindromes
        }
        int reversed = 0;
        int original = number;
        while (number != 0) {
            int lastDigit = number % 10;
            reversed = reversed * 10 + lastDigit;
            number /= 10;
        }
        return original == reversed;
    }

    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int fib = 1;
        int prevFib = 1;

        for (int i = 2; i < n; ++i) {
            int temp = fib;
            fib += prevFib;
            prevFib = temp;
        }

        return fib;
    }

    public boolean kiemTraNamNhuan(int year) {
        // A leap year is divisible by 4 but not by 100, unless it is also divisible by 400.
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public boolean kiemTraChuoiDoiXung(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false; // Characters do not match
            }
            i++;
            j--;
        }
        return true; // All characters matched, it's a palindrome
    }

    public int tinhTongSoLe(int upto) {
        int sum = 0;
        for (int number = 1; number <= upto; number++) {
            if (kiemTraSoLe(number)) {
                sum += number;
            }
        }
        return sum;
    }

    public int tinhTongSoChan(int upto) {
        int sum = 0;
        for (int i = 0; i <= upto; i++) {
            if (kiemTraSoChan(i)) {
                sum += i;
            }
        }
        return sum;
    }

    public boolean kiemTraSoChinhPhuong(int number) {
        if (number < 0) {
            return false; // Negative numbers cannot be perfect squares
        }
        int sqrt = (int) Math.sqrt(number);
        return sqrt * sqrt == number;
    }

    public int timUocChungLonNhat(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int timBoiChungNhoNhat(int a, int b) {
        return a * (b / timUocChungLonNhat(a, b));
    }

    public int tinhTongTu0(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += i;
        }
        return sum;
    }

    public int daoNguocSo(int number) {
        int reversed = 0;
        while (number != 0) {
            int lastDigit = number % 10;
            reversed = reversed * 10 + lastDigit;
            number /= 10;
        }
        return reversed;
    }

    public long tinhGiaiThua(int number) {
        long result = 1;
        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }
        return result;
    }

    public boolean kiemTraTuoi(Date birthDate, int age) {
        Calendar today = Calendar.getInstance();
        Calendar birthDay = Calendar.getInstance();
        birthDay.setTime(birthDate);
        birthDay.add(Calendar.YEAR, age);
        return !birthDay.after(today);
    }

    public boolean kiemTraDoDaiString(String input, int min, int max) {
        if (input == null) {
            return false; // Null string does not meet any length requirements
        }
        int length = input.length();
        return length >= min && length <= max;
    }

    public boolean kiemTraSoNguyenTo(int number) {
        if (number <= 1) {
            return false; // 0 and 1 are not prime numbers
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false; // Number is divisible by another number, so not prime
            }
        }
        return true; // Number is prime
    }

    public void solveQuadraticEquation(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;
        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.print(root1 + " " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.print(root);
        } else {
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
            System.out.print(realPart + " + " + imaginaryPart + "i ");
            System.out.print(realPart + " - " + imaginaryPart + "i");
        }
    }

    public String getOutput(Runnable method) {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            method.run();
        } finally {
            System.setOut(originalOut);
        }

        return outContent.toString().trim();
    }

    private static final DecimalFormat df = new DecimalFormat("#.##");

    public void solveQuarticEquation(double a, double b, double c) {
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.print("Phương trình có vô số nghiệm.");
                } else {
                    System.out.print("Phương trình vô nghiệm.");
                }
            } else {
                double root = -c / b;
                if (root < 0) {
                    System.out.print("Phương trình có 2 nghiệm phức phân biệt: x1 = " + df.format(Math.sqrt(-root)) + "i, x2 = " + df.format(-Math.sqrt(-root)) + "i");
                } else {
                    double x1 = Math.sqrt(root);
                    double x2 = -Math.sqrt(root);
                    System.out.print("Phương trình có hai nghiệm phân biệt: x1 = " + df.format(x1) + ", x2 = " + df.format(x2));
                }
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                System.out.print("Phương trình có 4 nghiệm phức phân biệt: ");
                double realPart = -b / (2 * a);
                double imaginaryPart = Math.sqrt(-delta) / (2 * a);
                System.out.print("x1 = " + df.format(realPart) + " + " + df.format(imaginaryPart) + "i ");
                System.out.print("x2 = " + df.format(realPart) + " - " + df.format(imaginaryPart) + "i ");
                System.out.print("x3 = " + df.format(realPart) + " + " + df.format(imaginaryPart) + "i ");
                System.out.print("x4 = " + df.format(realPart) + " - " + df.format(imaginaryPart) + "i ");
            } else if (delta == 0) {
                double root = -b / (2 * a);
                if (root < 0) {
                    System.out.print("Phương trình có 2 nghiệm phức phân biệt: x1 = " + df.format(Math.sqrt(-root)) + "i, x2 = " + df.format(-Math.sqrt(-root)) + "i");
                } else if (root == 0) {
                    System.out.print("Phương trình có nghiệm kép: x = 0");
                } else {
                    double x1 = Math.sqrt(root);
                    double x2 = -Math.sqrt(root);
                    System.out.print("Phương trình có hai nghiệm kép: x1 = " + df.format(x1) + ", x2 = " + df.format(x2));
                }
            } else {
                double sqrtDelta = Math.sqrt(delta);
                double root1 = (-b + sqrtDelta) / (2 * a);
                double root2 = (-b - sqrtDelta) / (2 * a);
                List<String> roots = new ArrayList<>();
                if (root1 >= 0) {
                    roots.add("x1 = " + df.format(Math.sqrt(root1)));
                    roots.add("x2 = " + df.format(-Math.sqrt(root1)));
                } else {
                    roots.add("x1 = " + df.format(Math.sqrt(-root1)) + "i");
                    roots.add("x2 = " + df.format(-Math.sqrt(-root1)) + "i");
                }
                if (root2 >= 0) {
                    roots.add("x3 = " + df.format(Math.sqrt(root2)));
                    roots.add("x4 = " + df.format(-Math.sqrt(root2)));
                } else {
                    roots.add("x3 = " + df.format(Math.sqrt(-root2)) + "i");
                    roots.add("x4 = " + df.format(-Math.sqrt(-root2)) + "i");
                }
                System.out.print("Phương trình có các nghiệm: ");
                for (String root : roots) {
                    System.out.print(root + " ");
                }
            }
        }
    }
}
