package encryptdecrypt.IOHandlers.plainText;

import encryptdecrypt.IOHandlers.ArgumentHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PlainTextFromFile extends PlainTextMethod {
    PlainTextFromFile(ArgumentHandler argumentHandler) {
        super(argumentHandler);
    }

    @Override
    public String getPlainText() {
        return getPlainTextFromFile();
    }

    private String getPlainTextFromFile() {
        ArgumentHandler argHandler = argumentHandler;
        File file = new File("src\\resource\\" + argHandler.getInputFileName());

        String cipherText = "";
        try (Scanner sc = new Scanner(file)) {
            cipherText = sc.nextLine();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + argHandler.getInputFileName());
        }

        return cipherText;
    }
}
