/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecttest;
import java.util.*;
/**
 *
 * @author kacpe
 */
public class ProjectTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        int[][] encrypt = {{0b1101, 0b0110}, {0b0001, 0b1011}};
        
        //int[][] encrypt2 = shiftRow(encrypt);
        //showArray(encrypt2);
        
        HashMap<Integer, Integer> normal = new HashMap<>();
        
        normal.put(0b0000, 0b1110);
        normal.put(0b0001, 0b0100);
        normal.put(0b0010, 0b1101);
        normal.put(0b0100, 0b0010);
        normal.put(0b0101, 0b1111);
        normal.put(0b0110, 0b1011);
        normal.put(0b0111, 0b1000);
        normal.put(0b1000, 0b0011);
        normal.put(0b1001, 0b1010);
        normal.put(0b1010, 0b0110);
        normal.put(0b1011, 0b1100);
        normal.put(0b1100, 0b0101);
        normal.put(0b1101, 0b1001);
        normal.put(0b1110, 0b0000);
        normal.put(0b1111, 0b0111);
        
        //outputMap(normal);
        
        HashMap<Integer, Integer> reversed = reverseHashMap(normal);
        
        //outputMap(reversed);
        showArray(encrypt);
        int[][] nS = nibbleSub(encrypt, normal);
        showArray(nS);
        int[][] iNS = nibbleSub(nS, reversed);
        showArray(iNS);
        
        outputMap(fillSubTable(true));
        outputMap(fillSubTable(false));
        */
        encryptWord();
    }
    
    public static int[][] shiftRow(int[][] nibbles) {
        int temp = nibbles[1][0];
        nibbles[1][0] = nibbles[1][1];
        nibbles[1][1] = temp;
        return nibbles;
    }
    
    public static void showArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    public static void showArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    public static HashMap<Integer, Integer> fillSubTable(boolean isInverse) {
        HashMap<Integer, Integer> normal = new HashMap<>();
        
        normal.put(0b0000, 0b1110);
        normal.put(0b0001, 0b0100);
        normal.put(0b0010, 0b1101);
        normal.put(0b0100, 0b0010);
        normal.put(0b0101, 0b1111);
        normal.put(0b0110, 0b1011);
        normal.put(0b0111, 0b1000);
        normal.put(0b1000, 0b0011);
        normal.put(0b1001, 0b1010);
        normal.put(0b1010, 0b0110);
        normal.put(0b1011, 0b1100);
        normal.put(0b1100, 0b0101);
        normal.put(0b1101, 0b1001);
        normal.put(0b1110, 0b0000);
        normal.put(0b1111, 0b0111);
        
        if (!isInverse) {
            return normal;
        }
        else {
            HashMap<Integer, Integer> reversed = new HashMap<>();
            for(Map.Entry<Integer, Integer> entryPair : normal.entrySet()) {
                reversed.put(entryPair.getValue(), entryPair.getKey());
            }
            return reversed;
        }
    }
    
    public static void outputMap(HashMap<Integer, Integer> map) {
        for(Map.Entry<Integer, Integer> entryPair : map.entrySet()) {
            System.out.println(entryPair.getKey() + " : " + entryPair.getValue());
        }
    }
    
    public static int[][] nibbleSub(int[][] array, HashMap<Integer, Integer> subMap) {
        int[][] after = new int[2][2];
        for (int i = 0; i < after.length; i++) {
            for (int j = 0; j < after[0].length; j++) {
                after[i][j] = subMap.get(array[i][j]);
            }
        }
        return after;
    }
    
    public static int[][] encrypt(int[][] toCipher, int[][] key) {
        int[][] encrypted = {{0110, 1001}, {1010, 1100}};
        
        return encrypted;
    }
    
    public static int[][] convertTo2x2(String toConvert) {
        int[][] converted = new int[2][2];
        
        converted[0][0] = Integer.parseInt(toConvert.substring(0,4));
        converted[0][1] = Integer.parseInt(toConvert.substring(4,8));
        converted[1][0] = Integer.parseInt(toConvert.substring(8,12));
        converted[1][1] = Integer.parseInt(toConvert.substring(12,16));
        /*
        converted[0][0] = toConvert.substring(0,4);
        converted[0][1] = toConvert.substring(4,8);
        converted[1][0] = toConvert.substring(8,12);
        converted[1][1] = toConvert.substring(12,16);
        */
        showArray(converted);
        return converted;
    }
    
    public static char convertToChar(int[][] toConvert) {
        String[][] toFill = new String[2][2];
        for (int i = 0; i < toConvert.length; i++) {
            for (int j = 0; j < toConvert[0].length; j++) {
                toFill[i][j] = Integer.toString(toConvert[i][j]);
                while (toFill[i][j].length() <= 3) {
                    toFill[i][j] = "0" + toFill[i][j];
                }
            }
        }
        showArray(toFill);
        String strChar = toFill[0][0] + toFill[0][1] + toFill[1][0] + toFill[1][1];
        int convInt = Integer.parseInt(strChar, 2);
        char character = (char)convInt;
        System.out.println(character);
        return character;
    }
    
    public static void /*int[][]*/ encryptWord(/*int[][] key*/) {
        String encryptedWord = "";
        
        Scanner in = new Scanner (System.in);
        
        System.out.println("Enter a word: ");
        
        String word = in.nextLine();
        
        char[] wordArray = word.toCharArray();
        
        String[] unicodeArray = new String[wordArray.length];
        
        for (int i = 0; i < wordArray.length; i++) {
            unicodeArray[i] = String.format("%16s", Integer.toBinaryString(wordArray[i])).replace(' ', '0');
        }
        
        for (int i = 0; i < unicodeArray.length; i++) {
            //convertTo2x2(unicodeArray[i]);
            encryptedWord += convertToChar(convertTo2x2(unicodeArray[i]));
        }
        
        System.out.println(encryptedWord);
        //encryptedWord += encrypt(unicodeArray[i], key);
        
    }
    
}
