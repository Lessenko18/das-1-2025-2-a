# Turma: das-1-2025-2-a

# 📘 AulasWalter - Notas de Aulas  2° Bimestre


## Aula 1 - 29/09/2025

### 🔹 Circuit Braker Pattern
Proteger a comunicação entre sistemas

Pense em um disjuntor:
* 🔹 Estado Fechado -> significa que está tudo funcionando normalmente, a comunicação segue estável.
* 🔹 Estado Aberto -> quando ocorre uma falha, o disjuntor cai e a comunicação é interrompida.
* 🔹 Estado Meio-Aberto (half-open) -> nesse ponto ele testa a conexão novamente. Se a tentativa for bem-sucedida, ele considera válido e vai voltando ao normal. Se falhar, retorna ao estado de aberto.

<p align="center">
<img width="500" height="500" alt="image" src="https://github.com/user-attachments/assets/3bdfa4eb-6b7e-4029-8437-7c99ba382b8d" />
</p>

Link para conhecimento: https://learn.microsoft.com/pt-br/azure/architecture/patterns/circuit-breaker?wt.mc_id=AZ-MVP-5003638

