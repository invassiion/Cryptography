import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;

public class Power {


    //    todo Функция быстрого возведения числа в степень по модулю.
    public static BigInteger Powmod(BigInteger a, BigInteger x, BigInteger p) {
//        y=ax mod p
        return ((a.modPow(x, p)));
    }

    public static long modulo(long a, long x, long p) {
        long y = 1;
        long s = a; // хранит текущее значние ряда
        while (x > 0) {
            if (x % 2 == 1) { // в двоичном коде числа х берем только единицы
                y = (y * s) % p; // вычесялем следующее значние ряда
            }
            s = (s * s) % p;
            x /= 2;
        }
        return (y % p); // итоговое значение
    }


// todo Функция, реализующая обобщённый алгоритм Евклида. Функция
//      должна позволять находить наибольший общий делитель и обе
//      неизвестных из уравнения.

//    ищем остаток деления b % a (30 % 18) = 12, присваиваем b = 12, повторяем цикл но теперь у нас уже a > b(b = 12)
//значит выполняем a % b (18 % 12) = 6? снова переходим к циклу, теперь снова b > a, значит выполняем b % a (30 % 6),
// остаток от деления 0, на этом мы прекращаем наш цикл и узнаем,
// что наибольший общий делитель 18 и 30 = 6. и выводим a + b (b = 0, a = 6).

//        public static int evklid(int a,int b) {
//            while (b !=0) { //Если a > b, то a = a % b, если меньше, то b = b % a
//                int tmp = a%b;
//                a = b;
//                b = tmp;
//            }
//            return a;
//        }

//        ax + by = gcd(a, b)

    public static int extentedEvklid(int a, int b, AtomicInteger x, AtomicInteger y) {
        if (a == 0) {
            x.set(0);
            y.set(1);
            return b;
        }
        AtomicInteger X = new AtomicInteger(), Y = new AtomicInteger();
        int gcd = extentedEvklid(b % a, a, X, Y);
        x.set(Y.get() - b / a * X.get());
        y.set(X.get());
        return gcd;

    }

    public static boolean DiHel() {
        System.out.println(" Cхема Диффи-Хеллмана \t");
        long aliceResult = 0;
       long aliceQ = GenDH.getQ();
       long P = GenDH.getP();
       long g = GenDH.getG();
            aliceResult =  Power.modulo(g,aliceQ ,P);
            long bobResult = 0;
            long bobQ = GenDH.getQ();
            bobResult = Power.modulo(g,bobQ, P);
            long aliceKey;
            aliceKey = Power.modulo(bobResult,aliceQ, P);

             long bobKey;
            bobKey = Power.modulo(aliceResult, bobQ, P);
            if (aliceKey == bobKey) {
            System.out.println("Ключ Алисы - " + aliceKey + "\n" +
                    "Ключ Боба - " + bobKey + "\n" +
                    "Программа отработала успешно, ключи совпали");
        } else {
            System.out.println("Программа позорная, ключи не совпали");

        }
        return true;
    }
}





//    todo Функция построения общего ключа для двух абонентов по схеме
//         Диффи-Хеллмана
