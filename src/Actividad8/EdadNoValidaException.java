package Actividad8;

public class EdadNoValidaException extends Exception {
	int edadErronea;
	public EdadNoValidaException(int edadErronea) {
		this.edadErronea = edadErronea;
	}
	
	public void mostrarExcepcion() {
		System.out.println("La edad:"+this.edadErronea+"  "+"no es correcta");
	}

}
