import java.util.*;

public class main {
    public static void main(String[] args) {
//        int[] my_array = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
//        System.out.println(average(my_array));
//
//        int [] arr = {90, 77, 67, 55, 75, 57, 98, 17, 50, 23, 30, 100, 34, 75, 28, 43, 14, 52, 64, 13};
//        int x = 64;
//        int indexOf = getIndexOf(arr, x);
//        System.out.println("indexof"+ x +":"+ indexOf);
//
//        String[] arr1 = {"nail","cure","vagabond","riddle","act","songs","zipper","excite","magical","eager","blood","coast","guess","selfish","milky","ticket","authority"};
//        String[] arr2 = {"cure","wicked","guess","vagabond","riddle","act","excite","songs","troubled","eager","blood","coast","waiting","selfish","milky","ticket","authority","nail"};
//        String[] common = getCommonElements(arr1, arr2);
//        System.out.println(Arrays.asList(common));
//
//        int m = 5, n = 5;
//        int mat1[][] = new int[m][n];
//        int mat2[][] = new int[m][n];
        Random rnd = new Random();
//
//        for (int i = 0; i < mat1[0].length; i++) {
//            for (int j = 0; j < mat2[0].length; j++){
//                mat1[i][j] = rnd.nextInt(20);
//                mat2[i][j] = rnd.nextInt(20);
//            }
//        }
//
//        System.out.println(Arrays.deepToString(mat1).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
//        System.out.println(Arrays.deepToString(mat2).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
//
//        int sum[][] = addMatrices(mat1, mat2);
//        System.out.println(Arrays.deepToString(sum).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));

        //
        int r = 5, s = 5;
        int m1[][] = new int[r][s];
        int m2[][] = new int[r][s];

        for (int i = 0; i < m1[0].length; i++) {
            for (int j = 0; j < m1[0].length; j++){
                m1[i][j] = rnd.nextInt(20);
                m2[i][j] = rnd.nextInt(20);
            }
        }

        System.out.println(Arrays.deepToString(m1).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
        System.out.println(Arrays.deepToString(m2).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));

        int prod[][] = matProd(m1, m2);
        //System.out.println(Arrays.deepToString(sum).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
    }

    public static int[][] matProd (int [][] m1, int [][] m2){
        int [][] prod = new int [m1[0].length][m1[0].length];
        int total;
        for (int i = 0; i < m1[0].length; i ++){
            total = 0;
            for (int j = 0; j < m1[0].length; j++){



            }

        }
        return prod;
    }

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

