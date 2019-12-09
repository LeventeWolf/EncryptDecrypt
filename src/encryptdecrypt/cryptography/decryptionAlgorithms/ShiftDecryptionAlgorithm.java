package encryptdecrypt.cryptography.decryptionAlgorithms;

import encryptdecrypt.cryptography.CryptographAlgorithm;

public class ShiftDecryptionAlgorithm implements CryptographAlgorithm {
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
            shiftedLetter = shiftLetter(letter, key);
            cipherText.append(shiftedLetter);
        }

        return cipherText.toString();
    }

    private char shiftLetter(char letter, int key) {
        char[] abc = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        if (Character.isLetter(letter)) {
            int index = find(abc, Character.toLowerCase(letter)) - key;
            while (index < 0) index += abc.length;
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
