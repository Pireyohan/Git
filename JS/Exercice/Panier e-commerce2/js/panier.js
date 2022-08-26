let items = [];

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
  
function addElement(parent, tag, text) {
      let element = document.createElement(tag);
    element.textContent = text;
    parent.appendChild(element);
    
    return element;
}
  
function insertItemHTML(parent, item, index) {
    let mainDiv = addElement(parent, "div", "");
    mainDiv.className = "item";
    
    addElement(mainDiv, "h2", item.name);  
    addElement(mainDiv, "p", `Prix : ${item.price}`);
    
    let quantityContainer = addElement(mainDiv, "p", "Quantité : ");
    let quantityElement = addElement(quantityContainer, "span", item.quantity);
    quantityElement.id = `quantity_${index}`;
    
    let button = addElement(mainDiv, "button", "Ajouter");
    button.dataset.prodId = index;
    button.onclick = add;
}

function load(url){
  const xhr = new XMLHttpRequest();
  xhr.onload = function(){
      items = JSON.parse(this.responseText);
      refreshBoutique();
  }
  xhr.open("GET", url);
  xhr.send();
  return false;
}

function refreshBoutique(){
    itemsContainer.innerHTML = "";
    for (let i = 0; i < items.length; ++i) {
        insertItemHTML(itemsContainer, items[i], i);
    }
}
  
let total = 0;
let itemsContainer = document.getElementById("items");
load("http://data.snx.ovh/page1.json");