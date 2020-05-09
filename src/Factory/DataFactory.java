package Factory;

import java.util.Random;

public class DataFactory {
    public static int[][] createMatrix(int width, int length){
        int[][] matrix = new int[width][length];

        for(int w = 0; w < width; w++){
            for(int l = 0; l < width; l++){
                // Generate random number between 1 and 150
                Random rand = new Random();
                int randomInt = rand.nextInt(151);
                matrix[w][l] = randomInt;
            }
        }

        return matrix;
    }
}
