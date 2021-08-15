function alertValoration(){
  let valoration = document.getElementById('valoration').value;
  let punto = (valoration == 1 ? "punto" : "puntos");
  alert(`Has valorado con ${valoration} ${punto}`);
}

function onlyNumber(number) {
  for(let char of number) {
      if (isNaN(parseInt(char, 10))){
          return false;
      }
  }
  return true;
}

function validateNumeric(number, fieldname, expectedLength){
  if (!number || number.length != expectedLength || onlyNumber(number)){
      alert(`El campo ${fieldname} debe tener ${expectedLength} dígitos`);
      throw `validationError`;
  }
}

function alertBankAccount(){
  let country = document.getElementById('country').value;
  let iban = document.getElementById('iban').value;
  validateNumeric(iban, "IBAN", 2)
  let entity = document.getElementById('entity').value;
  validateNumeric(entity, "Entidad", 4)
  let subsidiary = document.getElementById('subsidiary').value;
  validateNumeric(subsidiary, "Sucursal", 4)
  let dc = document.getElementById('dc').value;
  validateNumeric(dc, "DC", 2)
  let account = document.getElementById('account').value;
  validateNumeric(account, "Cuenta", 10)
  let bankaccount = `${country}-${iban}-${entity}-${subsidiary}-${dc}-${account}`;
  alert(`Le informamos que su cuenta bancaria es: ${bankaccount}`);
}

function alertWeekDate(){
  let date = new Date(document.getElementById('date').value);
  let days = ['Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado', 'Domingo'];
  let numberdayweek = date.getDay() - 1;
  alert(`La fecha seleccionada en el elemento de fecha es un ${days[numberdayweek]}`);
}
