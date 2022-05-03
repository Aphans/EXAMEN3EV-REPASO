package Exceptions;

import java.util.Scanner;

public class Actividad2 {

	public static void rellenaArray(int [] numeros) {
		for (int i = 0; i < numeros.length; i++) {
			try {
				numeros[i]=(int) (Math.random()*20)+1 ;
				if(i>5)
					throw new IndexOutOfBoundsException("REVISA TUS DATOS");
				if(numeros[0]+numeros[1]<10)
					throw new ArithmeticException();
			}
			catch(NumberFormatException exc) {
				System.out.println("El número no tiene buen formato");
			}
		}
	}
	public static void mostrarArray(int []numeros) {
		for (int i = 0; i < numeros.length; i++) {
			System.out.println(numeros[i]);
		}
	}
	public static void main(String[] args) {
		final int NUM = 5;
		int[] enteros = new int[NUM];
		int posicion = 0;
		Scanner teclado = new Scanner(System.in);
		int cont = 0;
		int divisor = 0;
		while (cont < NUM) {
			try {
				System.out.println("Introduce una posición del array:");
				posicion = Integer.parseInt(teclado.nextLine());
				System.out.println("Introduce un divisor:");
				divisor = Integer.parseInt(teclado.nextLine());
				enteros[posicion] = 100 / divisor;
				cont++;
				rellenaArray(enteros);
				mostrarArray(enteros);
				System.out.println("El contenido del array de enteros es:");
				for (int valor : enteros) {
					System.out.println(valor);
				}
			}
			catch(ArrayIndexOutOfBoundsException exc) {
				System.out.println("Index 6 out of bounds for length 5");
			}

			catch(ArithmeticException exc) {
				System.out.println("No se puede dividir por cero");
			}
			catch(NumberFormatException exc) {
				System.out.println("El divisor debe ser un númerico");
			}
			catch(IndexOutOfBoundsException exc) {
				exc.getMessage();
			}

		}
	}
}

