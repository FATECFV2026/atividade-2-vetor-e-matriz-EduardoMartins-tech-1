[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/kE1QNNup)
[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-2e0aaae1b6195c2367325f4f02e2d04e9abb55f0b24a779b69b11b9e10269abc.svg)](https://classroom.github.com/online_ide?assignment_repo_id=23603229&assignment_repo_type=AssignmentRepo)
# Atividade 2 - Vetores e Matrizes

## Sumario 
- [Como Utilizar](#como-utilizar-)
- [Como a Avaliacao Automatica Funciona](#como-a-avaliacao-automatica-funciona-)
- [Exercicios](#exercicios-)
  - [Exercicio 01: Progressao Geometrica](#-exercicio-01-progressao-geometrica)
  - [Exercicio 02: Sequencia Decrescente](#-exercicio-02-sequencia-decrescente)
  - [Exercicio 03: Vetor Dinamico](#-exercicio-03-vetor-dinamico)
  - [Exercicio 04: Sequencia Crescente com Soma](#-exercicio-04-sequencia-crescente-com-soma)
  - [Exercicio 05: Matriz com Valores Incrementais](#-exercicio-05-matriz-com-valores-incrementais)
  - [Exercicio 06: Operacao entre Matrizes](#-exercicio-06-operacao-entre-matrizes)

## Como Utilizar 📁


1. **IMPLEMENTE** o método `main` com um menu interativo que permita escolher entre os 6 exercícios
2. **COMPLETE** cada método (ex01 a ex06) seguindo os enunciados abaixo
3. **ADICIONE** validação de entrada conforme especificado em cada exercício
4. **EXIBA** os resultados no console usando `System.out.println()`
5. **TESTE** cada exercício para verificar se está funcionando corretamente

**O QUE VOCÊ DEVE ENTREGAR:**
- Arquivo [App.java](src/App.java) completamente implementado
- Menu funcional no método main
- Todos os 6 exercícios funcionando corretamente
- Validações de entrada implementadas
- Saídas formatadas conforme especificado

**Requisitos:**
- Java Development Kit (JDK) instalado
- Para VS Code: Extension Pack for Java

## Como a Avaliacao Automatica Funciona 🤖

Ao fazer **push** no repositório, o GitHub Actions executa o autograder automaticamente. Cada exercício é avaliado pelo arquivo [autograde/Autograder.java](autograde/Autograder.java), que chama os seus métodos via **reflection** e verifica se os resultados estão corretos.

**O que o autograder verifica em cada exercício:**

| Exercício | Método esperado em `App.java` | O que é testado |
|-----------|-------------------------------|-----------------|
| Ex01 | `progressaoGeometrica(int)` | Retorna `int[10]` com progressão geométrica (dobro); retorna `null` para entrada > 20 |
| Ex02 | `sequenciaDecrescente(int)` | Retorna `int[10]` decrescente (-1 por posição); retorna `null` para entrada ≤ 1 |
| Ex03 | `vetorDinamico(int)` | Retorna `int[N]` com `[1, 2, ..., N]`; retorna `null` para entrada > 1000 |
| Ex04 | `sequenciaCresenteComSoma(int)` + `calcularSoma(int[])` | Vetor crescente (+1) e soma correta de todos os elementos |
| Ex05 | `matrizIncrementais(int)` | Matriz N×N com valores sequenciais a partir de `N+1` |
| Ex06 | `operacaoEntreMatrizes(int)` | Retorna `int[][][3]`: matrizes N, Z (iguais) e Soma (N+Z) |

**Como o teste passa:**
- Se todas as verificações forem satisfeitas, o autograder imprime `OK!`
- O GitHub Classroom considera o teste aprovado quando a saída contém `OK`
- Se alguma verificação falhar, imprime `FAIL: <motivo>` e o teste é reprovado

**Para testar localmente:**
```bash
# Compilar tudo
javac -d bin src/App.java autograde/Autograder.java

# Rodar um exercício específico
java -cp bin autograde.Autograder ex1
```

## Exercicios 🛠️

### 🔢 Exercicio 01: Progressao Geometrica
Faça um programa que leia um valor inteiro **menor ou igual a 20**. Armazene este valor na primeira posição de um vetor de 10 elementos. Complete o vetor fazendo com que cada elemento seja o **dobro do elemento anterior**.

**O QUE IMPLEMENTAR:**
- Validação: Valor deve ser ≤ 20 (repetir leitura se inválido)
- Criar vetor de 10 posições
- N[0] = valor lido
- Para i=1 até 9: N[i] = N[i-1] * 2

**Entrada:** Valor ≤ 20  
**Processamento:** Cada posição = 2 × posição anterior  
**Saída Esperada:** 
- Exibir o vetor completo usando `Arrays.toString(N)`
- Exemplo: Se entrada = 5, saída = [5, 10, 20, 40, 80, 160, 320, 640, 1280, 2560]

---

### 📉 Exercicio 02: Sequencia Decrescente  
Desenvolva um programa que leia um valor inteiro **entre 1 e 100 (não inclusos)**. Armazene este valor na primeira posição de um vetor de 10 elementos. Complete o vetor fazendo com que cada elemento seja o **elemento anterior decrementado de 1**.

**O QUE IMPLEMENTAR:**
- Validação: 1 < valor < 100 (repetir leitura se inválido)
- Criar vetor de 10 posições
- N[0] = valor lido
- Para i=1 até 9: N[i] = N[i-1] - 1

**Entrada:** 1 < valor < 100  
**Processamento:** Cada posição = posição anterior - 1  
**Saída Esperada:** 
- Exibir o vetor completo usando `Arrays.toString(N)`
- Exemplo: Se entrada = 50, saída = [50, 49, 48, 47, 46, 45, 44, 43, 42, 41]

---

### 📊 Exercicio 03: Vetor Dinamico
Crie um programa que leia um valor inteiro **entre 1 e 1000**. Crie um vetor com tamanho igual ao valor lido e preencha com uma **sequência numérica de 1 até o tamanho do vetor**.

**O QUE IMPLEMENTAR:**
- Validação: 1 < valor ≤ 1000 (repetir leitura se inválido)
- Criar vetor com tamanho dinâmico: `int N[] = new int[valor]`
- Para i=0 até tamanho-1: N[i] = i + 1

**Entrada:** 1 < valor ≤ 1000  
**Processamento:** Vetor[i] = i + 1  
**Saída Esperada:** 
- Exibir o vetor completo usando `Arrays.toString(N)`
- Exemplo: Se entrada = 8, saída = [1, 2, 3, 4, 5, 6, 7, 8]

---

### ➕ Exercicio 04: Sequencia Crescente com Soma
Desenvolva um programa que leia um valor inteiro **entre 1 e 100 (não inclusos)**. Armazene este valor na primeira posição de um vetor de 10 elementos. Complete o vetor fazendo com que cada elemento seja o **elemento anterior incrementado de 1**. Calcule e exiba a **soma de todos os elementos**.

**O QUE IMPLEMENTAR:**
- Validação: 1 < valor < 100 (repetir leitura se inválido)
- Criar vetor de 10 posições
- N[0] = valor lido; soma += N[0]
- Para i=1 até 9: N[i] = N[i-1] + 1; soma += N[i]

**Entrada:** 1 < valor < 100  
**Processamento:** Cada posição = posição anterior + 1; somar todos os elementos  
**Saída Esperada:** 
- Exibir o vetor completo usando `Arrays.toString(N)`
- Exibir a soma total: `System.out.println("Soma: " + soma)`
- Exemplo: Se entrada = 15, saída = [15, 16, 17, 18, 19, 20, 21, 22, 23, 24] e Soma: 195

---

### 🎯 Exercício 05: Matriz com Valores Incrementais
Crie um programa que leia um valor inteiro **entre 3 e 50**. Crie uma matriz quadrada NxN e preencha com valores incrementais começando a partir do **valor lido + 1**. Exiba a matriz no console.

**O QUE IMPLEMENTAR:**
- Validação: 3 < valor ≤ 50 (repetir leitura se inválido)
- Criar matriz quadrada NxN: `int N[][] = new int[valor][valor]`
- Contador inicial = valor + 1
- Para cada posição [i][j]: N[i][j] = contador++
- Exibir matriz formatada

**Entrada:** 3 < valor ≤ 50  
**Processamento:** Matriz[i][j] com valores incrementais  
**Saída Esperada:** 
- Matriz formatada linha por linha usando `System.out.printf("%4d ", N[i][j])`
- Exemplo: Se entrada = 4, matriz 4x4 começando em 5:
```
   5    6    7    8
   9   10   11   12
  13   14   15   16
  17   18   19   20
```

---

### 🔄 Exercicio 06: Operacao entre Matrizes
Desenvolva um programa que leia um valor inteiro **entre 3 e 50**. Crie duas matrizes quadradas (N e Z) preenchidas com os mesmos valores incrementais. Crie uma terceira matriz que seja a **soma das duas matrizes anteriores**.

**O QUE IMPLEMENTAR:**
- Validação: 3 < valor ≤ 50 (repetir leitura se inválido)
- Criar 3 matrizes quadradas NxN: N, Z e Soma
- Contador inicial = valor + 1
- Para cada posição [i][j]: 
  - N[i][j] = contador
  - Z[i][j] = contador (valores iguais)
  - Soma[i][j] = N[i][j] + Z[i][j]
  - contador++
- Exibir as 3 matrizes formatadas

**Entrada:** 3 < valor ≤ 50  
**Processamento:** Matrizes N e Z iguais; Soma = N + Z  
**Saída Esperada:** 
- Três matrizes formatadas (N, Z e Soma)
- Use `System.out.printf("%4d ", matriz[i][j])`
- Exemplo: Se entrada = 3, contador inicia em 4:
  - Matriz N e Z: valores 4,5,6,7,8,9,10,11,12
  - Matriz Soma: valores 8,10,12,14,16,18,20,22,24



## Criterio de Avaliacao 📝

- **Compilação:** 1 ponto
- **Exercicio 01:** 1,5 pontos
- **Exercicio 02:** 1,5 pontos  
- **Exercicio 03:** 1,5 pontos
- **Exercicio 04:** 1,5 pontos
- **Exercicio 05:** 1,5 pontos
- **Exercicio 06:** 1,5 pontos

**Total: 10 pontos**

**Observações:**
- Código deve compilar sem erros
- Cada exercicio deve validar entrada conforme especificado
- Saídas devem estar formatadas corretamente
- Menu interativo deve funcionar adequadamente






