package domain;

import java.util.Random;

public class RandomPointGenerator {

    private static Random random = new Random();

    public static boolean generate() {
        return random.nextBoolean();
    }
}
