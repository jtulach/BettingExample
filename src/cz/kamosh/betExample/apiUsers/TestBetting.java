package cz.kamosh.betExample.apiUsers;

import cz.kamosh.betExample.BettingAgency;
import cz.kamosh.betExample.DrawableRandomBet;
import cz.kamosh.betExample.DrawableBetResult;
import cz.kamosh.betExample.WinLostTimeBasedBet;
import cz.kamosh.betExample.WinLostBetResult;

public class TestBetting {
    private static final double START_CASH = 1000;
    private static final double EACH_STAKE_AMOUNT = 200;
     
    public static void main(String[] args) {
        double myCash = START_CASH;        
        
        BettingAgency bettingAgency = BettingAgency.getInstance();
        
        System.out.println("Before betting");
        showScore(bettingAgency, myCash);
        System.out.println("-----------");
        
        // Let's try to bet 5 times.
        // Some of the bets might have draw results
        myCash -=EACH_STAKE_AMOUNT;
        myCash += bettingAgency.evaluateBet(EACH_STAKE_AMOUNT, DrawableBetResult.DRAW, new DrawableRandomBet());
        myCash -=EACH_STAKE_AMOUNT;
        myCash += bettingAgency.evaluateBet(EACH_STAKE_AMOUNT, WinLostBetResult.LOST, new WinLostTimeBasedBet());
        myCash -=EACH_STAKE_AMOUNT;
        myCash += bettingAgency.evaluateBet(EACH_STAKE_AMOUNT, DrawableBetResult.WIN, new DrawableRandomBet());
        myCash -=EACH_STAKE_AMOUNT;
        myCash += bettingAgency.evaluateBet(EACH_STAKE_AMOUNT, WinLostBetResult.WIN, new WinLostTimeBasedBet());
        myCash -=EACH_STAKE_AMOUNT;
        myCash += bettingAgency.evaluateBet(EACH_STAKE_AMOUNT, DrawableBetResult.LOST, new DrawableRandomBet());                
        
        System.out.println("After betting score");
        showScore(bettingAgency, myCash);
        
        if(myCash < START_CASH) {
            System.out.println("I lost");
        } else {
            System.out.println("I am a winner!!!");
        }        
    }
    
    private static void showScore(BettingAgency bettingAgency, double myCash) {
        System.out.println("Betting agency: " + bettingAgency.getCurrentCashAmount());
        System.out.println("Me: " + myCash);
    }
}
