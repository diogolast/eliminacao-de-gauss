package escalonador;

import java.io.*;
import java.util.StringTokenizer;

public class gauss {
	
	// troca a linha i com linha k
	static void troca(double[][] A, int i, int k, int j) {
		int m = A[0].length - 1;
		double temp;
		for (int q = j; q <= m; q++) {
			temp = A[i][q];
			A[i][q] = A[k][q];
			A[k][q] = temp;
		}
	}

	// divisao de linha i por A[i][j] Ex A12/A11
	static void divide(double[][] A, int i, int j) {
		int m = A[0].length - 1; //tamanho da linha da matriz
		for (int q = j + 1; q <= m; q++){
			A[i][q] /= A[i][j]; //divide o primeiro elemento da linha com os proximos
		}
		A[i][j] = 1;
	}

	
	// subtrai elemento com a multipliccação de elementos de outra linha Ex A22 - (A21*A12)
	static void elimina(double[][] A, int i, int j) {		
		int n = A.length - 1; //linhas
		int m = A[0].length - 1; // colunas
		for (int p = 1; p <= n; p++) {
			if (p != i && A[p][j] != 0) {
				for (int q = j + 1; q <= m; q++) {
					A[p][q] -= A[p][j] * A[i][q];					
				}
				A[p][j] = 0;
			}
		}
	}

	// imprimi Matriz
	static void printMatrix(PrintWriter out, double[][] A) {
		int n = A.length - 1;
		int m = A[0].length - 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++)
				out.print(A[i][j] + "  ");
			out.println();
		}
		out.println();
		out.println();
	}

	// metodo principal
	public static void main(String[] args) throws IOException {
		int n, m, i, j, k;
		String line;
		StringTokenizer st;
		String pathIn = "src/in.txt";
		String pathOut = "src/out.txt";

		// le arquivo para contar o numero de linhas e colunas
		BufferedReader inCount = new BufferedReader(new FileReader(pathIn));
		String linha;
		int x = 0, y = 0;
		while ((linha = inCount.readLine()) != null) {
			String[] values = linha.split(" ");
			for (String str : values) {
				y = y + 1; // numero total de elementos
			}
			x = x + 1; // numero de linhas
		}
		inCount.close();

		n = x;

		m = y / x;

		// leitura do arquivo para começar a resolver o sistema
		BufferedReader in = new BufferedReader(new FileReader(pathIn));
		PrintWriter out = new PrintWriter(new FileWriter(pathOut));

		// declara A (n+1)x(m+1) pois não irei utilizar o index 0
		double[][] A = new double[n + 1][m + 1];

		for (i = 1; i <= n; i++) {
			line = in.readLine();
			st = new StringTokenizer(line); // pega as variaveis separadas por um espaço
			for (j = 1; j <= m; j++) {
				A[i][j] = Double.parseDouble(st.nextToken()); //insiro todos os elementos do arquivo na matriz A
			}
		}
		// fecha arquivo de entrada
		in.close();

		// imprimi matriz A no arquivo out.txt
		printMatrix(out, A);

		// Algoritmo Gauss
		i = 1;
		j = 1;
		while (i <= n && j <= m) { // while de leitura de toda a matriz

			// procura por valor 0 em cada loop
			k = i;
			while (k <= n && A[k][j] == 0) {
				k++;
			}
			
			if (k <= n) {
				
				// se k for diferente de i, troca linha i com linha k
				if (k != i) {
					troca(A, i, k, j);
					printMatrix(out, A);
				}

				// se A[i][j] nao é 1, divide linha i por A[i][j]
				if (A[i][j] != 1) {
					divide(A, i, j);
					printMatrix(out, A);
				}
				
				//faz operacao para zerar as linhas
				elimina(A, i, j);
				printMatrix(out, A);
				i++;
			}
			j++;
		}

		// fecha arquivo de saida
		out.close();
	}

}
