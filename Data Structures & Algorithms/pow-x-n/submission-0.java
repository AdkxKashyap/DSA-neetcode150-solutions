class Solution {

    public double myPow(double x, int n) {

        long exp = n;

        if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }

        return power(x, exp);
    }

    private double power(double x, long n) {

        if (n == 0)
            return 1;

        double half = power(x, n / 2);

        if (n % 2 == 0)
            return half * half;

        return x * half * half;
    }
}