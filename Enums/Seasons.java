public enum Seasons {
    WINTER (Games.SNOWBALLS),
    SPRING (Games.SHIPS),
    SUMMER (Games.SUNDOGS),
    FALL (Games.POOLS);

    private Games game;

    Seasons(Games game) {
        this.game = game;
    }

    public Games getGame() {
        return game;
    }
}
