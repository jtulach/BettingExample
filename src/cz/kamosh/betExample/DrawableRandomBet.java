package cz.kamosh.betExample;

import java.util.Random;

/**
 * This is basic implementation of drawable bet based on random numbers.
 */
public final class DrawableRandomBet  {    
    private static Random rnd = new Random(System.currentTimeMillis());
    
    public DrawableBetResult checkBet() {
        switch(rnd.nextInt(3)) {
            case 0:
                return DrawableBetResult.WIN;
            case 1:
                return DrawableBetResult.LOST;
            case 2:
                return DrawableBetResult.DRAW;
        }
        throw new IllegalStateException("Disaster, random not returning value from range");
    }
    
    /**
     * Package private method suitable only for tests
     * @param seed Value for random seed
     */
    static void setSeed(long seed)
    {
        rnd = new Random(seed);
    }
 
}
