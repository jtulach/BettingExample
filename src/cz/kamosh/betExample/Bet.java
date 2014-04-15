package cz.kamosh.betExample;

interface Bet<BET_RESULT extends BetResult> {

    BET_RESULT checkBet();
}
