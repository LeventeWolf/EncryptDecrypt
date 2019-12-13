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
        File file = new File("src\\resource\\" + argumentHandler.getInputFileName());

        String cipherText = "";
        try (Scanner sc = new Scanner(file)) {
            cipherText = sc.nextLine();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + argumentHandler.getInputFileName());
        }

        return cipherText;
    }
}
