class Solution {
    public int fib(int N) {
        if (N == 0) return 0;
        if (N == 1 || N == 2) return 1;
        int first = 1, second = 1;
        int result = 0;
        for (int i = 3; i < N + 1; i++) {
            result = first + second;
            first = second;
            second = result;
        }

        return result;
    }
}

/* Recursion with Memoization */
// class Solution {
//     private int[] memo;
//     private int recursion(int N) {
//         if (N == 0) return 0;
//         if (N == 1 || N == 2) return 1;
//         if (memo[N] > 0) return memo[N];
//         memo[N] = recursion(N-1) + recursion(N-2);
//         return memo[N];
//     }

//     public int fib(int N) {
//         memo = new int[N+1];
//         return recursion(N);
//     }
// }

/* Recursion */
// class Solution {
//     public int fib(int N) {
//         // terminator
//         if (N == 0) return 0;
//         if (N == 1 || N == 2) return 1;
//         return fib(N-1) + fib(N-2);
//     }
// }