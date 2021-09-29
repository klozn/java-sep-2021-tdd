package advanced.codelab02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    Customer customer= new Customer("test");

    @Test
    void gainPoints_TotalPointsIncreased() {
        customer.gainPoints(4);
        customer.gainPoints(5);
        customer.gainPoints(1);
        assertEquals(10, customer.totalPoints());
    }

    @Test
    void gainPoints_whenNegativeAmount_trowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> customer.gainPoints(-1));
    }
}