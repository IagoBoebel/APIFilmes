public enum MovieAtributes {
    NAME(1), POSTER_URL(2), NOTA(3), YEAR(4);

    private final int valor;

    MovieAtributes(int valor) {
        this.valor = valor;
    }
    public int getValor() {
        return valor;
    }
    public String toString() {
        return String.valueOf(valor);
    }
}
