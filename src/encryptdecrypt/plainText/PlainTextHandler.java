package encryptdecrypt.plainText;

import encryptdecrypt.IOHandlers.ArgumentHandler;

public class PlainTextHandler {
    private PlainTextMethod plainTextMethod;
    private String[] args;

    public PlainTextHandler(String[] args) {
        this.args = args;
    }

    public String getPlainText() {
        return plainTextMethod.getPlainText(args);
    }

    public void setPlainTextMethod() {
        ArgumentHandler argHandler = new ArgumentHandler(args);
        String in = argHandler.getInputFileName();
        String data = argHandler.getData();

        if (!data.equals("")) {
            plainTextMethod = new PlainTextFromConsole();
        } else if (!in.equals("")) {
            plainTextMethod = new PlainTextFromFile();
        } else {
            //TODO throw exception
        }
    }

}
