package advanced;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ArraysCodelab08Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private String[] namesDatabase;
    private boolean[] rentDatabase;


    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        namesDatabase = new String[]{"Marc", "Sophie", "Jef", "Laura", "Michal"};
        rentDatabase = new boolean[]{true, true, false, false, true};
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void printOutTenantStatusWillPrintOutNameAndHasPaidRentWhenRentHasBeenPaid() {
        ArraysCodelab08.printOutTenantStatus(2, namesDatabase, rentDatabase);

        Assertions.assertThat(outContent.toString().trim()).isEqualTo("Sophie has paid his/her rent.");
    }

    @Test
    void printOutTenantStatusWillPrintOutNameAndHasNotPaidRentWhenRentHasBeenPaid() {
        ArraysCodelab08.printOutTenantStatus(3, namesDatabase, rentDatabase);

        Assertions.assertThat(outContent.toString().trim()).isEqualTo("Jef has not paid his/her rent.");
    }

    @Test
    void printOutTenantStatusWillPrintOutApartmentDoesntExistWhenNumberIsOutOfBounds() {
        ArraysCodelab08.printOutTenantStatus(-1, namesDatabase, rentDatabase);
        ArraysCodelab08.printOutTenantStatus(10, namesDatabase, rentDatabase);

        Assertions.assertThat(outContent.toString().trim()).isEqualTo("Apartment -1 does not exist.\r\nApartment 10 does not exist.");
    }
}
