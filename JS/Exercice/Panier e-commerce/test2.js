const itemsDiv = [
    {
        name: "Chaussure A",
        price: 125,
        quantity: 0
    },
    {
        name: "Chaussure B",
        price: 135,
        quantity: 0
    },
    {
        name: "Chaussure C",
        price: 135,
        quantity: 0
    }
]

//Cette fonction permet de factoriser l'insertion  d'élément dans ma page 
//HTML pour lui donner sa div , sa balise et le texte dans la balise
function addElementInDiv(parent, tagDiv, textDansDiv) {
    let element = document.createElement(tagDiv);
    element.textContent = textDansDiv;
    parent.appendChild(element);

    return element;
}

function insertItemsDivDansHTML(parent, itemsDiv, index) {
    let mainDiv = addElementInDiv(parent, "div", "");
    mainDiv.className = "itemsDiv"; // 

    addElementInDiv(mainDiv, "h2", itemsDiv.name);
    addElementInDiv(mainDiv, "p", `Prix : ${itemsDiv.price}`);

    let quantityContainer = addElementInDiv(mainDiv, "p", "Quantité : ");
    let quantityElement = addElementInDiv(quantityContainer, "span", itemsDiv.quantity);
    quantityElement.id = `quantity_${index}`;

    let buttonDajout = addElementInDiv(main)
}

//Permet de boucler sur chaque élément qui se trouve dans le JSON
// pour peupler chaque div qui va être créer
let itemsContainer = document.getElementById("itemsDiv");

for (let i = 0; i < itemsDiv.length; ++i) {
    insertItemsDivDansHTML(itemsContainer, itemsDiv[i], i);
}