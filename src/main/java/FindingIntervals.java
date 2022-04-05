import java.util.ArrayList;
import java.util.List;

public class FindingIntervals {
    private final List<CutBorder> cutBorders;

    public FindingIntervals(List<CutBorder> cutBorders) {
        this.cutBorders = cutBorders;
    }

    public List<Interval> findMoreCoveredIntervals() {
        if (cutBorders == null) {
            return null;
        }

        sortValues(0, cutBorders.size() - 1);
        List<CutBorder> borders = findIntervals(1);

        return bordersToIntervals(borders);
    }

     private void sortValues(int leftIndex, int rightIndex) {
         int pivot = cutBorders.get((leftIndex + rightIndex) / 2).value();
         int leftMarker = leftIndex;
         int rightMarker = rightIndex;

         while (leftMarker <= rightMarker) {
             while (cutBorders.get(leftMarker).value() < pivot) {
                 leftMarker++;
             }
             while (cutBorders.get(rightMarker).value() > pivot) {
                 rightMarker--;
             }

             if (leftMarker <= rightMarker) {
                 boolean needSwap = checkNeedSwap(cutBorders, leftMarker, rightMarker);

                 if (needSwap) {
                     CutBorder tmp = cutBorders.get(rightMarker);
                     cutBorders.set(rightMarker, cutBorders.get(leftMarker));
                     cutBorders.set(leftMarker, tmp);
                 }

                 leftMarker++;
                 rightMarker--;
             }
         }

         if (leftMarker < rightIndex) {
             sortValues(leftMarker, rightIndex);
         }
         if (rightMarker > leftIndex) {
             sortValues(leftIndex, rightMarker);
         }
     }

    private boolean checkNeedSwap(List<CutBorder> cutBorders, int left, int right) {
        if (cutBorders.get(left).value() == cutBorders.get(right).value()) {
            return !cutBorders.get(left).isBeginning();
        }

        return true;
    }

    private List<CutBorder> findIntervals(int quantityCovered) {
        List<CutBorder> intervals = new ArrayList<>();

        int newQuantityCovered = 0;
        boolean isIntervalWithMaxCoverage = false;

        for (CutBorder cutBorder : cutBorders) {
            if (cutBorder.isBeginning()) {
                newQuantityCovered++;
            } else {
                if (newQuantityCovered == quantityCovered) {
                    intervals.add(cutBorder);
                    isIntervalWithMaxCoverage = false;
                }

                newQuantityCovered--;
            }

            if (newQuantityCovered > quantityCovered) {
                return findIntervals(newQuantityCovered);
            }

            if (newQuantityCovered == quantityCovered) {
                if (!isIntervalWithMaxCoverage) {
                    intervals.add(cutBorder);
                    isIntervalWithMaxCoverage = true;
                }
            }
        }

        return intervals;
    }

    private List<Interval> bordersToIntervals(List<CutBorder> borders) {
        List<Interval> intervals = new ArrayList<>();

        for (int i = 0; i < borders.size(); i = i + 2) {
            intervals.add(new Interval(borders.get(i).value(), borders.get(i + 1).value()));
        }

        return intervals;
    }
}
