package cz.kamosh.betExample;

import java.util.Random;

/**
 * Implementer may introduce any type of drawable bet extending this class. 
 * This is basic implementation based on random numbers.
 */
public class DrawableBet implements CheckBet<DrawableBetResult> {    
    private static Random rnd = new Random(System.currentTimeMillis());
    
    @Override
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
 
}
