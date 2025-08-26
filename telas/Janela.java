package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import funcoes.*;

public class Janela extends JFrame {

    private JLabel jlAgencia, jlConta, jlNome, jlEndereco, jlTelefone, jlCpf;
    private JFormattedTextField jtfAgencia, jtfConta, jtfNome, jtfEndereco, jtfTelefone, jtfCpf;
    private JRadioButton jrbCorrente, jrbPoupanca;
    private ButtonGroup bgContas;
    private JSeparator jSeparator01, jSeparator02;
    private JButton jbConsultar, jbAtualizar, jbCriar, jbExcluir;

    public Janela() {
        super("Java Swing - Desenvolvimento de Sistemas");
        setSize(400, 255);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);
        centralizar();

        // Labels
        jlAgencia = new JLabel("Código da Agência");
        jlAgencia.setBounds(10, 10, 110, 18);
        getContentPane().add(jlAgencia);

        jlConta = new JLabel("Número da Conta:");
        jlConta.setBounds(205, 10, 105, 18);
        getContentPane().add(jlConta);

        jSeparator01 = new JSeparator();
        jSeparator01.setBounds(10, 40, 365, 10);
        getContentPane().add(jSeparator01);

        jlNome = new JLabel("Nome:");
        jlNome.setBounds(10, 50, 60, 18);
        jlNome.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(jlNome);

        jlEndereco = new JLabel("Endereço:");
        jlEndereco.setBounds(10, 75, 60, 18);
        jlEndereco.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(jlEndereco);

        jlTelefone = new JLabel("Telefone:");
        jlTelefone.setBounds(10, 100, 60, 18);
        jlTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(jlTelefone);

        jlCpf = new JLabel("CPF:");
        jlCpf.setBounds(10, 125, 60, 18);
        jlCpf.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(jlCpf);

        // Campos
        try {
            MaskFormatter maskAgencia = new MaskFormatter("####");
            maskAgencia.setPlaceholderCharacter('_');
            jtfAgencia = new JFormattedTextField(maskAgencia);
            jtfAgencia.setBounds(125, 10, 50, 20);
            getContentPane().add(jtfAgencia);

            MaskFormatter maskConta = new MaskFormatter("######");
            maskConta.setPlaceholderCharacter('_');
            jtfConta = new JFormattedTextField(maskConta);
            jtfConta.setBounds(315, 10, 60, 20);
            getContentPane().add(jtfConta);

            jtfNome = new JFormattedTextField();
            jtfNome.setBounds(75, 50, 300, 20);
            getContentPane().add(jtfNome);

            jtfEndereco = new JFormattedTextField();
            jtfEndereco.setBounds(75, 75, 300, 20);
            getContentPane().add(jtfEndereco);

            MaskFormatter maskTelefone = new MaskFormatter("(##) #####-####");
            maskTelefone.setPlaceholderCharacter('_');
            jtfTelefone = new JFormattedTextField(maskTelefone);
            jtfTelefone.setBounds(75, 100, 300, 20);
            getContentPane().add(jtfTelefone);

            MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
            maskCpf.setPlaceholderCharacter('_');
            jtfCpf = new JFormattedTextField(maskCpf);
            jtfCpf.setBounds(75, 125, 300, 20);
            getContentPane().add(jtfCpf);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Radio Buttons
        jrbCorrente = new JRadioButton("Conta Corrente");
        jrbCorrente.setBounds(100, 150, 111, 20);
        jrbCorrente.setMnemonic(KeyEvent.VK_C);
        jrbCorrente.setSelected(true);
        getContentPane().add(jrbCorrente);

        jrbPoupanca = new JRadioButton("Conta Poupança");
        jrbPoupanca.setBounds(225, 150, 118, 20);
        jrbPoupanca.setMnemonic(KeyEvent.VK_P);
        getContentPane().add(jrbPoupanca);

        bgContas = new ButtonGroup();
        bgContas.add(jrbCorrente);
        bgContas.add(jrbPoupanca);

        jSeparator02 = new JSeparator();
        jSeparator02.setBounds(10, 180, 365, 10);
        getContentPane().add(jSeparator02);

        // Botões
        jbConsultar = new JButton("Consultar");
        jbConsultar.setBounds(15, 190, 75, 23);
        jbConsultar.setMnemonic(KeyEvent.VK_S);
        getContentPane().add(jbConsultar);

        jbAtualizar = new JButton("Atualizar");
        jbAtualizar.setBounds(105, 190, 75, 23);
        jbAtualizar.setMnemonic(KeyEvent.VK_A);
        jbAtualizar.setEnabled(false);
        getContentPane().add(jbAtualizar);

        jbCriar = new JButton("Criar");
        jbCriar.setBounds(200, 190, 75, 23);
        getContentPane().add(jbCriar);

        jbExcluir = new JButton("Excluir");
        jbExcluir.setBounds(295, 190, 75, 23);
        jbExcluir.setMnemonic(KeyEvent.VK_F);
        jbExcluir.setEnabled(false);
        getContentPane().add(jbExcluir);
    }

    // Getters
    public JFormattedTextField getJtfAgencia() { 
        return jtfAgencia; 
    }
    public JFormattedTextField getJtfConta() { 
        return jtfConta; 
    }
    public JFormattedTextField getJtfNome() { 
        return jtfNome; 
    }
    public JFormattedTextField getJtfEndereco() { 
        return jtfEndereco; 
    }
    public JFormattedTextField getJtfTelefone() { 
        return jtfTelefone; 
    }
    public JFormattedTextField getJtfCpf() { 
        return jtfCpf; 
    }
    public JRadioButton getJrbCorrente() { 
        return jrbCorrente; 
    }
    public JRadioButton getJrbPoupanca() { 
        return jrbPoupanca; 
    }
    public JButton getJbConsultar() { 
        return jbConsultar; 
    }
    public JButton getJbAtualizar() { 
        return jbAtualizar; 
    }
    public JButton getJbCriar() { 
        return jbCriar; 
    }
    public JButton getJbExcluir() { 
        return jbExcluir;
    }

    // Centralizar a janela
    private void centralizar() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension janela = getSize();
        setLocation((screen.width - janela.width) / 2, (screen.height - janela.height) / 2);
    }

    public static void main(String[] args) {
        Janela janela = new Janela();
        new Cadastro(janela);
        janela.setVisible(true);
    }
}
