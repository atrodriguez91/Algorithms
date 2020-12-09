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
        
    }
}
