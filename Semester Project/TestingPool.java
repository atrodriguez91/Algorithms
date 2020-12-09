import java.util.Arrays;
import java.util.Random;

public class TestingPool {
    int[] testingPool; // Batch of 8 from population size
    int infected = 1; // If a sample if infected
    int notInfected = 0; // If a sample isn't infected
    int testCount = 0; // Amount of tests depending on case
    int totalTests = 0; // Cumulative amount of tests for entire procedure
    boolean isInfected = false; // Flag for infection

 // Pooled testing function algorithm
    public static int runPooledTest(int testingPool[]) {
        // ==================== INITIAL TEST ==============================
        TestingPool test = new TestingPool();
        test.testCount = 1; // One test must be done for the initial large group
        for (int i = 0; i < testingPool.length; i++) {
            if (testingPool[i] == test.infected) {
                test.testCount++;
                test.isInfected = true;
                System.out.println("Infection found in main group");
                break;
            } else {
                test.isInfected = false;
            }
        }
        // ==================== IF INFECTION = TRUE, SPLIT THE GROUP INTO 2 ==============================
        if (test.isInfected == true) {
            int len = testingPool.length;
            int groupA[] = Arrays.copyOfRange(testingPool, 0, len / 2); // Separation of groups from main
            int groupB[] = Arrays.copyOfRange(testingPool, len / 2, len); // into 2 sub groups
            for (int i = 0; i < groupA.length; i++) {
                if (groupA[i] == test.infected && groupB[i] == test.notInfected) {
                    test.testCount++;
                    test.isInfected = true;
                    for (int j = 0; j < groupA.length; j++) {
                        test.testCount++;
                    }
                    System.out.println("Case (2): 1 infection found in subgroup A, " + test.testCount + " tests used.");
                    break;
                } else if (groupA[i] == test.notInfected && groupB[i] == test.infected) {
                    test.testCount++;
                    for (int j = 0; j < groupB.length; j++) {
                        test.testCount++;
                        test.isInfected = true;
                    }
                    System.out.println("Case (2): 1 infection found in subgroup B, " + test.testCount + " tests used.");
                    break;
                } else if (groupA[i] == test.infected && groupB[i] == test.infected) {
                    test.isInfected = true;
                    test.testCount++;
                    for (int j = 0; j < groupA.length; j++) {
                        test.testCount++;
                    }
                    for (int j = 0; j < groupB.length; j++) {
                        test.testCount++;
                    }
                    System.out.println("Case (3): infection found in BOTH subgroups, " + test.testCount + " tests used.");
                    break;
                }
            }
        } else {
            System.out.println("Case (1): No infections, " + test.testCount + " test used.");
        }
        return test.testCount;
    }

    public static int[] randomInfection(int[] arr) {
        TestingPool test = new TestingPool();
        Random rand = new Random();
        test.testingPool = new int[8];
        if (new java.util.Random().nextInt(6) == 1) {
            test.testingPool[rand.nextInt(7)] = 1;
        }
        return test.testingPool;
    }

    public static void populationPool(int groups) {
        TestingPool test = new TestingPool();
        int people = groups * 8;
        while (groups > 0) {
            int testsDone = runPooledTest(randomInfection(test.testingPool));
            test.totalTests += testsDone;
            groups -= 1;
        }
        System.out.println("Total tests used per " + people + " people: " + test.totalTests);
    }

    public static void main(String[] args) {
        populationPool(125);
    }
}
