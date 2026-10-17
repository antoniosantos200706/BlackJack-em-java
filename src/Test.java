import java.util.HashSet;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        testarIntegridadeBaralho();
        testarDinamicaDoAs();
        System.out.println("\n✓ Todos os 2 testes passaram com sucesso!");
    }

    /**
     * Teste 1: Verifica se o Baralho inicializa com 52 cartas sem nulls,
     * se não há duplicados e se o método tirarCarta() esvazia a pilha.
     */
    private static void testarIntegridadeBaralho() {
        System.out.println("--- Teste 1: Baralho (52 cartas e consumo da pilha) ---");
        Baralho baralho = new Baralho();
        Set<String> cartasUnicas = new HashSet<>();
        int contador = 0;

        while (!baralho.EstaVazio()) {
            Carta c = baralho.tirarCarta();
            assert c != null : "Erro: Foi retirada uma carta nula do baralho!";
            cartasUnicas.add(c.toString());
            contador++;
        }

        assert contador == 52 : "Falha: O baralho devia ter 52 cartas, mas teve: " + contador;
        assert cartasUnicas.size() == 52 : "Falha: Existem cartas repetidas no baralho!";
        assert baralho.EstaVazio() : "Falha: O baralho devia estar vazio no final!";
        System.out.println("-> OK: 52 cartas únicas consumidas corretamente.");
    }

    /**
     * Teste 2: Testa a transição dinâmica de valor do Ás (11 para 1)
     * e o cálculo de pontuação com figuras (rei/rainha/valete).
     */
    private static void testarDinamicaDoAs() {
        System.out.println("\n--- Teste 2: Pontuação e Dinâmica do Ás ---");
        Jogador jogador = new Jogador(false);

        // 1. Ás (11) + nove (9) = 20 pontos
        jogador.adicionarCarta(new Carta(Valor.As, Nipes.espadas));
        jogador.adicionarCarta(new Carta(Valor.nove, Nipes.copas));
        assert jogador.getPontos() == 20 : "Falha: Esperado 20 pontos, obteve: " + jogador.getPontos();

        // 2. + Ás: total de 20 + 11 = 31 -> reduz um Ás para 1 -> fica 21 pontos
        jogador.adicionarCarta(new Carta(Valor.As, Nipes.ouros));
        assert jogador.getPontos() == 21 : "Falha: Esperado 21 pontos, obteve: " + jogador.getPontos();
        assert !jogador.excedeu() : "Falha: Jogador não devia ter estourado com 21!";

        // 3. + rainha (10): total de 21 + 10 = 31 -> reduz o outro Ás para 1 -> mantém 21 pontos
        jogador.adicionarCarta(new Carta(Valor.rainha, Nipes.paus));
        assert jogador.getPontos() == 21 : "Falha: Esperado 21 pontos após converter ambos os Ases, obteve: " + jogador.getPontos();

        // 4. + dois (2): 21 + 2 = 23 -> rebentou (> 21)
        jogador.adicionarCarta(new Carta(Valor.dois, Nipes.espadas));
        assert jogador.getPontos() == 23 : "Falha: Esperado 23 pontos, obteve: " + jogador.getPontos();
        assert jogador.excedeu() : "Falha: Jogador devia ter estourado com 23 pontos!";

        System.out.println("-> OK: Lógica de pontuação e redução do Ás validada.");
    }

    /**
     * Teste 3: Valida restrições financeiras do Jogador e Dealer,
     * bem como o isolamento do saldo no reset da mão.
     */

        // 4. Adiciona cartas e executa o reset de ronda

}