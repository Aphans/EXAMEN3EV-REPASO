package Ficheros;

import java.io.File;
import java.util.Scanner;

public class Actividad1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String directorio;
		System.out.println("Escribe un directorio");
		directorio = sc.next();
		File file = new File(directorio);
		String [] archivos = file.list();
		for (int i = 0; i < archivos.length; i++) {
			System.out.println(archivos[i]);
		}
		sc.close();
	}

}
