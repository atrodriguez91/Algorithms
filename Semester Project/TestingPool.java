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
                if (groupA[i] == test.infected && groupB[i] == test.notInfected) { // Condition if Group A is infected
                    test.testCount++;                                              // and Group B is not. We test the  
                    test.isInfected = true;                                        // subgroup again. 
                    for (int j = 0; j < groupA.length; j++) {
                        test.testCount++;                                          // Group A is then tested individually.  
                    }
                    System.out.println("Case (2): 1 infection found in subgroup A, " + test.testCount + " tests used.");
                    break;
                    // 7 tests will be used here: 1 for main group, 1 for negative subgroup,
                    // 1 for positive group, then a final 4 every indiviual of the positive group.
                } else if (groupA[i] == test.notInfected && groupB[i] == test.infected) { // Condition to check the inverse
                    test.testCount++;                                                     // of the above. 
                    for (int j = 0; j < groupB.length; j++) { // Group B is tested 
                        test.testCount++;                     // individually for positives. 
                        test.isInfected = true;
                    }
                    System.out.println("Case (2): 1 infection found in subgroup B, " + test.testCount + " tests used.");
                    break;
                    // 7 tests will be used here: 1 for main group, 1 for negative subgroup,
                    // 1 for positive group, then a final 4 every indiviual of the positive group.
        // ==================== CASE 3 - IF BOTH GROUPS ARE INFECTED ==============================  
                } else if (groupA[i] == test.infected && groupB[i] == test.infected) { // Both groups are infected 
                    test.isInfected = true;
                    test.testCount++;
                    for (int j = 0; j < groupA.length; j++) { // All of Group A is tested again
                        test.testCount++;
                    }
                    for (int j = 0; j < groupB.length; j++) { // All of Group B is tested again
                        test.testCount++;
                    }
                    System.out.println("Case (3): infection found in BOTH subgroups, " + test.testCount + " tests used.");
                    break;
                }
            }
        // ==================== CASE 1 - NO INFECTION IS FOUND ============================== 
        } else {
            System.out.println("Case (1): No infections, " + test.testCount + " test used.");
            // By default, if no infections were found with the main group, only 1 test 
            // will be used.
        }
        return test.testCount;
    }
    // This function takes a group of 8, randomizing
    // the placement of an infection. 
    public static int[] randomInfection(int[] arr) {
        TestingPool test = new TestingPool();
        Random rand = new Random();
        test.testingPool = new int[8];
        if (new java.util.Random().nextInt(6) == 1) { // Each group has roughly 16% chance of having an infection. 
            test.testingPool[rand.nextInt(7)] = 1; // Since the infection rate is 2% per 1000, this equates to 20 people
        }                                          // per the article. Since a batch of 8 people are being tested at a time,
        return test.testingPool;                   // with a 16% chance of infection (0.16 * 125 groups = 20 people = 2% infection)
    }
    // This function takes in a certain amount of groups
    // and attempts the algorithm per group. Since 1 group
    // is 8 people, the algorithm runs 125 times. 
    public static void populationPool(int groups) {
        TestingPool test = new TestingPool();
        int people = groups * 8;
        while (groups > 0) {
            int testsDone = runPooledTest(randomInfection(test.testingPool));
            test.totalTests += testsDone; // Adds the total amount of tests conducted
            groups -= 1; // Counter that decrements the amount of groups left
        }
        System.out.println("Total tests used per " + people + " people: " + test.totalTests);
    }

    public static void main(String[] args) {
        populationPool(125);
    }
}
