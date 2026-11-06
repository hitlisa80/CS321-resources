import java.util.Random;
import java.util.Date;
import java.util.Scanner;
import java.io.File;

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

        //Instructions for third argument
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
        long timeStamp = new Date().getTime(); // Get current timestamp in milliseconds

        Object randomKey = null;
        Random random = new Random();
        // Initialize scanner for file reading if dataSource is 3
        Scanner scanner = null;
            if (dataSource == 3) {
            
            File newFile = new File("word-list.txt");
            if (!newFile.exists()) {
                System.out.println("File not found: word-list.txt");
                return;
            }
            try {
                scanner = new Scanner(newFile);
            } catch (Exception e) {
                System.out.println("Error opening file: " + e.getMessage());
                return;
            }

        }



        while (linearProbing.getCount() < targetCountInt) {
            if (dataSource == 1) {
                randomKey = random.nextInt();
            }
            else if (dataSource == 2) {
                Date myDate = new Date(timeStamp);
                randomKey = myDate;
                timeStamp+=1000;
            }
            else if (dataSource == 3) {
                if (scanner.hasNextLine()) {
                    randomKey = scanner.nextLine();
                   
                }
                else {
                    System.out.println("End of file reached.");
                    break;
                }
            }
        
    

            HashObject linearObj = new HashObject(randomKey);
            HashObject doubleObj = new HashObject(randomKey);
            int currentCount = linearProbing.getCount();
            linearProbing.insert(linearObj);
            doubleHashing.insert(doubleObj);
            if (debugLevel == 2) {
                 if (linearProbing.getCount() > currentCount) {
                        System.out.println("Key was new");
                     }
                  else {
                        System.out.println("Key was already present");
                     }
             }
            }
        if (debugLevel == 1) {
            linearProbing.dumpToFile("linear-dump.txt");
            doubleHashing.dumpToFile("double-dump.txt");
        }
        System.out.println("Total Unique Keys: " + linearProbing.getCount());
        if (dataSource == 1) {
            System.out.println("Input Source Type: Random Numbers");
            }
        else if (dataSource == 2) {
            System.out.println("Input Source Type: Dates");
        }
        else if (dataSource == 3) {
            System.out.println("Input Source Type: Words");
        }
        System.out.println("Linear Probing Average Probes: " + linearProbing.getAverageProbes());
        System.out.println("Double Hashing Average Probes: " + doubleHashing.getAverageProbes());

    }
}




    

