<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
    * { box-sizing: border-box; margin: 0; padding: 0; font-family: Arial, sans-serif; }
    body { background: #f7f9fa; display: flex; justify-content: center; padding: 2rem; }
    .container { width: 100%; max-width: 800px; background: #fff; border: 1px solid #ddd; border-radius: 8px; padding: 2rem; }
    h1, h2, h3 { color: #333; text-align: center; margin-bottom: 1rem; }
    p, ul, ol, pre { margin-bottom: 1rem; color: #555; }
    .sequence { margin: 2rem 0; }
    .actor { display: flex; flex-direction: column; align-items: center; padding: 1rem; }
    .actor-title { font-weight: bold; margin-bottom: 0.5rem; }
    .arrow { display: flex; align-items: center; justify-content: space-between; margin: 1rem 0; }
    .arrow div { padding: 0.5rem; border-radius: 4px; font-size: 0.9rem; color: #555; }
    .arrow .request { background: #d4e5ff; }
    .arrow .response { background: #dff0d8; }
    .actor img { width: 50px; height: 50px; border-radius: 50%; margin-bottom: 0.5rem; }
  </style>
</head>
<body>
  <div class="container">
    <h1>Mutant Detector API</h1>
    <p>Magneto está reclutando mutantes para su lucha contra los X-Men, y ha creado un sistema para detectar si un humano es mutante basado en su secuencia de ADN.</p>

    <h2>Desafío</h2>
    <p>El desafío consiste en desarrollar una API que permita verificar si una persona es mutante o no, en base a su secuencia de ADN.</p>

    <h3>Reglas del desafío</h3>
    <ul>
      <li>Recibes una secuencia de ADN en forma de un array de strings...</li>
      <!-- Completa las reglas según tu descripción original -->
    </ul>

    <h2>Uso de la API</h2>
    <p>La API está desplegada en <a href="https://magneto-1a52.onrender.com">https://magneto-1a52.onrender.com</a>.</p>

    <h3>1. Verificar si es mutante</h3>
    <p><b>Endpoint:</b> <code>/api/mutant</code></p>
    <h4>Request Body (JSON)</h4>
    <pre>{ "dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"] }</pre>
    <h4>Responses</h4>
    <ul>
      <li><b>200 OK:</b> Si el ADN corresponde a un mutante.</li>
      <li><b>403 Forbidden:</b> Si el ADN no corresponde a un mutante.</li>
    </ul>

    <h2>Diagrama de Secuencia del Endpoint /api/mutant</h2>
    <div class="sequence">
      <div class="actor">
        <div class="actor-title">Usuario</div>
        <img src="https://cdn-icons-png.flaticon.com/512/254/254451.png" alt="Usuario">
      </div>
      <div class="arrow">
        <div class="request">POST /api/mutant (DNARequest)</div>
        <div class="response">HTTP Response (DNAResponse)</div>
      </div>

      <div class="actor">
        <div class="actor-title">DnaController</div>
        <img src="https://cdn-icons-png.flaticon.com/512/484/484167.png" alt="DnaController">
      </div>
      <div class="arrow">
        <div class="request">checkDna(DNARequest)</div>
        <div class="response">DNAResponse</div>
      </div>

      <div class="actor">
        <div class="actor-title">DnaService</div>
        <img src="https://cdn-icons-png.flaticon.com/512/190/190603.png" alt="DnaService">
      </div>
      <div class="arrow">
        <div class="request">analyzeDna(String[] dna)</div>
        <div class="response">isMutant = true/false</div>
      </div>
      <div class="arrow">
        <div class="request">validateDna(dna)</div>
        <div class="response">true/false</div>
      </div>

      <div class="actor">
        <div class="actor-title">DnaRepository</div>
        <img src="https://cdn-icons-png.flaticon.com/512/1828/1828393.png" alt="DnaRepository">
      </div>
      <div class="arrow">
        <div class="request">findByDna(dnaSequence)</div>
        <div class="response">Optional&lt;Dna&gt;</div>
      </div>
    </div>
  </div>
</body>
</html>

