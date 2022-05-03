package Actividad12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Actividad12 {
	public static int contarLíneas(File file) {
		try {
			Scanner sc = new Scanner(file);
			int contador=0;
			while(sc.hasNextLine()) {
				sc.nextLine();
				contador++;
			}
			sc.close();

			return contador;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public static int contarCaracteres(File file) {
		try {
			Scanner sc = new Scanner(file);
			int contador=0;
			while(sc.hasNextLine()) {
				contador += sc.nextLine().length();

			}
			sc.close();
			return contador;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return 0;

	}
	public static int contarPalabras(File file) {
		try {
			Scanner sc = new Scanner(file);
			int contador=0;
			while(sc.hasNextLine()) {
				StringTokenizer tokens=new StringTokenizer(sc.nextLine());
				contador += tokens.countTokens();

			}
			sc.close();
			return contador;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return 0;

	}
	public static String cadenaMax(File file) {
		try {
			Scanner sc = new Scanner(file);
			int contador=0;
			String palabra = "";
			while(sc.hasNextLine()) {
				StringTokenizer tokens=new StringTokenizer(sc.nextLine());
				while(tokens.hasMoreTokens()){
					String p = tokens.nextToken();
					if (p.length() > palabra.length()) palabra = p;
				}

			}
			sc.close();
			return palabra;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return "";

	}
	public static int cuentaPalabra(File file,String palabra) {
		try {
			Scanner sc = new Scanner(file);
			int contador=0;
			while(sc.hasNextLine()) {
				StringTokenizer tokens=new StringTokenizer(sc.nextLine());
				while(tokens.hasMoreTokens()){
					String p = tokens.nextToken();
					if(p.equals(palabra)) {
						contador++;
					}
				}

			}
			sc.close();
			return contador;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return 0;

	}
	
	
	
	

	public static void main(String[] args) {
		File file = new File("numeros.txt");
		System.out.println(contarLíneas(file));
		System.out.println(contarCaracteres(file));
		System.out.println(contarPalabras(file));
		System.out.println(cadenaMax(file));
		System.out.println(cuentaPalabra(file,"eeeeeeeeeeeeeeeeeeeee"));
	}

}
