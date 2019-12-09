package encryptdecrypt.cryptography;

import encryptdecrypt.IOHandlers.ArgumentHandler;
import encryptdecrypt.IOHandlers.outPutHandler.OutPutHandler;
import encryptdecrypt.cryptography.decryptionAlgorithms.ShiftDecryptionAlgorithm;
import encryptdecrypt.cryptography.decryptionAlgorithms.UnicodeDecryptionAlgorithm;
import encryptdecrypt.cryptography.encryptionAlgorithms.ShiftEncryptionAlgorithm;
import encryptdecrypt.cryptography.encryptionAlgorithms.UnicodeEncryptionAlgorithm;
import encryptdecrypt.exceptions.WrongArgumentException;
import encryptdecrypt.plainText.PlainTextHandler;

public class CipherMachine {
    private CryptographAlgorithm cryptographAlgorithm;
    private ArgumentHandler argHandler;
    private PlainTextHandler plainTextHandler;
    private OutPutHandler outPutHandler;

    public CipherMachine(ArgumentHandler argumentHandler) {
        this.argHandler = argumentHandler;
        setPlainTextHandler();

        outPutHandler = new OutPutHandler(argumentHandler);
    }

    private void setPlainTextHandler() {
        plainTextHandler = new PlainTextHandler(argHandler.getArgs());
        plainTextHandler.setPlainTextMethod();
    }

    private void setCryptographAlgorithm() throws WrongArgumentException {
        String algorithm = argHandler.getAlgorithm();

        switch (argHandler.getMode()) {
            case "enc":
                switch (algorithm) {
                    case "shift" -> cryptographAlgorithm = new ShiftEncryptionAlgorithm();

                    case "unicode" -> cryptographAlgorithm = new UnicodeEncryptionAlgorithm();
                }
                break;
            case "dec":
                switch (algorithm) {
                    case "shift" -> cryptographAlgorithm = new ShiftDecryptionAlgorithm();

                    case "unicode" -> cryptographAlgorithm = new UnicodeDecryptionAlgorithm();
                }
                break;
            default:
                throw new WrongArgumentException("Invalid mode: " + argHandler.getMode());
        }
    }

    private String cipherText(String plainText) {
        try {
            setCryptographAlgorithm();
        } catch (WrongArgumentException e) {
            System.out.println(e.getMessage());
            return "";
        }

        return cryptographAlgorithm.cryptograph(plainText, argHandler.getKey());

    }

    public void doCryptography() {
        String plainText = plainTextHandler.getPlainText();
        String cipherText = cipherText(plainText);
        outPutHandler.outPutCipherText(cipherText);
    }
}
