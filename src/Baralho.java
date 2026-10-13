import java.util.Deque; // interface
import java.util.ArrayDeque; // codigo
import  java.util.Random;// para o shufle

public class Baralho {
    private static final Carta [] cartas = new Carta[52];
    private final Deque<Carta> stack = new ArrayDeque<>(cartas.length);

    public Baralho() {
        int i = 0;
        for (Nipes n: Nipes.values()){
            for (Valor v : Valor.values()){
                this.cartas[i] = new Carta(v ,n);
                i++;
            }
        }
        shufle(cartas);
        for (Carta c : cartas) {
            stack.push(c);
        }
    }
    private void shufle( Carta[] c ){
        Random r = new Random();
        for (int i = 0 ;i < cartas.length; i++ ){
            int j = r.nextInt(i +1);

            Carta temp = cartas[j];
            c[i] =c[j];
            c[j]= temp;
        }
    }


    public boolean EstaVazio(){return this.stack.isEmpty(); }

    public Carta tirarCarta () {return this.stack.pop();}
}
