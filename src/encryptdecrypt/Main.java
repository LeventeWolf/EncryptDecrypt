package encryptdecrypt;

import encryptdecrypt.IOHandlers.ArgumentHandler;
import encryptdecrypt.cryptography.CipherMachine;

public class Main {
    public static void main(String[] args) {
        ArgumentHandler argHandler = new ArgumentHandler(args);
        CipherMachine cipherMachine = new CipherMachine(argHandler);
        cipherMachine.doCryptography();
    }
}