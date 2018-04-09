/**
 * 
 */

//    var userCode = $("#rand_code");
//    //登录开始   
//    $("#username").blur(function(){
//    	$(".tip").remove();
//    	if(userName.val() == 0){
//    		userName.after("<span class='tip'>用户名是必填的</span>");
//    	}
//    });
//    $("#password").blur(function(){
//    	$(".passTips").remove();
//    	if(userPassword.val().length == 0){
//    		userPassword.after("<span class='passTips'>密码是必填的</span>");
//    	}
//    });
	$('#password').bind('input propertychange', function() {
	    if($(this).val().length>1){
	    	$('#demo_img').show();
	    }else{
	    	$('#demo_img').hide();
	    }
	}); 
	
	$("#demo_img").click(function() {
		var demoImg = document.getElementById("demo_img");
		var demoInput = document.getElementById("password");
//		alert(demoInput.type);
//		alert($('#password').attr('type'));
		if (demoInput.type == "password") {
			demoInput.type = "text";
			demo_img.src = "/assets/images/invisible.png";
		}else {
			demoInput.type = "password";
			demo_img.src = "/assets/images/visible.png";
		}
	});
	function login(){
		window.location.href ="/home";
		
	}
	$('#userName').blur('input propertychange', function() {
//    	$(".tip").remove();
    	if($("#userName").val() == ""){
    		$(".name_lable").remove()
    		$("#userName").after("<span class='name_lable' style='color:red'>用户名是必填的</span>");
    	}else{
    		$(".name_lable").remove();
    	}
    });
//    $("#password").blur(function(){
    $('#password').blur('input propertychange', function() {
//    	$(".passTips").remove();
    	if($("#password").val() == ""){
    		$(".pass_lable").remove()
    		$("#password").after("<span class='pass_lable' style='color:red'>密码是必填的</span>");
    	}else{
    		$(".pass_lable").remove();
    	}
    });
$('#mail').blur('input propertychange', function() {
//    	$(".tip").remove();
	var mail = $.trim($('#mail').val());
	var isEmail = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	if(mail == ""){
		$(".mail").remove()
		$("#mail").after("<span class='mail' style='color:red'>邮箱是必填的</span>");
	}else if(!(isEmail.test(mail))){
		$(".mail").remove()
		$("#mail").after("<span class='mail' style='color:red'>邮箱格式不正确</span>");
	}else{
		$(".mail").remove();
	}
});
//    $("#password").blur(function(){
$('#cpassword1').blur('input propertychange', function() {
//    	$(".passTips").remove();
	if($("#cpassword1").val() == ""){
		$(".pass_lable2").remove()
		$("#cpassword2").after("<span class='pass_lable2' style='color:red'>请再次输入密码</span>");
	}else if($("#cpassword1").val() !=$("#password1").val() ){
		$("#cpassword2").after("<span class='pass_lable2' style='color:red'>两次密码不一致</span>");
	}else{
		$(".pass_lable2").remove();
	}
});
$('#userName1').blur('input propertychange', function() {
//    	$(".tip").remove();
	if($("#userName1").val() == ""){
		$(".name_lable1").remove()
		$("#userName1").after("<span class='name_lable1' style='color:red'>用户名是必填的</span>");
	}else{
		$(".name_lable1").remove();
	}
});
//    $("#password").blur(function(){
$('#password1').blur('input propertychange', function() {
//    	$(".passTips").remove();
	if($("#password1").val() == ""){
		$(".pass_lable1").remove()
		$("#password1").after("<span class='pass_lable1' style='color:red'>密码是必填的</span>");
	}else{
		$(".pass_lable1").remove();
	}
});

function checkLogin(arg1,arg2){
	var flag = false;
	var sign = false;
	var userName = arg1;
	var password = arg2;
//        	$(".tip").remove();
	if(userName == ""){
		flag = false;
		$(".name_lable").remove()
		$("#userName").after("<span class='name_lable' style='color:red'>用户名是必填的</span>");
	}else{
		flag = true;
		$(".name_lable").remove();
	}
//        $("#password").blur(function(){
//        	$(".passTips").remove();
	if(password== ""){
		sign = false;
		$(".pass_lable").remove()
		$("#password").after("<span class='pass_lable' style='color:red'>密码是必填的</span>");
	}else{
		sign = true;
		$(".pass_lable").remove();
	}
//		alert(userName);
//		alert(password);
//    	$("#userName").blur(function(){

	return flag && sign;
}
	function checkSign(arg1,arg2,arg3,arg4){
		var flag = false;
		var sign = false;
		var expm = false;
		var expc = false;
		var expp = false;
		var mail = arg1;
    	var userName = arg2;
		var password1 = arg3;
		var cpassword = arg4;
		var isEmail = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
		if(mail == ""){
			expm = false;
			$(".mail").remove()
			$("#mail").after("<span class='mail' style='color:red'>邮箱是必填的</span>");
		}else if(!(isEmail.test(mail))){
			expm = false;
			$(".mail").remove()
			$("#mail").after("<span class='mail' style='color:red'>邮箱格式不正确</span>");
		}else{
			expm = true;
			$(".mail").remove();
		}
		if(userName == ""){
			flag = false;
			$(".name_lable1").remove()
			$("#userName1").after("<span class='name_lable1' style='color:red'>用户名是必填的</span>");
		}else{
			flag = true;
			$(".name_lable1").remove();
		}
//        $("#password").blur(function(){
//        	$(".passTips").remove();
		if(password1== ""){
			expp = false;
			$(".pass_lable1").remove()
			$("#password1").after("<span class='pass_lable1' style='color:red'>密码是必填的</span>");
		}else{
			expp = true;
			$(".pass_lable1").remove();
		}
		if(cpassword== ""){
			expc = false;
			$(".pass_lable2").remove()
			$("#cpassword1").after("<span class='pass_lable2' style='color:red'>请再次输入密码</span>");
		}else if(cpassword != password1) {
			expc = false;
			$(".pass_lable2").remove()
			$("#cpassword1").after("<span class='pass_lable2' style='color:red'>两次密码不一致</span>");
		}else
		{
			expc = true;
			$(".pass_lable2").remove();
		}
//		alert(userName);
//		alert(password);
//    	$("#userName").blur(function(){
    	
        return flag && expc && expp && expm;
	}
	$("body").keydown(function() {
	    if (event.keyCode == "13") {//keyCode=13是回车键
	        $("#login-button").click();
	    }
	});

    $("#login-button").click(function() {
    	var userName = $("#userName").val();
    	var password = $("#password").val();
    	
    	var noEmpty = checkLogin(userName,password);
    	if(noEmpty==true){
    		
//    	alert(userName);
//    	alert(userPassword);
//    	 data:{"userName":userName,"password":password},
//    	$.post("demo_test.html",function(data,status){
//            alert("Data: " + data + "nStatus: " + status);
//        });
    	var $postUrl = "/login";
    	var $data = {"userName":userName,"password":password};
    	var $type = "json";
//    	$.post($postUrl,$data,$type);
    	$.ajax({
            //提交数据的类型 POST GET
            type:"POST",
            //提交的网址
            url:$postUrl,
            //提交的数据
            data:$data,
            //返回数据的格式
            datatype: "json",
            //在请求之前调用的函数
//            beforeSend:function(){$("#msg").html("logining");},
            //成功返回之后调用的函数             
            success: function(result){
//            	var fd = result["message"]
            	var ff = result["success"];
            	if(true==ff){
//            		alert("afdd");
//            		$.get("/user/login")
            		login();
            	}else{
            		alert( result["message"]);
            	}
//            	alert("返回的数据" + ff);
//            	alert("返回的数据" + fd);
//            	$.get("/user/login")
            }
            //调用执行后调用的函数
//            complete: function(XMLHttpRequest, textStatus){
//               alert(XMLHttpRequest.responseText);
//               alert(textStatus);
//                //HideLoading();
//            },
            //调用出错执行的函数
//            error: function(){
//                //请求出错处理
//            }         
         });
    	}
    	
    });
$("#sign-button").click(function() {
	var mail = $("#mail").val();
	var userName = $("#userName1").val();
	var password = $("#password1").val();
	var cpassword = $("#cpassword1").val();

	var noEmpty = checkSign(mail,userName,password,cpassword);
	//alert(noEmpty);
	if(noEmpty==true){

//    	alert(userName);
//    	alert(userPassword);
//    	 data:{"userName":userName,"password":password},
//    	$.post("demo_test.html",function(data,status){
//            alert("Data: " + data + "nStatus: " + status);
//        });
		var $postUrl = "/regist";
		var $data = {"mail":mail,"userName":userName,"password":password,"cpassword":cpassword};
		var $type = "json";
//    	$.post($postUrl,$data,$type);
		$.ajax({
			//提交数据的类型 POST GET
			type:"POST",
			//提交的网址
			url:$postUrl,
			//提交的数据
			data:$data,
			//返回数据的格式
			datatype: "json",
			//在请求之前调用的函数
//            beforeSend:function(){$("#msg").html("logining");},
			//成功返回之后调用的函数
			success: function(result){
//            	var fd = result["message"]
				var ff = result["success"];
				if(true==ff){
//            		alert("afdd");
//            		$.get("/user/login")
					login();
				}else{
					alert( result["message"]);
				}
//            	alert("返回的数据" + ff);
//            	alert("返回的数据" + fd);
//            	$.get("/user/login")
			}
			//调用执行后调用的函数
//            complete: function(XMLHttpRequest, textStatus){
//               alert(XMLHttpRequest.responseText);
//               alert(textStatus);
//                //HideLoading();
//            },
			//调用出错执行的函数
//            error: function(){
//                //请求出错处理
//            }
		});
	}


});
    $("#signOut").click(function() {
    	top.location.href = "/signOut"
    });
    
//    function checkForm(){
//        //jQuery取得用户输入的name，age,email值
//        var name = $("#clientname").val();
//        var age = $("#age").val();
//        var email = $("#email").val();
//        //如果名字为空
//        if(name == ""){
//        //假如name后面有lable标签，则清空后面的内容，即清除图中红色字体提示的“用户名不能为空”
//            $(".name_lable").empty();
//        //接着在类选择器.name后面添加一个lable标签
//            $("#clientname").after("<label class='name_lable'><font>用户名不能为空</font></label>");
//        }else{
//        //不为空就清空后面的红色提示，如“用户名不能为空”，使其消失
//            $(".name_lable").empty();
//        }
//        if(age == ""){
//        //同上
//            $(".age_lable").empty();
//            $("#age").after("<label class='age_lable'><font>年龄不能为空</font></label>");
//        }
//    
//        //如果年龄不为空且不是数字0-130之间，则在#age后面添加一个提示“年龄是0-130的数字”的提示；
//        else if(checkAge(age)== false){
//            $(".age_lable").empty();
//            $("#age").after("<label class='age_lable'><font>年龄是0-130的数字</font></label>");
//        }else{
//            $(".age_lable").empty();
//        }
//            //定义一个方法，校验年龄是否在0-130之间，是就返回true；
//        function checkAge(age){
//        var flag = false;
//        for(var i = 0; i<=130; i++){
//            if(age == i){
//                flag = true;
//                break;
//            }
//        }
//        return flag;
//       }
//    
//        if(email == ""){
//            $(".email_lable").empty();
//            //在email后面添加个lable标签用after
//            $("#email").after("<label class='email_lable'><font>邮箱不能为空</font></label>");
//        }else{
//            $(".email_lable").empty();
//        }
//        return false;
//    }
    //年