var Screen = {
	canvas: null,
	ctx: null,
	img: null,
	draw : function(){
		//alert("M");
	this.canvas.width = window.innerWidth;
	this.canvas.height = window.innerHeight;
		this.ctx.drawImage(this.img,0,0,this.img.width,this.img.height, 0,0,window.innerWidth,window.innerHeight);
	}
}

var setup = function(){
	var canvas = document.createElement("canvas");
	canvas.width = window.innerWidth;
	canvas.height = window.innerHeight;
	canvas.id = "canvas";
	Screen.canvas = canvas;
	var ctx = canvas.getContext("2d");
	document.getElementById("gameDiv").appendChild(canvas);
	Screen.ctx = ctx;
	var img = new Image();
	Screen.img = img;
	img.src = "Linux.jpg";
}

var draw = function(){
	Screen.draw();
}