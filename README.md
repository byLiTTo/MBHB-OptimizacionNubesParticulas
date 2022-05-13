# Algoritmos de optimización basados en nube de partículas
:computer: Modelos Bioinspirados y Heurísticas de Búsqueda.  
:school: Universidad de Huelva.  
:books: Curso 2020/2021.

___

# Introducción
El objetivo de esta actividad académicamente dirigida, es estudiar el funcionamiento de los algoritmos de optimización basados en nube de partículas (PSO). Vamos a implementar las dos versiones presentes en la teoría, el PSO local y el global, que más adelante explicaremos más detenidamente.

Para poder poner en marcha el funcionamiento de estos algoritmos se nos ha asignado como objetivo encontrar el punto mínimo global de dos funciones matemáticas, que son:
- La función de Rosenbrock, cuyo mínimo se encuentra en el punto ( 1, 1 ).
- La función de Rastrigin, cuyo mínimo se encuentra en el punto ( 0, 0 ).

___

# Algoritmos
Este tipo de algoritmos simula el comportamiento de las bandadas de aves. Las aves cuando van a alimentarse o saben dónde está la comida pero sí saben la distancia hasta llegar a ella, la estrategia consisten en seguir al ave que se encuentra más cerca de la comida.

Es por ello que hemos creado una clase Ave que funciona como agente ya que nuestro escenario se trata de un sistema multiagente. Las aves se mueven por el espacio de búsqueda y guardan la mejor solución que han encontrado. En función de cómo se mueven o en base a qué solución convergen, podemos encontrarnos dos tipos:

# PSO Búsqueda Local
Donde el agente a la hora de calcular su nueva posición lo hace en función de la mejor posición que conoce suya y la mejor solución de su entorno, que en este caso hemos elegido que sean los 2 vecinos más próximos.

Los resultados son:

<table style="width:100%">
    <tr>
        <th colspan='1'> </th>
        <th colspan='4'> Algoritmo PSO Local</th>
    </tr>
    <tr>
        <th></th>
        <th colspan='2'>Rosenbrock</th>
        <th colspan='2'>Rastrigin</th>
    </tr>
    <tr>
        <th></th>
        <th>Coste</th>
        <th>Evaluaciones</th>
        <th>Coste</th>
        <th>Evaluaciones</th>
    </tr>
    <tr>
        <th>Ejecución 1</th>
        <th>0.99102</th>
        <th>40591666</th>
        <th>0.99892</th>
        <th>27243802</th>
    </tr>
    <tr>
        <th>Ejecución 2</th>
        <th>0.89701</th>
        <th>40660031</th>
        <th>0.14744</th>
        <th>27336128</th>
    </tr>
    <tr>
        <th>Ejecución 3</th>
        <th>0.97019</th>
        <th>40537985</th>
        <th>0.50104</th>
        <th>27517422</th>
    </tr>
    <tr>
        <th>Ejecución 4</th>
        <th>0.96705</th>
        <th>40018877</th>
        <th>0.99938</th>
        <th>27117650</th>
    </tr>
    <tr>
        <th>Ejecución 5</th>
        <th>0.99680</th>
        <th>39940843</th>
        <th>0.99986</th>
        <th>27056116</th>
    </tr>
    <tr>
        <th>Media</th>
        <th>0.964414</th>
        <th>40349880.00</th>
        <th>0.729328</th>
        <th>27254223.00</th>
    </tr>
    <tr>
        <th>Desviación</th>
        <th>0.03981313</th>
        <th>305585.29</th>
        <th>0.39035386</th>
        <th>163700.52</th>
    </tr>
</table>

# PSO Búsqueda Global
A diferencia del anterior algoritmo, se busca el mejor global y cada particula modifica su posición en función de el mejor encontrado por si mismo y el mejor de toda la bandada.

Los resultados son:

<table style="width:100%">
    <tr>
        <th colspan='1'> </th>
        <th colspan='4'> Algoritmo PSO Global</th>
    </tr>
    <tr>
        <th></th>
        <th colspan='2'>Rosenbrock</th>
        <th colspan='2'>Rastrigin</th>
    </tr>
    <tr>
        <th></th>
        <th>Coste</th>
        <th>Nº Ev</th>
        <th>Coste</th>
        <th>Nº Ev</th>
    </tr>
    <tr>
        <th>Ejecución 1</th>
        <th>0.9910202847493185</th>
        <th>40591666</th>
        <th>0.5008537683720345</th>
        <th>27350473</th>
    </tr>
    <tr>
        <th>Ejecución 2</th>
        <th>0.8970173671660165</th>
        <th>40660031</th>
        <th>0.14744420388833226</th>
        <th>27144733</th>
    </tr>
    <tr>
        <th>Ejecución 3</th>
        <th>0.9701944560769704</th>
        <th>40537985</th>
        <th>0.8640877085956149</th>
        <th>27808097</th>
    </tr>
    <tr>
        <th>Ejecución 4</th>
        <th>0.9670589694763619</th>
        <th>40018877</th>
        <th>0.8616846214970276</th>
        <th>27192824</th>
    </tr>
    <tr>
        <th>Ejecución 5</th>
        <th>0.9968093804690624</th>
        <th>39940843</th>
        <th>0.49760517265569215</th>
        <th>27834458</th>
    </tr>
    <tr>
        <th>Media</th>
        <th>0.974798</th>
        <th>40349880.00</th>
        <th>0.574335095</th>
        <th>27466117.00</th>
    </tr>
    <tr>
        <th>Desviación</th>
        <th>0.03830717</th>
        <th>305585.29</th>
        <th>0.300020477</th>
        <th>297985.13</th>
    </tr>
</table>

___

# Comparación global de los algoritmos
<table style="width:100%">
    <tr>
        <th colspan='1'></th>
        <th colspan='4'>Rosenbrock</th>
    </tr>
    <tr>
        <th>Algoritmo</th>
        <th>Mejor</th>
        <th>Media</th>
        <th>Peor</th>
        <th>Desv.</th>
    </tr>
    <tr>
        <th>Óptima</th>
        <th>-</th>
        <th>1</th>
        <th>-</th>
        <th>-</th>
    </tr>
    <tr>
        <th>PSO Local</th>
        <th>0.99680</th>
        <th>0.964414</th>
        <th>0.89701</th>
        <th>0.03981313</th>
    </tr>
    <tr>
        <th>PSO Global</th>
        <th>0.99680</th>
        <th>0.97479</th>
        <th>0.89701</th>
        <th>0.03830717</th>
    </tr>
</table>

<table style="width:100%">
    <tr>
        <th colspan='1'></th>
        <th colspan='4'>Rastrigin</th>
    </tr>
    <tr>
        <th>Algoritmo</th>
        <th>Mejor</th>
        <th>Media</th>
        <th>Peor</th>
        <th>Desv.</th>
    </tr>
    <tr>
        <th>Óptima</th>
        <th>-</th>
        <th>1</th>
        <th>-</th>
        <th>-</th>
    </tr>
    <tr>
        <th>PSO Local</th>
        <th>0.99986</th>
        <th>0.729328</th>
        <th>0.14744</th>
        <th>0.39035386</th>
    </tr>
    <tr>
        <th>PSO Global</th>
        <th>0.86408</th>
        <th>0.57433</th>
        <th>0.14744</th>
        <th>0.300020477</th>
    </tr>
</table>

Como primera conclusión podemos observar la gran diferencia entre los resultados de una función y otra. En el función Rosenbrock podríamos afirmar que ambos algoritmos realizan su objetivo con éxito, pero cuando pasamos a la función de Rastrigin, lo que nos da a pensar es que el algoritmo posee algún tipo de error, pero no es así. Viendo la diferencia de número de evaluciones y la gran desviación, lo que podemos deducir es que para la función de Rastrigin deberíamos de haber dejado funcionar durante más tiempo el algoritmo, ya que no ha podido converger de los diferentes mínimos locales que ha ido encontrando, a diferencia de la función Rosenbrock, donde ha podido converger de mejor forma.

En cuanto a la diferencia entre el local y el global, se podría decir que el local converge menos pero cae en mínimos no óptimos y viceversa.