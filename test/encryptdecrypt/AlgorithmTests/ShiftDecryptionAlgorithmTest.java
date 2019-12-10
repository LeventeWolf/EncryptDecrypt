package encryptdecrypt.AlgorithmTests;

import encryptdecrypt.cryptography.CryptographAlgorithm;
import encryptdecrypt.cryptography.decryptionAlgorithms.ShiftDecryptionAlgorithm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShiftDecryptionAlgorithmTest {
    private CryptographAlgorithm cryptographAlgorithm = new ShiftDecryptionAlgorithm();

    @Test
    void testShiftDecryptionAlgorithm() {
        int key = 5;
        String encryptedText = "Bjqhtrj yt mdujwxpnqq!";
        String actual = cryptographAlgorithm.cryptograph(encryptedText, key);
        assertEquals("Welcome to hyperskill!", actual);
    }

    @Test
    void testIfKeyIsZero() {
        int key = 0;
        String encryptedText = "shouldBeThis";
        String actual = cryptographAlgorithm.cryptograph(encryptedText, key);
        assertEquals("shouldBeThis", actual);
    }

    @Test
    void testEmptyString() {
        int key = 5;
        String actual = cryptographAlgorithm.cryptograph("", key);
        assertEquals("", actual);
    }
}