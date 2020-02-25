/*
 * Evan Robertson
 * February 24 2020
 * SimpleEncryption.java
 * This program is able to do a simple cipher shifting and encrypt/decrypt based 
 * on user input
 */

package simpleencryption;
import javax.swing.JOptionPane;
/**
 *
 * @author Evan
 */
public class SimpleEncryption {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Let user decide in encryption or decryption
        String action = JOptionPane.showInputDialog("1: Encrypt \n 2: Decrypt");
        String encrypted = "";
        String decrypted = "";
        
        //For encryption:
        if (Integer.parseInt(action) == 1) {
            //Get word to encrypt
            String plainText = JOptionPane.showInputDialog("Enter word to be encrypted");
            //Set to all caps
            plainText = plainText.toUpperCase();
            encrypted = "";
            //create an array to have every integer value of the chars stored in
            int[] newArr = new int[plainText.length()];
            //Get the shift
            String rotationAmount = JOptionPane.showInputDialog("Enter the shift amount");
            
            //Check if rotation is suitable
            if (Integer.parseInt(rotationAmount) >= 1 && Integer.parseInt(rotationAmount) <=25) {
                //Loop for re creating the string as an array of numbers
                for (int i = 0; i < plainText.length(); i++) {
                    if (65 <= (int)plainText.charAt(i) && (int)plainText.charAt(i) <= 90) {
                        //Shift said numbers rotationAmount number of times
                        newArr[i] = (int)plainText.charAt(i) + Integer.parseInt(rotationAmount);
                    }
                    //If its greater than lower case z, loop back to a
                    if (newArr[i] > 90){
                        newArr[i] -= 26;
                    }
                    //rewrite as new string
                    encrypted += (char)newArr[i];
                }
                //Output box
                JOptionPane.showMessageDialog(null, "Your encrypted message is: \n" 
                            + encrypted);
            }
            else {
                //fallback
                JOptionPane.showMessageDialog(null, "Enter a valid number");
                System.exit(0);
            }
        }
        //For decryption:
        else if (Integer.parseInt(action) == 2) {
            //Get word to be decrypted
            String encryptedText = JOptionPane.showInputDialog("Enter word to be decrypted");
            //Set to caps
            encryptedText = encryptedText.toUpperCase();
            //create a new array to store all numerical values
            int[] newArr = new int[encryptedText.length()];
            //Get shift amount for decryption
            String rotationAmount = JOptionPane.showInputDialog("Enter the shift amount");
            //Check if the shift is valid
            if (Integer.parseInt(rotationAmount) >= 1 && Integer.parseInt(rotationAmount) <=25) {
                //Loop to reverse the effects of a shift
                for (int i = 0; i < encryptedText.length(); i++) {
                    if (65 <= (int)encryptedText.charAt(i) && (int)encryptedText.charAt(i) <= 90) {
                        //Subtacrtion this time to reverse any potential shift
                        newArr[i] = (int)encryptedText.charAt(i) - Integer.parseInt(rotationAmount);
                    }
                    // If its less than a loop back to z
                    if (newArr[i] < 65){
                        newArr[i] += 26;
                    }
                    //rewrite as new string
                    decrypted += (char)newArr[i];
                }
                //Output box
                JOptionPane.showMessageDialog(null, "Your decrypted message is: \n" 
                            + decrypted);
            }
            //fallback
            else {
                JOptionPane.showMessageDialog(null, "Enter a valid number");
                System.exit(0);
            }
            
        }
        //fallback
        else {
            JOptionPane.showMessageDialog(null, "Enter a valid number");
            System.exit(0);
        }
    }
    
}
