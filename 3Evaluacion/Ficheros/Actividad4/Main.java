package Actividad4;

import java.io.File;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		File directorio = new File("C:\\Users\\daw\\Desktop");
		File fichero1 = new File(directorio,"Fichero1.txt");
		File fichero2 = new File(directorio,"Fichero2.txt");
		try {
			fichero1.createNewFile();
			fichero2.createNewFile();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
