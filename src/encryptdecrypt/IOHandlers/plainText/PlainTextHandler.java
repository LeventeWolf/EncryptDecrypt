package encryptdecrypt.IOHandlers.plainText;

import encryptdecrypt.IOHandlers.ArgumentHandler;

public class PlainTextHandler {
    private PlainTextMethod plainTextMethod;
    private ArgumentHandler argHandler;

    public PlainTextHandler(ArgumentHandler argHandler) {
        this.argHandler = argHandler;
    }

    public String getPlainText() {
        return plainTextMethod.getPlainText();
    }

    public void setPlainTextMethod() {
        String in = argHandler.getInputFileName();
        String data = argHandler.getData();

        if (!data.equals("")) {
            plainTextMethod = new PlainTextFromConsole(argHandler);
        } else if (!in.equals("")) {
            plainTextMethod = new PlainTextFromFile(argHandler);
        } else {
            //TODO throw exception
        }
    }

}
