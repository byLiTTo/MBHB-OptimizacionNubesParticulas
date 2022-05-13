<img src="imagenes/1.tiff"/>

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
        <th colspan='5'> Algoritmo PSO Local</th>
    </tr>
    <tr>
        <th></th>
        <th colspan='2'>Rosenbrock</th>
        <th colspan='2'>Rastrigin</th>
    </tr>
    <tr>
        <th></th>
        <th>Coste</th>
        <th>Nº Evaluaciones</th>
        <th>Coste</th>
        <th>Nº Evaluaciones</th>
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