package Micorsoft;

public class RotateFunction {
    public int maxRotateFunction(int[] A) {
        int sum = 0, F = 0, n = A.length;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            F += i * A[i];
        }
        int max = F;
        for (int i = n - 1; i > 0; i--) {
            F = F + sum - n * A[i];
            max = Math.max(max, F);
        }
        return max;
    }
}
