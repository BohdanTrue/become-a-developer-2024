import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileDataProcessor {
    private ArrayList<Long> list;

    public FileDataProcessor(String fileName) {
        this.list = parseToArrayList(fileName);
    }

    private ArrayList<Long> parseToArrayList(String fileName) {
        ArrayList<Long> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(Long.parseLong(line));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public long getMax() {
        return Collections.max(list);
    }

    public long getMin() {
        return Collections.min(list);
    }

    public double getAverage() {
        return list.stream()
                .mapToDouble(num -> num)
                .average()
                .getAsDouble();
    }

    public double getMedian() {
        ArrayList<Long> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        int size = sortedList.size();
        return size % 2 == 0
                ? 0.5 * (sortedList.get(size / 2) + sortedList.get(size / 2 - 1))
                : sortedList.get(size / 2);
    }

    public int biggestIncreasingSequence() {
        int biggestSequence = 0;
        int counter = 1;
        ArrayList<Long> sequence = new ArrayList<>();
        ArrayList<Long> listOfNumbers = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > list.get(i - 1)) {
                counter++;
                if (listOfNumbers.isEmpty()) {
                    listOfNumbers.add(list.get(i - 1));
                }
                listOfNumbers.add(list.get(i));
            } else {
                if (counter > biggestSequence) {
                    biggestSequence = counter;
                    sequence.clear();
                    sequence.addAll(listOfNumbers);
                }
                listOfNumbers.clear();
                counter = 1;
            }
        }
        System.out.println("BIGGEST INCREASING LIST: " + sequence);
        return biggestSequence;
    }

    public int biggestDecreasingSequence() {
        int biggestSequence = 0;
        int counter = 1;
        ArrayList<Long> sequence = new ArrayList<>();
        ArrayList<Long> listOfNumbers = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                counter++;
                if (listOfNumbers.isEmpty()) {
                    listOfNumbers.add(list.get(i - 1));
                }
                listOfNumbers.add(list.get(i));
            } else {
                if (counter > biggestSequence) {
                    biggestSequence = counter;
                    sequence.clear();
                    sequence.addAll(listOfNumbers);
                }
                listOfNumbers.clear();
                counter = 1;
            }
        }
        System.out.println("BIGGEST DECREASING LIST: " + sequence);
        return biggestSequence;
    }
}
