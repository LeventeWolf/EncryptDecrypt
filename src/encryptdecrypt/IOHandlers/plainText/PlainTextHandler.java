package encryptdecrypt.IOHandlers.plainText;

import encryptdecrypt.IOHandlers.ArgumentHandler;

import java.util.HashMap;

public class PlainTextHandler {
    HashMap<String, PlainTextMethod> map = new HashMap<>();
    private PlainTextMethod plainTextMethod;
    private ArgumentHandler argHandler;


    public PlainTextHandler(ArgumentHandler argHandler) {
        this.argHandler = argHandler;
        setMap();
        setPlainTextMethod();
    }

    public String getPlainText() {
        return plainTextMethod.getPlainText();
    }

    public void setPlainTextMethod() {
        String inputMode = argHandler.getInPutMode();

        plainTextMethod = map.get(inputMode);
    }

    private void setMap() {
        map.put("console", new PlainTextFromConsole(argHandler));
        map.put("file", new PlainTextFromFile(argHandler));
    }

    public PlainTextMethod getPlainTextMethod() {
        return plainTextMethod;
    }
}
