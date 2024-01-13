import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        int[] array = new int[100];
       try {
            String fileName = "src/input.txt";
            File file = new File(fileName);
            Scanner fileInput = new Scanner(file);

            int i = 0;
            while(fileInput.hasNext()){
                array[i] = fileInput.nextInt();
                i++;
            }

            array = Arrays.copyOf(array, i);

           System.out.print("Array "+Arrays.toString(array));
           System.out.println();
       } catch (FileNotFoundException ex){
           System.out.println(ex.getMessage());
       }
        System.out.println("Number of ints that contains 9: "+ count9(array));
       int[] num = filter9(array);
        System.out.println("Array with numbers that contains 9: "+ Arrays.toString(num));
        int[] index = whereAt9(array);
        System.out.println("Array of index: "+ Arrays.toString(index));
    }

    public static int count9(int[] array){
        int count = 0;
       for(int number : array) {
           boolean found = false;
            while (number != 0) {
                int remainder = number % 10; // Get the last digit
                if (remainder == 9 && !found) {
                    count++;
                    found = true;
                }
                number /= 10; // Remove the last digit
            }
       } return count;
    }

    public static int[] filter9(int[] data){
        int count = count9(data);
        int[] result = new int[count];
        int i = 0;

        for(int number : data){
            boolean found = false;
            int temp = number;
            while (number != 0) {
                int remainder = number % 10; // Get the last digit
                if (remainder == 9 && !found) {
                    result[i] = temp;
                    i++;
                    found = true;
                }
                number /= 10; // Remove the last digit
            }
        } return result;
    }

    public static int[] whereAt9(int[] data) {
        int count = count9(data);
        int[] indices = new int[count];
        int index = 0;

        for (int i = 0; i < data.length; i++) {
            int number = data[i];
            boolean found = false;

            while (number != 0) {
                int remainder = number % 10; // Get the last digit
                if (remainder == 9 && !found) {
                    indices[index] = i;
                    index++;
                    found = true;
                }
                number /= 10; // Remove the last digit
            }
        }

        return Arrays.copyOf(indices, index); // Trim the array to the actual number of indices
    }
}