package Actividad7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Actividad7 {
	public static void main(String[] args) {
		//Declaraciones
		int opcion = 0;
		String nombreArchivo  ,ruta,datos;
		String nombre,apellidos,ciudadNacimiento;
		//Creación ruta y fichero
		File añadirRuta;
		File archivo = null;
		//Escritura fichero
		FileWriter fw = null;
		BufferedWriter bfw;
		//Lectura fichero
		FileReader filer = null;
		BufferedReader bfiler;
		Scanner sc = new Scanner(System.in);
		while(opcion!=3) {
		System.out.println("Escribe una opción");
		opcion = sc.nextInt();
		//Menú
		switch(opcion) {
		case 1:
			//Añadiendo nombre del fichero y ruta
			System.out.println("Escribe el nombre del archivo");
			nombreArchivo = sc.next();
			System.out.println("Escribe el nombre de la ruta");
			ruta = sc.next();
			añadirRuta = new File(ruta);
			archivo = new File(añadirRuta,nombreArchivo);
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Añadiendo contenido al fichero
			System.out.println("Escribe contenido en el fichero:");
			System.out.println("Escribe tu nombre:");
			nombre = sc.next();
			System.out.println("Escribe tus apellidos:");
			apellidos = sc.next();
			System.out.println("Escribe la ciudad en la que naciste:");
			ciudadNacimiento = sc.next();
			datos = nombre+" , "+apellidos+" , "+ciudadNacimiento;
			try {
				fw = new FileWriter(archivo,true);
				bfw = new BufferedWriter(fw);
				bfw.write(datos);
				bfw.newLine();
				bfw.flush();
				bfw.close();
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 2:
			try {
				filer = new FileReader(archivo);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bfiler = new BufferedReader(filer);
			System.out.println("Contenido del fichero:");
			try {
				while((datos = bfiler.readLine())!=null){
					System.out.println(datos);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case 3:
			break;
		}
	}
		sc.close();
	}

}
