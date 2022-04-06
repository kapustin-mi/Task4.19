import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class FindingIntervalsTest {
    private final List<CutBorder> cutBorders;
    private final List<Interval> intervals;

    public FindingIntervalsTest(List<CutBorder> cutBorders, List<Interval> intervals) {
        this.cutBorders = cutBorders;
        this.intervals = intervals;
    }

    @Parameterized.Parameters
    public static List<Object[]> cases() throws FileNotFoundException {
        return Arrays.asList(new Object[][]{
                {Utils.readCutBorders(new File("src/test/resources/inputWithoutIntervals.txt")),
                        Utils.readIntervals(new File("src/test/resources/answerForInputWithoutIntervals.txt"))},
                {Utils.readCutBorders(new File("src/test/resources/inputWithOneInterval.txt")),
                        Utils.readIntervals(new File("src/test/resources/answerForInputWithOneInterval.txt"))},
                {Utils.readCutBorders(new File("src/test/resources/inputWithTwoDifferentIntervals.txt")),
                        Utils.readIntervals(new File("src/test/resources/answerForInputWithTwoDifferentIntervals.txt"))},
                {Utils.readCutBorders(new File("src/test/resources/inputWithTenIntervals.txt")),
                        Utils.readIntervals(new File("src/test/resources/answerForInputWithTenIntervals.txt"))},
                {Utils.readCutBorders(new File("src/test/resources/inputWithTwoEqualIntervals.txt")),
                        Utils.readIntervals(new File("src/test/resources/answerForInputWithTwoEqualIntervals.txt"))}
        });
    }

        @Test
        public void findMoreCoveredIntervals () {
            Assert.assertEquals(intervals, new FindingIntervals(cutBorders).findMoreCoveredIntervals());
        }
    }
