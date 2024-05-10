import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var numbers = getNumbers("numbers.txt");
        System.out.println("_min: " + _min(numbers));
        System.out.println("_max: " + _max(numbers));
        System.out.println("_sum: " + _sum(numbers));
        System.out.println("_mult: " + _mult(numbers));
    }


    public static int[] getNumbers(String path){
        try {
            var file = new File(path);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }

            var scanner = new Scanner(file);
            String line = scanFile(path);
            String[] numbers = line.split(" ");
            scanner.close();

            int[] intNumbers = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                intNumbers[i] = Integer.parseInt(numbers[i]);
            }

            return intNumbers;
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new int[0];
    }

    public static String scanFile(String path) {
        try {
            var file = new File(path);

            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }

            var scanner = new Scanner(file);
            String  line = scanner.nextLine();
            scanner.close();
            return line;

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new String();
    }

    public static int _min(int[] numbers) {
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    public static int _max(int[] numbers) {
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public static int _sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static long _mult(int[] numbers) {
        long mult = 1;
        for (int number : numbers) {
            mult *= number;
        }
        return mult;
    }
}