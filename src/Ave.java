import java.util.Random;

/**
 * 
 */

/**
 * @author Carlos Garcia Silva
 *
 */
public class Ave {
	// ==============================================================================
	// VARIABLES
	// ==============================================================================

	public Vector X; // Posicion actual de la particula
	public Vector pBest; // Posicion de la mejor particula encontrada
	public Vector V; // Gradiente del movimiento de la particula

	public double x_fitness; // Solucion de la posicion actual
	public double p_fitness; // Solucion de la mejor posicion

	private Random aleatorio;

	// ==============================================================================
	// CONSTRUCTORES
	// ==============================================================================

	public Ave() {
		this(new Vector(0, 0), new Vector(0, 0), new Random(2435464));
	}

	public Ave(Vector posicion, Vector velocidad, Random a) {
		this.X = posicion;
		this.pBest = posicion;
		this.V = velocidad;
		this.p_fitness = PSO_Rosen.fitness(pBest);
		this.aleatorio = a;
	}

	// ==============================================================================
	// METODOS PUBLICOS
	// ==============================================================================

	public void actualizarValores(double w, double o1, double o2, Vector pBest,
			Vector g, double maxV) {

//			// Inercia
//			double ineX = w * this.V.getX();
//			double ineY = w * this.V.getY();
		//
//			// Cognitivo
//			double r1 = aleatorio.nextDouble();
//			double cogX = o1 * r1 * (pBest.getX() - this.X.getX());
//			double cogY = o1 * r1 * (pBest.getY() - this.X.getY());
		//
//			// Social
//			double r2 = aleatorio.nextDouble();
//			double socX = o2 * r2 * (g.getX() - this.X.getX());
//			double socY = o2 * r2 * (g.getY() - this.X.getY());
		//
//			double velX = ineX + cogX + socX;
//			double velY = ineY + cogY + socY;

		double velX = (w * this.V.getX())
				+ (o1 * aleatorio.nextDouble() * (pBest.getX() - this.X.getX()))
				+ (o2 * aleatorio.nextDouble() * (g.getX() - this.X.getX()));

		double velY = (w * this.V.getY())
				+ (o1 * aleatorio.nextDouble() * (pBest.getY() - this.X.getY()))
				+ (o2 * aleatorio.nextDouble() * (g.getY() - this.X.getY()));

		// Comprobamos que no sobre pasa la velocidad maxima
		if (velX > maxV) {
			velX = maxV;
		}
		if (velY > maxV) {
			velY = maxV;
		}
		if (velX < -maxV) {
			velX = -maxV;
		}
		if (velY < -maxV) {
			velY = -maxV;
		}

		// Actualizamos la velocidad
		this.V.set(velX, velY);

		// Actualizamos la posicion
		this.X.traslada(velX, velY);

		// Comprobamos que la posicion no se salga de los limites
		// si se sale lo ajustamos a los bordes
		if (this.X.getX() > Rosenbrock.MAX_X) {
			this.X.setX(Rosenbrock.MAX_X);
		}
		if (this.X.getX() < Rosenbrock.MIN_X) {
			this.X.setX(Rosenbrock.MIN_X);
		}
		if (this.X.getY() > Rosenbrock.MAX_Y) {
			this.X.setY(Rosenbrock.MAX_Y);
		}
		if (this.X.getY() < Rosenbrock.MIN_Y) {
			this.X.setY(Rosenbrock.MIN_Y);
		}
	}
}
