package cz.kamosh.betExample;

/**
 * You may introduce a new type of win/lost bet by implementing this interface.
 */
public interface WinLostBet {

    public WinLostBetResult checkBet();
    
}
