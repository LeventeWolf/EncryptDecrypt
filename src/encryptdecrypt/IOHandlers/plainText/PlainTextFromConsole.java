package encryptdecrypt.IOHandlers.plainText;

import encryptdecrypt.IOHandlers.ArgumentHandler;

public class PlainTextFromConsole extends PlainTextMethod {
    PlainTextFromConsole(ArgumentHandler argumentHandler) {
        super(argumentHandler);
    }

    @Override
    public String getPlainText() {
        return argumentHandler.getData();
    }
}
