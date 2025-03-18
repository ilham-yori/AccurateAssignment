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

        for (int y = 1; y < height - 1; y++) {
            for (int x = 1; x < length - 1; x++) {
                if (matrix[y][x] == 1 &&
                        matrix[y - 1][x] == 1 &&
                        matrix[y + 1][x] == 1 &&
                        matrix[y][x - 1] == 1 &&
                        matrix[y][x + 1] == 1) {

                    if (marked[y][x] ||
                            marked[y - 1][x] ||
                            marked[y + 1][x] ||
                            marked[y][x - 1] ||
                            marked[y][x + 1]) {

                        continue;
                    }

                    display[y][x] = '*';
                    display[y - 1][x] = '*';
                    display[y + 1][x] = '*';
                    display[y][x - 1] = '*';
                    display[y][x + 1] = '*';

                    marked[y][x] = true;
                    marked[y - 1][x] = true;
                    marked[y + 1][x] = true;
                    marked[y][x - 1] = true;
                    marked[y][x + 1] = true;

                    crossCenters.add("(" + x + ", " + y + ")");
                }
            }
        }
        System.out.println("Matrix with crosses marked:\n");

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < length; x++) {
                System.out.print(display[y][x] + " ");
            }
            System.out.println();
        }

        System.out.println("\nCoordinates of cross centers (X, Y):");

        for (String coord : crossCenters) {
            System.out.println(coord);
        }
    }
}