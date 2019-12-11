package encryptdecrypt.IOHandlers.plainText;

import encryptdecrypt.IOHandlers.ArgumentHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PlainTextFromFile implements PlainTextMethod {
    @Override
    public String getPlainText(String[] args) {
        return getPlainTextFromFile(args);
    }

    private String getPlainTextFromFile(String[] args) {
        ArgumentHandler argHandler = new ArgumentHandler(args);
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
