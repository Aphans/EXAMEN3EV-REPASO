package Actividad14;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Actividad14 {
	public static void main(String[] args) throws IOException {
		Random numero = new Random();
		int randomNumero = numero.nextInt(800) + 500;
		int contadorEscritos=0,contadorTotal=0;
		
		File file = new File("aleatorios.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		FileWriter filerw = new FileWriter(file);
		BufferedWriter filebw = new BufferedWriter(filerw);
		boolean [] number = new boolean[1000 + 1];
		while(randomNumero>contadorTotal) {
			Random r = new Random();
			int randomInt = r.nextInt(1000) + 1;
			
			contadorTotal++;
			
			if (number[randomInt]) continue;
			
			try {
				number[randomInt] = true;
				
				contadorEscritos++;
				
				filebw.write(String.valueOf(randomInt));
				filebw.newLine();
			}

			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		filebw.close();
		System.out.println("Numeros en total:"+contadorTotal);
		System.out.println("Numeros escritos:"+contadorEscritos);
	}
}
