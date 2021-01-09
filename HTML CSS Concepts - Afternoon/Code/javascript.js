function saveUser(){
    var fname = document.getElementById("fname").value;
    var lname = document.getElementById("lname").value;
    var mobile = document.getElementById("mobile").value;
    var pwd = document.getElementById("pwd").value;
    var email = document.getElementById("email").value;
    var e = document.getElementById("genders");
    var gender = e.options[e.selectedIndex].text;
    var dob = document.getElementById("dob").value;
    var age = document.getElementById("age").value;
    var favcol = document.getElementById("favcol").value;
    var userobj = {
        "firstname":fname,
        "lastname":lname,
        "mobile":mobile,
        "password":pwd,
        "email":email,
        "gender":gender,
        "dateofbirth":dob,
        "age":age,
        "favcolor":favcol
    };
    localStorage.setItem("userdata",JSON.stringify(userobj));
    document.getElementById("userdataop").innerHTML = getdetails();
    console.log("data saved to localbase");
    return false;
}

function clearUserData(){
    localStorage.clear();
    console.log("data cleared from local");
    document.getElementById("userdataop").innerHTML = "No data Available";
}

function onloaduser(){
    if(localStorage.length==1){
        console.log("data found on page load");
        document.getElementById("userdataop").innerHTML = getdetails();
    }else{
        console.log("data not found on load");
        document.getElementById("userdataop").innerHTML= "No data Available";
    }
}

function getdetails(){
    let userd = localStorage.getItem("userdata");
    let user = JSON.parse(userd);
    // console.log(user);
    var string = "";
    for(k in user){
        string += k +" : "+ user[k] + ",   ";
    }
    // console.log(user);
    return string;
}

function blockaccess(){
    return false;
}