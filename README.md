
<body>

<h1>Mutant Detector API</h1>

<p>Magneto está reclutando mutantes para su lucha contra los X-Men, y ha creado un sistema para detectar si un humano es mutante basado en su secuencia de ADN.</p>

<h2>Desafío</h2>
<p>El desafío consiste en desarrollar una API que permita verificar si una persona es mutante o no, en base a su secuencia de ADN. Además, la API debe contar con estadísticas que muestren la cantidad de humanos mutantes y no mutantes detectados.</p>

<h2>API Usage</h2>
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

<h2>Diagrama de Secuencia</h2>
<p>El siguiente diagrama de secuencia describe el proceso de verificación de ADN mutante:</p>
<pre>
User -> API: POST /api/mutant
API -> MutantService: isMutant(dna)
MutantService -> ADNValidator: validarADN(dna)
MutantService -> ADNAnalyzer: analizarSecuencias(dna)
MutantService -> DB: guardarResultado(dna, isMutant)
API -> User: Respuesta 200/403
</pre>

<h2>Arquitectura del Sistema</h2>
<p>La aplicación sigue una arquitectura de microservicios sencilla:</p>
<ul>
  <li><b>API Gateway:</b> Procesa las solicitudes HTTP y las dirige al servicio correspondiente.</li>
  <li><b>Servicio de Mutantes:</b> Analiza la secuencia de ADN para determinar si el humano es mutante.</li>
  <li><b>Base de Datos:</b> Guarda las secuencias de ADN y el resultado de la verificación.</li>
</ul>

<h2>Tests Automáticos</h2>
<p>El proyecto incluye una suite de tests automáticos con cobertura superior al 80%. Puedes ejecutar los tests con el siguiente comando:</p>
<pre>
./gradlew test
</pre>

</body>
</html>
