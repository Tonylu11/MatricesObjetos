package utiles;

public class Menu {
	String titulo = null;
	String[] opciones = null;
	int numOpciones = 0;

	public Menu(String titulo, String[] opciones) {
		this.titulo = titulo;
		this.opciones = opciones;
		this.numOpciones = this.opciones.length;
	}

	public int gestionar() {
		mostrarMenu();
		return pedirOpcion();

	}

	private int pedirOpcion() {
		int opcion = 0;
		do {
			opcion = Teclado.leerEntero();
		} while (opcion < 1 || opcion > numOpciones);
		return opcion;
	}

	private void mostrarMenu() {
		int contador = 1;
		System.out.println("-- " + titulo);
		for (String opcion : opciones) {
			System.out.println("(" + (contador++) + ") " + opcion);
		}
	}
}
