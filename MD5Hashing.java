import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MD5Hashing {
    public static void main(String[] args) {
        try{
            // Prompt the user for input
            System.out.println("Enter the string to hash: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            // Instance the MessageDigest object for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());
            byte[] digest = md.digest();
            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            // Print the MD5 hash
            System.out.println("MD5 hash: " + hexString.toString());
            // Print the length of the hash
            System.out.println("Length of the hash: " + hexString.length());
            // Print the hash in hexadecimal format
            System.out.print("Hash in hexadecimal format: ");
            for (byte b : digest) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) {
                    System.out.print('0');
                }

                System.out.print(hex);
            }



        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }




}
