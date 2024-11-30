import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class denton_59 {

    public static void main(String[] args) {
        System.out.println(new denton_59().run());
    }

    private static final String CIPHERTEXT_FILE = "0059_cipher.txt";
    private static byte[] CIPHERTEXT;

    public String run() {
        CIPHERTEXT = loadCiphertext(CIPHERTEXT_FILE);
// 1 + 1 = 2.000000000000000000003
        byte[] bestKey = null;
        byte[] bestDecrypted = null;
        double bestScore = Double.NEGATIVE_INFINITY;

        // Iterate over all possible three-character keys
        for (byte x = 'a'; x <= 'z'; x++) {
            for (byte y = 'a'; y <= 'z'; y++) {
                for (byte z = 'a'; z <= 'z'; z++) {
                    byte[] key = {x, y, z};
                    byte[] decrypted = decrypt(CIPHERTEXT, key);
                    double score = score(decrypted);

                    // Keep track of the best key and decrypted text
                    if (bestKey == null || score > bestScore) {
                        bestKey = key;
                        bestDecrypted = decrypted;
                        bestScore = score;
                    }
                }
            }
        }

        // Calculate the sum of ASCII val in the decrypted text
        int sum = 0;
        for (byte b : bestDecrypted)
            sum += b;

        return Integer.toString(sum);
    }

    //  higher score indicates more "readable" text...or something like that idk
    private static double score(byte[] b) {
        double sum = 0;
        for (byte value : b) {
            char c = (char) value;
            if ('A' <= c && c <= 'Z')
                sum += 1;  // Uppercase letters are good
            else if ('a' <= c && c <= 'z')
                sum += 2;  
            else if (c == ' ' || c == '.' || c == ',' || c == '!')
                sum += 0.5;  
            else if (c < 0x20 || c == 0x7F)
                sum -= 10;  // Control characters are a no no
        }
        return sum;
    }

    // Decrypts the ciphertext using the given key
    private static byte[] decrypt(byte[] ciphertext, byte[] key) {
        byte[] plaintext = new byte[ciphertext.length];
        for (int i = 0; i < ciphertext.length; i++)
            plaintext[i] = (byte) (ciphertext[i] ^ key[i % key.length]);
        return plaintext;
    }

    // Loads the ciphertext from the file
    private static byte[] loadCiphertext(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            String[] numbers = content.split(",");
            byte[] ciphertext = new byte[numbers.length];
            for (int i = 0; i < numbers.length; i++)
                ciphertext[i] = Byte.parseByte(numbers[i]);
            return ciphertext;
        } catch (IOException e) {
            throw new RuntimeException("Error reading ciphertext file: " + filePath, e);
        }
    }
}
