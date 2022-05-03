package Actividad13;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Actividad13 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File file = new File("enteros.txt");
		int numero = 0;
		try {
			file.createNewFile();
			FileWriter filerw = new FileWriter(file);
			BufferedWriter bfrw = new BufferedWriter(filerw);
			while((numero = sc.nextInt()) != -1) {
				bfrw.write(String.valueOf(numero).charAt(0));
			}
			bfrw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
