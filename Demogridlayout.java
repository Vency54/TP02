/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp02;

import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Demogridlayout {

    public static void main(String[] args) {
        JFrame janela = new JFrame("Exemplo GridLayout com Dois Painéis");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(400, 180);

        // A janela principal usa GridLayout com 1 linha e 2 colunas (dois painéis lado a lado)
        janela.setLayout(new GridLayout(2, 1));

        JTextField campoTexto1 = new JTextField();
        JTextField campoTexto2 = new JTextField();
        JTextField campoTexto3 = new JTextField();

        // Primeiro painel
        JPanel painel1 = new JPanel();
        painel1.setLayout(new GridLayout(3, 2, 10, 10)); // 2 linhas, 1 coluna no painel 1
        painel1.add(new JLabel("Nome"));
        painel1.add(campoTexto1);
        painel1.add(new JLabel("Idade:"));
        painel1.add(campoTexto2);
        painel1.add(new JLabel("Endereço:"));
        painel1.add(campoTexto3);

        // Segundo painel
        JPanel painel2 = new JPanel();

        JButton botaoOk = new JButton("Ok");
        JButton botaoSair = new JButton("Sair");
        JButton botaoLimpar = new JButton("Limpar");
        botaoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTexto1.setText("");
                campoTexto2.setText("");
                campoTexto3.setText("");
            }
        });
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });

        botaoOk.setBounds(50, 30, 120, 40);

        painel2.setLayout(new GridLayout(1, 4)); // 2 linhas, 1 coluna no painel 2
        painel2.add(botaoOk);
        painel2.add(botaoLimpar);
        painel2.add(new JButton("Mostrar"));
        painel2.add(botaoSair);

        // Adiciona os dois painéis na janela principal
        janela.add(painel1);
        janela.add(painel2);

        janela.setVisible(true);
    }
}
