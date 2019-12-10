package encryptdecrypt.AlgorithmTests;

import encryptdecrypt.cryptography.CryptographAlgorithm;
import encryptdecrypt.cryptography.decryptionAlgorithms.UnicodeDecryptionAlgorithm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnicodeDecryptionAlgorithmTest {
    private CryptographAlgorithm cryptographAlgorithm = new UnicodeDecryptionAlgorithm();

    @Test
    void testShiftDecryptionAlgorithm() {
        int key = 5;
        String encryptedText = "\\jqhtrj%yt%m~ujwxpnqq&";
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