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
}
