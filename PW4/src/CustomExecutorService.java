import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CustomExecutorService implements ExecutorService {

    private final int threadNum;
    private final List<Thread> threads;
    private final BlockingQueue<Runnable> tasks;

    public CustomExecutorService(int threadNum) {
        this.threadNum = threadNum;
        this.threads = new ArrayList<>(threadNum);
        this.tasks = new LinkedBlockingQueue<>();

        for (int i = 0; i < threadNum; i++) {
            Thread thread = new Thread(() -> {
                while (true) {
                    Runnable task = null;
                    try {
                        task = tasks.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                    task.run();
                }
            });
            thread.start();
            threads.add(thread);
        }
    }

    @Override
    public void execute(Runnable command) {
        tasks.add(command);
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        FutureTask<T> futureTask = new FutureTask<>(task);
        execute(futureTask);
        return futureTask;
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        FutureTask<T> futureTask = new FutureTask<>(task, result);
        execute(futureTask);
        return futureTask;
    }

    @Override
    public Future<?> submit(Runnable task) {
        FutureTask<?> futureTask = new FutureTask<>(task, null);
        execute(futureTask);
        return futureTask;
    }
    @Override
    public void shutdown() {
        threads.forEach(Thread::interrupt);
    }

    @Override
    public List<Runnable> shutdownNow() {
        threads.forEach(Thread::interrupt);
        return new ArrayList<>(tasks);
    }

    @Override
    public boolean isShutdown() {
        return threads.stream().allMatch(Thread::isInterrupted);
    }

    @Override
    public boolean isTerminated() {
        return tasks.isEmpty() && threads.stream().allMatch(Thread::isInterrupted);
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }



    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return null;
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        List<Future<T>> futures = new ArrayList<>();
        for (Callable<T> task : tasks) {
            FutureTask<T> futureTask = new FutureTask<>(task);
            futures.add(futureTask);
            execute(futureTask);
        }

        var startTime = System.currentTimeMillis();
        while (!futures.stream().allMatch(Future::isCancelled)) {
            if (unit.toMillis(timeout) > System.currentTimeMillis() - startTime) {
                break;
            }
            Thread.sleep(100);
        }
        return futures;
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return null;
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }


}
