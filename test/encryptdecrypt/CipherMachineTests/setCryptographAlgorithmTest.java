package encryptdecrypt.CipherMachineTests;

import encryptdecrypt.IOHandlers.ArgumentHandler;
import encryptdecrypt.cryptography.CipherMachine;
import encryptdecrypt.cryptography.decryptionAlgorithms.ShiftDecryptionAlgorithm;
import encryptdecrypt.cryptography.decryptionAlgorithms.UnicodeDecryptionAlgorithm;
import encryptdecrypt.cryptography.encryptionAlgorithms.ShiftEncryptionAlgorithm;
import encryptdecrypt.cryptography.encryptionAlgorithms.UnicodeEncryptionAlgorithm;
import encryptdecrypt.exceptions.WrongArgumentException;
import manifold.ext.api.Jailbreak;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class setCryptographAlgorithmTest {
    private String[] args = {"-mode", "en", "-alg", "enc"};
    private ArgumentHandler argumentHandler = new ArgumentHandler(args);
    @Jailbreak
    private CipherMachine cipherMachine = new CipherMachine(argumentHandler);

    @Test
    void setCryptographAlgorithm_ThrowsWrongArgumentException_IfInvalidMode() {
        try {
            cipherMachine.setCryptographAlgorithm();
        } catch (WrongArgumentException e) {
            return;
        }
        fail("Exception wasn't threw");
    }

    @Test
    void Should_SetCryptographAlgorithm_To_ShiftEncryptionAlgorithm() {
        String[] args = {"-mode", "enc", "-alg", "shift"};
        ArgumentHandler argumentHandler = new ArgumentHandler(args);
        @Jailbreak
        CipherMachine cipherMachine = new CipherMachine(argumentHandler);

        cipherMachine.setCryptographAlgorithm();

        assertTrue(cipherMachine.cryptographAlgorithm instanceof ShiftEncryptionAlgorithm);
    }

    @Test
    void Should_SetCryptographAlgorithm_To_UnicodeEncryptionAlgorithm() {
        String[] args = {"-mode", "enc", "-alg", "unicode"};
        ArgumentHandler argumentHandler = new ArgumentHandler(args);
        @Jailbreak
        CipherMachine cipherMachine = new CipherMachine(argumentHandler);

        cipherMachine.setCryptographAlgorithm();

        assertTrue(cipherMachine.cryptographAlgorithm instanceof UnicodeEncryptionAlgorithm);
    }

    @Test
    void Should_SetCryptographAlgorithm_To_ShiftDecryptionAlgorithm() {
        String[] args = {"-mode", "dec", "-alg", "shift"};
        ArgumentHandler argumentHandler = new ArgumentHandler(args);
        @Jailbreak
        CipherMachine cipherMachine = new CipherMachine(argumentHandler);

        cipherMachine.setCryptographAlgorithm();

        assertTrue(cipherMachine.cryptographAlgorithm instanceof ShiftDecryptionAlgorithm);
    }

    @Test
    void Should_SetCryptographAlgorithm_To_UnicodeDecryptionAlgorithm() {
        String[] args = {"-mode", "dec", "-alg", "unicode"};
        ArgumentHandler argumentHandler = new ArgumentHandler(args);
        @Jailbreak
        CipherMachine cipherMachine = new CipherMachine(argumentHandler);

        cipherMachine.setCryptographAlgorithm();

        assertTrue(cipherMachine.cryptographAlgorithm instanceof UnicodeDecryptionAlgorithm);
    }



}