package Actividad30;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Actividad30 {
	public static void main(String[] args) {
		try {
			FileOutputStream fo = new FileOutputStream("materiales.txt");
			String[] materiales= {"tijeras","colador","colador","batidora","alicates","batidora","alicates","cafetera","embudo","tetera","embudo","alicates","destornillador"};
			int [] cantidades = {7,1,4,3,5,2,10,1,2,1,3,2,6};
			for (int i = 0; i < cantidades.length; i++) {
				try {
					byte material[] = new byte[15];
					System.arraycopy(materiales[i].getBytes(), 0, material, 0, materiales[i].getBytes().length);
					fo.write(material, 0, material.length);
					String cantidad = String.valueOf(cantidades[i]);
					fo.write(cantidad.getBytes(), 0, cantidad.getBytes().length);
					fo.write(String.valueOf("\n").getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
