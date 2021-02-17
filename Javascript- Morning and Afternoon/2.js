var arr = [10,9,8,7,6];

console.log("Array before any operation ",arr);

arr.push(23);
console.log("Array after Push ",arr);

arr.pop();
console.log("Array after Pop ",arr);

arr.shift();

console.log("Array after Shift function ",arr);

arr.unshift(1);

console.log("Array after Unshift function  ",arr);

console.log("Index of 7 is ",arr.indexOf(7));

arr.splice(2,1);
console.log("After removing item at index 2",arr);

var new_copy = arr.slice(1, 3);
console.log("After applying slice from index 1 to 3 new copy is ", new_copy);