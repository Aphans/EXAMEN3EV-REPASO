package Exceptions;

public class Actividad1 {
	static void generaException() {
		int nums[]= new int [4];
		System.out.println("Antes de ser generada");
		nums[7]=10; //To exception
		System.out.println("Este mensaje no se emitirá");
	}
	public static void main(String[] args) {
		try {
			Actividad1.generaException();
		}
		catch(ArrayIndexOutOfBoundsException exc) {
			System.out.println("Index-out-Bounds");
		}
		System.out.println("Mensaje posterior a catch");
	}
}
