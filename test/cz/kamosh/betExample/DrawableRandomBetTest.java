package cz.kamosh.betExample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DrawableRandomBetTest {

    private static final long RANDOM_SEED = 0;

    public DrawableRandomBetTest() {
    }        

    @Test
    public void testWinDrawableBets() {
        DrawableRandomBet.setSeed(RANDOM_SEED);
        // We can be sure that we will win all bets, although they seem random,
        // this is because we can influence the seed for Random function        
        double wonMoney = 0;
        wonMoney += BettingAgency.getInstance().evaluateBet(100, DrawableBetResult.WIN, new DrawableRandomBet());
        wonMoney += BettingAgency.getInstance().evaluateBet(100, DrawableBetResult.LOST, new DrawableRandomBet());
        wonMoney += BettingAgency.getInstance().evaluateBet(100, DrawableBetResult.LOST, new DrawableRandomBet());
        wonMoney += BettingAgency.getInstance().evaluateBet(100, DrawableBetResult.DRAW, new DrawableRandomBet());
        wonMoney += BettingAgency.getInstance().evaluateBet(100, DrawableBetResult.DRAW, new DrawableRandomBet());
        wonMoney += BettingAgency.getInstance().evaluateBet(100, DrawableBetResult.DRAW, new DrawableRandomBet());
        wonMoney += BettingAgency.getInstance().evaluateBet(100, DrawableBetResult.DRAW, new DrawableRandomBet());
        wonMoney += BettingAgency.getInstance().evaluateBet(100, DrawableBetResult.WIN, new DrawableRandomBet());
        wonMoney += BettingAgency.getInstance().evaluateBet(100, DrawableBetResult.WIN, new DrawableRandomBet());
        wonMoney += BettingAgency.getInstance().evaluateBet(100, DrawableBetResult.DRAW, new DrawableRandomBet());
        DrawableRandomBet.setSeed(System.currentTimeMillis());
        Assert.assertEquals("Did not win expected money", 1400, wonMoney, .5);
    }
    
    @Test
    public void testProbability() {
        // With many attempts, we should be quite close to probability 1/3
        // that we win, althouth seed is really random
        DrawableRandomBet.setSeed(System.currentTimeMillis());
        final int ATTEMPTS_COUNT = 100000;
        int winningAttempts = 0;
        for(int i=0; i < ATTEMPTS_COUNT; i++)
        {
            if(BettingAgency.getInstance().evaluateBet(100, DrawableBetResult.WIN, new DrawableRandomBet()) > 0) {
                winningAttempts++;
            }
        }
        Assert.assertEquals((double)1/3, (double)winningAttempts/ATTEMPTS_COUNT, 0.01);        
    }
    
}
