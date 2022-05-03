package Exceptions;

import java.io.IOException;

public class Actividad6 {
	public static void main(String[] args) throws IOException {
		Actividad6.main();
	}
	public static void main()throws java.io.IOException{
		try {
			throw new Exception("MENSAJE");
		}
		catch(Exception e) {
			e.getMessage();
		}
		finally {
			System.out.println("Esta pasando por el bloque finally");
		}
	}
}
 