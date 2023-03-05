import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;
public class Main {


    public static void main(String[] args) {

        System.out.println("Возведение в степень  адекватным методом : " + Power.Powmod(BigInteger.valueOf(7),BigInteger.valueOf(23),BigInteger.valueOf(11)));
        System.out.println("Возведение в степень самостоятельно : " +Power.modulo(7,23,11));
        AtomicInteger x = new AtomicInteger(), y = new AtomicInteger();
        System.out.println("обобщенный Алгоритм Евклида: " + Power.extentedEvklid(15,10,x,y));
        System.out.printf("x = %d, y = %d\n", x.get(), y.get());
        System.out.println(Power.DiHel());

//        System.out.println(GenDH.getQ());
//        System.out.println(GenDH.getP());
//        System.out.println(GenDH.getG());

    }


}

