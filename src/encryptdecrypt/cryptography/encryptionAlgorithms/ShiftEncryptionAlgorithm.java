package encryptdecrypt.cryptography.encryptionAlgorithms;

import encryptdecrypt.cryptography.CryptographAlgorithm;

public class ShiftEncryptionAlgorithm implements CryptographAlgorithm {

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
            shiftedLetter = shiftLetter(letter, key);
            cipherText.append(shiftedLetter);
        }

        return cipherText.toString();
    }

    private char shiftLetter(char letter, int key) {
        char[] abc = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        if (Character.isLetter(letter)) {
            int index = find(abc, Character.toLowerCase(letter)) + key;
            while (index > abc.length) index -= abc.length;
            return  Character.isLowerCase(letter) ? abc[index] : Character.toUpperCase(abc[index]);
        } else {
            return letter;
        }
    }

    private int find(char[] charArray, char c) {
        for (int j = 0; j < charArray.length; j++)
            if (charArray[j] == c) return j;
        return -1;
    }
}
