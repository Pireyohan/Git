const contenantChoixOrdinateur = document.getElementById('choix-ordinateur');
const contenantChoixUtilisateur = document.getElementById('choix-utilisateur');
const contenantResultat = document.getElementById('resultat');

const choixPossibles = document.querySelectorAll('button');
let choixUtilisateur
let resultat
let choixOrdinateur

//Event click sur les boutons
choixPossibles.forEach(choixPossibles => choixPossibles.addEventListener('click', (e) => {
    //recuperation de l'ID du bouton cliqué
    choixUtilisateur = e.target.id;
    //on ajoute l'image qui correspond au choix
    contenantChoixUtilisateur.innerHTML = `<img src="${choixUtilisateur}.png">`
    generer_choix_ordinateur()
    verification()
}))


//Fonction pour générer le choix de l'ordinateur 
function generer_choix_ordinateur() {
    random = Math.floor(Math.random() * 3) + 1 // générer des nombres entre 1 et 3
    if (random === 1) { //si random = à 1
        choixOrdinateur = "pierre"
    }
    if (random === 2) { //si random = à 2
        choixOrdinateur = "papier"
    }
    if (random === 3) { //si random = à 3
        choixOrdinateur = "ciseaux"
    }
    //on ajoute l'image qui correspond au choix
    contenantChoixOrdinateur.innerHTML = `<img src="${choixOrdinateur}.png">`
}

//Fonction pour vérifier si le joueur a gagné or not

function verification() {
    if (choixUtilisateur == choixOrdinateur) {
        resultat = "Egalite !";
    }
    //Les cas ou le joueur perd
    if (choixUtilisateur == "pierre" && choixOrdinateur == "papier") {
        resultat = "Perdu !";
    }

    if (choixUtilisateur == "papier" && choixOrdinateur == "ciseaux") {
        resultat = "Perdu !";
    }
    if (choixUtilisateur == "ciseaux" && choixOrdinateur == "pierre") {
        resultat = "Perdu !";
    }
    // Les cas ou le joueur gagne
    if (choixUtilisateur == "pierre" && choixOrdinateur == "ciseaux") {
        resultat = "Gagné !";
    }

    if (choixUtilisateur == "papier" && choixOrdinateur == "pierre") {
        resultat = "Gagné !";
    }
    if (choixUtilisateur == "ciseaux" && choixOrdinateur == "papier") {
        resultat = "Gagné !";
    }


}