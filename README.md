# Turma: das-1-2025-2-a

# Aula 1 - 04/08/2025

 Principios de projeto de software - Capitulo 5 do livro

Padrões mitigam a complexidade

# Abstração: 
Seria representar algo do mundo real para resolver um problema

 Config <-- configurações
 
 Controller <-- html, api, rest
 
 Entity <-- dados
 
 Repository <-- Con db
 
 Service <-- Lógica

# Ocultamento de informação: 
Não há necessidade de entender todo o funcionamento de um framework para poder usa-lo 

# Código Coeso (Coesão)
Um código que realiza uma tarefa muito bem feita!
Elementos de um módulo (como classes, funções ou pacotes) estão relacionados e trabalham juntos para um propósito único e bem definido.

# Acoplamento 

- Acoplamento: dependência de uma classe com outra
- Autoacoplamento: instanciação e uso de um método no construtor de outra class
- 
UML
- Flecha vazia: herança
- Flecha tracejada: implementação
- Flecha cheia: Associação

---//--- 

- # Aula 2 - 05/08/2025

- O que é SOLID?

Usar a orientação a objetos do jeito mais correto possível!

S — Single Responsibility Principle (Princípio da responsabilidade única)
O — Open-Closed Principle (Princípio Aberto-Fechado)
L — Liskov Substitution Principle (Princípio da substituição de Liskov)
I — Interface Segregation Principle (Princípio da Segregação da Interface)
D — Dependency Inversion Principle (Princípio da inversão da dependência)

Maneira de usar o conceito de responsábildiade única
M - Dados
V - HTML
C - Controlar a tela

Código:
package br.univille;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janelinha extends JFrame{

    private JButton botaozinho;
    private Controlador controlador;

    public Janelinha() {
        setTitle("Eu nao acredito");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        botaozinho = new JButton("ME CLICA");
        controlador = new Controlador();
        botaozinho.addActionListener(controlador);
        
        add(botaozinho);

        setVisible(true);
    }
    public static void main(String[] args) {
        new Janelinha();
    }

}
package br.univille;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Controlador implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        meClica();
    }

    private void meClica(){
        JOptionPane.showMessageDialog(null, "NAO ACREDITO");
    }
}
