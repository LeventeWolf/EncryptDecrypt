package encryptdecrypt.IOHandlers.outPut;

import encryptdecrypt.IOHandlers.ArgumentHandler;
import encryptdecrypt.IOHandlers.plainText.PlainTextFromConsole;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutPutHandlerTest {
    private OutPutHandler OutPutHandler;

    private void setOutPutHandler(String[] args) {
        OutPutHandler = new OutPutHandler(new ArgumentHandler(args));
        OutPutHandler.setOutPutMethod();
    }

    @Test
    void Should_Set_OutPutMethod_To_OutPutToFile() {
        String[] args = {
                "-out", "sampleFileName.txt"};

        setOutPutHandler(args);

        OutPutMethod actual = OutPutHandler.getOutPutMethod();

        assertTrue(actual instanceof OutPutToFile);
    }

    @Test
    void Should_Set_OutPutMethod_To_OutPutToConsole() {
        String[] args = {"-mode", "enc", "-key", "5",
                "-data", "Welcome to hyperskill!",
                "-alg", "shift"};
        setOutPutHandler(args);

        OutPutMethod actual = OutPutHandler.getOutPutMethod();

        assertTrue(actual instanceof OutPutToConsole);
    }
}