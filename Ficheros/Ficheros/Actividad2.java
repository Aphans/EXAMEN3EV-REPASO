package Ficheros;

import java.io.File;
import java.util.Scanner;

public class Actividad2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String directorio;
		System.out.println("Escribe un directorio");
		directorio = sc.next();
		File file = new File(directorio);
		System.out.println("La ruta es:"+file.getPath());
		System.out.println("La ruta absoluta es:"+file.getAbsolutePath());
		System.out.println("El tamaño del directorio o archivo es:"+file.length());
		System.out.println("¿Se puede leer?"+file.canRead());
		System.out.println("¿Se puede escribir?"+file.canWrite());
		System.out.println("¿Es fichero o directorio?"+file.isFile());
		System.out.println("¿Existe?"+file.exists());
		sc.close();
	}


}
