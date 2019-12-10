package encryptdecrypt.CipherMachineTests;

import encryptdecrypt.IOHandlers.ArgumentHandler;
import encryptdecrypt.cryptography.CipherMachine;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class CipherMachineTest {
    private String[] args;
    private ArgumentHandler argHandler;
    private CipherMachine cipherMachine;

    @Test
    void Should_OutPut_To_Console() {
        args = new String[]{"-mode", "enc", "-key", "5",
                "-data", "Welcome to hyperskill!", "-alg", "shift"};

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        cipherMachine.doCryptography();

        assertEquals("Bjqhtrj yt mdujwxpnqq!\r\n", outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    void Should_OutPut_To_File() {
        args = new String[]{"-mode", "enc", "-key", "5",
                "-data", "Welcome to hyperskill!",
                "-alg", "shift",
                "-out", "outPutFileTest.txt"};
        argHandler = new ArgumentHandler(args);
        cipherMachine = new CipherMachine(argHandler);
        cipherMachine.doCryptography();
        File file = new File(argHandler.getOutPutFileName());
        Scanner sc = new Scanner(file);

        if (!file.exists()) fail("File was not created.");
        assertEquals("Bjqhtrj yt mdujwxpnqq!", sc.nextLine());
    }
}