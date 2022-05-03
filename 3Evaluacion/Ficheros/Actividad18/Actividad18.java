package Actividad18;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Actividad18 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File fichero = new File("C:\\Users\\daw\\Desktop\\Fichero.txt");
		try {
			EscribirRegistros(fichero);
			System.out.println("Escribe el ID");
			int id = sc.nextInt();
			System.out.println("Escribe el importe");
			double importe = sc.nextDouble();
			sc.close();
			sumarSalario(fichero,id,importe);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sc.close();
	}
	public static void EscribirRegistros(File f) throws IOException,FileNotFoundException{
		
		int dept[]= {10,20,10,10,30,30,20};
		double salario[]= {1000.45,2400.60,3000.0,1500.56,2200.0,1435.87,2000.0};
		String [] apellido = {"FERNANDEZ","GIL","LOPEZ","RAMOS","SEVILLA","CASILLA","REY"};
		RandomAccessFile fr = null;
		StringBuilder buffer=null;
		int id ;
		double importe;
		if(!f.exists()){
			f.createNewFile();
		}
		fr = new RandomAccessFile(f,"rw");
		for (int i = 0; i < apellido.length; i++) {
			fr.writeInt(i+1);
			buffer = new StringBuilder(apellido[i]);
			buffer.setLength(10);
			fr.writeChars(buffer.toString());
			fr.writeInt(dept[i]);
			fr.writeDouble(salario[i]);
		}
		
		fr.close();
	}
	public static void sumarSalario(File f,int id, double importe) throws IOException {
		RandomAccessFile fr = null;
		int dept;
		double salario = 0;
		char [] apellido = new char[10];
		String apellidos;
		char aux;
		int posicion =(id-1)*36;
		try {
			fr = new RandomAccessFile(f,"rw");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fr.seek(posicion);
		id = fr.readInt();
		fr.skipBytes(20);
		dept = fr.readInt();
		salario = fr.readDouble();
		double salarioActualizado =salario+importe;
		System.out.format("ID: "+id+ "Salario antiguo:"+salario+" El salario nuevo es:"+salarioActualizado);


	}
}