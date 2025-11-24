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
## Aula 15 - 20/10/2025

### Estilo de Arquitetura em Camadas  
**Resumo do Capítulo 10**

A arquitetura em camadas é um dos estilos mais utilizados por ser simples, de fácil implementação e de baixo custo.  
Seu objetivo é organizar o sistema em **camadas horizontais**, onde cada uma possui **responsabilidades bem definidas**.

---

### *Topologia*

Os componentes são divididos em camadas horizontais, e cada camada tem uma função específica dentro do sistema.  
A quantidade de camadas pode variar, mas geralmente encontramos **quatro camadas principais**:

* **Apresentação (UI):** responsável pela interface com o usuário.  
* **Negócio (ou Comercial):** contém as regras e a lógica da aplicação.  
* **Persistência:** lida com o acesso e manipulação de dados.  
* **Banco de Dados:** armazena as informações do sistema.

Cada camada deve ser **independente** e **abstraída das demais**, aplicando o conceito de **separação de responsabilidades**.  
Isso facilita a manutenção, os testes e o desenvolvimento em equipe — permitindo que cada desenvolvedor atue na camada em que tem maior domínio técnico.

> 💡 *Exemplo:* A camada de apresentação trata apenas da interface visual, sem interferir na lógica de negócios ou na persistência de dados.

---

### Camadas de Isolamento

Cada camada pode ser:

* **Fechada:** a requisição só pode passar pela camada imediatamente abaixo, sem “pular” camadas.  
* **Aberta:** permite que uma camada superior acesse diretamente outra mais abaixo.

O isolamento garante que as camadas possam ser **substituídas ou modificadas** sem afetar o restante do sistema, mantendo a **independência entre elas**.

---

### Adicionando Camadas

As camadas abertas são úteis quando há necessidade de criar uma **nova camada intermediária** para melhorar a comunicação entre duas camadas já existentes.  
Isso permite introduzir serviços de cache, adaptação ou segurança sem alterar o restante da estrutura.

---

### Outras Considerações

* A arquitetura em camadas é um **excelente ponto de partida** para a maioria das aplicações, especialmente quando a estrutura do sistema ainda não está bem definida.  
* Um possível problema é o **antipadrão Sinkhole**, que ocorre quando as requisições passam por várias camadas **sem processamento relevante**, gerando custo desnecessário.
  
 Regra80-20: é aceitável que até 20% das requisições sejam *sinkholes*, mas se esse número chegar a 80%, é sinal de que a arquitetura deve ser revisada.

---

### Por que usar esse estilo de arquitetura?

Esse estilo é indicado para:

* **Aplicações pequenas ou médias;**  
* **Projetos com prazos e orçamentos limitados;**  
* **Situações em que o arquiteto ainda está definindo os requisitos de negócio.**

Resumo: É uma escolha prática, simples e eficiente para começar, podendo ser evoluída futuramente para arquiteturas mais complexas (como Hexagonal ou Microserviços).


## Aula 16 - 27/10/2025

Arquitetura Pipeline
Nesse modelo, o processamento ocorre em sequência, passando por etapas chamadas filtros.

Os principais tipos de filtros são:

Produtor: gera os dados de entrada.
Transformador: modifica ou processa os dados.
Verificador: valida os resultados intermediários.
Consumidor: recebe e utiliza a saída final.
Essa arquitetura é útil quando o fluxo de dados pode ser dividido em etapas bem definidas e independentes.


## Aula 17 - 03/11/2025
# Arquitetura Microkernel

Na arquitetura **microkernel**, o núcleo do sistema mantém apenas o essencial para garantir o funcionamento básico.

A real utilidade e flexibilidade do sistema surgem por meio dos **plug-ins**, que estendem e especializam o comportamento conforme necessário.

O núcleo pode assumir diferentes formas, como:

- **Arquitetura em camadas**
- **Monólito modular**
- **Serviços de domínio separados**

# Plug-ins

Os **plug-ins** são componentes autônomos e independentes, focados em funcionalidades específicas.  
Eles isolam partes voláteis do código, facilitando manutenção, evolução e testes.

Normalmente se comunicam com o núcleo por **chamadas diretas (ponto a ponto)**.  
Quando os plug-ins são remotos, o sistema passa a ser distribuído — aumentando complexidade, custo e desafios de implantação.

---

# Registro de Plug-ins

O núcleo precisa conhecer quais plug-ins existem e como acessá-los.  
Esse registro pode ser realizado de duas formas:

- **Mapa interno simples** (chave → plug-in)  
- **Mecanismo completo de registro e descoberta**

---

# Contratos

Os contratos definem o comportamento esperado, além das entradas e saídas trocadas entre o núcleo e os plug-ins.  
Geralmente seguem padrões estabelecidos dentro do domínio.

---

# Classificação das Características

## Pontos fortes
- Simplicidade  
- Baixo custo  
- Boa testabilidade  
- Boa confiabilidade  

## Pontos fracos
- Escalabilidade limitada  
- Baixa tolerância a falhas  
- Baixa elasticidade  

---

A arquitetura pode ser **particionada por domínio** ou **por critérios técnicos**.  
A **adição, remoção ou substituição** de funcionalidades torna-se simples graças aos plug-ins independentes.


## Aula 18 - 10/11/2025

# Arquitetura de Microsserviços

A arquitetura de **microsserviços** não surge de padrões repetidos, mas de princípios do **DDD**, especialmente dos **contextos delimitados**.  
Cada serviço define apenas o necessário para operar, mantendo autonomia e foco no domínio.

## Distribuição
Microsserviços executam em máquinas ou VMs separadas, o que melhora o uso de recursos, mas introduz desafios comuns em sistemas distribuídos, como **latência maior**, **checagens de segurança recorrentes** e **overhead**.

## Contexto Delimitado e Granularidade
Cada serviço modela um domínio específico ou um fluxo de trabalho completo — a forma mais extrema de particionamento por domínio.  
A granularidade exige cuidado: serviços pequenos demais geram acoplamento excessivo. Boas diretrizes incluem:

- manter o serviço coeso em termos de finalidade;  
- evitar transações distribuídas;  
- observar a comunicação: se muitos serviços “conversam demais”, talvez devam ser combinados.

A granularidade é ajustada com o tempo — dificilmente está correta na primeira tentativa.

## Isolamento de Dados
Cada microsserviço possui seu próprio banco.  
A tecnologia pode variar por serviço, conforme custo, desempenho ou necessidade.  
Esse isolamento garante autonomia das equipes e impede dependências indesejadas.

## Camada de API
A API expõe funcionalidades úteis, mas não deve atuar como **orquestradora central**, para não comprometer o desacoplamento.

## Reutilização Operacional
Diferente do estilo SOA, a lógica operacional é separada da lógica de domínio.  
O padrão **sidecar** concentra funções técnicas (logs, segurança, monitoramento), formando uma malha de serviços com controle padronizado.

## Front-ends
Embora o front-end originalmente fizesse parte do contexto delimitado, isso raramente funciona bem.  
Duas abordagens se destacam:

- front-end consumindo diretamente as APIs;  
- front-end estruturado como um serviço separado com granularidade própria.

## Comunicação e Sagas
Manter baixo acoplamento exige decidir entre comunicação **síncrona** ou **assíncrona**.  
Coreografias usam eventos; orquestração é centralizada — menos alinhada ao estilo, mas às vezes necessária.  
Transações distribuídas devem ser evitadas; **Sagas** garantem consistência entre serviços.

## Características da Arquitetura
**Pontos fortes:** alta escalabilidade, elasticidade e evolução contínua.  
**Pontos fracos:** desempenho reduzido devido ao grande volume de chamadas de rede e verificações de segurança.

