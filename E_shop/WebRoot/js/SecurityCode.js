//ÑéÖ¤ÂëË¢ĞÂ
	function change() {
		var img = document.getElementById("securityimg");
		img.src = "./securityCode.action?"+new Date().getTime();
	}