import java.util.ArrayList;
import java.util.List;

public class Practical1 {
    //A java program to calculate the average value of array elements.
    public static double average (int [] array){
        double total= 0;
        for (int i = 0; i < array.length; i++){
            total += array[i];
        }
        return (total/array.length);
    }

    //A Java program to find the index of an array element given
    public static int getIndexOf (int [] array, int x){
        int index = 0;
        while (true){
            if (array[index] == x) break;
            index++;
        }
        return index;
    }

    //Array of all the words that appear in both arrays
    public static String[] getCommonElements (String[] arr1, String[] arr2){
        List<String> list = new ArrayList<String>();
        int i = 0;
        int index = 0;
        while (i < arr1.length){
            for (int x = 0; x < arr2.length; x++){
                if (arr1[i] == arr2[x]){
                    list.add(index, arr1[i]);
                    index++;
                    break;
                }
            }
            i++;
        }
        String[] dupes = new String[list.size()];
        list.toArray(dupes); // fill the array
        return dupes;
    }

    //Return the sum of two matrices
    public static int[][] addMatrices (int[][] m1, int[][] m2){
        int [][] result = new int [m1[0].length][m2[0].length];
        for (int i = 0; i < m1[0].length; i++) {
            for (int j = 0; j < m2[0].length; j++){
                result[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return result;
    }
}
