package paa;

import java.util.ArrayList;
import java.util.List;

public class algoritmosProva {

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
		} else if (S[meio] < 0) {
			return pesquisa(S, meio + 1, fim);
		} else if (meio > S[meio]) {
			return pesquisa(S, ini, meio - 1);
		} else {
			return pesquisa(S, meio + 1, fim);
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
		System.out.println(pesquisa(S, 0, 3));
		int[] A = {2, 3, 5, 6};
		System.out.println(pesquisa(A, 0, 3));

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
	}

}
