package Ficheros;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Actividad3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nombreDirectorio,ruta;
		System.out.println("Escribe un nombre para el directorio");
		nombreDirectorio = sc.next();
		System.out.println("Escribe la ruta para el directorio");
		ruta = sc.next();
		File file = new File (ruta,nombreDirectorio);
		file.mkdir();
		File fichero1 = new File(file,"FICHERO1.TXT");
		File fichero2 = new File(file,"FICHERO2.TXT");
		try {
			fichero1.createNewFile();
			fichero2.createNewFile();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[]ficheros = file.list();
		System.out.println("Los ficheros son");
		for (int i = 0; i < ficheros.length; i++) {
			System.out.println(ficheros[i]);
		}
		File fichero3 = new File(file,"FICHERO3.TXT");
		fichero2.renameTo(fichero3);
		System.out.println("Los ficheros creados pero con renombraciones son:");
		String[] ficheros2 = file.list();
		for (int i = 0; i < ficheros2.length; i++) {
			System.out.println(ficheros2[i]);
		}
		
		sc.close();

	}

}
