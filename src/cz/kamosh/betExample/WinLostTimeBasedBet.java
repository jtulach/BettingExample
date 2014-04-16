package cz.kamosh.betExample;

/** 
 * This is basic implementation of win/lost bet based on current time.
 */
public final class WinLostTimeBasedBet {    
    
    public WinLostBetResult checkBet() {
        if(System.currentTimeMillis() % 2 == 0) {
            return WinLostBetResult.WIN;
        } else {
            return WinLostBetResult.LOST;
        }        
    }    

}
