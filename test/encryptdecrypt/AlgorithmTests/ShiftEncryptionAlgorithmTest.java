package encryptdecrypt.AlgorithmTests;

import encryptdecrypt.cryptography.CryptographAlgorithm;
import encryptdecrypt.cryptography.encryptionAlgorithms.ShiftEncryptionAlgorithm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShiftEncryptionAlgorithmTest {
    private CryptographAlgorithm cryptographAlgorithm = new ShiftEncryptionAlgorithm();

    @Test
    void testShiftEncryptionAlgorithm() {
        int key = 5;
        String encryptedText = "Welcome to hyperskill!";
        String actual = cryptographAlgorithm.cryptograph(encryptedText, key);
        assertEquals("Bjqhtrj yt mdujwxpnqq!", actual);
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