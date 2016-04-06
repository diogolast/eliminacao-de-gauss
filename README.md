## Método de Gauss-Jordan

O algoritmo resolve sistemas lineares de N variáveis.

Uma matriz está na forma escalonada reduzida quando ela satisfaz as seguintes condições:<br />
1. O primeiro elemento não-nulo de cada linha não-nula (chamado o pivô da linha) é igual a 1.<br />
2. O pivô da linha i + 1 ocorre à direita do pivô da linha i.<br />
3. Se uma coluna contém um pivô, então todos os outros elementos desta coluna são iguais a 0.<br />
4. Todas as linhas nulas ocorrem abaixo das linhas não-nulas.

## Utilização

Insira uma matriz separada por espaço no arquivo in.txt
```
2 1 1 8
1 1 4 15
0 3 2 9
```
A saída de todos os passos do escalonamento será encontrada em out.txt
```
2.0  1.0  1.0  8.0  
1.0  1.0  4.0  15.0  
0.0  3.0  2.0  9.0  


1.0  0.5  0.5  4.0  
1.0  1.0  4.0  15.0  
0.0  3.0  2.0  9.0  


1.0  0.5  0.5  4.0  
0.0  0.5  3.5  11.0  
0.0  3.0  2.0  9.0  


1.0  0.5  0.5  4.0  
0.0  1.0  7.0  22.0  
0.0  3.0  2.0  9.0  


1.0  0.0  -3.0  -7.0  
0.0  1.0  7.0  22.0  
0.0  0.0  -19.0  -57.0  


1.0  0.0  -3.0  -7.0  
0.0  1.0  7.0  22.0  
0.0  0.0  1.0  3.0  


1.0  0.0  0.0  2.0  
0.0  1.0  0.0  1.0  
0.0  0.0  1.0  3.0
```

##Referência

http://people.ucsc.edu/~ptantalo/math21/Winter07/GaussJordan.java
