# 🐾 Jogo da Velha Cat x Dog  

Este projeto Java implementa um **Jogo da Velha com interface gráfica**, substituindo os tradicionais ‘X’ e ‘O’ por ícones pixelados de **gatinhos e cachorrinhos**.  
A interface é construída com **Swing**, oferecendo uma experiência divertida e amigável.

---

## 🚀 Funcionalidades

- 🎨 **Tabuleiro com Fundo Personalizado:**  
  O tabuleiro usa uma imagem de fundo, deixando o visual mais atrativo.

- 🐱🐶 **Ícones Customizados:**  
  Cada jogador é representado por um ícone: um gato ou um cachorro.

- 🔁 **Controle de Turnos:**  
  Alternância automática entre os jogadores.

- 🏆 **Verificação de Vitória e Empate:**  
  Detecta vitórias por linhas, colunas ou diagonais e identifica empates.

- 🔄 **Botão de Reiniciar:**  
  Permite reiniciar a partida com um clique.

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java  
- **Interface Gráfica:** Swing  
- **Imagens:** Ícones `.png` para jogadores e tabuleiro  
- **Lógica de Jogo:** Controle de turnos, detecção de vitória/empate  
- **Reinício de Partida:** Ação associada a botão Swing

---

## 📁 Estrutura do Projeto

pasta_do_projeto/

├── JogoDaVelha.java // Classe principal com a lógica do jogo

├── PainelTabuleiroComImagem.java // Classe auxiliar para imagem de fundo

├── gatinho.png // Ícone do jogador 1 (gato)

├── cachorrinho.png // Ícone do jogador 2 (cachorro)

└── tabuleiro.png // Imagem de fundo do tabuleiro



---

## ⚙️ Como Compilar e Executar

### 1. Acesse o diretório do projeto

```bash
cd "caminho/para/a/pasta/do/projeto"
```

### 2. Compile os arquivos Java

```bash
javac JogoDaVelha.java PainelTabuleiroComImagem.java
```

### 3. Execute o jogo

```bash
java JogoDaVelha
```

## 🧰 Requisitos

Java Development Kit (JDK) 8 ou superior

Variáveis de ambiente configuradas para java e javac

Terminal compatível: Bash, CMD, PowerShell, etc.
