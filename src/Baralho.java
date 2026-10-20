import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Baralho implements Iterable<Carta> {
    private final Deque<Carta> stack = new ArrayDeque<>(52);

    public Baralho() {
        List<Carta> listaCartas = Stream.of(Nipes.values())
                .flatMap(n -> Stream.of(Valor.values())
                        .filter(v -> v != Valor.As1)
                        .map(v -> new Carta(v, n)))
                        .collect(Collectors.toList());

        // Baralha a lista
        Collections.shuffle(listaCartas);

        // Insere as cartas na pilha
        listaCartas.forEach( stack::push);
    }


    public Iterator<Carta> iterator() {
        return this.stack.iterator();
    }
    public boolean EstaVazio(){return this.stack.isEmpty(); }

    public Carta tirarCarta () {return this.stack.pop();}
}
