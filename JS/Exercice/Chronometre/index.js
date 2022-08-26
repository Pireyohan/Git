// Les variables dont on a besoin 
var sp, btn_start, btn_stop, t, ms, s, min, h;

//fonction pour init les variables quand la page se charge
window.onload = function () {
    sp = document.getElementsByTagName('span');
    btn_start = document.getElementById('start');
    btn_stop = document.getElementById('stop');
    t;
    ms = 0, s = 0, min = 0, h = 0;
}
//mettre en place le compteur

function update_chrono() {
    ms += 1;
    if (ms == 10) {
        ms = 1;
        s += 1;
    }
    if (s == 60) {
        s = 0;
        min += 1;
    }
    if (min == 60) {
        min = 0;
        h += 1;
    }

    //insertion des valeurs dans les spans
    //[0] permet de selectionner le premier span
    sp[0].innerHTML = h + "h";
    sp[1].innerHTML = min + "min";
    sp[2].innerHTML = s + "s";
    sp[3].innerHTML = ms + "ms";
}
// mettre en place le fonction du bouton start
function start() {
    //cette ligne execute la fonction update toutes les 100ms
    t = setInterval(update_chrono, 100);
    btn_start.disabled = true
}

//stopper le chrono
function stop() {
    clearInterval(t); //suppression de linterval que nous avions créer
    btn_start.disabled = false;
}


