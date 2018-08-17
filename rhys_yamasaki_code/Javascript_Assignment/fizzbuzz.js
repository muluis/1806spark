// Part 2: FizzBuzz
// Create an HTML page called fizzbuzz.html with an input box and unordered list.
// Create a JavaScript page called fizzbuzz.js and inside the html page reference it.

// The user will enter a positive number N.
// Print From 0 to N;
// Print For each multiple of 3, display "Fizz" instead of the number inside the unordered list of the html page. 
// Print For each multiple of 5, display "Buzz" instead of the number inside the unordered list of the html page. 
// Print For numbers which are multiples of both 3 and 5, display "FizzBuzz" instead of the number inside the unordered list of the html page.


// e.g. Input value = 15 (modifying the ul element to display below)
// 1
// 2
// fizz
// 4
// buzz
// fizz
// 7
// 8
// fizz
// buzz
// 11
// fizz
// 13
// 14
// fizzbuzz

document.addEventListener("change", appendItems);

let getValue;

function appendItems() {
    getValue = document.getElementById("num").value;
    var ul = document.getElementById("item");
    while (ul.hasChildNodes()) {
        ul.removeChild(ul.firstChild);
    }

    for (let i = 1; i <= getValue; i++) {
        var char = "";
        (i % 3 == 0) ? char += "Fizz" : char;
        (i % 5 == 0) ? char += "Buzz": char;
        (i % 3 !== 0 && i % 5 !== 0) ? char += i : char;
        var node = document.createElement("li");
        node.appendChild(document.createTextNode(char));
        ul.appendChild(node);
    }
}
