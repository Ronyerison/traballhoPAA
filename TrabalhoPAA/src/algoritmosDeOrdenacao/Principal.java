package algoritmosDeOrdenacao;

import java.util.Random;

public class Principal {
	
	public static void sortearVetor(int[] vetor){
		
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = 1 +  new Random().nextInt(vetor.length);
		}
	}
	
	public static void ordemCrescente(int[] vetor){
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = i+1;
		}
	}
	
	public static void ordemDecrescente(int[] vetor){
		int j= vetor.length;
		for (int i = 0 ; i < vetor.length; i++) {
			vetor[i] = j;
			j--;
		}
	}
	
	public static void calcularTemposAleatorio(int op, double[][] tempos, int[] vetor, Ordenacao o){
		long inicio, fim;
		for (int j = 0; j < 3; j++) {
			gerarVetor(op, vetor);
			inicio = System.currentTimeMillis();
			o.bubleSort(vetor);
			fim = System.currentTimeMillis();
			tempos[0][j] = (double) (fim - inicio);
			tempos[0][3] = tempos[0][3] + tempos[0][j];
			
			gerarVetor(op, vetor);
			inicio = System.currentTimeMillis();
			o.insertionSort(vetor);
			fim = System.currentTimeMillis();
			tempos[1][j] = (double) (fim - inicio);
			tempos[1][3] = tempos[1][3] + tempos[1][j];
			
			gerarVetor(op, vetor);
			inicio = System.currentTimeMillis();
			o.selectionSort(vetor);
			fim = System.currentTimeMillis();
			tempos[2][j] = (double) (fim - inicio);
			tempos[2][3] = tempos[2][3] + tempos[2][j];
			
			gerarVetor(op, vetor);
			inicio = System.currentTimeMillis();
			o.heapSort(vetor);
			fim = System.currentTimeMillis();
			tempos[3][j] = (double) (fim - inicio);
			tempos[3][3] = tempos[3][3] + tempos[3][j];
			
			gerarVetor(op, vetor);
			inicio = System.currentTimeMillis();
			o.mergeSort(vetor);
			fim = System.currentTimeMillis();
			tempos[4][j] = (double) (fim - inicio);
			tempos[4][3] = tempos[4][3] + tempos[4][j];
			
			gerarVetor(op, vetor);
			inicio = System.currentTimeMillis();
			o.quickSort(vetor, 0, vetor.length-1);
			fim = System.currentTimeMillis();
			tempos[5][j] = (double) (fim - inicio);
			tempos[5][3] = tempos[5][3] + tempos[5][j];
			
			gerarVetor(op, vetor);
			inicio = System.currentTimeMillis();
			o.hibridSort(vetor);
			fim = System.currentTimeMillis();
			tempos[6][j] = (double) (fim - inicio);
			tempos[6][3] = tempos[6][3] + tempos[6][j];
		}
		
		for (int i = 0; i < 7; i++) {
			tempos[i][3] = tempos[i][3] / 3;
		}
	}
	
	public static void gerarVetor(int op, int[] vetor){
		if(op==1){
			sortearVetor(vetor);
		}
		if(op==2){
			ordemCrescente(vetor);
		}
		if(op==3){
			ordemDecrescente(vetor);
		}
	}

	public static void imprimirTempos(double[][] tempos){
		System.out.print(" Buble sort = ");
		for (int i = 0; i < 4; i++) {
			System.out.printf(" %.3f ", tempos[0][i]);
		}
		System.out.print("\n Insertion sort = ");
		for (int i = 0; i < 4; i++) {
			System.out.printf(" %.3f ", tempos[1][i]);
		}
		System.out.print("\n Selection sort = ");
		for (int i = 0; i < 4; i++) {
			System.out.printf(" %.3f ", tempos[2][i]);
		}
		System.out.print("\n Heap sort = ");
		for (int i = 0; i < 4; i++) {
			System.out.printf(" %.3f ", tempos[3][i]);
		}
		System.out.print("\n Merge sort = ");
		for (int i = 0; i < 4; i++) {
			System.out.printf(" %.3f ", tempos[4][i]);
		}
		System.out.print("\n Quick sort = ");
		for (int i = 0; i < 4; i++) {
			System.out.printf(" %.3f ", tempos[5][i]);
		}
		System.out.print("\n Hibrid sort = ");
		for (int i = 0; i < 4; i++) {
			System.out.printf(" %.3f ", tempos[6][i]);
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ordenacao o = new Ordenacao();
		int N = 50000;
		int[] vetor = new int[N];
		double[][] tempos = new double[7][4];
		
		calcularTemposAleatorio(3,tempos, vetor, o);
		imprimirTempos(tempos);
		

	}

}
