
function getInput() {
    var x = document.getElementById("first").value;
    var list = document.getElementById("demo");
    var count = [];
    for (var i = 0; i <= x; i++) {
    console.log(i);
        count.push(i);
   
    }

//Check if number is a multiple.
var num;
for (num in  count) {
    if (num % 3 == 0 && num % 5 == 0) {
        count[num] = "fizzbuzz";
    }
   else  if (num % 3 == 0) {
        count[num] = "fizz";
    }
    else if (num % 5 == 0) {
        count[num] = "buzz";
    }
    


};
console.log(count);
let listItem = document.createElement("li");
listItem.innerHTML = count;
list.appendChild(listItem);
    
}

function clearAll() {
document.getElementById("first").value = " ";

document.getElementById("demo").value = " ";
}


