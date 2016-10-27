/*
 * 定义三个函数。分别为获取数值：getNum，清空屏幕：clearContent，计算：calculateOperation，S获得结果：getResult。
 */

var result; //保存点击运算符之前输入框中的数值
var operator = ""; //保存运算符
var firstNum = ""; //首次输入值
var lastNum = ""; //运算符后面的值
var firstDot = false; //是否是首次中的小数点
var lastDot = false; //是否是运算符后面数字的小数点
var lastTemp = ""; //运算结果保存变量

function getNum(control) {
	var txt = document.getElementById('testdialog');
	//数值输入已经存在小数点,则不允许再输入小数点
	if (document.getElementById('testdialog').value == "NaN" || document.getElementById('testdialog').value == "Infinity") {
		document.getElementById('testdialog').value = "";
	}

	if (lastTemp != "" && operator == "") {
		return false;
	}

	if (operator == "") {
		if (firstNum == "") {
			if (control.value == '.') {
				return false;
			} else {
				firstNum = control.value;
			}
		} else {
			if (control.value == '.' && firstDot) {
				return false;
			} else if (control.value == '.' && !firstDot) {
				firstDot = true;
				firstNum += control.value;
			} else {
				if (firstNum.indexOf('.') <= -1) {
					if (control.value == "0") {
						return false;
					}
				}
				firstNum += control.value;
			}
		}
	} else {
		if (lastNum == "") {
			if (control.value == '.') {
				return false;
			} else {
				lastNum += control.value;
			}
		} else {
			if (control.value == '.' && lastDot) {
				return false;
			} else if (control.value == '.' && !lastDot) {
				lastDot = true;
				lastNum += control.value;
			} else {
				lastNum += control.value;
			}
		}
	}

	txt.value += control.value; //将控件值赋给数值输入框中
}

function clearContent() {
	document.getElementById('testdialog').value = "";
	result = "";
	operator = "";
	lastTemp = "";
}

// +、-、*、/ 事件
function calculateOperation(symbol) {
	//将运算符保存入全局变量中
	if (symbol.value == NaN) {
		return false;
	}

	if (operator != "") {
		if (symbol.value == "+" || symbol.value == "-" || symbol.value == "*" || symbol.value == "/") {
			return false;
		}
	}

	operator = symbol.value;
	var txt = document.getElementById('testdialog');
	if (txt.value == "")
		return false;

	txt.value += operator;
	return true;
}


function getResult() {
	var opValue;
	var txt = document.getElementById('testdialog');
	//计算表达式中存在运算符
	if (lastTemp != "") {
		if (operator == '*') {
			opValue = parseFloat(lastTemp) * parseFloat(lastNum);
		} else if (operator == '/') {
			opValue = parseFloat(lastTemp) / parseFloat(lastNum);
		} else if (operator == '+') {
			opValue = parseFloat(lastTemp) + parseFloat(lastNum);
		} else if (operator == '-') {
			opValue = parseFloat(lastTemp) - parseFloat(lastNum);
		} else if (operator == "" && firstNum == "" && lastNum == "" && lastTemp != "") {
			opValue = parseFloat(lastTemp);
		} else if (operator == "" && firstNum == "" && lastNum == "" && lastTemp == "") {
			opValue = "";
		}
		txt.value = opValue;
		if (txt.value == "Infinity") {
			lastTemp = "";
		} else {
			lastTemp = opValue;
		}
	} else {
		if (operator == '*') {
			opValue = parseFloat(firstNum) * parseFloat(lastNum);
		} else if (operator == '/') {
			opValue = parseFloat(firstNum) / parseFloat(lastNum);
		} else if (operator == '+') {
			opValue = parseFloat(firstNum) + parseFloat(lastNum);
		} else if (operator == '-') {
			opValue = parseFloat(firstNum) - parseFloat(lastNum);
		} else if (operator == "" && firstNum != "" && lastNum == "") {
			opValue = parseFloat(firstNum);
		} else if (operator == "" && firstNum == "" && lastNum == "") {
			opValue = "";
		}
		txt.value = opValue;
		if (txt.value == "NaN" || txt.value == "Infinity") {
			lastTemp = "";
		} else {
			lastTemp = opValue;
		}
	}

	result = "";
	opValue = "";
	firstNum = "";
	lastNum = "";
	operator = "";
	firstDot = false;
	lastDot = false;
}