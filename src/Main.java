import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int height = 15;
        int length = 25;

        int[][] matrix = new int[height][length];
        char[][] display = new char[height][length];
        boolean[][] marked = new boolean[height][length];

        List<String> crossCenters = new ArrayList<>();
        Random rand = new Random();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < length; x++) {
                if (rand.nextBoolean()) {
                    matrix[y][x] = 1;
                } else {
                    matrix[y][x] = 0;
                }

                if (matrix[y][x] == 1) {
                    display[y][x] = '1';
                } else {
                    display[y][x] = '0';
                }
            }
        }
    }
}