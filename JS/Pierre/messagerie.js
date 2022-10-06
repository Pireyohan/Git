function load() {//fonction de chargement des donnÃ©es brut
    fetch('http://data.snx.ovh/messages.php')
        .then(function (response) {
            return response.json();// converti resultat requete en json
        })
        .then(function (data) {
            const msg = document.getElementById("msg");
            for (let i = 0; i < data.length; i++) {
                const div = document.createElement("div");
                msg.appendChild(div);
                const span = document.createElement("span");
                div.appendChild(span);
                span.innerHTML = data[i].message;
                span.classList.add("bg-primary", "text-light", "rounded-pill", "p-1")

            }
        })
}
load();

function send() {
    const data = new FormData(document.getElementById("Myform"))

    fetch('http://data.snx.ovh/messages.php', {
        method: "POST",
        body: data
    })
        .then(function (res) {
            return res.json();
        })
        .then(function (res) {
            console.log('Response: ', res);
        })
        .catch(function (err) {
            console.log('Error message: ', error);
        })
}

const b = document.getElementById("btn")

b.addEventListener('click', function (a) {
    a.preventDefault();
    send();
})