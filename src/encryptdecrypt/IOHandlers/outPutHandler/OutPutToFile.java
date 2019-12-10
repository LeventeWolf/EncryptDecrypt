package encryptdecrypt.IOHandlers.outPutHandler;

import java.io.FileWriter;
import java.io.IOException;

public class OutPutToFile implements OutPutMethod {
    String fileName;

    public OutPutToFile(String fileName) {
        this.fileName = fileName;
    }

    //TODO outPut file to resource folder
    public void outPut(String cipherText) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(cipherText);
        } catch (IOException e) {
            System.out.println("Can't make " + fileName + " file.");
        }
    }
}
