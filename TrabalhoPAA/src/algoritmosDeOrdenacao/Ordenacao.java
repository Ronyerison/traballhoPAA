package algoritmosDeOrdenacao;

import java.util.Arrays;
import java.util.Random;

public class Ordenacao {

	public static void bubleSort(int[] vetor){
		int aux;
		boolean parar = false;
		while(parar == false){
			parar = true;
			for (int i = 0; i < vetor.length-1; i++) {
				if(vetor[i] > vetor[i+1]){
					aux = vetor[i+1];
					vetor[i+1] = vetor[i];
					vetor[i] = aux;
					parar = false;
				}
			}
		}
	}
	
	public static void insertionSort(int[] vetor){
		int j, aux;
		for (int i = 1; i < vetor.length; i++) {
			j = i;
			while( j > 0 && vetor[j] < vetor[j-1] ){
				aux = vetor[j-1];
				vetor[j-1] = vetor[j];
				vetor[j] = aux;
				j--;
			}
		}
	}
	
	public static void selectionSort(int[] vetor) {
		int min, pos_min, aux;
		for (int i = 0; i < vetor.length - 1; i++) {
			min = vetor[i];
			pos_min = i;
			for (int j = i+1; j < vetor.length; j++) {
				if (vetor[j] < min) {
					min = vetor[j];
					pos_min = j;
				}
			}
			aux = vetor[i];
			vetor[i] = min;
			vetor[pos_min] = aux;
		}
	}
	
	public static void mergeSort(int[] vetor){
		if(vetor.length > 1){
			int q = vetor.length/2;
			int[] esquerda = Arrays.copyOfRange(vetor, 0, q);
			int[] direita = Arrays.copyOfRange(vetor, q, vetor.length);
			mergeSort(esquerda);
			mergeSort(direita);
			merge(vetor, esquerda, direita);
		}
	}
	
	public static void merge(int[] a, int[] l, int[] r) {
        int totElem = l.length + r.length;
        //int[] a = new int[totElem];
        int i,li,ri;
        i = li = ri = 0;
        while ( i < totElem) {
            if ((li < l.length) && (ri<r.length)) {
                if (l[li] < r[ri]) {
                    a[i] = l[li];
                    i++;
                    li++;
                }
                else {
                    a[i] = r[ri];
                    i++;
                    ri++;
                }
            }
            else {
                if (li >= l.length) {
                    while (ri < r.length) {
                        a[i] = r[ri];
                        i++;
                        ri++;
                    }
                }
                if (ri >= r.length) {
                    while (li < l.length) {
                        a[i] = l[li];
                        li++;
                        i++;
                    }
                }
            }
        }
        //return a;

    
		
	}
	
	public static void constroiHeapMax(int[] vetor,int tam){
		
		for (int i = tam/2 - 1; i >= 0; i--) {
			refazHeapMax(vetor, i, tam);
		}
	}

	private static void refazHeapMax(int[] vetor, int i, int tam) {
		int maior;
		int e = esquerda(i);
		int d = direita(i);
		
		if(esquerda(i) < tam){
			if(e < tam && vetor[e] > vetor[i]){
				maior = e;
			}else{
				maior = i;
			}
			if(d < tam && vetor[d] > vetor[maior]){
				maior = d;
			}
			if(maior != i){
				int aux = vetor[maior];
				vetor[maior] = vetor[i];
				vetor[i] = aux;
				refazHeapMax(vetor, maior, tam);
			}
		}
	}
	
	public static void heapSort(int[] vetor){
		int tam = vetor.length;
		int aux;
		constroiHeapMax(vetor, tam);
		for (int i = vetor.length - 1; i > 0; i--) {
			aux = vetor[0];
			vetor[0] = vetor[i];
			vetor[i] = aux;
			tam--;
			refazHeapMax(vetor, 0, tam);
		}
	}
	
	public static int esquerda(int i){
		return 2*i+1;
	}
	
	public static int direita(int i){
		return 2*i+2;
	}
	
	public static int tamHeap(int[] vetor){
		return vetor.length;
	}
	
	public static void quickSort(int[] vetor, int e, int d){
		int i = e, j = d;
		int pivo = vetor[e + (d-e)/2];
		
		while(i <= j){
			while(vetor[i] < pivo){
				i++;
			}
			while (vetor[j] > pivo) {
				j--;
			}
			if(i <= j){
				troca(vetor, i, j);
				i++;
				j--;
			}
		}
		if(e < j)
			quickSort(vetor, e, j);
		if(i < d)
			quickSort(vetor, i, d);
	}

	public static void troca(int[] vetor, int i, int j){
		int aux = vetor[i];
		vetor[i] = vetor[j];
		vetor[j] = aux;
	}

	public static void hibridSort(int[] vetor){
		if(vetor.length > 1000){
			quickSort(vetor, 0, vetor.length-1);
		}else{
			insertionSort(vetor);
		}
	}

}
