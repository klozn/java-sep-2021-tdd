package basic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class MethodsCodelab12Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void willPrintOutSeveralTemperatureConversions() {
        MethodsCodelab12.main(null);
        assertThat(outContent.toString()).isEqualToNormalizingNewlines("""
                ***********************
                Hi my name is Jef
                I am 33 years old.
                Which means I am
                an adult
                ***********************
                Hi my name is Sofie
                I am 16 years old.
                Which means I am
                not an adult
                """);
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }
}
