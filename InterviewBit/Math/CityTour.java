/*
Question link: https://www.interviewbit.com/problems/city-tour/
 */

import java.util.*;

class Solution {
    static long power(long x, long y, long p) {
        // Initialize result
        long res = 1;
        // Update x if it is more than or
        // equal to p
        x = x % p;
        while (y > 0) {
            // If y is odd, multiply x
            // with result
            if (y % 2 == 1)
                res = (res * x) % p;
            // y must be even now
            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }
        return res;
    }

    // Returns n^(-1) mod p
    static long modInverse(long n, long p) {
        return power(n, p-2, p);
    }

    // Returns nCr % p using Fermat's
    // little theorem.
    static long nCrModPFermat(long n, long r, long p) {
        r = Math.min(r, n - r);
        // Base case
        if (r == 0)
            return 1;
        // Fill factorial array so that we
        // can find all factorial of r, n
        // and n-r
        long[] fac = new long[(int)(n+1)];
        fac[0] = 1;
        for (int i = 1; i <= n; i++)
            fac[i] = fac[i-1] * i % p;
        return (fac[(int)n]* modInverse(fac[(int)r], p) % p * modInverse(fac[(int)(n-r)], p) % p) % p;
    }

    public int solve(int A, ArrayList<Integer> B) {
        int leftCorner = 0, rightCorner = 0;
        ArrayList<Integer> gapSizes = new ArrayList<>();
        Collections.sort(B);
        leftCorner = Math.min(B.get(0) - 1, A);
        rightCorner = Math.max(B.get(B.size() - 1), 0);
        rightCorner = A - rightCorner;
        int gap = 0;
        for (int i = B.get(0) + 1; i < B.get(B.size() - 1); i += 1) {
            if (B.indexOf(i) < 0) {
                gap += 1;
            } else {
                if (gap > 0) {
                    gapSizes.add(gap);
                }
                gap = 0;
            }
        }
        if (gap > 0) {
            gapSizes.add(gap);
        }
        long total = 1;
        for (int i = 0; i < gapSizes.size(); i += 1) {
            total *= power(2, (long)(gapSizes.get(i) - 1), 1000000007);
            total = total % 1000000007;
        }
        if (leftCorner > 0) {
            gapSizes.add(leftCorner);
        }
        if (rightCorner > 0) {
            gapSizes.add(rightCorner);
        }
        int runningTotal = 0;
        for (int i = 0; i < gapSizes.size(); i += 1) {
            long combo = nCrModPFermat((long)(runningTotal + gapSizes.get(i)), (long)gapSizes.get(i), (long)1000000007);
            runningTotal += gapSizes.get(i);
            total = (total * combo) % 1000000007;
        }
        return (int)total;
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(537, 796, 542, 214, 289, 230));
        int B = 1000;
        Solution sol = new Solution();
        System.out.println(sol.solve(B, A));
    }
}