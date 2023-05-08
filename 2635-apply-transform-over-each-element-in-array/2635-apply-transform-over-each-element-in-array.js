/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    let finalArr=[]
    for(var i=0;i<arr.length;i++){
        finalArr.push(fn(arr[i],i));
    }
    
    return finalArr;
};