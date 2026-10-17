import java.util.*;
import java.util.stream.Collectors;

public class Baralho implements Iterable<Carta> {
    private final Deque<Carta> stack = new ArrayDeque<>(52);

    public Baralho() {
        Carta [] cartas = new Carta[52];
        List<Carta> listaCartas = Arrays.stream(Nipes.values())
                .flatMap(n -> Arrays.stream(Valor.values())
                        .filter(v -> v != Valor.As1)
                        .map(v -> new Carta(v, n)))
                .collect(Collectors.toList());

        // Baralha a lista
        Collections.shuffle(listaCartas);

        // Insere as cartas na pilha
        for (Carta c : listaCartas) {
            this.stack.push(c);
        }
    }
    private void shuffle( Carta[] c ){
        Random r = new Random();
        for (int i = 0 ;i < c.length; i++ ){
            int j = r.nextInt(i +1);

            Carta temp = c[j];
            c[i] =c[j];
            c[j]= temp;
        }
    }


    public Iterator<Carta> iterator() {
        return this.stack.iterator();
    }
    public boolean EstaVazio(){return this.stack.isEmpty(); }

    public Carta tirarCarta () {return this.stack.pop();}
}
