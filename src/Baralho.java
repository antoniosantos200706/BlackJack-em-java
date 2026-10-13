import java.util.Deque; // interface
import java.util.ArrayDeque; // codigo

public class Baralho {
    private static Carta [] cartas = new Carta[52];

    public Baralho() {
        int i = 0;
        Deque<Carta> baralho = new ArrayDeque<>();
        for (Nipes n: Nipes.values()){
            for (Valor v : Valor.values()){
                this.cartas[i] = new Carta(v ,n);
            }
        }
    }
}
