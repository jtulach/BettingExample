package cz.kamosh.betExample;

/**
 * You may introduce a new  type of drawable bet by implementing this interface.
 */
public interface DrawableBet extends Bet<DrawableBetResult> {

    @Override
    public DrawableBetResult checkBet();
    
}