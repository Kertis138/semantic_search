package univek.com.semanticserver.core.managers;

import java.util.ArrayList;

public class ThreadManager {
    private ArrayList<Thread> threads = new ArrayList<>();
    private int lastThreadsCount = 0;
    private long lastThreadsTime = 0;

    public int getThreadsCount() {
        return threads.size();
    }

    public int getLastThreadsCount() {
        return lastThreadsCount;
    }

    public long getLastThreadsTime() {
        return lastThreadsTime;
    }

    public void addNewTask(Runnable task) {
        Thread thread = new Thread(task);
        threads.add(thread);
    }

    public void runAllAndJoin() {
        for (Thread thread : threads)
            thread.start();

        try {

            long start = System.currentTimeMillis();
            for (Thread thread : threads)
                thread.join();

            long finish = System.currentTimeMillis();
            lastThreadsTime = finish - start;
            lastThreadsCount = getThreadsCount();
            threads.clear();
        }
        catch (Exception e) {
            e.printStackTrace();
            threads.clear();
        }
    }
}
