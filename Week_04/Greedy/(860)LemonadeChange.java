class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0; // five dollar bills currently have
        int ten = 0; // ten dollar bills currently have

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) return false;
                ten++;
                five--;
            } else { // 20
                if (five > 0 && ten > 0) {
                    // 15 = 10 + 5
                    five--;
                    ten--;
                } else if (five >= 3) {
                    // 15 = 3 * 5
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

/**
 *  I thought as long as there are enough amount of money in hand, we should return true.
 *  But the thing is, even though you have 20 bucks in hand, two 10, you cannot give the correct change
 *  because you cannot split the 10 to two 5.
 *
 *  Simulation:
 *  How Greedy is applied?
 *  If I swap line 14 and 18, the result is wrong.
 *  Always give out the largest bill first, which is the optimal move because we want to leave as much as change
 *  for later small amount of change.
 */