let home;
let personal;
let account;
var loggedIn = false;
var accountLogged = {
    name: "Marcin Salamon",
    email: "salamonmarcin29@gmail.com"
}

window.onload = function() {
    document.getElementById("home").onclick = changeIFrame;
    document.getElementById("personal").onclick = changeIFrame;
    document.getElementById("account").onclick = changeIFrame;
    document.getElementById("login").onclick = changeIFrame;
    document.getElementById('login').innerHTML = accountLogged.name;
}

function changeIFrame(){
    document.getElementsByTagName("iframe")[0].src ='pages/' + this.id + ".html";
    document.getElementById('login').innerHTML = accountLogged.name;
}


