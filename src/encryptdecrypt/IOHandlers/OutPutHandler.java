package encryptdecrypt.IOHandlers;

import java.io.FileWriter;
import java.io.IOException;


public class OutPutHandler {
    public static void writeToFile(String fileName, String text) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToConsole(String text) {
        System.out.println(text);
    }
}
