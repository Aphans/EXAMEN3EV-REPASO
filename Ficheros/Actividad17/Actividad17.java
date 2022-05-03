package Actividad17;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Actividad17 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nombreFichero = null;
		Random r = new Random();
		int contador=0;
		int suma=0;
		int [] numeros = new int[50];
		File file = new File("numeros.dat");
		try {
			file.createNewFile();

			FileOutputStream out = new FileOutputStream(file);   
			DataOutputStream das =new DataOutputStream(out);

			while(contador<numeros.length) {
				int randomInt = r.nextInt(500) + 1;
				das.writeByte(randomInt);
				suma += randomInt;
				contador++;
			}
			das.close();//Para poder leer
			
			FileInputStream in = new FileInputStream(file);
			DataInputStream dis = new DataInputStream(in);

			int valor=dis.read();

			contador = 0;
			System.out.println("Binarios:");
			while((valor=dis.read())!=-1){
				numeros[contador] = valor;
				contador++;
			}

			dis.close();

			file = new File("texto.txt");
			FileWriter filew = new FileWriter(file);
			for(int i = 0; i < numeros.length; i++) {
				filew.write(String.valueOf(numeros[i]) + "\n");
			}

			filew.close();

			FileReader fileReader = new FileReader(file);
			contador = 0;
			System.out.println("Texto:");
			while((valor=fileReader.read())!=-1 && contador < numeros.length){
				numeros[contador] = valor;
				System.out.println(String.valueOf(valor));
				contador++;
			}
			
			fileReader.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(sc!=null) {
				sc.close();
			}
		}

	}

}
