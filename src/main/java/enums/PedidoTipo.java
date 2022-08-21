package enums;

/**
 *
 * @author ander
 */
public enum PedidoTipo {
    VENDA('V', "Venda"),ORCAMENTO('O', "Orçamento");
    
    public char sigla;
    public String tipo;
    
    private PedidoTipo(char sigla, String tipo){
        this.sigla = sigla;
        this.tipo = tipo;
    }

    public char getSigla() {
        return sigla;
    }

    public void setSigla(char sigla) {
        this.sigla = sigla;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return tipo;
    }
    
}
