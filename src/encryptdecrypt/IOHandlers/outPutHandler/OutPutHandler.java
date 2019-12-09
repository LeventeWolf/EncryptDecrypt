package encryptdecrypt.IOHandlers.outPutHandler;

import encryptdecrypt.IOHandlers.ArgumentHandler;

public class OutPutHandler {
    private OutPutMethod outPutMethod;
    private ArgumentHandler argHandler;

    public OutPutHandler(ArgumentHandler argHandler) {
        this.argHandler = argHandler;
    }

    private void setOutPutMethod() {
        String fileName = argHandler.getOutPutFileName();

        //if fileName is not given OutPutToConsole
        //if fileName is given OutPutToFile
        if (fileName.equals("")) {
            outPutMethod = new OutPutToConsole();
        } else {
            outPutMethod = new OutPutToFile(fileName);
        }
    }

    public void outPutCipherText(String cipherText) {
        setOutPutMethod();
        outPutMethod.outPut(cipherText);
    }
}
