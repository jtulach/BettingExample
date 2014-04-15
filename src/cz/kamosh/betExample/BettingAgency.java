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
        return innerEvaluateBet(amount, expectedResult, checkDrawableBet);
    }

    public double evaluateBet(double amount, WinLostBetResult expectedResult, WinLostTimeBasedBet checkWinLooseBet) {
        return innerEvaluateBet(amount, expectedResult, checkWinLooseBet);
    }

    private double innerEvaluateBet(double amount, BetResult betResult, Bet checkBet) {
        if(amount < 0) {
            throw new IllegalArgumentException("Cannot bet negative money");
        }
        cash += amount;
        if (checkBet.checkBet().getInnerBetResult() == betResult.getInnerBetResult()) {
            cash -= amount * BETTING_ODD;
            return amount * BETTING_ODD; // User won
        }
        return 0;
    }
}
