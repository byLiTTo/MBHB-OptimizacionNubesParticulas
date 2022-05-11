/**
 * 
 */

/**
 * @author Carlos Garcia Silva
 *
 */
public class Rosenbrock {

	// ==============================================================================
	// VARIABLES
	// ==============================================================================

	public static final double MIN_X = -2.0;
	public static final double MAX_X = 3.0;

	public static final double MIN_Y = -2.0;
	public static final double MAX_Y = 3.0;

	// ==============================================================================
	// CONSTRUCTORES
	// ==============================================================================

	public Rosenbrock() {
	}

	// ==============================================================================
	// METODOS PUBLICOS
	// ==============================================================================

	public static double aplica(Vector posicion) {
		return Math.pow(1 - posicion.getX(), 2)
				+ 100 * Math.pow(posicion.getY() - Math.pow(posicion.getX(), 2), 2);
	}
}
