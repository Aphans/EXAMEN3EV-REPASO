package Actividad11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Actividad11 {
	static FileReader fr1 = null;
	static BufferedReader ficherorea1 = null;
	static FileReader fr2 = null;
	static BufferedReader ficherorea2 = null;
	public static void unirFicheros(File file1,File file2) {
		File file3 = new File(file1.getName() + "_" + file2.getName()+".txt");
		if(file3.exists()) {
			try {
				file3.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			FileWriter filew = new FileWriter(file3);
			BufferedWriter filebw = new BufferedWriter(filew);
			fr1 = new FileReader(file1);
			ficherorea1 = new BufferedReader(fr1);
			fr2 = new FileReader(file2);
			ficherorea2 = new BufferedReader(fr2);
			String lineaFichero;
			while((lineaFichero= ficherorea1.readLine())!=null){
				filebw.write(lineaFichero);
			}
			filebw.newLine();
			while((lineaFichero= ficherorea2.readLine())!=null){
				filebw.write(lineaFichero);
			}
			filebw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		File file1 = new File("file1.txt");
		File file2 = new File("file2.txt");

		if(file1.exists() && file2.exists()) {
			unirFicheros(file1,file2);
		}
	}

}
