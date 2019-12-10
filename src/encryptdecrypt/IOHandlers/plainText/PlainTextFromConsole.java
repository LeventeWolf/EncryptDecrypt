package encryptdecrypt.IOHandlers.plainText;

import encryptdecrypt.IOHandlers.ArgumentHandler;

public class PlainTextFromConsole implements PlainTextMethod {

    @Override
    public String getPlainText(String[] args) {
        ArgumentHandler argHandler = new ArgumentHandler(args);
        return argHandler.getData();
    }
}
