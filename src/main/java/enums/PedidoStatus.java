package enums;

/**
 *
 * @author ander
 */
public enum PedidoStatus {
    ORCAMENTO('O'),
    ABERTO('A'),
    FECHADO('F'),
    CANCELADO('C');
    
    private char sigla;

    private PedidoStatus(char sigla) {
        this.sigla = sigla;
    }

    public char getSigla() {
        return sigla;
    }

    public void setSigla(char sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return Character.toString(sigla);
    }
    
    
}
