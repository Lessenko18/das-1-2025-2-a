# Turma: das-1-2025-2-a

# Aula 1 - 04/08/2025 !!

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

UML

- Flecha vazia: herança
- Flecha tracejada: implementação
- Flecha cheia: Associação

---//---

# Aula 2 - 05/08/2025 !!

O que é SOLID?

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

```
package br.univille;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Janelinha extends JFrame {

    private JButton botaozinho;
    private Controlador controlador;

    public Janelinha() {
        setTitle("Eu não acredito");
        setSize(500, 500);
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
    package br.univille;

    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import javax.swing.JOptionPane;

    public class Controlador implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        meClica();
    }

    private void meClica() {
        JOptionPane.showMessageDialog(null, "NÃO ACREDITO");
    }
    }
```
---//---

# Aula 3 - 11/08/2025 !!

#Princípio da Inversão de Dependência (Dependency Inversion Principle)
Em vez de o Controller depender diretamente de uma implementação concreta, ele deve se comunicar primeiro com uma interface ou abstração.
Isso evita o acoplamento direto entre classes, facilitando a manutenção, a troca de implementações e a realização de testes.
A ideia central é: módulos de alto nível não devem depender de módulos de baixo nível, ambos devem depender de abstrações.

# Prefira Composição à Herança

A herança deve ser usada apenas quando existe uma relação clara do tipo "é um" (is-a), por exemplo:

- Animal → Gato

- Animal → Cachorro

Um gato nunca se tornará um cachorro, ou vice-versa.
Quando a relação não for estritamente hierárquica, prefira composição, ou seja, construir comportamentos combinando diferentes objetos, em vez de criar cadeias de herança profundas.

A composição oferece mais flexibilidade, evita acoplamento excessivo e facilita a reutilização de código.

--//--

# Princípio de Demeter (Menor Conhecimento)

Também chamado de Law of Demeter.

A ideia é evitar dependências desnecessárias e não acessar diretamente objetos internos de outros objetos.
Fuja de variáveis globais e trabalhe com as informações locais e disponíveis no contexto atual.

--//--

# Princípio do Aberto/Fechado (Open/Closed Principle)

Um objeto deve proteger seu comportamento para que ninguém possa quebrá-lo alterando diretamente sua lógica interna.
A ideia é que quem cria a classe não quer que ela seja modificada, mas sim estendida com novas funcionalidades.

Aberto para extensão, fechado para modificação
Proteja o que a classe já faz, mas permita adicionar novos comportamentos sem alterar o código existente.

# Aula 4 - 12/08/2025

SOLID:

L: Princípio de substituição de Liskov - redefinição de métodos de classe base em classe filho (aplicado quando tem herança). Se há uma herança, com vários filhos, o código dos filhos deve ser feita de tal maneira a manter a compatibilidade com o pai, caso elas forem substituídas (sem quebrar o padrão que o pai tem) Filho(método x) -> Pai <- Filho2(Método x) | aplicar os dois filhos não quebra a classe

# Aula 5 25/08/2025
Implementação Observer
https://github.com/Lessenko18/das-1-2025-2-a/tree/2cec642fdb3a6c96d3d7162c08b9f0fbce069083/designpatterns

# Aula 6 - 26/08/2025

Para desenvolver um bom software, é fundamental construir uma estrutura sólida. Essa estrutura é definida por meio da arquitetura de software, que pode ser entendida a partir de três dimensões principais:

1. Características da Arquitetura

São os requisitos não funcionais que direcionam o sistema, como:

Disponibilidade
Confiabilidade
Testabilidade
Escalabilidade
Segurança

Essas características não podem ser todas atendidas ao mesmo tempo; é preciso selecionar aquelas que melhor se adequam ao contexto do sistema.

2. Decisões de Arquitetura

Correspondem às regras e padrões estabelecidos para garantir consistência no desenvolvimento.
Sem essas definições, o software pode acumular problemas e se tornar difícil de manter.
Exemplos de decisões arquiteturais:

Definir entre Monólito ou Microserviços
Escolher padrões de integração e comunicação
Definir políticas de versionamento

3. Princípios de Design

São boas práticas e diretrizes que orientam o desenvolvimento dentro da arquitetura escolhida.
Devem ser seguidos sempre que possível, garantindo que o sistema permaneça padronizado, compreensível e de fácil manutenção.
Exemplos: separação de responsabilidades, coesão de módulos, baixo acoplamento.

# Aula 7 - 01/09/2025

# Arquitetura de Software

Quando falamos em construir software de qualidade, não dá para pensar só em código. É preciso ter uma arquitetura bem definida, que vai servir como base para o sistema crescer e se manter saudável ao longo do tempo.

# Características da Arquitetura

Essas são as chamadas qualidades não funcionais: disponibilidade, escalabilidade, segurança, desempenho, testabilidade…
A verdade é: nenhum sistema consegue ser perfeito em tudo. Por isso, o arquiteto precisa escolher quais características são mais importantes para aquele projeto específico.
Um exemplo bem clássico é decidir se o sistema vai ser Monolito ou Microserviços.

# Princípios de Design

Aqui entram as boas práticas que ajudam a manter o sistema limpo e organizado.
São as “regras de convivência” do software, que guiam o time e evitam bagunça no futuro.

# O Papel do Arquiteto de Software

- O arquiteto não é só “o cara que desenha caixinhas”. Ele tem responsabilidades bem práticas, como:
- Tomar decisões difíceis: escolher tecnologias, justificar o porquê de cada decisão, pesar prós e contras.
- Olhar para o código constantemente: identificar onde precisa refatorar e quando vale a pena mexer.
- Estar sempre atualizado: acompanhar tendências, ver como novas tecnologias podem ajudar (ou atrapalhar).
- Garantir que o time siga os padrões: não adianta só decidir, é preciso manter disciplina. Testes e revisões de código ajudam nisso.
- Ter experiência e bagagem: boas decisões vêm muito da prática e de já ter passado por situações parecidas.
- Conhecer o negócio: não adianta ser só técnico, precisa entender o contexto do cliente.
- Saber lidar com pessoas: motivar, inspirar, negociar e até lidar com política dentro da empresa.

Em resumo, o arquiteto precisa ser tanto técnico quanto líder.

# DevOps na Arquitetura

Hoje em dia, não dá para falar de arquitetura sem citar DevOps.
A ideia é simples: aproximar desenvolvimento e operações para entregar valor mais rápido ao cliente.

- Planejamento: trabalhar em ciclos curtos, como no Scrum.
- Integração Contínua: ter um repositório confiável e sempre atualizado.
- Feedback constante: aprender com cada entrega, corrigir e melhorar.

Responsabilidade compartilhada: se o sistema cair, ninguém “joga a bomba” para o outro time. Todos trabalham juntos para resolver.
