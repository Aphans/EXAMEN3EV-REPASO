package Actividad9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Actividad9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File file = null;
		FileWriter filewriter = null;
		BufferedWriter bufferwriter = null;
		FileReader filereader = null;
		BufferedReader bufferedreader = null;
		String nombreFichero;
		String algo;
		System.out.println("Escribe un nombre para el fichero");
		nombreFichero = sc.next();
		file = new File(nombreFichero);
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			filewriter = new FileWriter(file);
			bufferwriter= new BufferedWriter(filewriter);
			System.out.println("Escribe algo");
			algo = sc.next();
			bufferwriter.write(algo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				bufferwriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			filereader = new FileReader(file);
			bufferedreader = new BufferedReader(filereader);
			String linea;
			char letra;
			try {
				while((linea= bufferedreader.readLine())!=null){
					for (int i = 0; i < linea.length(); i++) {
						letra = linea.charAt(i);
						if(letra >= 'A' && letra <= 'Z') { //mayuscula
							letra = Character.toString(letra).toLowerCase().toCharArray()[0];
						}
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
