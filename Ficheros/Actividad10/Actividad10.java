package Actividad10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Actividad10 {
	public static void main(String[] args) {
		int suma = 0;
		// Asumimos que el fichero esta en el directorio de trabajo (carpeta del proyecto Java)
		File f = new File("C:\\Users\\daw\\eclipse-workspace\\3Evaluacion\\Ficheros\\numeros.txt");
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			String line;
			while((line=br.readLine())!=null) {
				suma += Integer.parseInt(line);
			}
			System.out.println("La suma de los numeros del fichero es: " + suma);

			br.close();
			fr.close();
		} catch (IOException e) {
			System.out.println("Error de lectura en el fichero");
			e.printStackTrace();
		} 
		// Esta segunda excepcion permite controlar si el fichero contiene caracteres no numericos
		catch (NumberFormatException e) {
			System.out.println("El programa ha encontrado caracteres que no son numeros (ojo con poner saltos de linea de mas)");
		}
	}

}
