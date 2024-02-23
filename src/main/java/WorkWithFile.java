import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class WorkWithFile {

    public ArrayList<Long> parseToArrayList(String fileName) {
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

    public long getMax(ArrayList<Long> list) {
        return Collections.max(list);
    }

    public long getMin(ArrayList<Long> list) {
        return Collections.min(list);
    }

    public double getAverage(ArrayList<Long> list) {
        return list.stream()
                .mapToDouble(num -> num)
                .average()
                .getAsDouble();
    }

    public double getMedian(ArrayList<Long> list) {
        Collections.sort(list);
        int size = list.size();
        return size % 2 == 0 ? 0.5 * (list.get(size / 2) + list.get(size / 2 - 1)) : list.get(size / 2);
    }

    public int biggestIncreasingSequence(ArrayList<Long> list) {
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

    public int biggestDecreasingSequence(ArrayList<Long> list) {
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
