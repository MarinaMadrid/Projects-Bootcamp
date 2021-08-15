//Validation
function validation(number, letter){
    validateNumeric(number, 8);
    
    validateLetter(letter, 1);
}



//Number
function allNumbers(number) {
    for(let char of number) {
        if (isNaN(parseInt(char, 10))){
            return false;
        }
    }
    return true;
}


function validateNumeric(number, expectedLength){
    if (!number){
        alert('El campo de número no puede estar vacio.');
        throw 'validationError';
    } 
    if (!allNumbers(number)){
        alert('El campo de número debe contener solo números.');
        throw 'validationError'; 
    }
    if (number.length != expectedLength){
        alert(`El campo de número debe tener ${expectedLength} dígitos.`);
        throw 'validationError';
    }
}

//Letter
const supported = [
    "T",
    "R",
    "W",
    "A",
    "G",
    "M",
    "Y",
    "F",
    "P",
    "D",
    "X",
    "B",
    "N",
    "J",
    "Z",
    "S",
    "Q",
    "V",
    "H",
    "L",
    "C",
    "K",
    "E" 
];

//I, Ñ, O and U aren't in the NID.
function correctLetter(upperLetter) {
    for (let letter of supported) {
        if (letter === upperLetter){
            return true;
        } 
    }
    alert('El campo de letra debe ser una letra soportada.');
    throw 'validationError';
}

function validateLetter(upperLetter, expectedLength){
    if (!upperLetter || upperLetter.length != expectedLength || !correctLetter(upperLetter)){
        alert('El campo de letra debe tener un dígito.');
        throw 'validationError';
    }
}

//Delete all when there is an error or Reset is pressed
function deleteAll(){
    document.getElementById('number').value = '';
    document.getElementById('letter').value = '';
    var divResult1 = document.getElementsByClassName('result1')[0];
    removeChildren(divResult1);
    var divResult2 = document.getElementsByClassName('result2')[0];
    removeChildren(divResult2);
}

//Calculate the letter
function calculateLetter(number){
    let remainder = number % 23;
    return supported[remainder];
}
    
//Creation the h1
function creationH1(trueLetter, divResult1){
    var h1 = document.createElement("h1");
    var texth1 = document.createTextNode(`La letra correspondiente a ese número de DNI es ${trueLetter}.`);  
    h1.appendChild(texth1);
    divResult1.appendChild(h1);
}

//Comparation between upperLetter and trueLetter
function compareExpectedLetter(number, upperLetter, trueLetter, divResult1, divResult2){
    creationH1(trueLetter, divResult1);
    var h3 = document.createElement("h3");
    if (upperLetter != trueLetter) {
        var texth3 = document.createTextNode("Las letras no coinciden, por lo tanto, la letra introducida es incorrecta.");
        h3.appendChild(texth3);
        h3.className ='redcolor';
        divResult2.appendChild(h3);
    }
    else{
        var texth3 = document.createTextNode("Las letras coinciden, por lo tanto, la letra introducida es correcta.");
        h3.appendChild(texth3);
        h3.className = 'greencolor';
        divResult2.appendChild(h3);
    }
}

//Removing Children
function removeChildren(element){
    element.innerHTML = '';
}

//Button "Enter"
function process(){
    try{
        let number = document.getElementById('number').value;
        let letter = document.getElementById('letter').value;
        let upperLetter = letter.toUpperCase();
        validation(number, upperLetter);
        var divResult1 = document.getElementsByClassName('result1')[0];
        removeChildren(divResult1);
        var divResult2 = document.getElementsByClassName('result2')[0];
        removeChildren(divResult2);
        compareExpectedLetter(number, upperLetter, calculateLetter(number), divResult1, divResult2);
    } catch (error){
        deleteAll();
    }
}

//Keyboard key "Enter"
function onEnterProcess(e) {
    if (e.key === "Enter") {
        process();
    }
}