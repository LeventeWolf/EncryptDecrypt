package encryptdecrypt.cryptography;

import encryptdecrypt.IOHandlers.ArgumentHandler;
import encryptdecrypt.IOHandlers.outPut.OutPutHandler;
import encryptdecrypt.cryptography.decryptionAlgorithms.ShiftDecryptionAlgorithm;
import encryptdecrypt.cryptography.decryptionAlgorithms.UnicodeDecryptionAlgorithm;
import encryptdecrypt.cryptography.encryptionAlgorithms.ShiftEncryptionAlgorithm;
import encryptdecrypt.cryptography.encryptionAlgorithms.UnicodeEncryptionAlgorithm;
import encryptdecrypt.IOHandlers.plainText.PlainTextHandler;

import java.util.HashMap;

public class CipherMachine {
    private CryptographAlgorithm cryptographAlgorithm;
    private ArgumentHandler argHandler;
    private PlainTextHandler plainTextHandler;
    private OutPutHandler outPutHandler;
    private HashMap<String, CryptographAlgorithm> algorithmMap = new HashMap<>();

    public CipherMachine(ArgumentHandler argumentHandler) {
        this.argHandler = argumentHandler;
        setPlainTextHandler();
        setAlgorithmMap();

        outPutHandler = new OutPutHandler(argumentHandler);
    }

    private void setPlainTextHandler() {
        plainTextHandler = new PlainTextHandler(argHandler);
        plainTextHandler.setPlainTextMethod();
    }

    private void setAlgorithmMap() {
        algorithmMap.put("shiftenc", new ShiftEncryptionAlgorithm());
        algorithmMap.put("shiftdec", new ShiftDecryptionAlgorithm());
        algorithmMap.put("unicodeenc", new UnicodeEncryptionAlgorithm());
        algorithmMap.put("unicodedec", new UnicodeDecryptionAlgorithm());
    }

    private void setCryptographAlgorithm() {
        String algorithmMode = argHandler.getAlgorithm() + argHandler.getMode();

        cryptographAlgorithm = algorithmMap.get(algorithmMode);
    }

    private String cipherText(String plainText) {
        setCryptographAlgorithm();

        return cryptographAlgorithm.cryptograph(plainText, argHandler.getKey());
    }

    public void doCryptography() {
        String plainText = plainTextHandler.getPlainText();
        String cipherText = cipherText(plainText);
        outPutHandler.outPutCipherText(cipherText);
    }
}
