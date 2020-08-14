class Solution {
    public int[] plusOne(int[] digits) {

        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }

        // only 1 situation that the carry > 0, the input is 9..9
        if (carry > 0) {
            int[] arr = new int[digits.length + 1];
            arr[0] = 1;
            return arr;
        }

        return digits;

    }
}