package matrices;

import utiles.Menu;
import utiles.Teclado;

/**
 * Lee este documento. Espero te ayude al diseño de la clase Matriz. Ya que
 * hemos dado el método toString(), elimina mostrar() del diseño. Entrega la
 * clase TestMatriz que cree un menú para utilizar la clase Matriz Al final hay
 * unas cuantas preguntas a las que responder. Entrégalas en formato pdf.
 * 
 * @author Antonio Luque Bravo
 * @version 1.0
 * 
 */
public class TestMatriz {
	static Menu menuMatrices = new Menu("Matrices", new String[] {
			"Crear Matriz", "Trasponer Matriz", "Sumar Matrices",
			"Restar Matrices", "Multiplicar Matrices", "Mostrar Matrices",
			"Salir" });
	static Menu menuElegirMatriz = new Menu("Elige la matriz.", new String[] {
			"Matriz 1.", "Matriz 2." });

	static Menu menuCrearMatriz = new Menu(
			"Elige el modo de creacion de la matriz", new String[] {
					"Inicializarla con un maximo y un minimo dado.",
					"Inicializarla con valores a cero." });
	static Matriz matriz1;
	static Matriz matriz2;

	public static void main(String[] args) {
		do {
			switch (menuMatrices.gestionar()) {
			case 1:// Crear Matrices
				crearMatrices();
				break;
			case 2:// Trasponer
				trasponerMatrices();
				break;
			case 3:// Sumar Matrices
				sumarMatrices();
				break;
			case 4:// Restar Matrices
				restarMatrices();
				break;
			case 5:// Multiplicar Matrices
					// multiplicarMatrices();
				break;
			case 6:
				mostrarMatrices();
				break;
			default:// Salir
				System.out.println("Adiooooos");
				return;
			}
		} while (true);
	}

	private static void restarMatrices() {
		if (comprobarSiNull(matriz1) && comprobarSiNull(matriz2))
			matriz1.restar(matriz2);
	}

	private static void sumarMatrices() {
		Matriz suma;
		if (comprobarSiNull(matriz1) && comprobarSiNull(matriz2)) {
			suma = matriz1.sumar(matriz2);
			System.out.println("MATRIZ SUMA:\n" + suma);
		}

	}

	private static void mostrarMatrices() {
		switch (menuElegirMatriz.gestionar()) {
		case 1:
			if (comprobarSiNull(matriz1))
				System.out.println(matriz1);
			break;
		case 2:
			if (comprobarSiNull(matriz2))
				System.out.println(matriz2);
			break;
		}
	}

	private static boolean comprobarSiNull(Matriz matriz) {
		if (matriz == null) {
			System.out.println("La matriz no ha sido inicializada..");
			return false;
		}
		return true;

	}

	private static void trasponerMatrices() {
		switch (menuElegirMatriz.gestionar()) {
		case 1:
			matriz1.trasponer();
			break;
		case 2:
			matriz2.trasponer();
		}
	}

	private static void crearMatrices() {
		switch (menuElegirMatriz.gestionar()) {
		case 1:
			switch (menuCrearMatriz.gestionar()) {
			case 1:
				matriz1 = crearMatrizMinMax();
				break;
			case 2:
				matriz1 = crearMatrizPorDefecto();
				break;
			}
			break;
		case 2:
			switch (menuCrearMatriz.gestionar()) {
			case 1:
				matriz2 = crearMatrizMinMax();
				break;
			case 2:
				matriz2 = crearMatrizPorDefecto();
				break;
			}
			break;
		}
	}

	private static Matriz crearMatrizPorDefecto() {
		return new Matriz(pedirFilas(), pedirColumnas());
	}

	private static Matriz crearMatrizMinMax() {
		int min = Teclado
				.leerEntero("Dame el m�nimo de los valores de la matriz.");
		int max = Teclado
				.leerEntero("Dame el m�ximo de los valores de la matriz.");
		Matriz matriz = new Matriz(pedirFilas(), pedirColumnas(), min, max);
		return matriz;
	}

	private static int pedirColumnas() {
		int columnas;
		do {
			columnas = Teclado.leerEntero("Dame las columnas de la matriz.");
		} while (columnas < 1);
		return columnas;
	}

	private static int pedirFilas() {
		int filas;
		do {
			filas = Teclado.leerEntero("Dame las filas de la matriz.");
		} while (filas < 1);
		return filas;
	}
}
