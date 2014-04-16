package cz.kamosh.betExample;

public final class BettingAgency {

    private static final BettingAgency INSTANCE = new BettingAgency();

    // If you win, betting agency will pay you amount * BETTING_ODD
    private static final double BETTING_ODD = 1.4;    
    // Betting agency initial cash
    private static double cash = 10000;

    private BettingAgency() {
    }

    public static BettingAgency getInstance() {
        return INSTANCE;
    }

    public double getCurrentCashAmount() {
        return cash;
    }
    
    public double evaluateBet(double amount, DrawableBetResult expectedResult, DrawableRandomBet checkDrawableBet) {
        class EvalDrawableBet extends Evaluate<DrawableRandomBet> {
            @Override
            protected InnerBetResult betResult(DrawableRandomBet b) {
                return b.checkBet().getInnerBetResult();
            }
        }
        return new EvalDrawableBet().innerEvaluateBet(amount, expectedResult, checkDrawableBet);
    }

    public double evaluateBet(double amount, WinLostBetResult expectedResult, WinLostTimeBasedBet checkWinLooseBet) {
        class EvalWinLostBet extends Evaluate<WinLostTimeBasedBet> {
            @Override
            protected InnerBetResult betResult(WinLostTimeBasedBet b) {
                return b.checkBet().getInnerBetResult();
            }
        }
        return new EvalWinLostBet().innerEvaluateBet(amount, expectedResult, checkWinLooseBet);
    }
    
    private abstract class Evaluate<BET> {
        public double innerEvaluateBet(double amount, BetResult betResult, BET checkBet) {
            if(amount < 0) {
                throw new IllegalArgumentException("Cannot bet negative money");
            }
            cash += amount;
            if (betResult(checkBet) == betResult.getInnerBetResult()) {
                cash -= amount * BETTING_ODD;
                return amount * BETTING_ODD; // User won
            }
            return 0;
        }
        
        protected abstract InnerBetResult betResult(BET b);
    }
}
