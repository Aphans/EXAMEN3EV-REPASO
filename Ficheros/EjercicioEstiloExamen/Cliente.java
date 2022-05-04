package EjercicioEstiloExamen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Cliente {
	private String dni;
	static HashMap <String,Integer> productos = new HashMap<String,Integer>();
	public static void comprar() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("productos.txt"));
		String linea;
		linea = br.readLine();
		while(linea!=null) {
			String datos[]=linea.split(" ");
			String producto = String.valueOf(datos[0]);
			Integer cantidad = Integer.valueOf(datos[1]);
			Integer cantidadTotal = null;
			if(!productos.containsKey(producto)) {
				Integer cantidadRepetida = Integer.valueOf(datos[1]);
				cantidadTotal= cantidad+cantidadRepetida;
			}
			else {
				Integer cantidadRepetida = Integer.valueOf(datos[1]);
				cantidadTotal= cantidad+cantidadRepetida;
			}
			productos.put(producto, cantidadTotal);
			linea = br.readLine();
		}
	}
	public void mostrar() {
		for (String key: productos.keySet()){  
			System.out.println(key+ " = " + productos.get(key));
		} 

	}
	public static void main(String[] args) {
		try {
			comprar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
