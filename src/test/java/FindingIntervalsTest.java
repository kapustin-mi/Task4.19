import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RunWith(Parameterized.class)
public class FindingIntervalsTest {
    private final List<CutBorder> cutBorders;
    private final String intervals;

    public FindingIntervalsTest(List<CutBorder> cutBorders, String intervals) {
        this.cutBorders = cutBorders;
        this.intervals = intervals;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> cases() throws FileNotFoundException {
        return Arrays.asList(new Object[][]{
                {Utils.readCutBorders(new File("src/test/resources/inputWithFiveIntervals.txt")), "[(74; 87)]"},
                {Utils.readCutBorders(new File("src/test/resources/inputWithOneInterval.txt")), "[(22; 44)]"},
                {Utils.readCutBorders(new File("src/test/resources/inputWithTwoDifferentIntervals.txt")), "[(1; 2), (33; 55)]"},
                {Utils.readCutBorders(new File("src/test/resources/inputWithTenIntervals.txt")), "[(32; 33)]"},
                {Utils.readCutBorders(new File("src/test/resources/inputWithTwoEqualIntervals.txt")), "[(48; 51)]"}
        });
    }

        @Test
        public void findMoreCoveredIntervals () {
            Assert.assertEquals(intervals, Objects.requireNonNull(new FindingIntervals(cutBorders).findMoreCoveredIntervals()).toString());
        }
    }