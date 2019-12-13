package encryptdecrypt.IOHandlers.outPut;

public class OutPutToConsole implements OutPutMethod {
    public void outPut(String cipherText) {
        System.out.println(cipherText);
    }
}
