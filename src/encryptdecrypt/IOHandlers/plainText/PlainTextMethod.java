package encryptdecrypt.IOHandlers.plainText;

import encryptdecrypt.IOHandlers.ArgumentHandler;

abstract class PlainTextMethod {
    ArgumentHandler argumentHandler;

    PlainTextMethod(ArgumentHandler argumentHandler) {
        this.argumentHandler = argumentHandler;
    }

    abstract String getPlainText();
}
