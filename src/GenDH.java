import java.util.Locale;
import java.util.Random;
import java.util.stream.IntStream;

public class GenDH {
    public  static long getQ() {
            Random random = new Random();
            long prime1 = random.nextLong(10000) + 1;
            long prime2 = (2 * prime1) + 1;
//            System.out.println("Prime 1:" + prime1);
//            System.out.println("Prime 2:" + prime2);
//            System.out.println("Sophie-Germain Number:" + (prime1 * prime2));
long Q = prime1 * prime2;
        return Q;
    }

    public static long getP() {
        Long P = null;
        try {
            P = 2 * getQ() + 1;
            if (isPrime(P) == true)
                return P;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return P;
    }
    public static boolean isPrime(long number) {
        return number > 1
                && IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(n -> (number % n == 0));
    }
    public static long getG() {
        long g = 0;
        try {
            Random random = new Random();
            g = random.nextLong(10000);
            if (1 < getP() - 1 && Power.modulo(g, getQ(), getP()) != 1) {
                return g;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return g;
    }
}
