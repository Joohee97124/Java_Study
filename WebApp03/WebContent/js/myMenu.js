/**
 * myMenu.js
 */

function myMenu(status)
{
	var menu = document.getElementById("menuTable");
	
	if (status == 1)
	{
		menu.style.display = "block";
		// 블럭단위 요소처럼 그릴거야
	}
	else
	{
		menu.style.display = "none";
		// 안그릴거야
	}
	
	// inline 형 → 인라인 요소처럼 그릴거야
}



// 이렇게 안하고 매개변수를 받았다! 
/*
function myMenu1()
{
	
}

function myMenu2()
{
	
}
*/