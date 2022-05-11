/**
 * 
 */

/**
 * @author Carlos Garcia Silva
 *
 */
public class Vector {
	// ==============================================================================
	// VARIABLE
	// ==============================================================================

	private double x;
	private double y;

	// ==============================================================================
	// CONSTRUCTOR
	// ==============================================================================

	public Vector() {
		this(0, 0);
	}

	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}

	// ==============================================================================
	// SETs y GETs
	// ==============================================================================

	public void set(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	// ==============================================================================
	// METODO PUBLICO
	// ==============================================================================

	public void traslada(double deltaX, double deltaY) {
		this.x = x + deltaX;
		this.y = y + deltaY;
	}
}
