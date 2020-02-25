/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialbinarysearch1;

/**
 *
 * @author Alex
 */
import java.util.Arrays;
public class Search {
    
    int [] a; // declare array;
    
    void initialiseArray(int n) { // takes "size's" JTextField, converted to int, value through jButton1 method();
        int min = 0;  // set minimum range for random;
        int max = 20; // set maximum range for random;
       
        a = new int[n];
        for(int i = 0; i < n; i++) { // initialize a[] array;
            a[i] = min + (int) (Math.random() * max); // assign random numbers to a[] array;
        }
    }
    
    String printArray() { // returns values of a[] array initialized in initialiseArray() method and converted in String type ;
        if(a==null){ // create if statement to avoid printing "null" in setArray field in case of exception cases;
            return "";
        } else {
        return "Array  : "+Arrays.toString(a); // return values of a[] array in String type;
        }
    }
    
    String serialSearch(int number) { // takes "num's" JTextField value, converted to int, through jButton2 method();
        int flag = -1;
        String str;
        
        long start = System.nanoTime(); // set first variable to pinpoint serial search algoritm execution time;
        
        for(int i = 0; i<a.length; i++) { // use serial search algoritm to search desired value in a[] array;
            if(number == a[i]) { // use if statement to exit for loop if desired value was found;
                flag = 0;
                i = a.length;
            }
        }
        
        long elapsedTime = System.nanoTime() - start; // set second variable to pinpoint serial search algoritm execution time;
        
        if(flag ==-1) {
            str = "The number was not found"; // will be returned if desired value was not found;
        } else {
            str = "The number was found"; // will be returned if desired value was found;
        }
        
        return str + "\nThe time it takes the function to complete: "+elapsedTime+"nanoseconds"; // result of the method assigned to "Print" JTextArea through jButton2 method();
    }
    
    String binarySearch(int number) { // takes "Num's" JTextField value, converted to int, through jButton3 method();
        int flag = -1;
        int L, M, R;
        String str;
        L = 0;
        R = a.length-1;
        Arrays.sort(a); // sort a[] array to avoid unpredictable search result;
        
        long start = System.nanoTime(); // set first variable to pinpoint binary search algoritm execution time;
        
        while(L <= R) { // use binary search algoritm to search desired value in a[] array;
            M = (L+R)/2;
            if(a[M]==number) {
                flag = 0;
                L = R+1;
            } else if (a[M]>number) {
                R = M-1;
            } else {
                L = M+1;
            }
        }
        
        long elapseTime = System.nanoTime() - start; // set second variable to pinpoint binary search algoritm execution time;
        
        if(flag == -1) {
            str = "The number was not found"; // will be returned if desired value was not found;
        } else { 
            str = "The number was found";// will be returned if desired value was found;
        }
        
        return str+ "\nThe time it takes the function to complete: "+elapseTime+"nanoseconds"; // result of the method assigned to "Print" JTextArea through jButton3 method();
    }
}
