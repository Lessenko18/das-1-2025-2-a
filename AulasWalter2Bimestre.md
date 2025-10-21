# Turma: das-1-2025-2-a

# 📘 AulasWalter - Notas de Aulas  2° Bimestre


## Aula 1 - 29/09/2025

###  Circuit Braker Pattern
Proteger a comunicação entre sistemas

Pense em um disjuntor:
*  Estado Fechado -> significa que está tudo funcionando normalmente, a comunicação segue estável.
*  Estado Aberto -> quando ocorre uma falha, o disjuntor cai e a comunicação é interrompida.
*  Estado Meio-Aberto (half-open) -> nesse ponto ele testa a conexão novamente. Se a tentativa for bem-sucedida, ele considera válido e vai voltando ao normal. Se falhar, retorna ao estado de aberto.

<p align="center">
<img width="500" height="500" alt="image" src="https://github.com/user-attachments/assets/3bdfa4eb-6b7e-4029-8437-7c99ba382b8d" />
</p>

Link para conhecimento: https://learn.microsoft.com/pt-br/azure/architecture/patterns/circuit-breaker?wt.mc_id=AZ-MVP-5003638

## Aula 2 - 06/10/2025

### Características Arquiteturais

São qualidades que influenciam o design do sistema (como desempenho,
escalabilidade e segurança).
Existem 3 grupos principais:

-   **Operacionais**  desempenho, escalabilidade, elasticidade.
-   **Estruturais**  configuração, extensão, estabilidade.
-   **Transversais**  autenticação, armazenamento, acessibilidade.

 **Trade-offs:** é impossível priorizar todas as características ao
mesmo tempo. Boas arquiteturas buscam o **"menos pior"**, equilibrando o
que é mais importante.

------------------------------------------------------------------------

## Aula 3 - 06/10/2025

### CQRS (Command Query Responsibility Segregation)

Divide **leitura e escrita** em partes diferentes do sistema.
Ajuda em casos de:

-   **Performance**  quando o hardware já chegou ao limite.
-   **Concorrência**  muitos acessos travando o banco.

A ideia é usar **um banco principal pra escrita** e **réplicas pra
leitura**, melhorando a performance.

------------------------------------------------------------------------

## Aula 4 - 13/10/2025

### Retry Pattern

Quando algo falha, o sistema tenta de novo.
Pode ser:

-   **Imediato**  tenta logo em seguida.
-   **Com delay**  espera um tempo e tenta de novo, aumentando o tempo
    se continuar falhando (exponencial).

### Estilos Arquiteturais

-   **Grande Bola de Lama**  código bagunçado, difícil de manter.
-   **Arquitetura Monolítica**  tudo num só código (comum em sistemas
    embarcados).\
-   **Cliente-Servidor**  divide quem pede (cliente) e quem processa
    (servidor).

------------------------------------------------------------------------

## Aula 5 - 14/10/2025

### Arquitetura de Três Camadas

1.  **Apresentação (Front)**
2.  **Lógica de Negócio**
3.  **Banco de Dados**

 Monolito = tudo junto.
 Distribuída = vários serviços independentes (microserviços).

 **Falácias de sistemas distribuídos:**
- A rede é confiável.
- A latência é zero.
- A banda é infinita.
- A rede é segura.
- A topologia não muda.

Inclui também conceitos como **log distribuído** e **transações
distribuídas**.

------------------------------------------------------------------------

## Aula 6 - 20/10/2025

### Arquitetura em Camadas

Um dos estilos mais usados por ser simples e barato.
Cada camada tem uma função e responsabilidade:

-   **Apresentação**  interface.
-   **Comercial (Negócio)**  regras da aplicação.
-   **Persistência**  comunicação com o banco.
-   **Banco de Dados**  armazenamento real.

Essa separação ajuda cada dev a focar na parte que entende melhor e
facilita manutenção.
