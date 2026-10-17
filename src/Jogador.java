import java.util.List; // interface
import java.util.ArrayList; // codigo

public class Jogador {
    private boolean dealer;
    protected List<Carta> mao =new ArrayList<>();
    private int saldo ;
    private int aposta;
    private int pontos;

    public Jogador(boolean dealer) {
        this.dealer = dealer;
        this.saldo = dealer ? 0 : 250;
        this.aposta = 0;
    }


// adiciona carta ao jogador e verifica se estourou e aplica a regra do As
    public void adicionarCarta(Carta c){
        this.mao.add(c);
        this.pontos += c.getValorNumerico();
        int ind = 0;
        for (Carta s : mao){
            if (excedeu() && s.getValor() == Valor.As ){
                mao.set(ind,new Carta(Valor.As1, s.getNipe()));
                this.pontos -= 10;
            }
        ind += 1;
        }
    }

    public boolean excedeu () {return (this.pontos > 21); } // estourou ?

    public void limparjogo(){ // reseta mão e aposta para fim da ronda
        this.mao.clear();
        this.aposta= 0;
        this.pontos = 0 ;
    }

    // getters
    public void apostar(int aposta) {
        this.aposta = aposta;
    }
    public int getPontos() {return pontos;}

    public int getSaldo() {
        return saldo;
    }
    public int getAposta() {
        return aposta;
    }
    public boolean isDealer() {
        return dealer;
    }
}
