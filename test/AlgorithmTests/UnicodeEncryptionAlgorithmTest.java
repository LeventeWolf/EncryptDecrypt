package AlgorithmTests;

import encryptdecrypt.cryptography.CryptographAlgorithm;
import encryptdecrypt.cryptography.encryptionAlgorithms.UnicodeEncryptionAlgorithm;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class UnicodeEncryptionAlgorithmTest {
    private CryptographAlgorithm cryptographAlgorithm = new UnicodeEncryptionAlgorithm();

    @Test
    void testShiftDecryptionAlgorithm() {
        int key = 5;
        String encryptedText = "Welcome to hyperskill!";
        String actual = cryptographAlgorithm.cryptograph(encryptedText, key);
        assertEquals("\\jqhtrj%yt%m~ujwxpnqq&", actual);
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