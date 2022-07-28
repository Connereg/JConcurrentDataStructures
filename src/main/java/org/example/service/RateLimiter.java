package org.example.service;

import java.util.concurrent.Semaphore;

public class RateLimiter {
    private final int PERMITS_PER_SECOND;

    Semaphore sem;
    Thread permitReleaseThread;

    public static RateLimiter create(int permitsPerSecond) {
        return new RateLimiter(permitsPerSecond);
    }

    private RateLimiter(int permitsPerSecond) {

        PERMITS_PER_SECOND = permitsPerSecond;

        sem = new Semaphore(PERMITS_PER_SECOND);

        permitReleaseThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    sem.release(PERMITS_PER_SECOND);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        permitReleaseThread.start();

    }
    /**
     * If 'count' number of permits are available, claim them.
     * Else, wait.
     */
    public void acquire(int count) {
        // TODO
//        if (this.sem.availablePermits() >= count) {
//            try {
//                sem.acquire(count);
//            }
//            catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }

    /**
     * If 1 permit is available, claim it.
     * Else, wait.
     */
    public void acquire() {
        // TODO
        try {
            sem.acquire(1);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
