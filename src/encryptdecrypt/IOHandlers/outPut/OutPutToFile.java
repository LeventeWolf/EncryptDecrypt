package encryptdecrypt.IOHandlers.outPut;

import java.io.FileWriter;
import java.io.IOException;

public class OutPutToFile implements OutPutMethod {
    String fileName;

    public OutPutToFile(String fileName) {
        this.fileName = fileName;
    }

    public void outPut(String cipherText) {
        try (FileWriter fileWriter = new FileWriter("src\\resource\\" + fileName)) {
            fileWriter.write(cipherText);
        } catch (IOException e) {
            System.out.println("Can't make " + fileName + " file.");
        }
    }
}
