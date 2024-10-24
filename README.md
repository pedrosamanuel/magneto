
<body>

<h1>Mutant Detector API</h1>

<p>Magneto está reclutando mutantes para su lucha contra los X-Men, y ha creado un sistema para detectar si un humano es mutante basado en su secuencia de ADN.</p>

<h2>Desafío</h2>
<p>El desafío consiste en desarrollar una API que permita verificar si una persona es mutante o no, en base a su secuencia de ADN. Además, la API debe contar con estadísticas que muestren la cantidad de humanos mutantes y no mutantes detectados.</p>

<h3>Reglas del desafío</h3>
<ul>
    <li>Recibes una secuencia de ADN en forma de un array de strings, donde cada string representa una fila de la tabla (NxN).</li>
    <li>Las únicas letras permitidas en la secuencia de ADN son: <b>A</b> (Adenina), <b>T</b> (Timina), <b>C</b> (Citosina) y <b>G</b> (Guanina).</li>
    <li>Un humano es considerado <b>mutante</b> si en la secuencia de ADN se encuentran más de una secuencia de cuatro letras idénticas de forma:
        <ul>
            <li><b>Horizontal</b></li>
            <li><b>Vertical</b></li>
            <li><b>Diagonal</b> (en cualquiera de las dos direcciones)</li>
        </ul>
    </li>
    <li>Ejemplo de un caso mutante:</li>
    <pre>
{
  "dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]
}
    </pre>
    <p>En este caso, hay dos secuencias de cuatro letras iguales: una horizontal (CCCCTA) y otra diagonal (AGAAGG), por lo que el resultado es mutante.</p>
    <li>Si solo se encuentra una secuencia o ninguna, la persona no es mutante.</li>
</ul>

<h2>Uso de la API</h2>
<p>La API está desplegada en <a href="https://magneto-1a52.onrender.com">https://magneto-1a52.onrender.com</a> y ofrece los siguientes endpoints:</p>

<h3>1. Verificar si es mutante</h3>
<p><b>Endpoint:</b> <code>/api/mutant</code></p>
<p><b>Método:</b> POST</p>
<p><b>Descripción:</b> Este endpoint recibe una secuencia de ADN y determina si es mutante.</p>

<h4>Request Body (JSON)</h4>
<pre>
{
  "dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]
}
</pre>

<h4>Responses</h4>
<ul>
  <li><b>200 OK:</b> Si el ADN corresponde a un mutante. Respuesta:
    <pre>
{
  "mutant": true
}
    </pre>
  </li>
  <li><b>403 Forbidden:</b> Si el ADN no corresponde a un mutante o si el ADN no es válido. Respuesta:
    <pre>
{
  "mutant": false
}
    </pre>
  </li>
</ul>

<h3>2. Obtener estadísticas de verificaciones</h3>
<p><b>Endpoint:</b> <code>/api/stats</code></p>
<p><b>Método:</b> GET</p>
<p><b>Descripción:</b> Este endpoint devuelve las estadísticas sobre las verificaciones de ADN realizadas.</p>

<h4>Response</h4>
<pre>
{
  "count_mutant_dna": 40,
  "count_human_dna": 100,
  "ratio": 0.4
}
</pre>

<h2>Requisitos para ejecutar el proyecto localmente</h2>
<p>Si deseas ejecutar este proyecto localmente, necesitarás:</p>
<ul>
  <li>Java 17 o superior</li>
  <li>Gradle instalado</li>
  <li>Docker (opcional, para el despliegue en contenedores)</li>
</ul>

<h3>Pasos para ejecutar localmente</h3>
<ol>
  <li>Clona este repositorio: <code>git clone https://github.com/tu-usuario/mutant-detector.git</code></li>
  <li>Entra al directorio del proyecto: <code>cd mutant-detector</code></li>
  <li>Compila el proyecto con Gradle: <code>./gradlew build</code></li>
  <li>Ejecuta la aplicación: <code>./gradlew bootRun</code></li>
</ol>

<h2>Tests Unitarios</h2>
<p>El proyecto incluye una serie de test unitarios para comprobar el funcionamiento de el metodo que comprueba si un adn es mutante o no.</p>
</body>
</html>
