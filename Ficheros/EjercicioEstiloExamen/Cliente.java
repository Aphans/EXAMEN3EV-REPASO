package EjercicioEstiloExamen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class Cliente {
	private String dni;
	static HashMap <String,Integer> productos = new HashMap<String,Integer>();
	public static void comprar() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("productos.txt"));
		String linea;
		while((linea = br.readLine()) !=null) {
			String datos[]=linea.split(" ");//Parte los datos en posiciones, una a la izquierda del espacio y otra a la derecha
			String producto = String.valueOf(datos[0]); //Guarda los datos de la izquierda que es un String
			Integer cantidad = Integer.valueOf(datos[1]);//Guarda los datos de la derecha que es un int;
			if(productos.containsKey(producto)) {
				Integer cantidadRepetida = productos.get(producto);
				cantidad+= cantidad+cantidadRepetida;
			}
			productos.put(producto, Integer.valueOf(cantidad));
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
	public static void sacarTicket() {
		File file =  new File("ticket.txt");
		File file2 = new File("precios.txt");
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file));
				for (String key: productos.keySet()){  
				bw.write(key);
				bw.write(" ");
				bw.write(String.valueOf(productos.get(key)));
				bw.newLine();
			}
			
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			BufferedReader br2 = new BufferedReader(new FileReader(file2));
			String linea;
			while((linea=br2.readLine())!=null) {
				String[] datos=linea.split(" ");
				double precio = Double.valueOf(datos[1]);
				int cantidad=0;
				for (String key : productos.keySet()) {
					if(key.equals(datos[0])) { //Así 
						 cantidad = productos.get(key);
						 System.out.println(cantidad);
							double precioTotal=+precio;
							bw.newLine();
							 DecimalFormat df = new DecimalFormat("#.00");
							bw.write("Precio Total:"+String.valueOf(df.format(precioTotal*cantidad)));
					return;
					}
				}
			
				
			
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(bw!=null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	public static void eliminarProducto(String producto,int cantidad) {
		Integer cantidades = productos.get(producto);
		if(!productos.containsKey(producto)) {
			System.out.println("El producto no existe en su lista");
		}
		else if(cantidades < cantidad) {
			System.out.println("No hay cantidad suficiente");
		}
		else if(cantidad>cantidad) {
			Integer CantidadTotal = cantidades - cantidad;
			productos.put(producto,CantidadTotal);
		}
		else if(productos.containsKey(producto)  && cantidades>cantidad) {
			productos.remove(producto);
		}
		else{
			productos.remove(producto);
		}
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
				System.out.println("¿Desea eliminar un producto?S/N");
				String eliminar = sc.next();
				eliminar.toUpperCase();
				if(eliminar.equals("S")){
					System.out.println("Indique el producto a eliminar");
					String productoEliminar = sc.next();
					System.out.println("Indique la cantidad del producto a elimnar");
					int cantidadEliminar = sc.nextInt();
					eliminarProducto(productoEliminar,cantidadEliminar);
				}
				else {
					if(eliminar.equals("N")) {
						opcion = sc.nextInt();
						return;
					}
				}
				break;
			case 5:
				sacarTicket();
				break;
			case 6:
				sc.close();
				salir = true;
				break;
			}
		}
	}
}
