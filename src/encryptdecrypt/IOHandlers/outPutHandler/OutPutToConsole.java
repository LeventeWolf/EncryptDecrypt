package encryptdecrypt.IOHandlers.outPutHandler;

public class OutPutToConsole implements OutPutMethod {
    public void outPut(String cipherText) {
        System.out.println(cipherText);
    }
}
