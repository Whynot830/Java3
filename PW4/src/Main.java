//import java.util.concurrent.ExecutorCompletionService;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class Main {
//    public static void main(String[] args) throws InterruptedException {
//        ExecutorCompletionService
//        Thread t1 = new Thread(() -> {
//            for (int i = 1; i <= 10; i++) {
//                System.out.println("This is message #" + i);
//
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    System.out.println("я собираюсь остановиться");
//                }
//            }
//        });
//        t1.start();
//        Thread.sleep(7000);
//        t1.interrupt();
//
//    }
//}


public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {

            CustomExecutorService a = new CustomExecutorService(1);
            for (int j = 0; j <100 ; j++) {
                final var j1 = j;
                a.submit(()-> System.out.println(j1));
            }
            a.submit(() -> {
                try {
                    System.out.println("aa;;a");
                    Thread.sleep(2000);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("1");
            });
            a.submit(() -> {
                System.out.println("2");
            });
        }


        System.out.println("I finished work");
    }
}