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
public class Matriz {
	private int filas;
	private int columnas;
	private int[][] matriz;

	Matriz(int filas, int columnas) {
		setFilas(filas);
		setColumnas(columnas);
		setMatriz(new int[getFilas()][getColumnas()]);
	}

	Matriz(int filas, int columnas, int min, int max) {
		if (min > max) {
			System.out.println("El minimo no debe exceder al maximo.");
			min = 0;
			max = 1;
		}
		setFilas(filas);
		setColumnas(columnas);
		setMatriz(new int[getFilas()][getColumnas()]);
		for (int i = 0; i < getFilas(); i++) {
			for (int j = 0; j < getColumnas(); j++) {
				matriz[i][j] = (int) (Math.random() * (max - min + 1) + min);
			}
		}
	}

	private int getFilas() {
		return filas;
	}

	private void setFilas(int filas) {
		this.filas = filas;
	}

	private int getColumnas() {
		return columnas;
	}

	private void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	private int[][] getMatriz() {
		return matriz;
	}

	private void setMatriz(int[][] matriz) {
		this.matriz = matriz;
	}

	Matriz sumar(Matriz s2) {
		if (!mismaDimension(s2)) {
			System.out
					.println("No se puede sumar matrices con diferente dimension.");
			return null;
		}
		Matriz suma = new Matriz(getFilas(), getColumnas());
		for (int i = 0; i < getFilas(); i++) {
			for (int j = 0; j < getColumnas(); j++) {
				suma.getMatriz()[i][j] = getMatriz()[i][j]
						+ s2.getMatriz()[i][j];
			}
		}
		return suma;
	}

	Matriz restar(Matriz r2) {
		if (!mismaDimension(r2)) {
			System.out
					.println("No se puede restar matrices con diferente dimension.");
			return null;
		}
		Matriz resta = new Matriz(getFilas(), getColumnas());
		for (int i = 0; i < getFilas(); i++) {
			for (int j = 0; j < getColumnas(); j++) {
				resta.getMatriz()[i][j] = getMatriz()[i][j]
						- r2.getMatriz()[i][j];
			}
		}
		return resta;
	}

	void trasponer() {
		Matriz traspuesta = new Matriz(getColumnas(), getFilas());
		for (int j = 0; j < getColumnas(); j++) {
			for (int i = 0; i < getFilas(); i++) {
				traspuesta.getMatriz()[j][i] = getMatriz()[i][j];
			}
		}
		matriz = traspuesta.getMatriz();
	}

	Matriz multiplicar(Matriz factor1) {
		if (!mismasColumnasFilas(factor1)) {
			System.out
					.println("Las dimensiones de las filas de la primera matriz tienen que coincidir con las columnas de la segunda matriz..");
			return null;
		}
		Matriz producto = new Matriz(matriz.length,
				factor1.getMatriz()[0].length);
		for (int i = 0; i < producto.getMatriz().length; i++) {
			for (int j = 0; j < producto.getMatriz()[i].length; j++) {
				for (int k = 0; k < matriz[0].length; k++) {
					producto.getMatriz()[i][j] += matriz[i][k]
							* factor1.getMatriz()[k][j];
				}
			}
		}
		return producto;
	}

	private boolean mismasColumnasFilas(Matriz factor1) {
		if (matriz.length == factor1.getMatriz()[0].length)
			return true;
		return false;
	}

	private boolean mismaDimension(Matriz matriz2) {
		if (getFilas() == matriz2.getFilas()
				&& getColumnas() == matriz2.getColumnas())
			return true;
		return false;
	}

	@Override
	public String toString() {
		String msj = "";
		for (int[] filas : getMatriz()) {
			for (int i : filas) {
				msj += i + "\t";
			}
			msj += "\n";
		}
		return msj;
	}

}
