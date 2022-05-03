package Actividad4;

import java.io.File;
import java.io.IOException;

public class Ficheros {
	public static void crearFichero(String ruta) {
		File file = new File(ruta);
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void eliminarFichero(File fichero) {
		fichero.delete();
	}
	public static void renombrarFichero(File fichero,File newFichero) {
		fichero.renameTo(newFichero);
	}
	public static void listarDirectorio(String [] directorio) {
		for (int i  = 0; i  < directorio.length; i ++) {
			System.out.println(directorio[i]);
		}
	}
}
