import java.util.ArrayList;
import java.util.Random;

/**
 * 
 */

/**
 * @author Carlos Garcia Silva
 *
 */
public class PSO_Rastri {
	// ==============================================================================
	// VARIABLES
	// ==============================================================================

	private double w = 0.729;
	private double O1 = 1.49445;
	private double O2 = 1.49445;

	private int numAves = 10;
	private double maxVelocidad;
	private ArrayList<Ave> bandada;
	private Random aleatorio;

	private Vector gBest;
	private double gBestFitness;

	private int numEvaluaciones;

	private int MaximoIteraciones = 100000000;
	private double criterioError = 0.001;
	private int minutos = 1;

	// ==============================================================================
	// CONSTRUCTOR
	// ==============================================================================

	public PSO_Rastri() {
		this(10, 0.01, 243546);
	}

	public PSO_Rastri(int semilla) {
		this(10, 0.01, semilla);
	}

	public PSO_Rastri(int aves, double maxV, int semilla) {
		this.numAves = aves;
		this.maxVelocidad = maxV;
		this.bandada = new ArrayList<Ave>();
		this.aleatorio = new Random(semilla);
		this.gBest = null;
		this.gBestFitness = Double.NEGATIVE_INFINITY;
	}

	public static double fitness(Vector x) {
		return 1 / (Rastrigin.aplica(x) + 1);
	}

	// ==============================================================================
	// SETs y GETs
	// ==============================================================================

	public Vector getVectorSolucion() {
		return this.gBest;
	}

	public double getSolucion() {
		return this.gBestFitness;
	}

	public int getEvaluaciones() {
		int aux = this.numEvaluaciones;
		this.numEvaluaciones = 0;
		return aux;
	}

	// ==============================================================================
	// METODOS PUBLICOS
	// ==============================================================================

	public void EjecutaLocal() {
		Inicializa();
		this.numEvaluaciones = 0;

		long limite = System.currentTimeMillis() + minutos * 60000;
		do {
			this.numEvaluaciones++;
			for (Ave ave : this.bandada) {
				ave.x_fitness = fitness(ave.X);
				if (ave.x_fitness > ave.p_fitness) {
					ave.pBest = ave.X;
					ave.p_fitness = ave.x_fitness;
				}
			}

			ActualizaValoresLocal();

			for (Ave ave : this.bandada) {
				if (ave.p_fitness > this.gBestFitness) {
					this.gBestFitness = ave.p_fitness;
					this.gBest = ave.pBest;
				}
			}
		} while (error() > criterioError && (System.currentTimeMillis() < limite));
	}

	public void EjecutaGlobal() {
		this.numEvaluaciones = 0;
		Inicializa();
		long limite = System.currentTimeMillis() + minutos * 60000;
		do {
			this.numEvaluaciones++;
			for (Ave ave : this.bandada) {
				ave.x_fitness = fitness(ave.X);
				if (ave.x_fitness > ave.p_fitness) {
					ave.pBest = ave.X;
					ave.p_fitness = ave.x_fitness;
				}
				if (ave.p_fitness > gBestFitness) {
					gBest = ave.pBest;
					gBestFitness = ave.p_fitness;
				}
			}

			ActualizaValoresGlobal();

		} while (error() > criterioError && (System.currentTimeMillis() < limite));
	}

	public void resetea(int aves, double maxV, int semilla) {
		this.numAves = aves;
		this.maxVelocidad = maxV;
		this.bandada = new ArrayList<Ave>();
		this.aleatorio = new Random(semilla);
		this.gBest = null;
		this.gBestFitness = Double.NEGATIVE_INFINITY;
	}

	// ==============================================================================
	// METODOS PRIVADOS
	// ==============================================================================

	// Iniciamos en una posicion random
	private void Inicializa() {
		for (int i = 0; i < numAves; i++) {
			Ave ave = new Ave(posicionAleatoria(), velocidadAleatoria(), aleatorio);
			this.bandada.add(ave);
		}
	}

	private Vector posicionAleatoria() {
		double rX = (this.aleatorio.nextDouble()
				* (Rosenbrock.MAX_X - Rosenbrock.MIN_X)) + Rosenbrock.MIN_X;
		double rY = (this.aleatorio.nextDouble()
				* (Rosenbrock.MAX_Y - Rosenbrock.MIN_Y)) + Rosenbrock.MIN_Y;
		return new Vector(rX, rY);
	}

	private Vector velocidadAleatoria() {
		double rX = (this.aleatorio.nextDouble() * (this.maxVelocidad * 2))
				- this.maxVelocidad;
		double rY = (this.aleatorio.nextDouble() * (this.maxVelocidad * 2))
				- this.maxVelocidad;
		return new Vector(rX, rY);
	}

	private void ActualizaAvesLocales() {
		for (Ave ave : this.bandada) {
			ave.x_fitness = fitness(ave.X);
			if (ave.x_fitness > ave.p_fitness) {
				ave.pBest = ave.X;
				ave.p_fitness = ave.x_fitness;
			}
		}

	}

	private void ActualizaAvesGlobales() {
		for (Ave ave : this.bandada) {
			if (ave.p_fitness > this.gBestFitness) {
				this.gBestFitness = ave.p_fitness;
				this.gBest = ave.pBest;
			}
		}
	}

	private void ActualizaValoresLocal() {
		for (int i = 0; i < this.numAves; i++) {
			Ave ave = bandada.get(i);
			Vector iBest;
			if (i == 0) {
				if (bandada.get(i + 1).p_fitness > bandada
						.get(numAves - 1).p_fitness) {
					if (bandada.get(i + 1).p_fitness > ave.p_fitness) {
						iBest = bandada.get(i + 1).pBest;
					} else {
						iBest = ave.pBest;
					}
				} else {
					if (bandada.get(numAves - 1).p_fitness > ave.p_fitness) {
						iBest = bandada.get(numAves - 1).pBest;
					} else {
						iBest = ave.pBest;
					}

				}
			} else if (i == this.numAves - 1) {
				if (bandada.get(0).p_fitness > bandada.get(i - 1).p_fitness) {
					if (bandada.get(0).p_fitness > ave.p_fitness) {
						iBest = bandada.get(0).pBest;
					} else {
						iBest = ave.pBest;
					}
				} else {
					if (bandada.get(i - 1).p_fitness > ave.p_fitness) {
						iBest = bandada.get(i - 1).pBest;
					} else {
						iBest = ave.pBest;
					}
				}
			} else {
				if (bandada.get(i - 1).p_fitness > bandada.get(i + 1).p_fitness) {
					if (bandada.get(i - 1).p_fitness > ave.p_fitness) {
						iBest = bandada.get(i - 1).pBest;
					} else {
						iBest = ave.pBest;
					}
				} else {
					if (bandada.get(i + 1).p_fitness > ave.p_fitness) {
						iBest = bandada.get(i + 1).pBest;
					} else {
						iBest = ave.pBest;
					}
				}
			}
			ave.actualizarValores(w, O2, O1, ave.pBest, iBest, maxVelocidad);
		}
	}

	private void ActualizaValoresGlobal() {
		for (Ave ave : bandada) {
			ave.actualizarValores(w, O2, O1, ave.pBest, gBest, maxVelocidad);
		}
	}

	private double error(Vector position) {
		double x = position.getX();
		double y = position.getY();

		// Sabemos que el minimo global para la funcion Rastrigin en el (0,0).
		return Math.pow(10 - x, 2) + Math.pow(10 - y, 2);
	}

	public double error() {
		return error(this.gBest);
	}
}
