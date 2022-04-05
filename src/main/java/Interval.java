public record Interval(int startingPoint, int endPoint) {

    @Override
    public String toString() {
        return "(" + startingPoint + "; " + endPoint + ")";
    }
}
