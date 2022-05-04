package EjercicioEstiloExamen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

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
	public static void mostrar() {
		for (String key: productos.keySet()){  
			System.out.println(key+ " = " + productos.get(key));
		} 
	}
	public static void añadirArticulo(String producto,int cantidad) {
		BufferedWriter br = null;
		try {
			 br = new BufferedWriter(new FileWriter("productos.txt",true));
			br.write(String.valueOf(producto));
			br.write(" ");
			br.write(String.valueOf(cantidad));
			br.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(br!=null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		productos.put(producto, cantidad);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		while(!salir) {
			System.out.println("1.Comprar productos"+"\n"+
					"2.Añadir Productos"+"\n"+
					"3.Mostrar productos"+"\n"+
					"4.Eliminar productos"+"\n"+
					"5.Sacar ticket"+"\n"+
					"6.Salir");
			int opcion = sc.nextInt();
			switch(opcion) {
			case 1:
				try {
					comprar();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Escribe el producto que desea añadir");
				String producto = sc.next();
				System.out.println("Indique la cantidad del producto a añadir");
				int cantidad = sc.nextInt();
				añadirArticulo(producto,cantidad);
				break;
			case 3:
				mostrar();
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				sc.close();
				salir = true;
				break;
			}
		}
	}
}
