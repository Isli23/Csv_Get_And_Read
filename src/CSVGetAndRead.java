import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class CSVGetAndRead {

    public static void main(String[] args) {
        String folderPath = "C:\\Users\\Premixx\\Desktop\\cvs_reader_java\\data"; // Your folder path
        List<String> csvFileNames = new LinkedList<>();

        File dir = new File(folderPath);
        File[] listOfFiles = dir.listFiles();

        if (listOfFiles != null) {
            for (File fileEntry : listOfFiles) {
                if (fileEntry.isFile() && fileEntry.getName().endsWith(".csv")) {
                    csvFileNames.add(fileEntry.getName());
                }
            }

            // Process each CSV file
            for (String fileName : csvFileNames) {
                processCsvFile(folderPath + File.separator + fileName);
            }
        } else {
            System.out.println("No CSV files found in the specified folder.");
        }
    }

    private static void processCsvFile(String filePath) {
        // Your logic to read and process the CSV file goes here
        System.out.println("Processing file: " + filePath);
        // ...
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                // Process each line (record) in the CSV file
                String[] columns = line.split(",");
                String column1 = columns[0]; // Assuming the first column
                String column2 = columns[1]; // Assuming the second column

                System.out.println("Column 1: " + column1 + ", Column 2: " + column2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
