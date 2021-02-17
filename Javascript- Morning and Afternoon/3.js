function find_index(argument) 
{
	var x = /cat$/
	var y = /^lion/
	var z = /ab+c/

	x = x.exec(argument);
	y = y.exec(argument);
	z = z.exec(argument);

	if(x)
	{
		console.log("Found CAT at pos ",x.index);
		return true;
	}
	if(y)
	{
		console.log("Found Lion at pos ",y.index);
		return true;
	}
	if(z)
	{
		console.log("Found pattern at ",z.index);
		return true;
	}

	console.log("Not Found");
	return false;

	// if(x.test(argument)  )
	// {
	// 	console.log("found at ",x.exec(argument).index);
	// }
	// else if(y.test(argument))
	// {
	// 	console.log("found at ",y.exec(argument).index)
	// }
	// else
	// 	console.log("Not found");
}

find_index("lisaabbbcdfsyedcast");