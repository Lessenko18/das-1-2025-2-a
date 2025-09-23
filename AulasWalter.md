# Turma: das-1-2025-2-a

# 📘 AulasWalter - Notas de Aula (2025/2)

Este repositório contém minhas anotações organizadas por aula, com conceitos de **Design e Arquitetura de Software**, **Princípios de Projeto**, **SOLID**, **Padrões de Projeto** e temas complementares como **DevOps** e **Trade-offs**.

---

## Aula 1 - 04/08/2025

### 🔹 Abstração

* Representar algo do mundo real dentro do software.
* Exemplo: classes `Entity` modelam dados do banco.

**Organização em camadas:**

* **Controller** - API REST / HTML
* **Entity** - Dados
* **Repository** - Comunicação com BD
* **Service** - Regras de negócio
* **Config** - Centraliza configurações

---

### 🔹 Ocultamento de Informação (Encapsulamento)

* Esconder detalhes internos da classe, expondo apenas o necessário.
* Em Java: atributos `private` + métodos `get/set`.

### 🔹 Coesão

* Medida de quão focada é uma classe/módulo em uma única responsabilidade.
* **Alta coesão = mais fácil de manter.**

### 🔹 Acoplamento

* Grau de dependência entre classes.
* **Baixo acoplamento** é desejável → facilita manutenção e reuso.

**Diagrama UML:**

* 🔹 Flecha vazia contínua - Herança
* 🔹 Flecha vazia pontilhada - Interface
* 🔹 Flecha cheia - Associação

**Classe anêmica:** classe com apenas atributos + getters/setters (sem comportamento).

---

## Aula 2 - 05/08/2025

### 🔹 Padrões de Código

* Seguir convenções melhora leitura e manutenção.
* Java: `CamelCase` para classes e `camelCase` para variáveis.

### 🔹 SOLID (Introdução)

Aplicar corretamente a **Orientação a Objetos**:

* **S** → Single Responsibility Principle
* **O** → Open-Closed Principle
* **L** → Liskov Substitution Principle
* **I** → Interface Segregation Principle
* **D** → Dependency Inversion Principle

**Arquitetura MVC:**

* **Model** → Dados (Entidade)
* **View** → Interface (HTML / tela)
* **Controller** → Intermediário entre Model e View

**Exemplo prático (Swing em Java):**

```java
package br.univille;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Janelinha extends JFrame {
    private JButton botaozinho;
    private Controlador controlador;

    public Janelinha() {
        setTitle("Exemplo MVC");
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
}
```

---

## Aula 3 - 11/08/2025

### 🔹 Princípio da Inversão de Dependências

* Módulos de alto nível **não devem depender** de baixo nível. Ambos devem depender de abstrações (interfaces).
* Evita dependência direta entre classes.

### 🔹 Prefira Composição à Herança

* Use **herança** apenas quando existe relação “é um” (*is-a*).
* Prefira **composição** para flexibilidade e reuso.

### 🔹 Princípio de Demeter (Menor Conhecimento)

* Uma classe deve conhecer **apenas o necessário**.
* Evitar encadeamento excessivo (`obj.getX().getY().getZ()`).

### 🔹 Aberto/Fechado

* Classes devem estar abertas para **extensão** mas fechadas para **modificação**.
* Evita quebrar funcionalidades já existentes.

---

## Aula 4 - 12/08/2025

### 🔹 Liskov Substitution Principle (LSP)

* Classes filhas devem poder substituir a classe pai **sem alterar comportamento esperado**.
* Exemplo: `Quadrado` não deve herdar de `Retângulo` se isso quebrar cálculos de área.

---

## Aula 5 - 25/08/2025

### 🔹 Padrão Observer

* Define relação **um-para-muitos**.
* Quando o *Subject* muda, notifica todos os *Observers*.

**Exemplo em Java:**

```java
// Interface Observer
public interface Observer {
    void update(String message);
}

// Subject
import java.util.ArrayList;
import java.util.List;

public class Publisher {
    private List<Observer> observers = new ArrayList<>();
    public void addObserver(Observer o) { observers.add(o); }
    public void notifyObservers(String msg) {
        for (Observer o : observers) o.update(msg);
    }
}

// Concrete Observer
public class Subscriber implements Observer {
    private String name;
    public Subscriber(String name) { this.name = name; }
    public void update(String msg) {
        System.out.println(name + " recebeu: " + msg);
    }
}
```

---

## Aula 6 - 26/08/2025

### 🔹 Arquitetura de Software

* Estrutura que define como o sistema cresce e se mantém saudável.

**Características (requisitos não funcionais):**

* Disponibilidade, Escalabilidade, Segurança, Testabilidade, Desempenho.

**Decisões arquiteturais:**

* Monólito vs Microsserviços
* Padrões de integração (REST, mensageria)
* Políticas de versionamento

**Princípios de Design:**

* Separação de responsabilidades
* Baixo acoplamento
* Alta coesão

---

## Aula 7 - 01/09/2025

### 🔹 Papel do Arquiteto

* Tomar decisões difíceis (tecnologias, trade-offs).
* Refatorar e revisar código.
* Manter-se atualizado.
* Conhecer o negócio.
* Lidar com pessoas (liderança, negociação).

### 🔹 DevOps

* Integração entre Dev e Ops.
* Práticas: Integração Contínua, Entrega Contínua, Feedback rápido.
* Responsabilidade compartilhada.

---

## Aula 8 - 08/09/2025

### 🔹 Trade-offs

* Não existe solução perfeita.
* Toda decisão arquitetural envolve **ganhos e perdas**.
* Exemplo: Microsserviços → mais escalável, mas aumenta complexidade.

### 🔹 Arquitetura baseada em Tópicos

* Comunicação **Publisher - Broker - Subscribers**.
* Vantagens: baixo acoplamento, expansão fácil.
* Desvantagens: risco de perda de mensagens.

### 🔹 Arquitetura baseada em Filas

* Modelo **Sender → Queue → Receiver**.
* Vantagens: garante ordem e confiabilidade.
* Desvantagens: mais acoplamento e complexidade.

---

## Aula 9 - Padrões de Projeto (GoF)

### Categorias

* **Criacionais** → Factory, Singleton, Builder
* **Estruturais** → Adapter, Facade, Composite, Decorator
* **Comportamentais** → Observer, Strategy, State

### Factory Method

* Centraliza criação de objetos.
* Facilita troca de implementação (TCP → UDP).

### Singleton

* Garante única instância global.

### Observer

* Relação um-para-muitos.
* Usado em notificações/eventos.

---

## Aula 10 - Expectativas de um Arquiteto

* Ser **técnico e líder** ao mesmo tempo.
* Manter a arquitetura **relevante e atualizada**.
* Equilibrar decisões técnicas e estratégicas.
* Conhecer profundamente o **negócio**.
* Buscar formação em “T”: **amplitude + profundidade**.

---

## 📌 Conclusão

* O estudo de Arquitetura e Design vai além da codificação: trata de **estratégia**, **qualidade** e **liderança**.
* Bons sistemas nascem de **decisões conscientes** (trade-offs bem analisados) e da aplicação de **padrões e princípios** corretos.

 "Um arquiteto não é só quem desenha caixinhas, mas quem garante que o sistema entrega valor de forma sustentável."
