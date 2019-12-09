package encryptdecrypt.cryptography;

public interface CryptographAlgorithm {
    String cryptograph(String rawText, int key);
}
