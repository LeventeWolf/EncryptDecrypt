package encryptdecrypt.IOHandlers.outPut;

import encryptdecrypt.IOHandlers.ArgumentHandler;

import java.util.HashMap;

public class OutPutHandler {
    private HashMap<String, OutPutMethod> map = new HashMap<>();
    private OutPutMethod outPutMethod;
    private ArgumentHandler argHandler;

    public OutPutHandler(ArgumentHandler argHandler) {
        this.argHandler = argHandler;
        setMap();
        setOutPutMethod();
    }

    public void setOutPutMethod() {
        outPutMethod = map.get(argHandler.getOutPutMode());
    }

    public void outPutCipherText(String cipherText) {
        outPutMethod.outPut(cipherText);
    }

    private void setMap() {
        map.put("console", new OutPutToConsole());
        map.put("file", new OutPutToFile(argHandler.getOutPutFileName()));
    }

    public OutPutMethod getOutPutMethod() {
        return outPutMethod;
    }
}
