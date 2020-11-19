package Enums;

import java.util.Random;

public class Loader {
    public static void main(String[] args) {
        Random random = new Random(System.currentTimeMillis());

        Seasons season = Seasons.values()[random.nextInt(4)];
        Players player = Players.values()[random.nextInt(4)];

        System.out.println(season + " " + season.getGame());
        System.out.println(player + " " + player.getGame());

        if (player.getGame() == season.getGame()) {
            System.out.println(player + " выиграл");
        }
        else {
            System.out.println(player + " проиграл");
        }
    }
}
