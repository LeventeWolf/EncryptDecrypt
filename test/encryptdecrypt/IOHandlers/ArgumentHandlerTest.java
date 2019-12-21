package encryptdecrypt.IOHandlers;

import encryptdecrypt.exceptions.ArgumentNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ArgumentHandlerTest {

    @Test
    void Should_Set_ArgumentMap_With_Given_Arguments() {
        String[] args = {"-mode", "enc", "-key", "5",
                "-data", "Welcome to hyperskill!", "-alg", "shift"};

        ArgumentHandler argHandler = new ArgumentHandler(args);

        HashMap<String, String> actual = argHandler.getArgumentMap();
        HashMap<String, String> expected = new HashMap<>();

        expected.put("-mode", "enc");
        expected.put("-key", "5");
        expected.put("-data", "Welcome to hyperskill!");
        expected.put("-alg", "shift");

        assertEquals(expected, actual);
    }

    //getInPutModeTests
    @Test
    void getInPutMode_Should_Throw_Exception() {
        String[] args = {"-mode", "enc", "-key", "5",
                 "-alg", "shift"};

        ArgumentHandler argHandler = new ArgumentHandler(args);
        
        try {
            argHandler.getInPutMode();
            fail("Should throw an exception if one or more of given numbers are negative");
        } catch (Exception e) {
            assertThat(e)
                    .isInstanceOf(ArgumentNotFoundException.class)
                    .hasMessage("Argument not found: -data or -in");
        }
    }

    @Test
    void getInPutMode_Should_Return_Console() {
        String[] args = {"-mode", "enc", "-key", "5",
                "-data", "Welcome to hyperskill!", "-alg", "shift"};

        ArgumentHandler argHandler = new ArgumentHandler(args);

        String actual = argHandler.getInPutMode();

        assertEquals("console", actual);
    }

    @Test
    void getInPutMode_Should_Return_File() {
        String[] args = {"-mode", "enc", "-key", "5",
                "-in", "protected.txt", "-alg", "shift"};

        ArgumentHandler argHandler = new ArgumentHandler(args);

        String actual = argHandler.getInPutMode();

        assertEquals("file", actual);
    }

    @Test
    void getInPutMode_Should_Prefer_Console_Over_File() {
        String[] args = {"-mode", "enc", "-key", "5",
                "-data", "Welcome to Hyperskill!",
                "-in", "protected.txt"};

        ArgumentHandler argHandler = new ArgumentHandler(args);

        String actual = argHandler.getInPutMode();

        assertEquals("console", actual);
    }

    //getOutPutModeTests
    @Test
    void getOutPutMode_Should_Return_Console() {
        String[] args = {"-mode", "enc", "-key", "5",
                "-data", "Welcome to Hyperskill!", "-alg", "shift"};

        ArgumentHandler argHandler = new ArgumentHandler(args);

        String actual = argHandler.getOutPutMode();

        assertEquals("console", actual);
    }

    @Test
    void getOutPutMode_Should_Return_File() {
        String[] args = {"-mode", "enc", "-key", "5",
                "-out", "protected.txt", "-alg", "shift"};

        ArgumentHandler argHandler = new ArgumentHandler(args);

        String actual = argHandler.getOutPutMode();

        assertEquals("file", actual);
    }
}