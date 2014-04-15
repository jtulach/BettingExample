package cz.kamosh.betExample;

import org.junit.Assert;
import org.junit.Test;

public class WinLostTimeBasedBetTest {

    @Test
    public void testProbability() throws InterruptedException {
        // With many attempts, we should be quite close to probability 1/2        
        final int ATTEMPTS_COUNT = 200;
        int winningAttempts = 0;
        for (int i = 0; i < ATTEMPTS_COUNT; i++) {
            Thread.sleep(25L);
            if (BettingAgency.getInstance().evaluateBet(100, WinLostBetResult.WIN, new WinLostTimeBasedBet()) > 0) {
                winningAttempts++;
            }
        }
        Assert.assertEquals((double) 1 / 2, (double)winningAttempts / (double)ATTEMPTS_COUNT, 0.1);
    }
}
