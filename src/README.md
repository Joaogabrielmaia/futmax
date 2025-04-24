### **Futmax - README**  
Implementação do problema **Futebol Máximo** em Java.

---

### **Descrição do Problema**

Carlo Ancelotti, técnico do Real Madrid, quer montar o maior time possível onde a diferença de habilidades (skills) entre quaisquer jogadores **não seja maior que 5**.

O programa recebe:
- O número total de jogadores `N`.
- Uma lista com as skills de cada jogador.

**Saída:**  
O tamanho do maior time possível respeitando a restrição de diferença de skills.

---

### **Estrutura de Pastas**

```
.
├── src
│   ├── Futebol.java       # Código-fonte Java
│   └── tests
│       ├── in1            # Arquivo de entrada 1
│       ├── in2            # Arquivo de entrada 2
│       ├── ...            
│       ├── in7            # Arquivo de entrada 7
│       ├── out1           # Saída esperada para in1
│       ├── out2           # Saída esperada para in2
│       ├── ...
│       └── out7           # Saída esperada para in7
└── README.md
```

---

### **Como Compilar e Rodar (PowerShell do VS Code)**

#### **Compilar o programa**

Abra o terminal do VS Code (``Ctrl + ` ``) e execute:

```powershell
javac src/Futebol.java
```

> Isso irá gerar o arquivo `Futebol.class` na pasta `src`.

---

#### **Rodar um único teste**

Para rodar um teste específico (ex: `in1`), use:

```powershell
Get-Content src/tests/in1 | java src.Futebol
```

---

#### **Rodar todos os testes de uma vez**

Execute o comando abaixo para rodar **todos os testes (in1 a in7)**:

```powershell
for ($i = 1; $i -le 7; $i++) {
    Write-Output "Teste ${i}:"
    Get-Content "src/tests/in${i}" | java src.Futebol
    Write-Output ""
}
```

**Saída esperada:**

```
Teste 1:
3

Teste 2:
<resultado do teste 2>

Teste 3:
<resultado do teste 3>
...
```

---

### **Exemplo de Entrada/Saída**

#### Entrada (`in1`):

```
6
1 10 17 12 15 2
```

#### Saída esperada (`out1`):

```
3
```

---

### **Como Funciona o Código**

1. **Leitura dos dados de entrada.**
2. **Ordenação manual** das skills (bubble sort) para garantir que os valores estejam em ordem crescente.
3. Uso de **dois ponteiros (sliding window)** para encontrar a maior sequência de jogadores onde a diferença entre o menor e o maior skill seja ≤ 5.
4. Impressão do tamanho da maior equipe possível.

---

### **Complexidade de Tempo**

O algoritmo tem complexidade **O(n²)** devido à ordenação manual, enquanto a busca da janela utiliza **O(n)**.

---


