import java.util.Random;
public class HashtableExperiment {

    public static void main(String[] args) {
        //Check for arguments
        if (args.length < 2) {
            System.out.println("Usage: java HashtableExperiment <dataSource> <loadFactor> [debugLevel]");
            return;
        }
        //3 variables
        int dataSource = Integer.parseInt(args[0]);
        double loadFactor = Double.parseDouble(args[1]);
        int debugLevel = 0; // Default debug level
        if (args.length > 2) {
            debugLevel = Integer.parseInt(args[2]);
        }
        int tableSize = TwinPrimeGenerator.generateTwinPrime(95500, 96000);
        System.out.println("Hashtable Experiment: " + tableSize);

        LinearProbing linearProbing = new LinearProbing(tableSize);
        DoubleHashing doubleHashing = new DoubleHashing(tableSize);
        double targetCount = (tableSize * loadFactor);
        targetCount = Math.ceil(targetCount);
        int targetCountInt = (int) targetCount;

        int randomKey;
        Random random = new Random();
        while (linearProbing.getCount() < targetCountInt) {
            randomKey = random.nextInt();
            HashObject linearObj = new HashObject(randomKey);
            HashObject doubleObj = new HashObject(randomKey);
            linearProbing.insert(linearObj);
            doubleHashing.insert(doubleObj);
        }
        System.out.println("Linear Probing Average Probes: " + linearProbing.getAverageProbes());
        System.out.println("Double Hashing Average Probes: " + doubleHashing.getAverageProbes());

    }


    
}
