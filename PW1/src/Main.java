public class Main {
    @FunctionalInterface
    public interface GCD {
        public int find(int a, int b);
    }

    public static void main(String[] args) {
        GCD gcd = (a, b) -> {
            while (a != 0 && b != 0) {
                if (a > b) a %= b;
                else if (a < b) b %= a;
            }
            return a + b;
        };
        int[] a = {123, 215, 59, 0, 1391};
        int[] b = {9, 265, 24, 120, 2782};
        for (int i = 0; i < 5; i++)
            System.out.println("GCD(" + a[i] + ", " + b[i] + ") = " + gcd.find(a[i],b[i]));
    }
}