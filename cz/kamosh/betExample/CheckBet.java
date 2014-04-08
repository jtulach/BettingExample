package cz.kamosh.betExample;

interface CheckBet<BET_RESULT extends BetResult> {

    BET_RESULT checkBet();
}
