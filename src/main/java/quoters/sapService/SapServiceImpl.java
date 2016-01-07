package quoters.sapService;

import quoters.annotations.Benchmark;

/**
 * Created by Jeka on 14/10/2015.
 */
public class SapServiceImpl implements SapService {
    @Override
    public void doWork() {
        System.out.println("123");
    }

    @Override
    @Benchmark
    public void drinkBeer() {
        System.out.println("Giness is the best");
    }
}
