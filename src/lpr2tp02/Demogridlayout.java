
package lpr2tp02;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
/**
1 – Desenvolver o seguinte sistema abaixo, empregando os conhecimentos adquiridos nas
aulas sobre interfaces gráficas em java.
* 
* Dupla: João Victor Lima Venceslau - Rayssa Silva de Oliveira
 */
public class Demogridlayout extends JFrame {
    private final JTextField campoNome;
    private final JTextField campoIdade;
    private final JTextField campoEndereco;
    private final List<Aluno> alunos;

    public Demogridlayout() {
        super("TP02 - Lista de Alunos");
        alunos = new ArrayList<>();
        campoNome = new JTextField();
        campoIdade = new JTextField();
        campoEndereco = new JTextField();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 180);
        setMinimumSize(new Dimension(400, 180));
        setResizable(false);
        setLocationRelativeTo(null);
        criarInterface();
    }

    private void criarInterface() {
        JPanel painelCampos = new JPanel(new GridLayout(3, 2, 10, 10));
        painelCampos.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        painelCampos.add(new JLabel("Nome:"));
        painelCampos.add(campoNome);
        painelCampos.add(new JLabel("Idade:"));
        painelCampos.add(campoIdade);
        painelCampos.add(new JLabel("Endereço:"));
        painelCampos.add(campoEndereco);

        JButton botaoOk = new JButton("Ok");
        JButton botaoLimpar = new JButton("Limpar");
        JButton botaoMostrar = new JButton("Mostrar");
        JButton botaoSair = new JButton("Sair");

        botaoOk.addActionListener(evento -> cadastrarAluno());
        botaoLimpar.addActionListener(evento -> limparCampos());
        botaoMostrar.addActionListener(evento -> mostrarAlunos());
        botaoSair.addActionListener(evento -> dispose());

        JPanel painelBotoes = new JPanel(new GridLayout(1, 4));
        painelBotoes.add(botaoOk);
        painelBotoes.add(botaoLimpar);
        painelBotoes.add(botaoMostrar);
        painelBotoes.add(botaoSair);

        JPanel painelPrincipal = new JPanel(new BorderLayout(0, 10));
        painelPrincipal.add(painelCampos, BorderLayout.CENTER);
        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);
        add(painelPrincipal);
    }

    private void cadastrarAluno() {
        String nome = campoNome.getText().trim();
        String idadeTexto = campoIdade.getText().trim();
        String endereco = campoEndereco.getText().trim();

        if (nome.isEmpty() || idadeTexto.isEmpty() || endereco.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idade;
        try {
            idade = Integer.parseInt(idadeTexto);
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(this, "A idade deve ser um número inteiro.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (idade < 0) {
            JOptionPane.showMessageDialog(this, "A idade não pode ser negativa.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setIdade(idade);
        aluno.setEndereco(endereco);
        aluno.setUUID(UUID.randomUUID());
        alunos.add(aluno);

        JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso.", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        limparCampos();
    }

    private void limparCampos() {
        campoNome.setText("");
        campoIdade.setText("");
        campoEndereco.setText("");
        campoNome.requestFocusInWindow();
    }

    private void mostrarAlunos() {
        if (alunos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum aluno cadastrado.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder mensagem = new StringBuilder("Resultado\n");
        for (Aluno aluno : alunos) {
            mensagem.append("Id: ")
                    .append(aluno.getUUID())
                    .append(" Nome: ")
                    .append(aluno.getNome())
                    .append("\n");
        }

        JOptionPane.showMessageDialog(this, mensagem.toString(), "Mensagem", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Demogridlayout().setVisible(true));
    }
}
