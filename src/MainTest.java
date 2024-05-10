import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testMinFunction() {
        int[] numbers = {5, 3, 8, 2, 10};
        assertEquals(2, Main._min(numbers));
    }

    @Test
    public void testMaxFunction() {
        int[] numbers = {5, 3, 8, 2, 10};
        assertEquals(10, Main._max(numbers));
    }

    @Test
    public void testSumFunction() {
        int[] numbers = {5, 3, 8, 2, 10};
        assertEquals(28, Main._sum(numbers));
    }

    @Test
    public void testMultFunction() {
        int[] numbers = {5, 3, 8, 2, 10};
        assertEquals(2400, Main._mult(numbers));
    }

    @Test
    public void testProgramSpeed() {
        long startTime = System.currentTimeMillis();

        try {
            File file = new File("large_numbers.txt");
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            String[] numbersStr = line.split(" ");
            int[] numbers = new int[numbersStr.length];
            for (int i = 0; i < numbersStr.length; i++) {
                numbers[i] = Integer.parseInt(numbersStr[i]);
            }
            scanner.close();

            Main._min(numbers);
            Main._max(numbers);
            Main._sum(numbers);
            Main._mult(numbers);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Time taken: " + totalTime + " milliseconds");
    }

    @Test
    public void testGetNumbers() {
        try {
            var path = "test_numbers.txt";
            createTestFile(path, "5 3 8 2 10");

            int[] expected = {5, 3, 8, 2, 10};
            assertArrayEquals(expected, Main.getNumbers(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testScanFile() {
        try {
            var path = "test_scan.txt";
            createTestFile(path, "1 2 3 4 5");

            assertEquals("1 2 3 4 5", Main.scanFile(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createTestFile(String path, String content) throws IOException {
        var file = new File(path);
        FileWriter writer = new FileWriter(file);
        writer.write(content);
        writer.close();
    }
}