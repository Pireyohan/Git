const contenantChoixOrdinateur = document.getElementById('choix-ordinateur');
const contenantChoixUtilisateur = document.getElementById('choix-utilisateur');
const contenantResultat = document.getElementById('resultat');
const contenantScoreYou = document.getElementById('votreScore');
const contenantScoreHim = document.getElementById('sonScore');
const choixPossibles = document.querySelectorAll('button');
const gifVictory = document.getElementById('gif');

let choixUtilisateur
let resultat
let choixOrdinateur

let score = 0;
let scoreYou = 0;
let scoreIA = 0;

//Event click sur les boutons
choixPossibles.forEach(choixPossibles => choixPossibles.addEventListener('click', (e) => {
    //recuperation de l'ID du bouton cliqué
    choixUtilisateur = e.target.id;
    //on ajoute l'image qui correspond au choix
    contenantChoixUtilisateur.innerHTML = `<img src="image/${choixUtilisateur}.png">`
    generer_choix_ordinateur();
    verification();
    victory();

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
    contenantChoixOrdinateur.innerHTML = `<img src="image/${choixOrdinateur}.png">`
}

//Fonction pour vérifier si le joueur a gagné or not

function verification() {
    if (choixUtilisateur == choixOrdinateur) {
        resultat = "Execo Mec !";
    }
    //Les cas ou le joueur perd
    if (choixUtilisateur == "pierre" && choixOrdinateur == "papier") {
        resultat = "Vous avez perdu !";
        scoreIA++;
        if (scoreYou > 0)
            scoreYou--;
    }

    if (choixUtilisateur == "papier" && choixOrdinateur == "ciseaux") {
        resultat = "Vous avez perdu !";
        scoreIA++;
        if (scoreYou > 0)
            scoreYou--;
    }
    if (choixUtilisateur == "ciseaux" && choixOrdinateur == "pierre") {
        resultat = "Vous avez perdu !";
        scoreIA++;
        if (scoreYou > 0)
            scoreYou--;
    }
    // Les cas ou le joueur gagne
    if (choixUtilisateur == "pierre" && choixOrdinateur == "ciseaux") {
        resultat = "Vous avez gagné !";
        scoreYou++;
        if (scoreIA > 0)
            scoreIA--;
    }

    if (choixUtilisateur == "papier" && choixOrdinateur == "pierre") {
        resultat = "Vous avez gagné !";
        scoreYou++;
        if (scoreIA > 0)
            scoreIA--;
    }
    if (choixUtilisateur == "ciseaux" && choixOrdinateur == "papier") {
        resultat = "Vous avez gagné !";
        scoreYou++;
        if (scoreIA > 0)
            scoreIA--;
    }
    contenantResultat.innerHTML = resultat;
    contenantScoreHim.innerHTML = "Him : " + scoreIA;
    contenantScoreYou.innerHTML = "You : " + scoreYou;
}

function victory() {
    if (scoreIA == 5 || scoreYou == 5) {

        {
            document.getElementById('gif').innerHTML = "<img src='image/Feu_dartifice.gif' >";
        }


    }
}