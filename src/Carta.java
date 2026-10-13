public class Carta {
    private final Valor valor;
    private final Nipes nipe;
    private boolean viradaCima;

    public Carta(Valor valor, Nipes nipe) {
        this.valor = valor;
        this.nipe = nipe;
        this.viradaCima = true;
    }

    public Nipes getNipe() {
        return nipe;
    }

    public Valor getValor() {
        return valor;
    }
    public int getValorNumerico(){
        return valor.getValorNumerico();
    }
}
