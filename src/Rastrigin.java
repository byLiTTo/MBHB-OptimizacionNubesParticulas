/**
 * 
 */

/**
 * @author Carlos Garcia Silva
 *
 */
public class Rastrigin {

	// ==============================================================================
	// VARIABLES
	// ==============================================================================

	public static final double MIN_X = -3.0;
	public static final double MAX_X = 3.0;

	public static final double MIN_Y = -3.0;
	public static final double MAX_Y = 3.0;

	// ==============================================================================
	// CONSTRUCTORES
	// ==============================================================================

	public Rastrigin() {
	}

	// ==============================================================================
	// METODOS PUBLICOS
	// ==============================================================================

	public static double aplica(Vector posicion) {
		double x = posicion.getX();
		double y = posicion.getY();
		return 10 * 2 + (x * x - 10 * Math.cos(2 * Math.PI * x))
				+ (y * y - 10 * Math.cos(2 * Math.PI * y));
	}
}
