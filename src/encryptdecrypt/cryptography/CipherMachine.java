package encryptdecrypt.cryptography;

import encryptdecrypt.IOHandlers.ArgumentHandler;
import encryptdecrypt.IOHandlers.OutPutHandler;
import encryptdecrypt.cryptography.decryptionAlgorithms.ShiftDecryptionAlgorithm;
import encryptdecrypt.cryptography.decryptionAlgorithms.UnicodeDecryptionAlgorithm;
import encryptdecrypt.cryptography.encryptionAlgorithms.ShiftEncryptionAlgorithm;
import encryptdecrypt.cryptography.encryptionAlgorithms.UnicodeEncryptionAlgorithm;
import encryptdecrypt.exceptions.WrongArgumentException;
import encryptdecrypt.plainText.PlainTextHandler;

public class CipherMachine {
    private ArgumentHandler argHandler;
    private PlainTextHandler plainTextHandler;
    private CryptographAlgorithm cryptographAlgorithm;

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

    public CipherMachine(ArgumentHandler argumentHandler) {
        this.argHandler = argumentHandler;
        setPlainTextHandler();
    }

    public void doCryptography() {
        String plainText = plainTextHandler.getPlainText();
        String cipherText = cipherText(plainText);
        OutPutCipherText(cipherText);
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

    private void setPlainTextHandler() {
        plainTextHandler = new PlainTextHandler(argHandler.getArgs());
        plainTextHandler.setPlainTextMethod();
    }

    //TODO make OutPutHandler a Strategy Pattern
    private void OutPutCipherText(String cipherText) {
        String destination = argHandler.getOutPutFileName();
        if (!destination.equals("")) {
            OutPutHandler.writeToFile(destination, cipherText);
        } else {
            OutPutHandler.writeToConsole(cipherText);
        }
    }
}
