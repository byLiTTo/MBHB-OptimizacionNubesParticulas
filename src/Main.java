import java.util.Locale;

/**
 * 
 */

/**
 * @author Carlos Garcia Silva
 *
 */
public class Main {
	public static void main(String[] args) {
		int[] semillas = {
				//840612802,
				//1314640371,
				1227221349, 
				342269428, 
				1603221416,
				796392706,
				//2116959593,
				//2020525633,
				532496463,
				//1841414609,
		};
		EjecutaRosenbrock(semillas);
		EjecutaRastrigin(semillas);
	}

	/**
	 * 
	 */
	private static void EjecutaRastrigin(int[] semillas) {
		String[] nombres = { "Local", "Global", };
		int ejecuciones = semillas.length;

		double[] costes = new double[ejecuciones];
		int[] evaluaciones = new int[ejecuciones];
		for (int i = 0; i < nombres.length; i++) {

			System.out.println(
					"Resultados de ejecutar la funcion de Rastrigin con PSO "
							+ nombres[i]);

			PSO_Rastri pso;

			System.out.println("\t\tCostes" + "\tEvaluaciones" + "\tTiempo");

			long sumatorioCostes = 0;
			long sumatorioEvaluaciones = 0;

			for (int j = 0; j < ejecuciones; j++) {
				pso = new PSO_Rastri(semillas[j]);
				long tiempoINI;
				long tiempoFIN;

				if (i == 0) {
					tiempoINI = System.currentTimeMillis();
					pso.EjecutaLocal();
					tiempoFIN = System.currentTimeMillis();
				} else {
					tiempoINI = System.currentTimeMillis();
					pso.EjecutaGlobal();
					tiempoFIN = System.currentTimeMillis();

				}

				costes[j] = pso.getSolucion();
				evaluaciones[j] = pso.getEvaluaciones();

				System.out.println("Ejecucion " + (j + 1) + ":\t" + costes[j] + "\t"
						+ evaluaciones[j] + "\t     " + "\t"
						+ (tiempoFIN - tiempoINI) + " ms\t("
						+ pso.getVectorSolucion().getX() + " "
						+ pso.getVectorSolucion().getY() + ")");

				sumatorioCostes += costes[j];
				sumatorioEvaluaciones += evaluaciones[j];
				pso.resetea(10, 0.01, semillas[j]);
			}

			double mediaCostes = (sumatorioCostes) / ejecuciones;
			double mediaEvaluaciones = (sumatorioEvaluaciones) / ejecuciones;

			System.out.printf(Locale.US, "\nMedia costes: %.2f\n", mediaCostes);
			System.out.printf(Locale.US, "\nMedia evaluaciones: %.2f\n",
					mediaEvaluaciones);

			sumatorioCostes = 0;
			sumatorioEvaluaciones = 0;

			for (int j = 0; j < ejecuciones; j++) {
				sumatorioCostes += Math.pow(mediaCostes - costes[j], 2);
				sumatorioEvaluaciones += Math
						.pow(mediaEvaluaciones - evaluaciones[j], 2);
			}

			double desviacionCostes = Math.sqrt(sumatorioCostes / ejecuciones);
			double desviacionEvaluaciones = Math
					.sqrt(sumatorioEvaluaciones / ejecuciones);

			System.out.printf(Locale.US, "\nDesviacion costes: %.2f\n",
					desviacionCostes);
			System.out.printf(Locale.US, "\nDesviacion evaluaciones: %.2f\n",
					desviacionEvaluaciones);

			System.out.println(
					"\n---------------------------------------------------");
		}
		
	}

	/**
	 * 
	 */
	private static void EjecutaRosenbrock(int[] semillas) {
		String[] nombres = { "Local", "Global", };
		int ejecuciones = semillas.length;

		double[] costes = new double[ejecuciones];
		int[] evaluaciones = new int[ejecuciones];
		for (int i = 0; i < nombres.length; i++) {

			System.out.println(
					"Resultados de ejecutar la funcion de Rosenbrock con PSO "
							+ nombres[i]);

			PSO_Rosen pso;

			System.out.println("\t\tCostes" + "\tEvaluaciones" + "\tTiempo");

			long sumatorioCostes = 0;
			long sumatorioEvaluaciones = 0;

			for (int j = 0; j < ejecuciones; j++) {
				pso = new PSO_Rosen(semillas[j]);
				long tiempoINI;
				long tiempoFIN;

				if (i == 0) {
					tiempoINI = System.currentTimeMillis();
					pso.EjecutaLocal();
					tiempoFIN = System.currentTimeMillis();
				} else {
					tiempoINI = System.currentTimeMillis();
					pso.EjecutaGlobal();
					tiempoFIN = System.currentTimeMillis();

				}

				costes[j] = pso.getSolucion();
				evaluaciones[j] = pso.getEvaluaciones();

				System.out.println("Ejecucion " + (j + 1) + ":\t" + costes[j] + "\t"
						+ evaluaciones[j] + "\t     " + "\t"
						+ (tiempoFIN - tiempoINI) + " ms\t("
						+ pso.getVectorSolucion().getX() + " "
						+ pso.getVectorSolucion().getY() + ")");

				sumatorioCostes += costes[j];
				sumatorioEvaluaciones += evaluaciones[j];
				pso.resetea(10, 0.01, semillas[j]);
			}

			double mediaCostes = (sumatorioCostes) / ejecuciones;
			double mediaEvaluaciones = (sumatorioEvaluaciones) / ejecuciones;

			System.out.printf(Locale.US, "\nMedia costes: %.2f\n", mediaCostes);
			System.out.printf(Locale.US, "\nMedia evaluaciones: %.2f\n",
					mediaEvaluaciones);

			sumatorioCostes = 0;
			sumatorioEvaluaciones = 0;

			for (int j = 0; j < ejecuciones; j++) {
				sumatorioCostes += Math.pow(mediaCostes - costes[j], 2);
				sumatorioEvaluaciones += Math
						.pow(mediaEvaluaciones - evaluaciones[j], 2);
			}

			double desviacionCostes = Math.sqrt(sumatorioCostes / ejecuciones);
			double desviacionEvaluaciones = Math
					.sqrt(sumatorioEvaluaciones / ejecuciones);

			System.out.printf(Locale.US, "\nDesviacion costes: %.2f\n",
					desviacionCostes);
			System.out.printf(Locale.US, "\nDesviacion evaluaciones: %.2f\n",
					desviacionEvaluaciones);

			System.out.println(
					"\n---------------------------------------------------");
		}
		
	}
}
