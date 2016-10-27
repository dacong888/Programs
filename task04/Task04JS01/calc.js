//x赋值
var xValue = "";
//y赋值
var yValue = "";
//结果
var result = "";
//屏显
var screamShow = "";
//dotValue
var xDot = "";
var yDot = "";
//dot是否赋值
var isXDot = false;
var isYDot = false;
//操作符
var optr = "";
//操作符是否赋值
var isOptr = false;
//赋值符号
var symbol = "";
//zero是否赋值
var isZero = false;
//x是否赋值
var isXValued = false;
//y是否赋值
var isYValued = false;

//辅助函数
function getStr (str) {
	 var strLen = str.indexOf(optr);
	 var strOut = "";
	 for(var i = 0; i <= strLen; i++){
	 	strOut += str[i];
	 }

	 return strOut;
}

//是否进行过操作
function getResultAndReset(){
	if (result != "") {
		clear_context();
	}
}

function getXorYValue(isValued, xyValue, input_num){
	if (result != "") {
		result = "";
		document.getElementById("result_id").value = result;
	}

	var tempValue = "";
	if(isValued){//如果xyValue有值
			if(xyValue == "0"){
				//如果等于零，判断numValues是否为零
				if (input_num.value == "0") {
					return xyValue;
				}else{
					tempValue = input_num.value;
				}
			}else{//xyValue != 0
					tempValue = input_num.value;
			}
		}else{//如果yValue没有值
			tempValue = input_num.value;
		}

		if (isOptr) {
			yValue == "0" ? yValue = tempValue : yValue += tempValue;
			//screamShow += yValue;
			screamShow = getStr(screamShow);
			screamShow += yValue;
			isYValued = true;
			//document.getElementById("result_id").value = screamShow;
			return yValue;
		}else{
			xValue == "0" ? xValue = tempValue : xValue += tempValue;
			screamShow = xValue;
			isXValued = true;
			//document.getElementById("result_id").value = screamShow;
			return xValue;
		}

		return "";
}

//获取dot
function getDot(dots){
	if (!isXValued) {
		xValue = "0";
		xValue += dots.value;
		isXDot = true;
		result = "";
		document.getElementById("result_id").value = xValue;
		return;
	}

	if (isOptr) {
		if (isYDot) {
			return ;
		}else {
			if (!isYValued) {
				yValue = "0";
				yValue += dots.value;
				isYDot = true;
				result = "";
				document.getElementById("result_id").value = xValue + optr + yValue;
			}else{
				yValue += dots.value;
				document.getElementById("result_id").value = xValue + optr + yValue;
			}
			
		}
	}else{
		if (isXDot) {
			return ;
		}else {
		xValue += dots.value;
		isXDot = true;
		document.getElementById("result_id").value = xValue;
		}
	}
}


//获取运算符
function getOptr(optrs){
	if (result != "") {
		return ;
	}

	if (!isXValued) {
		return ;
	}

	if (!isYValued) {
		optr = optrs.value;
		if(isOptr && isYValued){
			;
		}else if (isOptr) {
			screamShow = screamShow.replace(screamShow[screamShow.length-1], optr);
		}else{
			screamShow += optr;
		}

		isOptr = true;
	}
	
	document.getElementById("result_id").value = screamShow;
}

//获取数值
function getSpecialValue(){
	if (!isXValued && !isYValued && !isOptr) {
		return ;
	}

	if (isXValued && isYValued) {
		var return_value = null;
		switch(optr){
			case "+":
				return return_value = parseFloat(xValue) + parseFloat(yValue);
			case "-":
				return return_value = parseFloat(xValue) - parseFloat(yValue);
			case "*":
				return return_value = parseFloat(xValue) * parseFloat(yValue);
			case "/":
				return return_value = parseFloat(xValue) / parseFloat(yValue);
			default:
				break;
		}
	}

	if (!isYValued) {
		return xValue;
	}

	return "";
}

//PI操作
function getPI(){
	document.getElementById("result_id").value = Math.PI;
	clear_context(false);
}

//SIN操作
function getSin(){
	if (xValue == "") {
		return ;
	}

	document.getElementById("result_id").value = Math.sin(getSpecialValue());
	clear_context(false);
}

//COS操作
function getCos(){
	if (xValue == "") {
		return ;
	}
 
	document.getElementById("result_id").value = Math.cos(getSpecialValue());
	clear_context(false);
}

//Tan操作
function getTan(){
	if (xValue == "") {
		return ;
	}

	document.getElementById("result_id").value = Math.tan(getSpecialValue());
	clear_context(false);
}

//log操作
function getLog(){
	if (xValue == "") {
		return ;
	}

	document.getElementById("result_id").value = Math.log(getSpecialValue());
	clear_context(false);
}

//sqrt操作
function getSqrt(){
	if (xValue == "") {
		return ;
	}

	document.getElementById("result_id").value = Math.sqrt(getSpecialValue());
	clear_context(false);
}

//1/x操作
function get1_x(){
	if (xValue == "") {
		return ;
	}

	if (parseFloat(xValue) == 0) {
		document.getElementById("result_id").value = "除数不能为0";
		clear_context(false);
		return ;
	}

	document.getElementById("result_id").value = 1 / parseFloat(xValue);
	clear_context(false);
}

//平方操作
function getSquare(){
	if (xValue == "") {
		return ;
	}

	document.getElementById("result_id").value = parseFloat(getSpecialValue()) * parseFloat(getSpecialValue());
	clear_context(false);
}


//获取数值
function getNumber(numValues){
	var showInput = document.getElementById("result_id");
	//showInput.value = numValues.value;
	//如果执行了操作符，则给Y值赋值
	getResultAndReset();
	if (isOptr){
		getXorYValue(isYValued, yValue, numValues);
	}else{
		getXorYValue(isXValued, xValue, numValues);
	}

	showInput.value = screamShow;
}

//运算
function operator(){
	switch (optr) {
		case "/":
			if (parseFloat(yValue) == 0) {
				document.getElementById("result_id").value = "除数不能为0";
				result = "除数不能为0";
				xValue = "";
				isXValued = false;
			}else{
				result = parseFloat(xValue) / parseFloat(yValue);
				document.getElementById("result_id").value = result;
				clear_context(false);
			}
			break;
		case "*":
			result = parseFloat(xValue) * parseFloat(yValue);
			document.getElementById("result_id").value = result;
			clear_context(false);
			break;
		case "-":
			result = parseFloat(xValue) - parseFloat(yValue);
			document.getElementById("result_id").value = result;
			clear_context(false);
			break;
		case "+":
			result = parseFloat(xValue) + parseFloat(yValue);
			document.getElementById("result_id").value = result;
			clear_context(false);
			break;
		default:
			break;
	}
}


//清空
function clear_context(param){
	//x赋值
	xValue = "";
	//y赋值
	yValue = "";
	//结果
	resulut = "";
	//屏显
    screamShow = "";
	//dotValue
	var xDot = "";
	var yDot = "";
	//dot是否赋值
	isXDot = false;
	isYDot = false;
	//操作符
	optr = "";
	//操作符是否赋值
	isOptr = false;
	//赋值符号
	symbol = "";
	//zero是否赋值
	isZero = false;
	//x是否赋值
	isXValued = false;
	//y是否赋值
	isYValued = false;
	if (param) {
		document.getElementById("result_id").value = "";
	}
}

function calculator(targetValue){
	switch(targetValue.value){
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9":
		case "0":
			getNumber(targetValue);
			break;
		case "+":
		case "-":
		case "*":
		case "/":
			getOptr(targetValue);
			break;
		case ".":
			getDot(targetValue);
			break;
		case "=":
			operator();
			break;
		case "C":
			clear_context(true);
			break;
		case "sin":
			getSin();
			break;
		case "cos":
			getCos();
			break;
		case "tan":
			getTan();
			break;
		case "log()":
			getLog();
			break;
		case "1/x":
			get1_x();
			break;
		case "x²":
			getSquare();
			break;
		case "√":
			getSqrt();
			break;
		case "π":
			getPI();
			break;
		default:
			break;
	}
}

//DOM事件绑定
var btn1ClickEvent = document.getElementById("table_id");
btn1ClickEvent.addEventListener('click', function(e){
	calculator(e.target);
},false);
