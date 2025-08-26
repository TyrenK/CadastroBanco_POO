package objetos;

public class Cliente extends Pessoa {
    
    private Conta conta;

    public Cliente(String nome, String endereco, String telefone, String cpf){
        super(nome, endereco, telefone, cpf);
    }

    public Conta getConta() {
        return conta;
    }
    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
