package Exceptions;

public class Actividad7 extends Exception {
	String a;
	public Actividad7(String a) {
		this.a = a;
	}

	public static void main(String[] args) {
		try {
			String a = "333";
			throw new Actividad7(a);
		}
		catch(Actividad7 e) {
		  System.out.println("El string no es válido");
		}
	}

}
