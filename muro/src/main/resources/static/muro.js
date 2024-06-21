
async function load_comments(event) {
  // 0. Evitar que el enlace dirija a otra página
  event.preventDefault();
  // 1. Recuperamos el ID del mensaje clickeado
  const message_id = event.target.dataset.id;
  console.log("cklickeado el enlace " + message_id);
  // 2. Realizamos la solicitud al servidor
  const response = await fetch('/api/messages/'+message_id+'/comments');
  // 3. Abrimos la respuesta
  const data = await response.json()
  // 4. Renderizamos los comentarios
  render_comments(message_id, data);
}

function render_comments(message_id, data) {
  const lista_comentarios = document.getElementById(message_id);
  for (const comment of data) {
    lista_comentarios.innerHTML += `
      <div class="comentarios px-2 m-2 border border-success">
        <h4>${comment.creatorsName}</h4>
        <p>${comment.content}</p>
      </div>
    `;
    lista_comentarios.innerHTML += `
      <div class="comentarios px-2 m-2 border border-success">
        <h4>%s</h4>
        <p>%s</p>
      </div>
    `.formatted(comment.creatorName, comment.content);
  }
  // hacemos la lista de comentarios visible
  lista_comentarios.classList.remove('d-none');
}

function batman () {
  let str = '';
  for (let i=0; i<12; i++) {
    str += parseInt('hola')
  }
  console.log(str);
  console.log('LIIIIDEEEER');
}