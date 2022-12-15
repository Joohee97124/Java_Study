/**
 * ajax.js
 */

var ajax = null;

// AJAX 객체(XMLHttpRequest 객체) 생성 함수
function createAjax()
{
	// ※ 객체를 생성하는 방식(방법)의 차이일 뿐
	//   모두 XMLHttpRequest 객체를 생성하는 구문이다.
	
	/*
	if (window.ActiveXObject)	//-- IE 7 이전 버전이면
	{
		//return new ActiveXObject("Microsoft.XMLHTTP");
		return new ActiveXObject("Msxml2.XMLHTTP");
		// 인자를 다른 값을 넣었지만 ActiveXObject 를 생성한다는 것은 똑같음 
		//-- 이와 같은 방식으로 XMLHttpRequest 객체를 생성해라.
		//   (ActiveXObject 객체 → XMLHttpRequest 객체의 대리 객체)
	}
	else						//-- IE 7 이전 버전을 제외한 나머지 브라우저면
	{
		if(window.XMLHttpRequest)	//-- XMLHttpRequest 객체 지원 브라우저
		{
			return new XMLHttpRequest();
			//-- 이와 같은 방식으로 XMLHttpRequest 객체를 생성해라.
		}
		else						//-- AJAX 를 지원하지 않는 브라우저
		{
			return null;
		}
	}
	*/
	
	if (window.ActiveXObject)
		return new ActiveXObject("Msxml2.XMLHTTP");
	else if(window.XMLHttpRequest)	
		return new XMLHttpRequest();
	else
		return null;

}