package encryptdecrypt.IOHandlers.plainText;

import encryptdecrypt.IOHandlers.ArgumentHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlainTextHandlerTest {
    private PlainTextHandler plainTextHandler;

    private void setPlainTextHandler(String[] args) {
        plainTextHandler = new PlainTextHandler(new ArgumentHandler(args));
        plainTextHandler.setPlainTextMethod();
    }

    @Test
    void Should_Set_plainTextMethod_To_PlainTextFromConsole_If_Only_One_Mode_Is_Given() {
        String[] args = {
                "-data", "Welcome to hyperskill!"};

        setPlainTextHandler(args);

        PlainTextMethod actual = plainTextHandler.getPlainTextMethod();

        assertTrue(actual instanceof PlainTextFromConsole);
    }

    @Test
    void Should_Set_plainTextMethod_To_PlainTextFromConsole_Over_PlainTextFromConsole() {
        String[] args = {
                "-data", "Welcome to hyperskill!",
                "-in", "textFromFile.txt"};
        setPlainTextHandler(args);

        PlainTextMethod actual = plainTextHandler.getPlainTextMethod();

        assertTrue(actual instanceof PlainTextFromConsole);
    }

    @Test
    void Should_Set_plainTextMethod_To_PlainTextFromFile() {
        String[] args = {
                "-in", "Welcome to hyperskill!"};
        setPlainTextHandler(args);

        PlainTextMethod actual = plainTextHandler.getPlainTextMethod();

        assertTrue(actual instanceof PlainTextFromFile);
    }
}