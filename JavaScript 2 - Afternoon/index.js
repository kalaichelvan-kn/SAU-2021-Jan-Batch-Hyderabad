var intArr = [1, 2, 3, 4, 5];
function cusmap(arr, init, redfn){
    let last=0;
    for(var i=0; i<arr.length; i++) {        
        last = redfn(last,arr[i]);    
    }
    return last;
}    
var output = cusmap(intArr,0,(acc,cur)=> acc + cur);
document.getElementById('output').innerHTML = output;