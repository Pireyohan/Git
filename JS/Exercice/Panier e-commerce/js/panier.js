const items = [
  {
    name: "Chaussure A",
    price: 125,
    quantity: 0
  },
  {
    name: "Chaussure B",
    price: 135,
    quantity: 0
  }
]

function add(event) {
  let index = event.target.dataset.prodId;
  let item = items[index];

  item.quantity += 1;

  let quantityId = `quantity_${index}`;
  let quantityElement = document.getElementById(quantityId);
  quantityElement.textContent = item.quantity;

  total += item.price;
  let totalElement = document.getElementById("total");
  totalElement.textContent = total;
}

//fonction qui permet d'ajouter un élément en factorisation 
function addElement(parent, tag, text) {
  let element = document.createElement(tag);
  element.textContent = text;
  parent.appendChild(element);

  return element;
}

function insertItemHTML(parent, item, index) {
  let mainDiv = addElement(parent, "div", "");
  mainDiv.className = "items"; // 

  addElement(mainDiv, "h2", item.name);
  addElement(mainDiv, "p", `Prix : ${item.price}`);


  let quantityContainer = addElement(mainDiv, "p", "Quantité : ");
  let quantityElement = addElement(quantityContainer, "span", item.quantity);
  quantityElement.id = `quantity_${index}`;

  let button = addElement(mainDiv, "button", "Ajouter");
  button.dataset.prodId = index;
  button.onclick = add;
}


let total = 0;

let itemsContainer = document.getElementById("items");

for (let i = 0; i < items.length; ++i) {
  insertItemHTML(itemsContainer, items[i], i);
}