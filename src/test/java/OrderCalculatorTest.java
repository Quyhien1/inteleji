import org.example.OrderCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderCalculatorTest {
    static int count = 0;

    public OrderCalculatorTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        count = 0;
        System.out.println("starting test");
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("Test done " + count);
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
        count++;
        System.out.println("Done test " + count);
    }

    @Test
    public void testVIPCustomerWithSALE10Code() {
        OrderCalculator calculator = new OrderCalculator();
        double total =calculator.calculateTotalPrice(new double[]{100,200},"VIP",true,"SALE10");
        Assertions.assertEquals(210.0,total);
    }
    @Test
    public void testVIPCustomerWithWELCOME5Code() {
        OrderCalculator calculator = new OrderCalculator();
        double total =calculator.calculateTotalPrice(new double[]{100,200},"VIP",true,"WELCOME5");
        Assertions.assertEquals(225.0,total);
    }
    @Test
    public void testVIPCustomerWithNoDiscountCode() {
        OrderCalculator calculator = new OrderCalculator();
        double total =calculator.calculateTotalPrice(new double[]{100,200},"VIP",true,null);
        Assertions.assertEquals(240.0,total);
    }
    @Test
    public void testRegularCustomerWithSALE10Code() {
        OrderCalculator calculator = new OrderCalculator();
        double total =calculator.calculateTotalPrice(new double[]{100,200},"Regular",false,"SALE10");
        Assertions.assertEquals(255.0,total);
    }
    @Test
    public void testRegularCustomerWithWELCOME5Code() {
        OrderCalculator calculator = new OrderCalculator();
        double total =calculator.calculateTotalPrice(new double[]{100,200},"Regular",false,"WELCOME5");
        Assertions.assertEquals(270.0,total);
    }
    @Test
    public void testRegularCustomerWithNoDiscountCode() {
        OrderCalculator calculator = new OrderCalculator();
        double total =calculator.calculateTotalPrice(new double[]{100,200},"Regular",false,null);
        Assertions.assertEquals(285.0,total);
    }
    @Test
    public void testCustomerWithSALE10Code() {
        OrderCalculator calculator = new OrderCalculator();
        double total =calculator.calculateTotalPrice(new double[]{100,200},"",false,"SALE10");
        Assertions.assertEquals(270.0,total);
    }
    @Test
    public void testCustomerWithWELCOME5Code() {
        OrderCalculator calculator = new OrderCalculator();
        double total =calculator.calculateTotalPrice(new double[]{100,200},"",false,"WELCOME5");
        Assertions.assertEquals(285.0,total);
    }
    @Test
    public void testCustomerWithNoDiscountCode() {
        OrderCalculator calculator = new OrderCalculator();
        double total =calculator.calculateTotalPrice(new double[]{100,200},"",false,null);
        Assertions.assertEquals(300.0,total);
    }

    @Test
    public void exceptionTest() {
        OrderCalculator calculator = new OrderCalculator();
        double total =calculator.calculateTotalPrice(new double[]{0,200},"",false,null);
    Assertions.assertThrows(IllegalArgumentException()-> )
    }
}
