package Actividad5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Actividad5 {
	public static void main(String[] args) {
		File directorio = new File("C:\\Users\\daw\\Desktop\\Reader.txt");
		FileReader fr = null;
		String linea;
		try {
			fr = new FileReader(directorio);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader rf = new BufferedReader(fr);
		try {
			while((linea=rf.readLine())!=null) {
				System.out.println(linea);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
