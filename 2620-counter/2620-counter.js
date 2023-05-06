/**
 * @param {number} n
 * @return {Function} counter
 */
var curr;
var createCounter = function(n) {
    curr=n;
    return function() {
        curr++;
        return curr-1;
    };
    
    curr++;
};

/** 
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */