public enum valor {
    um(1),
    dois(2),
    tres(3),
    quatro(4),
    cinco(5),
    seis(6),
    sete(7),
    oito(8),
    nove(9),
    dez(10),
    As(11),
    rainha(10),
    valete(10) ,
    rei(10);
    private final int valor;

    valor(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
