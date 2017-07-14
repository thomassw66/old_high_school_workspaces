Matrix = function(n,m){
	this.n = n;
	this.m = m;
	var dat = new Array(n);
	for (var i = 0; i < dat.length;i++){
		dat[i] = new Array(m);
	}
	this.set = function(val,x,y){
		dat[x][y] = val;
	}
	this.get = function(x,y){
		return dat[x][y];
	}
	this.tostring = function(){
		var s = "";
		for(var i = 0; i < this.n; i++){
			s += "[";
			for(var j = 0; j < this.m; j++){
				if(j!=0)s+=", ";
				s+=this.get(i,j);
			}
			s+="]<br\/>\n";
		}
		return s;
	}
}

function addScalar(scalar, mat){
	var m = new Matrix(mat.n,mat.m);
	for(var i = 0; i < mat.n; i++){
		for(var j = 0; j < mat.m; j++){
			m.set(scalar+mat.get(i,j), i, j);
		}
	}
	return m;
}

function addMat(mat1,mat2){
	var m = new Matrix(mat1.n,mat1.m);
	for(var i = 0; i < mat1.n; i++){
		for(var j = 0; j < mat1.m; j++){
			m.set(mat1.get(i,j) + mat2.get(i,j),i,j);
		}
	}
	return m;
}

function mulScale(scale, mat){
	var m = new Matrix(mat.n,mat.m);
	for(var i = 0; i < mat.n; i++){
		for(var j = 0; j < mat.m; j++){
			m.set(scale * mat.get(i,j), i, j);
		}
	}
	return m;
}

function mulMat(mat1,mat2){
	var m = new Matrix(mat1.m,mat2.n);
	for(var i = 0; i < m.n; i++){
		for(var j = 0; j < m.m; j++){
			var s = 0;
			for(var x = 0; x < mat1.n; x++)
				s += mat1.get(x,j)*mat2.get(i,x);
			m.set(s,i,j);
		}
	}
}

function fillMat(val, mat){
	for(var i = 0; i < mat.n; i++){
		for(var j = 0; j < mat.m; j++){
			mat.set(val, i, j);
		}
	}
}