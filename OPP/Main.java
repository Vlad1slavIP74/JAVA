package lab2;

/**
 *         Assignment #2
 *    F1 = ((A + B)*(C*(MA*ME)))
 *    F2 = SORT(TRANS(MF)*MK)
 *    F3 = MAX((MO*MP)*R + MS*S)
 *
 */
public class Main {

    public static final int N = 4;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new F1("T1", Thread.MIN_PRIORITY, N);
        Thread t2 = new F2("T2", Thread.MAX_PRIORITY, N);
        Thread t3 = new Thread(new F3(N));
        t3.setName("T3");
        t3.setPriority(Thread.NORM_PRIORITY);

        t1.start(); // запускаю поток. викликаючи його метод run
        t2.start();
        t3.start();

        t1.join(); // очікую завершення потоків
        t2.join();
        t3.join();

    }

}