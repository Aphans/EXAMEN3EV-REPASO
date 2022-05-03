package Actividad6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Actividad6 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		File fichero = new File("C:\\Users\\daw\\Desktop\\Reader.txt");
		FileReader frefichero = null;
		String escribir = null;
		BufferedReader bffichero;
		FileWriter ficherow = null;
		BufferedWriter ficherobw = null;


		//Escribir fichero
		try {
			ficherow = new FileWriter(fichero, true);
			ficherobw = new BufferedWriter(ficherow);
			System.out.println("Escribe en el fichero, 'FIN' para finalizar");

			escribir = sc.nextLine();
			while(!escribir.equals("FIN")) {
				ficherobw.write(escribir);
				ficherobw.newLine();
				escribir = sc.nextLine();
			}
		}
		catch(IOException e) {
			System.out.println("Error!");
			e.printStackTrace();
		}
		finally {
			/*---------------IMPORTANTE CERRAR FICHERO PARA PODER LEERLO--------------------*/
			try {
				ficherobw.close();
				ficherow.close();
			}
			catch(IOException e) {
				System.out.println("Error!");
				e.printStackTrace();
			}
		}



		//Leer fichero
		try {
			frefichero = new FileReader(fichero);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bffichero = new BufferedReader(frefichero);
		System.out.println("Contenido del fichero:");
		try {
			while((escribir = bffichero.readLine())!=null) {
				System.out.println(escribir);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 

		sc.close();

	}
}
