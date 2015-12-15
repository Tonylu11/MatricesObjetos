package matrices;

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
	public static void main(String[] args) {
		Matriz matriz = new Matriz(2, 3, 0, 2);
		System.out.println("Matriz: \n" + matriz);// Matriz
		Matriz matriz1 = new Matriz(2, 3, 0, 1);
		System.out.println("Matriz 1: \n" + matriz1); // Matriz 1
		Matriz matrizSuma = matriz.sumar(matriz1);// Suma
		System.out.println("Matriz sumada con Matriz 1: \n" + matrizSuma);
		Matriz matrizResta = matriz.restar(matriz1);// Resta
		System.out.println("Matriz restada con Matriz 1: \n" + matrizResta);
		matriz1.trasponer();// Traspuesta Matriz 1
		System.out.println("Matriz 1 Traspuesta: \n" + matriz1);
		Matriz multiplicacion = matriz.multiplicar(matriz1);// Multiplicación
		System.out.println("Multiplicaci�n Matriz con Matriz 1 Traspuesta: \n"
				+ multiplicacion);
	}
}
