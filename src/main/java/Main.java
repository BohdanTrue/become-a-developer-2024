import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "10m.txt";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        WorkWithFile workWithFile = new WorkWithFile();
        ArrayList<Long> arrayList = workWithFile.parseToArrayList(fileName);
        System.out.println("MAX VALUE: " + workWithFile.getMax(arrayList));
        System.out.println("MIN VALUE: " + workWithFile.getMin(arrayList));
        System.out.println("AVERAGE VALUE: " + workWithFile.getAverage(arrayList));
        System.out.println("MEDIAN VALUE: " + workWithFile.getMedian(arrayList));
    }
}
