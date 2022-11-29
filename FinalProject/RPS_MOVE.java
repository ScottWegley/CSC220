package FinalProject;

public enum RPS_MOVE {
    ROCK,
    PAPER,
    SCISSORS;

    public RPS_OUTCOME fight(RPS_MOVE enemyMove) {
        if (this == enemyMove) {
            return RPS_OUTCOME.DRAW;
        }
        switch (this) {
            case ROCK:
                return ( enemyMove == PAPER ? RPS_OUTCOME.DEFEAT : RPS_OUTCOME.VICTORY);
            case PAPER:
                return ( enemyMove == SCISSORS ? RPS_OUTCOME.DEFEAT : RPS_OUTCOME.VICTORY);
            default: //Scissors Case
                return ( enemyMove == ROCK ? RPS_OUTCOME.DEFEAT : RPS_OUTCOME.VICTORY);
        }
    }
}