package encryptdecrypt.plainText;

import encryptdecrypt.IOHandlers.ArgumentHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

public class PlainTextFromFile implements PlainTextMethod {
    private static String getCipherTextFromFile(String[] args) {
        ArgumentHandler argHandler = new ArgumentHandler(args);
        PlainTextFromFile main = new PlainTextFromFile();
        File file = main.getFileFromResources(argHandler.getInputFileName());

        String cipherText = "";
        try (Scanner sc = new Scanner(file)) {
            cipherText = sc.nextLine();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + argHandler.getInputFileName());
        }

        return cipherText;
    }

    @Override
    public String getPlainText(String[] args) {
        return getCipherTextFromFile(args);
    }

    private File getFileFromResources(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }

    }
}
