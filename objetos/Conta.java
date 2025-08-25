package objetos;

public abstract class Conta {
    private String agencia, numero;
    private double saldo;


    public String getAgencia(){
        return agencia;
    }
    public void setCpf(String agencia){
        this.agencia = agencia;
    }

    public String getNumero(){
        return numero;
    }
    public void setNome(String numero){
        this.numero = numero;
    }

    public double getSaldo(){
        return saldo;
    }
    public void setEndereco(double saldo){
        this.saldo = saldo;
    }
    
    public void gravar() {}
    public void editar() {}
    public void excluir() {}
    public void cancelar() {}
}
