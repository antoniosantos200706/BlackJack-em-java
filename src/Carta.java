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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("valor: ");
        switch (this.valor){
            case Valor.As ,Valor.As1 -> sb.append("Ás");
            case Valor.um -> sb.append("1");
            case Valor.dois -> sb.append("2");
            case Valor.tres -> sb.append("3");
            case Valor.quatro -> sb.append("4");
            case Valor.cinco-> sb.append("5");
            case Valor.seis -> sb.append("6");
            case Valor.sete -> sb.append("7");
            case Valor.oito -> sb.append("8");
            case Valor.nove -> sb.append("9");
            case Valor.dez -> sb.append("10");
            case Valor.valete -> sb.append("Valete");
            case Valor.rainha -> sb.append("Dama");
            case Valor.rei -> sb.append("Rei");
        }
       sb.append( "  Nipe: " );
        switch (this.nipe){
            case Nipes.espadas ->  sb.append("Espadas (♠)");
            case Nipes.paus ->  sb.append("Paus (♣)");
            case Nipes.copas ->  sb.append("Copas (♥)");
            case Nipes.ouros ->  sb.append("Ouros (♦)");
        }
        return sb.toString();
    }
    public void setParaBaixo(){
        this.viradaCima = false;
    }
    public void setParaCima(){this.viradaCima = true;}
}
