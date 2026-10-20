public class Jogo {
    private final Baralho baralho;
    private final Jogador jogador;
    private final Dealer dealer;
    private boolean vezDeJogador;
    private boolean jogoTreminado;

    public Jogo() {
    this.dealer = new Dealer();
    this.jogador = new Jogador(false);
    this.baralho = new Baralho();
    }

    public void iniciarJogo(int aposta){

        if(aposta > 0 && aposta <= jogador.getSaldo() ) {
            this.jogador.apostar(aposta);
            this.jogador.adicionarSaldo(-aposta);

            Carta c = baralho.tirarCarta();
            c.setParaBaixo();

            this.dealer.adicionarCarta(c);
            this.dealer.adicionarCarta(baralho.tirarCarta());
            this.jogador.adicionarCarta(baralho.tirarCarta());
            this.jogador.adicionarCarta(baralho.tirarCarta());

            this.vezDeJogador = true;
            this.jogoTreminado = false;

            if( jogador.getPontos() == 21) turnoJogadorNaopedir();
        }
    }

    public void turnoJogadorPedir(){
        if (vezDeJogador && !jogoTreminado){
            jogador.adicionarCarta(baralho.tirarCarta());

             if(jogador.excedeu()){
                this.vezDeJogador = false;
                this.jogoTreminado = true;
                 dealer.getMao().get(0).setParaCima();
             }
        }
    }
    public void turnoJogadorNaopedir(){
        if (vezDeJogador && !jogoTreminado){
            this.vezDeJogador = false;
            turnoDealer();
            resolverResultado();
            this.jogoTreminado = true;
        }
    }

    public void turnoDealer(){
       while (dealer.dealerTiraCarta(dealer.getPontos())){
           dealer.adicionarCarta(baralho.tirarCarta());
       }
       dealer.getMao().get(0).setParaCima();
    }

    public void resolverResultado() {
        int pontosJ = jogador.getPontos();
        int pontosD = dealer.getPontos();
        int aposta = jogador.getAposta();

        if (jogador.excedeu()) {
            return;
        }

        if (dealer.excedeu() || pontosJ > pontosD) {
            if (pontosJ == 21 && jogador.getMao().size()==2 ) {
                jogador.adicionarSaldo(aposta + (aposta * 3) / 2);
            } else {
                jogador.adicionarSaldo(aposta * 2);
            }
        } else if (pontosJ == pontosD) {
            jogador.adicionarSaldo(aposta);
        }
    }
    public void proximoJogo(){
        this.jogador.limparjogo();
        this.dealer.limparJogo();
        this.vezDeJogador = false;
        this.jogoTreminado = false;
    }

    public boolean isJogoTreminado() {return jogoTreminado;}

    public boolean isVezDeJogador() {return vezDeJogador;}

    public Dealer getDealer() {return dealer;}

    public Jogador getJogador() {return jogador;}

    public Baralho getBaralho() {return baralho;}
}

