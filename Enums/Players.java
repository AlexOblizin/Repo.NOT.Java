public enum Players {
    TOM (Games.SUNDOGS),
    BILL (Games.POOLS),
    VASYA (Games.SHIPS),
    PETER (Games.SNOWBALLS);

    private Games game;

    Players(Games game) {
        this.game = game;
    }

    public Games getGame() {
        return game;
    }

}
