import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/input.txt");
        List<CutBorder> cutBorders = Utils.readCutBorders(file);

        FindingIntervals finding = new FindingIntervals(cutBorders);
        List<Interval> intervals = finding.findMoreCoveredIntervals();

        printResult(intervals);
    }

    private static void printResult(List<Interval> intervals) {
        System.out.print(intervals);
    }
}
