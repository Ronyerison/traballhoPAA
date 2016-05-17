package paa;

import java.util.ArrayList;
import java.util.List;

public class AlgoritmosProva {

	public static String pesquisa(int[] S, int ini, int fim) {
		if (ini == fim) {
			if (S[ini] == ini) {
				return "Existe!!!";
			} else {
				return "Não Existe!!!";
			}
		}
		int meio = (int) (ini + fim) / 2;
		if (S[meio] == meio) {
			return "Existe!!!";
		} else if (S[meio] < meio) {
			return pesquisa(S, meio + 1, fim);
		} else{
			return pesquisa(S, ini, meio - 1);
		} 
	}

	public static Integer questaoExtra(int[] C, int n) {
		int[][] tabela = new int[n][n];
		int x, y, z;
		for (int gap = 0; gap < n; gap++) {
			for (int i = 0, j = gap; j < n; i++, j++) {
				x = ((i + 2) <= j) ? tabela[i + 2][j] : 0;
				y = ((i + 1) <= (j - 1)) ? tabela[i + 1][j - 1] : 0;
				z = (i <= (j - 2)) ? tabela[i][j - 2] : 0;

				tabela[i][j] = max(C[i] + min(x, y), C[j] + min(y, z));
			}
		}
//		for (int[] is : tabela) {
//			for (int i : is) {
//				System.out.print(i + " ");
//			}
//			System.out.println("");
//		}
		return tabela[0][n - 1];
	}

	@SuppressWarnings("unused")
	public static List<int[]> questaoExtraV2(int[] vetor) {
		int count = 0, escolha = 0, i = 0, j = vetor.length - 1;
		boolean flag = true;
		List<int[]> A = new ArrayList<int[]>();
		List<int[]> W = new ArrayList<int[]>();
		while (count != vetor.length) {
			if (i == j) {
				int[] v = {vetor[i], i};
				if (flag) {
					A.add(v);
					flag = false;
				} else {
					W.add(v);
					flag = true;
				}
				// escolha += vetor[i];
				break;
			} else if (j == i + 1) {
				// escolha += max(vetor[i], vetor[j]);
				if (vetor[j] == max(vetor[i], vetor[j])) {
					int[] v = {vetor[j], j};
					if (flag) {
						A.add(v);
						flag = false;
					} else {
						W.add(v);
						flag = true;
					}
				} else {
					int[] v = {vetor[i], i};
					if (flag) {
						A.add(v);
						flag = false;
					} else {
						W.add(v);
						flag = true;
					}
				}
				break;
			} else {
				int a = vetor[i] + min(vetor[j], vetor[i + 2]);
				int b = vetor[j] + min(vetor[j - 2], vetor[i]);

				if (max(a, b) == a) {
					escolha += vetor[i];
					int[] v = {vetor[i], i};
					if (flag) {
						A.add(v);
						flag = false;
					} else {
						W.add(v);
						flag = true;
					}
					i++;
				} else {
					escolha += vetor[j];
					int[] v = {vetor[j], j};
					if (flag) {
						A.add(v);
						flag = false;
					} else {
						W.add(v);
						flag = true;
					}
					j--;
				}
			}
			count++;
		}

		return A;
	}

	public static int max(int a, int b) {
		return a > b ? a : b;
	}
	public static int min(int a, int b) {
		return a < b ? a : b;
	}

	public static void main(String[] args) {
		int[] S = {-5, -2, -1, 0, 3, 5};
		System.out.println(pesquisa(S, 0, 5));
		int[] A = {2, 3, 5, 6};
		System.out.println(pesquisa(A, 0, 3));
		int[] B = {-1, 1, 5, 7, 8, 10};
		System.out.println(pesquisa(B, 0, 5));

		int[] C = {0, -3, 5, 10};
		System.out.println("Questao Extra: " + questaoExtra(C, 4));
//		System.out.println("Questao Extra V2: "
//				+ Arrays.toString(questaoExtraV2(C).toArray()));

		int[] D = {0, -3, 5, 7};
		System.out.println("Questao Extra: " + questaoExtra(D, 4));
//		System.out.println("Questao Extra V2: " + questaoExtraV2(D));

		int[] E = {47, 50, -3, 7};
		System.out.println("Questao Extra: " + questaoExtra(E, 4));
//		System.out.println("Questao Extra V2: " + questaoExtraV2(E));

		int[] F = {15, 9, 57, 5, -3, 10};
		System.out.println("Questao Extra: " + questaoExtra(F, 6));
//		System.out.println("Questao Extra V2: " + questaoExtraV2(F));
		
//		//Exemplo questao 5
//		int [][] custos = {	{0, 1, 5, 5, 5, 10},
//							{0, 0, 5, 5, 1, 5},
//							{0, 0, 0, 5, 5, 5},
//							{0, 0, 0, 0, 5, 5},
//							{0, 0, 0, 0, 0, 1},
//							{0, 0, 0, 0, 0, 0}};
//		questao5(custos);
	}
	
	public static void questao5(int custo[][]){
		if (custo.length == 1) {
			System.out.println("Custo total: 0");
			System.out.println("Caminho: 0");
		} else {
			int custoMinimo[] = new int[custo.length];
			custoMinimo[0] = 0;
			custoMinimo[1] = custo[0][1];
			
			int caminhoMinimo[] = new int[custo.length];
			caminhoMinimo[0] = 0;
			caminhoMinimo[1] = 0;
			
			for (int i = 2; i < custo.length; i++) {
				custoMinimo[i] = custo[0][i];
				caminhoMinimo[i] = 0;
				for (int j = 1; j < i; j++) {
					if ((custoMinimo[j] + custo[j][i]) < custoMinimo[i]) {
						custoMinimo[i] = custoMinimo[j] + custo[j][i];
						caminhoMinimo[i] = j;
					}					
				}
			}
			
			System.out.print("Caminho: " + (caminhoMinimo.length-1));
			for (int i = caminhoMinimo.length-1; i > 0; i = caminhoMinimo[i]) {
				System.out.print(", " + caminhoMinimo[i]);
			}
			System.out.print("\nCusto: " + custoMinimo[custo.length-1]);
		}

	}

}
