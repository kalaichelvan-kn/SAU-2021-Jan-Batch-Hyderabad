function calculateSum(){
    document.getElementById('input1span').innerHTML = "";
    document.getElementById('input2span').innerHTML = "";
    var inpnum1 = document.getElementById('input1').value;
    var inpnum2 = document.getElementById('input2').value;
    var num1 = parseFloat(inpnum1);
    var num2 = parseFloat(inpnum2);
    var prevent = false;
    if(isNaN(num1)){
        document.getElementById('input1span').innerHTML = "Input element should be a Number";
        document.getElementById('input1').focus();
        prevent = true;
    }if(isNaN(num2)){
        document.getElementById('input2span').innerHTML = "Input element should be a Number";
        document.getElementById('input2').focus();
        prevent = true;
    }
    if(prevent)return !prevent;
    var ans = num1+num2;   
    document.getElementById('output').value = ans;
    return true;
}