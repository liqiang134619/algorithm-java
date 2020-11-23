package algorithm.dynamic;

import java.util.concurrent.ForkJoinPool;

/**
 * @author liq
 * @date 2020/11/22
 */
public class Demo01 {


    private static double eval(int n) {
        if (n == 0) {
            return 1.0;
        } else {
            double sum = 0.0;
            for (int i = 0; i < n; i++) {
                sum += eval(i);
            }
            return 2.0 * sum / n + n;
        }

    }

    //
    private static double eval2(int n) {
        double[] c = new double[n + 1];
        c[0] = 1.0;
        for (int i = 1; i <= n; i++) {
            double sum = 0.0;
            for (int j = 0; j < i; j++) {
                sum += c[j];
            }
            c[i] = 2.0 * sum / i + i;
        }
        return c[n];
    }

    private static double eval3(int n) {
        double[] c = new double[n + 1];
        c[0] = 1.0;
        double sum = c[0];
        for (int i = 1; i <= n; i++) {
            c[i] = 2.0 * sum / i + i;
            sum += c[i];
        }
        return c[n];
    }

    private static double eval4(int n) {

        double pre = 1.0;
        double current = 0.0;
        for (int i = 1; i <= n; i++) {
            current = 2.0 * pre / i + i;
            pre += current;


        }
        return current;
    }

    public static void main(String[] args) {
//        long l = System.currentTimeMillis();
//        System.out.println("---one done:" + eval(10000));
//        long times = System.currentTimeMillis() - l;
//        System.out.println(times);

        long l2 = System.currentTimeMillis();
        System.out.println("---two done:" + eval2(10000));
        long times2 = System.currentTimeMillis() - l2;
        System.out.println(times2);

        long l3 = System.currentTimeMillis();
        System.out.println("---three done:" + eval4(10000));
        long times3 = System.currentTimeMillis() - l3;
        System.out.println(times3);
    }
}
