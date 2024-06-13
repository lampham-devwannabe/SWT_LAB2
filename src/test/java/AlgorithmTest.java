import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
        assertFalse(alg.kiemTraSoLe(2));
        assertTrue(alg.kiemTraSoLe(1));
    }

    @Test
    void test_kiemTraSoChan_1() {
        assertTrue(alg.kiemTraSoChan(4));
        assertFalse(alg.kiemTraSoChan(3));
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
    void test_chiaHaiSoNguyen() {
        assertEquals(0, alg.chiaHaiSoNguyen(0, 5));
        assertEquals(1, alg.chiaHaiSoNguyen(8, 8));
        assertEquals(-5, alg.chiaHaiSoNguyen(10, -2));
        assertEquals(3, alg.chiaHaiSoNguyen(7, 2));
        assertEquals(5, alg.chiaHaiSoNguyen(10, 2));
        assertThrows(ArithmeticException.class,
                () -> alg.chiaHaiSoNguyen(5, 0));
    }

    @Test
    void test_nhanHaiSoNguyen() {
        assertEquals(6, alg.nhanHaiSoNguyen(2, 3));
        assertEquals(7, alg.nhanHaiSoNguyen(7, 1));
        assertEquals(-7, alg.nhanHaiSoNguyen(-7, 1));
        assertEquals(0, alg.nhanHaiSoNguyen(0, 5));
        assertEquals(0, alg.nhanHaiSoNguyen(0, -5));
        assertEquals(-35, alg.nhanHaiSoNguyen(-7, 5));
    }

    @Test
    void test_chiaLayDuHaiSoNguyen() {
        assertEquals(0, alg.chiaLayDuHaiSoNguyen(0, 5));
        assertEquals(3, alg.chiaLayDuHaiSoNguyen(3, 10));
        assertEquals(1, alg.chiaLayDuHaiSoNguyen(10, 3));
    }

    @Test
    void test_fibonacci() {
        assertEquals(0, alg.fibonacci(0));
        assertEquals(1, alg.fibonacci(1));
        assertEquals(1, alg.fibonacci(2));
        assertEquals(55, alg.fibonacci(10));
    }

    @Test
    void test_kiemTraNamNhuan() {
        assertTrue(alg.kiemTraNamNhuan(1600));
        assertFalse(alg.kiemTraNamNhuan(1900));
        assertTrue(alg.kiemTraNamNhuan(2004));
        assertFalse(alg.kiemTraNamNhuan(2019));
    }

    @Test
    void test_kiemTraPalindrome() {
        assertTrue(alg.kiemTraPalindrome(121));
        assertFalse(alg.kiemTraPalindrome(123));
    }

    @Test
    void test_sayHello() {
        assertEquals("Hello, Lam", alg.sayHello("Lam"));
        assertNull(alg.sayHello(null));
    }

    @Test
    void test_kiemTraChuoiDoiXung() {
        assertTrue(alg.kiemTraChuoiDoiXung("owo"));
        assertFalse(alg.kiemTraChuoiDoiXung("awp"));
    }

    @Test
    void test_tinhTongSoLe() {
        assertEquals(16, alg.tinhTongSoLe(7));
        assertEquals(64, alg.tinhTongSoLe(15));
    }

    @Test
    void test_tinhTongTu0() {
        assertEquals(28, alg.tinhTongTu0(7));
        assertEquals(15, alg.tinhTongTu0(5));
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
        assertEquals(6, alg.timUocChungLonNhat(18, 30));
    }

    @Test
    void test_timBoiChungNhoNhat() {
        assertEquals(49, alg.timBoiChungNhoNhat(7, 49));
    }

    @Test
    void test_daoNguocSo() {
        assertEquals(321, alg.daoNguocSo(123));
    }

    @Test
    void test_tinhGiaiThua() {
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

    @ParameterizedTest
    @CsvSource({
            "1, -3, 2, '2.0 1.0'",
            "1, -2, 1, '1.0'",
            "1, 1, 1, '-0.5 + 0.8660254037844386i -0.5 - 0.8660254037844386i'"
    })
    void test_solveQuadraticEquation(double a, double b, double c, String expectedOutput) {
        Runnable method = () -> alg.solveQuadraticEquation(a, b, c);
        String actualOutput = alg.getOutput(method);
        assertEquals(expectedOutput, actualOutput);
    }

    @ParameterizedTest
    @CsvSource({
            "1, -3, 2, 'Phương trình có các nghiệm: x1 = 1.41 x2 = -1.41 x3 = 1 x4 = -1'",
            "0, 1, -1, 'Phương trình có hai nghiệm phân biệt: x1 = 1, x2 = -1'",
            "0, 0, 0, 'Phương trình có vô số nghiệm.'",
            "1, 2, 5, 'Phương trình có 4 nghiệm phức phân biệt: x1 = -1 + 2i x2 = -1 - 2i x3 = -1 + 2i x4 = -1 - 2i'",
            "1, 0, -1, 'Phương trình có các nghiệm: x1 = 1 x2 = -1 x3 = 1i x4 = -1i'",
            "1, 0, 0, 'Phương trình có nghiệm kép: x = 0'",
            "1, 4, 4, 'Phương trình có 2 nghiệm phức phân biệt: x1 = 1.41i, x2 = -1.41i'"
    })
    void test_solveQuarticEquation(double a, double b, double c, String expectedOutput) {
        Runnable method = () -> alg.solveBiQuadraticEquation(a, b, c);
        String actualOutput = alg.getOutput(method);
        assertEquals(expectedOutput, actualOutput);
    }
}