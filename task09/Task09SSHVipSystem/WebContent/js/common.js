$(function(){
    //参数设置，若用默认值可以省略以下面代
    toastr.options = {
        "closeButton": false, //是否显示关闭按钮
        "debug": false, //是否使用debug模式
        "positionClass": "toast-bottom-center",//弹出窗的位置
        "showDuration": "300",//显示的动画时间
        "hideDuration": "1000",//消失的动画时间
        "timeOut": "5000", //展现时间
        "extendedTimeOut": "1000",//加长展示时间
        "showEasing": "swing",//显示时的动画缓冲方式
        "hideEasing": "linear",//消失时的动画缓冲方式
        "showMethod": "fadeIn",//显示时的动画方式
        "hideMethod": "fadeOut" //消失时的动画方式
        };
 
        //成功提示绑定
        $("#aboutmessage").click(function(){
        toastr.success("VIP查询系统 [v1.0.0.1]");
        })
        

         
      //信息提示绑定
      $("#goodsAddSuccess").click(function(){
      toastr.success("商品添加成功！");
      })
//       
//      //敬告提示绑定
//      $("#warning").click(function(){
//      toastr.warning("警告你别来烦我了");
//      })
//       
//      //错语提示绑定
//      $("#error").click(function(){
//      toastr.error("出现错误，请更改");
//      })
//       
//      //清除窗口绑定
//      $("#clear").click(function(){
//      toastr.clear();
//      })
    });  
    
    
function toVaild(){
	
	var pin = document.getElementById("pwd").value;
	var rtPin = document.getElementById("rtpwd").value;
	if(pin.equal(rtPin)){
		return true;
	}
	else{
		alter("两次输入密码不同，请重新输入。");
		return false;
	}
	
}  



function checkNum(obj) {
     //检查是否是非数字值
     if (isNaN(obj.value)) {
         obj.value = "";
     }
 };
 
 
    