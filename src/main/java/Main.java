import java.util.Scanner;

public class Main {
    private static String FILE_NAME;
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("ENTER THE FILE NAME: ");
            FILE_NAME = scanner.nextLine();

            FileDataProcessor workWithFile = new FileDataProcessor(FILE_NAME);
            System.out.println("MAX VALUE: " + workWithFile.getMax());
            System.out.println("MIN VALUE: " + workWithFile.getMin());
            System.out.println("AVERAGE VALUE: " + workWithFile.getAverage());
            System.out.println("MEDIAN VALUE: " + workWithFile.getMedian());
            System.out.println("BIGGEST INCREASING SEQUENCE VALUE: " + workWithFile.biggestIncreasingSequence());
            System.out.println("BIGGEST DECREASING SEQUENCE VALUE: " + workWithFile.biggestDecreasingSequence());
        } catch (Exception e) {
            System.out.println("CANNOT FIND FILE BY NAME: " + FILE_NAME);
        }
    }
}
