package cz.kamosh.betExample;

public enum WinLostBetResult implements BetResult {

    WIN(InnerBetResult.INNER_WIN),
    LOST(InnerBetResult.INNER_LOST);

    final InnerBetResult innerBetResult;

    private WinLostBetResult(InnerBetResult innerBetResult) {
        this.innerBetResult = innerBetResult;
    }

    @Override
    public InnerBetResult getInnerBetResult() {
        return innerBetResult;
    }

}
