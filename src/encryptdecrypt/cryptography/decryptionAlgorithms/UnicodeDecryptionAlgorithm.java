package encryptdecrypt.cryptography.decryptionAlgorithms;

import encryptdecrypt.cryptography.CryptographAlgorithm;

public class UnicodeDecryptionAlgorithm implements CryptographAlgorithm {

    @Override
    public String cryptograph(String plainText, int key) {
        return decrypt(plainText, key);
    }

    private String decrypt(String plainText, int key) {
        StringBuilder cipherText = new StringBuilder();
        char letter;
        char shiftedLetter;

        for (int i = 0; i < plainText.length(); i++) {
            letter = plainText.charAt(i);
            shiftedLetter = shiftLetter(letter, key, '-');
            cipherText.append(shiftedLetter);
        }

        return cipherText.toString();
    }

    private static char shiftLetter(char letter, int key, char sign) {
        if (sign == '+')
            return (char) ((int) letter + key);
        else
            return (char) ((int) letter - key);
    }
}
