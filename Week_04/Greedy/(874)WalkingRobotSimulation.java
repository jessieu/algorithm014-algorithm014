// Reference: https://blog.csdn.net/fuxuemingzhu/article/details/82356556
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // North - 0, East - 1, South - 2, West - 3
        int[] dx = new int[]{0, 1, 0, -1}; // offset of x coordinate
        int[] dy = new int[]{1, 0, -1, 0}; // offset of y coordinate

        int x = 0, y = 0, index = 0, result = 0;

        HashSet<Long> oSet = new HashSet();
        for (int[] os : obstacles) {
            long ox = (long) os[0] + 30000; // it's difficult to store an array into a set
            long oy = (long) os[1] + 30000;
            oSet.add((ox << 16) + oy);
        }

        for (int command : commands) {
            // calculate offset(for negative number modulo, still negative - don't use index - 1)
            if (command == -1) index = (index + 1) % 4;
            else if (command == -2) index = (index + 3) % 4;
            else { // Greedy?
                // move step by step
                for (int i = 0; i < command; i++) {
                    // current coordinate
                    int nx = x + dx[index];
                    int ny = y + dy[index];
                    // obstacle - stay
                    long code = (((long)nx + 30000) << 16) + ((long)ny + 30000);
                    if (oSet.contains(code)) {
                        break;
                    }
                    x = nx;
                    y = ny;
                    // calculate distance
                    result = Math.max(result, x * x + y * y);

                }

            }
        }
        return result;
    }
}