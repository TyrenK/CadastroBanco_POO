package funcoes;

import objetos.*;
import telas.Janela;
import java.util.ArrayList;
import javax.swing.*;

public class Cadastro {

    private Janela janela;
    private Cliente cliente;
    private Conta conta;

    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Conta> contas = new ArrayList<>();

    public Cadastro(Janela janela) {
        this.janela = janela;
        configurarEventos();

        janela.getJbConsultar().setEnabled(false);
        janela.getJbAtualizar().setEnabled(false);
        janela.getJbExcluir().setEnabled(false);
    }

    private void configurarEventos() {
        janela.getJbConsultar().addActionListener(e -> consultar());
        janela.getJbCriar().addActionListener(e -> criar());
        janela.getJbAtualizar().addActionListener(e -> atualizar());
        janela.getJbExcluir().addActionListener(e -> excluir());
    }

    private void criar() {

        if (!camposPreenchidos()) return;

        int agencia = Integer.parseInt(janela.getJtfAgencia().getText());
        int numero = Integer.parseInt(janela.getJtfConta().getText());

        boolean existe = contas.stream()
            .anyMatch(c -> c.getAgencia() == agencia && c.getNumero() == numero);
        if (existe) {
            JOptionPane.showMessageDialog(janela, "Conta já existe!");
            return;
        }

        if (janela.getJrbCorrente().isSelected()) {
            conta = new ContaCorrente(agencia, numero, 0.0);
        } else {
            conta = new ContaPoupanca(agencia, numero, 0.0);
        }
        contas.add(conta);

        cliente = new Cliente(janela.getJtfNome().getText(),
                            janela.getJtfEndereco().getText(),
                            janela.getJtfTelefone().getText(),
                            janela.getJtfCpf().getText());
        cliente.setConta(conta);
        clientes.add(cliente);

        JOptionPane.showMessageDialog(janela, "Conta criada com sucesso!");
        limparCampos();
        janela.getJbConsultar().setEnabled(true);

    }


    private void consultar() {
        try {
            String strAgencia = janela.getJtfAgencia().getText();
            String strConta = janela.getJtfConta().getText();
            int agencia = Integer.parseInt(janela.getJtfAgencia().getText());
            int numero = Integer.parseInt(janela.getJtfConta().getText());

            if (strAgencia.isEmpty() || strConta.isEmpty()) {
                JOptionPane.showMessageDialog(janela, "Número da agência e da conta devem ser preenchidos!");
                return; 
            }

            conta = contas.stream()
                    .filter(c -> c.getAgencia() == agencia && c.getNumero() == numero)
                    .findFirst()
                    .orElse(null);

            if (conta != null) {
                int index = contas.indexOf(conta);
                cliente = clientes.get(index);

                janela.getJtfNome().setText(cliente.getNome());
                janela.getJtfEndereco().setText(cliente.getEndereco());
                janela.getJtfTelefone().setText(cliente.getTelefone());
                janela.getJtfCpf().setText(cliente.getCpf());

                if (conta instanceof ContaCorrente) {
                    janela.getJrbCorrente().setSelected(true);
                } else {
                    janela.getJrbPoupanca().setSelected(true);
                }

                JOptionPane.showMessageDialog(janela, "Conta encontrada!");
                janela.getJbAtualizar().setEnabled(true);
                janela.getJbExcluir().setEnabled(true);

                janela.getJrbCorrente().setEnabled(false);
                janela.getJrbPoupanca().setEnabled(false);

                janela.getJtfNome().setEditable(false);
                janela.getJtfEndereco().setEditable(false);
                janela.getJtfTelefone().setEditable(false);
                janela.getJtfCpf().setEditable(false);
                janela.getJtfAgencia().setEditable(false);
                janela.getJtfConta().setEditable(false);
            } else {
                JOptionPane.showMessageDialog(janela, "Conta não encontrada!");
                janela.getJbAtualizar().setEnabled(false);
                janela.getJbExcluir().setEnabled(false);
                limparCampos();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(janela, "Agência e Conta devem ser números!");
        }
    }

    private boolean editando = false;

    private void atualizar() {
        if (cliente == null || conta == null) return;

        if (!editando) {
            janela.getJtfNome().setEditable(true);
            janela.getJtfEndereco().setEditable(true);
            janela.getJtfTelefone().setEditable(true);
            janela.getJtfCpf().setEditable(true);
            janela.getJtfAgencia().setEditable(true);
            janela.getJtfConta().setEditable(true);
            janela.getJrbCorrente().setEnabled(true);
            janela.getJrbPoupanca().setEnabled(true);

            janela.getJbExcluir().setEnabled(false);

            editando = true;
        } else {
            cliente.setNome(janela.getJtfNome().getText());
            cliente.setEndereco(janela.getJtfEndereco().getText());
            cliente.setTelefone(janela.getJtfTelefone().getText());
            cliente.setCpf(janela.getJtfCpf().getText());

            int novaAgencia = Integer.parseInt(janela.getJtfAgencia().getText());
            int novoNumero = Integer.parseInt(janela.getJtfConta().getText());
            conta.setAgencia(novaAgencia);
            conta.setNumero(novoNumero);

            Conta novaConta = null;
            if (janela.getJrbCorrente().isSelected() && !(conta instanceof ContaCorrente)) {
                novaConta = new ContaCorrente(conta.getAgencia(), conta.getNumero(), conta.getSaldo());
            } else if (janela.getJrbPoupanca().isSelected() && !(conta instanceof ContaPoupanca)) {
                novaConta = new ContaPoupanca(conta.getAgencia(), conta.getNumero(), conta.getSaldo());
            }

            if (novaConta != null) {
                int index = contas.indexOf(conta);
                contas.set(index, novaConta);
                cliente.setConta(novaConta);
                conta = novaConta;
            }

            JOptionPane.showMessageDialog(janela, "Dados atualizados com sucesso!");
            limparCampos();
            janela.getJtfNome().setEditable(true);
            janela.getJtfEndereco().setEditable(true);
            janela.getJtfTelefone().setEditable(true);
            janela.getJtfCpf().setEditable(true);
            janela.getJtfAgencia().setEditable(true);
            janela.getJtfConta().setEditable(true);
            janela.getJrbCorrente().setEnabled(true);
            janela.getJrbPoupanca().setEnabled(true);

            janela.getJbAtualizar().setEnabled(false);
            janela.getJbExcluir().setEnabled(false);

            editando = false;
        }
    }

    private void excluir() {
        if (cliente != null && conta != null) {
            int opcao = JOptionPane.showConfirmDialog(
                    janela,
                    "Deseja realmente excluir esta conta?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION
            );

            if (opcao == JOptionPane.YES_OPTION) {
                int index = contas.indexOf(conta);
                contas.remove(index);
                clientes.remove(index);

                JOptionPane.showMessageDialog(janela, "Conta excluída com sucesso!");
                limparCampos();

                cliente = null;
                conta = null;
                janela.getJbAtualizar().setEnabled(false);
                janela.getJbExcluir().setEnabled(false);

                janela.getJtfNome().setEditable(true);
                janela.getJtfEndereco().setEditable(true);
                janela.getJtfTelefone().setEditable(true);
                janela.getJtfCpf().setEditable(true);
                janela.getJtfAgencia().setEditable(true);
                janela.getJtfConta().setEditable(true);
                janela.getJrbCorrente().setEnabled(true);
                janela.getJrbPoupanca().setEnabled(true);

                if (contas.isEmpty()) {
                    janela.getJbConsultar().setEnabled(false);
                }
            }
        }
    }

    private void limparCampos() {
        janela.getJtfAgencia().setText("");
        janela.getJtfConta().setText("");
        janela.getJtfNome().setText("");
        janela.getJtfEndereco().setText("");
        janela.getJtfTelefone().setText("");
        janela.getJtfCpf().setText("");
        janela.getJrbCorrente().setSelected(true);
    }
    
    private boolean camposPreenchidos() {
    if (janela.getJtfAgencia().getText().isEmpty() ||
        janela.getJtfConta().getText().isEmpty() ||
        janela.getJtfNome().getText().isEmpty() ||
        janela.getJtfEndereco().getText().isEmpty() ||
        janela.getJtfTelefone().getText().isEmpty() ||
        janela.getJtfCpf().getText().isEmpty()) {

        JOptionPane.showMessageDialog(janela, "Todos os campos devem ser preenchidos!");
        return false;
    }
        return true;
    }
}
