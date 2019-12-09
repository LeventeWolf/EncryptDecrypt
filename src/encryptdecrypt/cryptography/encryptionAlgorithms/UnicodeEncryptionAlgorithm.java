package encryptdecrypt.cryptography.encryptionAlgorithms;

import encryptdecrypt.cryptography.CryptographAlgorithm;

public class UnicodeEncryptionAlgorithm implements CryptographAlgorithm {
    @Override
    public String cryptograph(String plainText, int key) {
        return encrypt(plainText, key);
    }

    private String encrypt(String plainText, int key) {
        StringBuilder cipherText = new StringBuilder();
        char letter;
        char shiftedLetter;

        for (int i = 0; i < plainText.length(); i++) {
            letter = plainText.charAt(i);
            shiftedLetter = shiftLetter(letter, key, '+');
            cipherText.append(shiftedLetter);
        }

        return cipherText.toString();
    }

    private char shiftLetter(char letter, int key, char sign) {
        if (sign == '+')
            return (char) ((int) letter + key);
        else if (sign == '-')
            return (char) ((int) letter - key);
        else {
            //TODO Throw exception
            return 0;
        }
    }
}
