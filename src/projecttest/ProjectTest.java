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
    
    public static HashMap<Integer, Integer> reverseHashMap(HashMap<Integer, Integer> map) {
        HashMap<Integer, Integer> reversed = new HashMap<>();
        
        for(Map.Entry<Integer, Integer> entryPair : map.entrySet()) {
            reversed.put(entryPair.getValue(), entryPair.getKey());
        }
        
        return reversed;
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
    
}
