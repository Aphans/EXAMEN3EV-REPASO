package Actividad8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Actividad8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion,numeros = 0;
		String nombreFichero;
		boolean salir=false;
		File fichero=null;
		FileWriter ficherow = null;
		FileReader ficheror = null;
		BufferedReader ficherorea = null;
		BufferedWriter ficherobw = null;
		final int numeroPares = 100;
		int contador = 0;
		System.out.println("1. Escritura de los 100 primeros números pares en un fichero de texto."+"\n"+
				"2. Mostrar por pantalla el contenido del fichero de texto creado."+"\n"+
				"3. Salir del Programa.\r\n"
				+ "");
		while(!salir) {
			System.out.println("Elija una opción");
			opcion = sc.nextInt();
			switch(opcion) {
			case 1:
				System.out.println("Escribe un nombre para el fichero");
				nombreFichero = sc.next();
				try {
					fichero = new File(nombreFichero);
					fichero.createNewFile();
					ficherow =new FileWriter (fichero);
					ficherobw =new BufferedWriter(ficherow);
					 contador = 0;
					while (contador < numeroPares) {
						if(numeros%2 == 0) {
							ficherobw.write(String.valueOf(numeros));
							ficherobw.newLine();
							contador++;
						}
						numeros++;
					}
				}
				catch (IOException e){
					System.out.println("Error de creacion de fichero o de escritura");
				}
				finally {
					try {
						ficherobw.close();
					} catch (IOException e) {
						System.out.println("Error: No se ha conseguido cerrar el fichero");
					}
				}
				break;

		case 2:
			System.out.println("El contenido del fichero es");
			try {
				ficheror= new FileReader(fichero);
				ficherorea = new BufferedReader(ficheror);
				String linea;
				try {
					while((linea= ficherorea.readLine())!=null){
						System.out.println(linea);

					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		case 3:
			salir=true;
		}
	}
	sc.close();
}

}
