package Actividad8;

public class Alumno{
	public static void main(String[] args) {
		try {
			Alumno a1 = new Alumno("Ángel",-1,3.3);
		}
		catch(EdadNoValidaException exc) {
			exc.mostrarExcepcion();
		}
	}
	private String nombre;
	private int edad;
	private double nota;
	public Alumno(String nombre, int edad, double nota) throws EdadNoValidaException {
			this.nombre = nombre;
			this.edad = edad;
			this.nota = nota;
			if(edad<0) {
				throw new EdadNoValidaException(edad);
			}
	}
}

