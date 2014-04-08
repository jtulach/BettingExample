package cz.kamosh.betExample;

/**
 * Implementer may introduce any type of win/lost bet extending this class. 
 * This is basic implementation based on current time.
 */
public class WinLostBet implements CheckBet<WinLostBetResult> {    
    
    @Override
    public WinLostBetResult checkBet() {
        if(System.currentTimeMillis() % 2 == 0) {
            return WinLostBetResult.WIN;
        } else {
            return WinLostBetResult.LOST;
        }        
    }

}
