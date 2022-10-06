let items = [];

const URL_LIST_CATEGORIES = "https://api.publicapis.org/categories";
const URL_LIST_ENTRIES = "https://api.publicapis.org/entries";


let container = document.getElementById('container');
const tableBody = document.querySelector(".table-body");
let myLoadedSection = document.querySelector('#myLoadedSection');
let categorieSelected = 'Animals';
let newUrl;
let listeCategories = new Array();
function loadSelect(url) {
    const xhr = new XMLHttpRequest();
    if (xhr.status == 404) {
        alert('Badaboum');
    }
    xhr.onload = function () {
        const json = JSON.parse(this.responseText).categories;
        console.log('json : ', json);
        const data = [... new Set(json)];
        listeCategories = data;
        console.log('Categorie in LoadSelect  :', listeCategories)
        console.log('data : ', data);
        // listeCategories = listeCategories.filter( (ele,pos)=>listeCategories.indexOf(ele) == pos);
        for (let i = 0; i < data.length; i++) {
            myLoadedSection.insertAdjacentHTML('beforeEnd', `<ul>
    <option value="${data[i]}" >${data[i]}</option>
    ` );
        }
    }

    xhr.open("GET", url);
    xhr.send();
    return false;
}
function drawTable(tableau) {
    for (let i = 0; i < tableau.length; i++) {
        tableBody.insertAdjacentHTML(
            "beforeEnd",
            `<tr>
          <td>${tableau[i].API}</td>
          <td>${tableau[i].Description}</td>
          <td>${tableau[i].Auth}</td>
          <td>${tableau[i].HTTPS}</td>
          <td>${tableau[i].Cors}</td>
          <td>${tableau[i].Link}</td>
          <td>${tableau[i].Category}</td>        
      </tr>`
        )
    }
}
myLoadedSection.addEventListener('change', function () {
    categorieSelected = myLoadedSection.value;
    // newUrl = `https://api.publicapis.org/entries?Category=${categorieSelected}`

    // load(newUrl);  
    tableBody.innerHTML = ''
    console.log('values of items to be filtered', items)
    items = items.filter(el => el.Category = categorieSelected)
    drawTable(items);
})

function load(url) {

    const xhr = new XMLHttpRequest();
    if (xhr.status == 404) {
        alert('xhr.status==404');
    }
    xhr.onload = function () {
        const json = JSON.parse(this.responseText).entries;
        items = json;
        const data = json.slice(0, 15);
        drawTable(data);

    }
    xhr.open("GET", url);
    xhr.send();
    return false;
}

load(URL_LIST_ENTRIES);
loadSelect(URL_LIST_CATEGORIES);