package _50_pow;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assert 1024.00000 == solution.myPow(2.0, 10);
        assert 9.26100 == solution.myPow(2.1, 3);
        assert 0.25000 == solution.myPow(2.0, -2);
    }

    public double myPow(double x, int n) {
        if (n == 0) return 1.0;

        if (n > 0) return pow(x, n);

        return 1.0 / pow(x, -n);
    }

    private double pow(double x, int n) {
        if (n == 0) return 1.0;
        if (n == 1) return x;
        if (n % 2 == 0) {
            return pow(x * x, n / 2);
        } else {
            return pow(x * x, n / 2) * x;
        }
    }
}
