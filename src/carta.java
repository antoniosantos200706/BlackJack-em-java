public class carta {
    private final valor valor;
    private final Nipes nipe;

    public carta(valor valor, Nipes nipe) {
        this.valor = valor;
        this.nipe = nipe;
    }

    public Nipes getNipe() {
        return nipe;
    }

    public valor getValor() {
        return valor;
    }
    public int getValorNumerico(){
        return valor.getValor();
    }
}
