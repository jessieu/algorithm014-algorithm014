class Solution {

    public int[][] merge(int[][] intervals) {
        if (intervals.length < 1) {
            return intervals;
        }
        // sort the interval by the lowerbound in an increasing order
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> results = new ArrayList<>();

        int[] current = intervals[0];
        results.add(current); // add the original interval into the resuls

        // update the current interval by referencing
        for (int[] in: intervals) {
            int currentStart = current[0];
            int currentEnd = current[1];
            int nextStart = in[0];
            int nextEnd = in[1];

            if (nextStart <= currentEnd) {
                current[1] = Math.max(currentEnd, nextEnd);
            } else {
                current = in;
                results.add(current); // add next interval
            }
        }

        return results.toArray(new int[results.size()][]);

    }
}