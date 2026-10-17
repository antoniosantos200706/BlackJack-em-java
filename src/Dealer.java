import java.util.Random;

public class Dealer {
    private final Jogador dealer;
    private static final Random r = new Random();
    public Dealer() {
        this.dealer = new Jogador(true);
    }

    public boolean dealerTiraCarta(int pontos) {
        if (pontos <= 16) return true;
        int prob = 1 + r.nextInt(20);
        int margem = 21 - pontos;

        return prob <= margem;
    }


    public Jogador getDealer() {
        return dealer;
    }
}

