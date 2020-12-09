import java.util.Arrays;

public class TestingPool {
    int[] testingPool; // Batch of 8 from population size
    int infected = 1; // If a sample if infected
    int notInfected = 0; // If a sample isn't infected
    int testCount = 0; // Amount of tests depending on case
    int totalTests = 0; // Cumulative amount of tests for entire procedure
    boolean isInfected = false; // Flag for infection

 // Pooled testing function algorithm
    public static int runPooledTest(int testingPool[]) {
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
        if (test.isInfected == true) {
            int len = testingPool.length;
            int groupA[] = Arrays.copyOfRange(testingPool, 0, len / 2);
            int groupB[] = Arrays.copyOfRange(testingPool, len / 2, len);
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
}
