function change_element(arr)
{
	console.log("Array before ",arr);
	arr.sort();
	console.log("array after sort",arr);

	arr = arr.map((item,index) => item * 10);

	console.log("array after multiplication of each numbers",arr);

	arr = arr.filter((item) => ((item%3) == 0))

	console.log("array elements which are divisible by 3 ",arr);

	return arr;
}

change_element([3,8,6,9,5,1]);