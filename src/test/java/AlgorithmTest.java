import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author LamPT
 * @created 6/11/2024
 */
class AlgorithmTest {
    Algorithm alg;

    @BeforeEach
    void setUp() {
        alg = new Algorithm();
    }

    @AfterEach
    void tearDown() {
        alg = null;
    }

    @Test
    void test_kiemTraSoLe_1() {
        assertTrue(alg.kiemTraSoLe(1));
    }

    @Test
    void test_kiemTraSoLe_2() {
        assertFalse(alg.kiemTraSoLe(2));
    }

    @Test
    void test_kiemTraSoChan_1() {
        assertFalse(alg.kiemTraSoChan(3));
    }

    @Test
    void test_kiemTraSoChan_2() {
        assertTrue(alg.kiemTraSoChan(4));
    }

    @Test
    void test_tongHaiSoNguyen_1() {
        assertEquals(3, alg.tongHaiSoNguyen(1, 2));
    }

    @Test
    void test_tongHaiSoNguyen_2() {
        assertEquals(3, alg.tongHaiSoNguyen(3, 0));
    }

    @Test
    void test_tongHaiSoNguyen_3() {
        assertEquals(0, alg.tongHaiSoNguyen(2, -2));
    }

    @Test
    void test_hieuHaiSoNguyen_1() {
        assertEquals(2, alg.hieuHaiSoNguyen(5, 3));
    }

    @Test
    void test_hieuHaiSoNguyen_2() {
        assertEquals(3, alg.hieuHaiSoNguyen(3, 0));
    }

    @Test
    void test_hieuHaiSoNguyen_3() {
        assertEquals(-1, alg.hieuHaiSoNguyen(6, 7));
    }

    @Test
    void test_hieuHaiSoNguyen_4() {
        assertEquals(4, alg.hieuHaiSoNguyen(2, -2));
    }

    @Test
    void test_chiaHaiSoNguyen_1() {
        assertEquals(5, alg.chiaHaiSoNguyen(10, 2));
    }

    @Test
    void test_chiaHaiSoNguyen_2() {
        assertEquals(0, alg.chiaHaiSoNguyen(0, 5));
    }

    @Test
    void test_chiaHaiSoNguyen_3() {
        assertEquals(1, alg.chiaHaiSoNguyen(8, 8));
    }

    @Test
    void test_chiaHaiSoNguyen_4() {
        assertEquals(-5, alg.chiaHaiSoNguyen(10, -2));
    }

    @Test
    void test_chiaHaiSoNguyen_5() {
        assertEquals(3, alg.chiaHaiSoNguyen(7, 2));
    }

    @Test
    void test_chiaHaiSoNguyen_6() {
        assertThrows(ArithmeticException.class,
                () -> alg.chiaHaiSoNguyen(5, 0));
    }

    @Test
    void test_nhanHaiSoNguyen_1() {
        assertEquals(6, alg.nhanHaiSoNguyen(2, 3));
        assertEquals(-35, alg.nhanHaiSoNguyen(-7, 5));
    }

    @Test
    void test_nhanHaiSoNguyen_2() {
        assertEquals(7, alg.nhanHaiSoNguyen(7, 1));
        assertEquals(-7, alg.nhanHaiSoNguyen(-7, 1));
    }

    @Test
    void test_nhanHaiSoNguyen_3() {
        assertEquals(0, alg.nhanHaiSoNguyen(0, 5));
        assertEquals(0, alg.nhanHaiSoNguyen(0, -5));
    }

    @Test
    void test_chiaLayDuHaiSoNguyen_1() {
        assertEquals(1, alg.chiaLayDuHaiSoNguyen(10, 3));
    }

    @Test
    void test_chiaLayDuHaiSoNguyen_2() {
        assertEquals(0, alg.chiaLayDuHaiSoNguyen(0, 5));
    }

    @Test
    void test_chiaLayDuHaiSoNguyen_3() {
        assertEquals(3, alg.chiaLayDuHaiSoNguyen(3, 10));
    }

    @Test
    void test_fibonacci_1() {
        assertEquals(0, alg.fibonacci(0));
        assertEquals(1, alg.fibonacci(1));
    }

    @Test
    void test_fibonacci_2() {
        assertEquals(1, alg.fibonacci(2));
        assertEquals(55, alg.fibonacci(10));
        assertEquals(6765, alg.fibonacci(20));
        assertEquals(832040, alg.fibonacci(30));
    }

    @Test
    void test_kiemTraNamNhuan_1() {
        assertTrue(alg.kiemTraNamNhuan(2004));
        assertTrue(alg.kiemTraNamNhuan(2016));
    }

    @Test
    void test_kiemTraNamNhuan_2() {
        assertFalse(alg.kiemTraNamNhuan(2019));
        assertFalse(alg.kiemTraNamNhuan(2021));
    }

    @Test
    void test_kiemTraNamNhuan_3() {
        assertFalse(alg.kiemTraNamNhuan(1900));
        assertFalse(alg.kiemTraNamNhuan(2100));
    }

    @Test
    void test_kiemTraNamNhuan_4() {
        assertTrue(alg.kiemTraNamNhuan(1600));
        assertTrue(alg.kiemTraNamNhuan(2000));
    }

    @Test
    void test_kiemTraPalindrome_1() {
        assertTrue(alg.kiemTraPalindrome(121));
    }

    @Test
    void test_kiemTraPalindrome_2() {
        assertFalse(alg.kiemTraPalindrome(123));
    }

    @Test
    void test_sayHello_1() {
        assertNull(alg.sayHello(null));
    }

    @Test
    void test_sayHello_2() {
        assertEquals("Hello, Lam", alg.sayHello("Lam"));
    }

    @Test
    void test_kiemTraChuoiDoiXung() {
        assertTrue(alg.kiemTraChuoiDoiXung("owo"));
    }

    @Test
    void test_tinhTongSoLe() {
        assertEquals(16, alg.tinhTongSoLe(7));
    }

    @Test
    void test_TinhTongSoChan() {
        assertEquals(20, alg.tinhTongSoChan(8));
    }

    @Test
    void test_kiemTraSoChinhPhuong() {
        assertTrue(alg.kiemTraSoChinhPhuong(49));
    }

    @Test
    void test_timUocChungLonNhat() {
        assertEquals(6, alg.timUocChungLonNhat(18,30));
    }

    @Test
    void test_timBoiChungNhoNhat() {
        assertEquals(49,alg.timBoiChungNhoNhat(7,49));
    }

    @Test
    void test_daoNguocSo() {
        assertEquals(321, alg.daoNguocSo(123));
    }

    @Test
    void test_TinhGiaiThua() {
        assertEquals(24, alg.tinhGiaiThua(4));
    }

    @Test
    void test_kiemTraDoDaiString() {
        assertTrue(alg.kiemTraDoDaiString("heroic", 1, 10));
    }

    @Test
    void test_kiemTraSoNguyenTo() {
        assertTrue(alg.kiemTraSoNguyenTo(53));
    }

    @Test
    void test_solveQuadraticEquation_1() {
        double a = 1;
        double b = -3;
        double c = 2;
        String expectedOutput = "2.0 1.0";
        Runnable method = () -> alg.solveQuadraticEquation(a, b, c);
        String actualOutput = alg.getOutput(method);
        System.out.println(expectedOutput + "\n" + actualOutput);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void test_solveQuadraticEquation_2() {
        double a = 1;
        double b = -2;
        double c = 1;
        String expectedOutput = "1.0";
        Runnable method = () -> alg.solveQuadraticEquation(a,b,c);
        String actualOutput = alg.getOutput(method);
        assertEquals(expectedOutput,actualOutput);
    }

    @Test
    void test_solveQuadraticEquation_3() {
        double a = 1;
        double b = 1;
        double c = 1;
        String expectedOutput = "-0.5 + 0.8660254037844386i -0.5 - 0.8660254037844386i";
        Runnable method = () -> alg.solveQuadraticEquation(a,b,c);
        String actualOutput = alg.getOutput(method);
        assertEquals(expectedOutput,actualOutput);
    }

    @ParameterizedTest
    @CsvSource({
            "1, -3, 2, 'Phương trình có các nghiệm: x1 = 1.41 x2 = -1.41 x3 = 1 x4 = -1'",
            "0, 1, -1, 'Phương trình có hai nghiệm phân biệt: x1 = 1, x2 = -1'",
            "0, 0, 0, 'Phương trình có vô số nghiệm.'",
            "1, 2, 5, 'Phương trình có 4 nghiệm phức phân biệt: x1 = -1 + 2i x2 = -1 - 2i x3 = -1 + 2i x4 = -1 - 2i'"
    })
    void test_solveBiquadraticEquation(double a, double b, double c, String expectedOutput) {
        Runnable method = () -> alg.solveBiquadraticEquation(a, b, c);
        String actualOutput = alg.getOutput(method);
        System.out.println("Actual Output:\n" + actualOutput);
        assertEquals(expectedOutput, actualOutput);
    }
}