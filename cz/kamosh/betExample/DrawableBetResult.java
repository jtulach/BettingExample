package cz.kamosh.betExample;

public enum DrawableBetResult implements BetResult {

    WIN(InnerBetResult.INNER_WIN),
    LOST(InnerBetResult.INNER_LOST),
    DRAW(InnerBetResult.INNER_DRAW);

    final InnerBetResult innerBetResult;

    private DrawableBetResult(InnerBetResult innerBetResult) {
        this.innerBetResult = innerBetResult;
    }

    @Override
    public InnerBetResult getInnerBetResult() {
        return innerBetResult;
    }

}
