package game.value;

import common.code.GameErrorCode;

public class TryCount {
    private final static int MIN_TRY_COUNT = 1;
    private int tryCount;

    public TryCount(int tryCount) {
        throwInvalidRangeOfTryCount(tryCount);
        this.tryCount = tryCount;
    }

    private void throwInvalidRangeOfTryCount(int tryCount) {
        if(tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException(GameErrorCode.INVALID_RANGE_OF_TRY_COUNT.getErrorMessage());
        }
    }

    public int getTryCount() {
        return tryCount;
    }


}
