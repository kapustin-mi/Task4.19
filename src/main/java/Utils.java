import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {

    public static List<CutBorder> readCutBorders(File file) throws FileNotFoundException {
        List<String> lines = readLines(file);

        if (lines.size() == 0) {
            return null;
        }

        List<CutBorder> cutBorders = new ArrayList<>();

        for (String line : lines) {
            String[] points = line.split(", ");
            cutBorders.add(new CutBorder(Integer.parseInt(points[0]), true));
            cutBorders.add(new CutBorder(Integer.parseInt(points[1]), false));
        }

        return cutBorders;
    }

    public static List<Interval> readIntervals(File file) throws FileNotFoundException {
        List<String> lines = readLines(file);

        if (lines.size() == 0) {
            return null;
        }

        List<Interval> intervals = new ArrayList<>();

        for (String line : lines) {
            String[] points = line.split(", ");
            intervals.add(new Interval(Integer.parseInt(points[0]), Integer.parseInt(points[1])));
        }

        return intervals;
    }

    public static List<String> readLines(File file) throws FileNotFoundException {
        List<String> lines = new ArrayList<>();
        Scanner scn = new Scanner(file);

        while (scn.hasNext()) {
            lines.add(scn.nextLine());
        }

        return lines;
    }
}
