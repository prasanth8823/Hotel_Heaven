//function for email Id dobValidation.
function emailValidation() {

    // get email Id value form html.
    let email = document.querySelector("#emailId").value;

    //set Regular expression for emaiId validation.
    let emailRegex = /^[a-zA-Z0-9.]+@gmail\.com$/;

    //validating the email id.
    if (emailRegex.test(email) == false) {
        alert("invalid email id");
        return false;
    }
    else{
        return true;
    }
}

//function for password validation.
function passwordValidation() {

    //get password and confrim password for html.
    let password = document.querySelector("#password").value;

    //set Regular expression for password. 
    let lowercaseRegex = /[a-z]/;
    let uppercaseRegex = /[A-Z]/;
    let numaricalRegex = /[0-9]/;
    let specialCharRegex = /[\W_]/;

    //validating password.
    if(password.length < 8){
        alert("password should have eight or more than eight charecter")
        return false;
    }
    if (!password.match(lowercaseRegex)) {
        alert("password should have lowercase");
        return false;
    }
    if(!password.match(uppercaseRegex)){
        alert("password should have uppercase");
        return false;
    }
    if(!password.match(numaricalRegex)){
        alert("password should have numbers");
        return false;
    }
    if(!password.match(specialCharRegex)){
        alert("password should have spacial charecter");
        return false;
    }
    else{
        return true;
    }
    
}

//function contains all the validating function.
//it call all the function when user click on the submit butten in html.
function inputvalidation() {

    //calling all validating function.
    emailValidation();
    passwordValidation();
}