
function load2() {
    fetch("https://data.snx.ovh/API.json")
        .then(function (res) {
            return res.json();
        })
        .then(function (value) {
            var cards = document.getElementById("cards");
            var html = "";
            value.forEach(element => {
                html += `<div class="container">
                
                <div class="card  mt-5 b">
                    <div class="card">
                        <div class="card-header d-flex justify-content-between">
                            <div >
                                <img src="imp.jpg" class="rounded-pill float-start p-0 img-user mt-1 " alt="photo"> 
                                <div class=row>     
                                <span class="username fs-6 p-0 mx-2 ">@` + element.author + `</span>
                                <span class="fullname-cards text-secondary fw-lighter ms-2  fs-6 p-0"> `+ element.fullname + `</span>
                                </div>
                            </div>
                            <div class="nav-item dropdown me-3 ">
        
                                <a class="nav-link dropdown-toggle text-muted fw-bolder " href="#" role="button"
                                    data-bs-toggle="dropdown" > ...      
                                </a>
                                <ul class="dropdown-menu ">
                                    <li>
                                        <a class="dropdown-item" href="#">
                                        <div class="d-flex bd-highlight align-items-end text-secondary">
                                            <div class="">
                                                Configuration
                                            </div>
                                         </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a class="dropdown-item" href="#">
                                            <div class="d-flex bd-highlight align-items-end">
                                                <div class="">
                                                    Save
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a class="dropdown-item" href="#">
                                            <div class="d-flex bd-highlight align-items-end">
                                                <div class="">
                                                    Hide
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a class="dropdown-item" href="#">
                                            <div class="d-flex bd-highlight align-items-end">
                                                <div class="">
                                                    Report
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                </ul>
                            </div>      
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="time">
                            <i class="bi bi-clock"></i>
                            <span class="post-time fw-lighter ">` + element.time + `</span>
                        </div>
                        <p class="card-text text-primary post-title mt-2">` + element.title + `</p>
                        <p class="card-text"><small class="post-message ">` + element.content + `</small></p>
                    </div>
                    <div class="card-footer fs-6">
                        <span class="text-primary mx-2"><i class="bi bi-hand-thumbs-up"></i> Like</span>
                        <span class="text-primary mx-2"><i class="bi bi-chat"></i> Comment</span>
                        <span class="text-primary mx-2"><i class="bi bi-share"></i> Share</span>
                    </div>
                </div>
            </div>
        `;

            });
            cards.innerHTML = html;
        })
        .catch(function (err) {
            // Une erreur est survenue
        });
}
load2();

/* 
const URL_API = "https://data.snx.ovh/API.json";
let indexOfUserToRetrieve = 0;

let username = '';
let fullname = '';
let message = '';

// let divCentrales = `
//     <div class="card ">                    
//         <div class="card-header ">
//             <img src="imp.jpg" class="rounded-pill float-start p-0 img-user mt-1" alt="John" >
//             <div class="card-text mx-2">
//                 <span class="username fs-6 p-0 mx-2"></span>
//                 <p class="fullname-cards fw-lighter mx-5 fs-6 p-0"></p>
//             </div>

//         </div>
//         <div class="card-body">
//             <div class="time">
//                 <i class="bi bi-clock"></i>
//                 <span class="post-time fw-lighter"></span>
//             </div>
//             <p class="card-text text-primary post-title"></p>
//             <p class="card-text"><small class="post-message"></small></p>
//         </div>
//         <div class="card-footer fs-6">
//             <span class="text-primary mx-2"><i class="bi bi-hand-thumbs-up"></i> Like</span>
//             <span class="text-primary mx-2"><i class="bi bi-chat"></i> Comment</span>
//             <span class="text-primary mx-2"><i class="bi bi-share"></i> Share</span>
//         </div>
//     </div>`;
// document.querySelector('.posts').appendChild(divCentrales);

async function getUserInfo(indexOfUserToRetrieve) {
    fetch(URL_API)
        .then((res) => res.json())
        .then((data) => {
            username = data[indexOfUserToRetrieve].author;
            fullname = data[indexOfUserToRetrieve].fullname;
            message = data[indexOfUserToRetrieve].content;
            let postTitle = data[indexOfUserToRetrieve].title;
            let postTime = data[indexOfUserToRetrieve].time;


            let usernameDivs = document.querySelectorAll('.username');
            let fullnameDivs = document.querySelectorAll('.fullname');
            let fullnameCardsDivs = document.querySelectorAll('.fullname-cards');
            let postTimeDivs = document.querySelectorAll('.post-time');
            let postTitleDivs = document.querySelectorAll('.post-title');
            let postMessageDivs = document.querySelectorAll('.post-message');

            usernameDivs.forEach(element => {
                element.innerText = '@' + username;
            });
            fullnameDivs.forEach(el => {
                el.innerText = 'Fullname : ' + fullname;
            });
            fullnameCardsDivs.forEach(el => {
                el.innerText = fullname;
            })
            postTimeDivs.forEach(el => {
                el.innerText = postTime;
            })
            postTitleDivs.forEach(el => {
                el.innerText = postTitle;
            })
            postMessageDivs.forEach(el => {
                el.innerText = message;
            })


        });
}
getUserInfo(0);

 */