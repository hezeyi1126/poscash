;!function (win) {
	"use strict";
	
	var Pro = function(){
		this.name = "请求对象";
	};
	
	/**
	调用服务接口  service-服务名（springBean名）  method-调用的方法名   params-参数对象   , func 回调函数
	*/
	Pro.prototype.callServer= function(service ,method , params ,func){
	
		$.ajax({
				url:"/serviceCtl" , // 请求路径
				type:"POST" , //请求方式
				contentType: "application/json; charset=utf-8",
				data:JSON.stringify({
					serviceName : service,
					methodName : method,
					params : params
				}),
				success:function (res) {
					if(res.state == '-9'){
						top.window.location='/login.html';
					}
					func(res);
				},//响应成功后的回调函数
				error:function () {
					alert("出错啦...")
				},//表示如果请求响应出现错误，会执行的回调函数
				dataType:"json"//设置接受到的响应数据的格式
			});
		/*axios({
			    method: 'post',
			    url: '/serviceCtl',
			    data:{
			    	serviceName : service,
			    	methodName : method,
			    	params : params
			    }
		    }
		).then(function(res){
			func(res)
		});*/
	}
	
	
	
	
	win.pro = new Pro();
	
	win.loadCss = function(url) {
			var link = document.createElement('link');
			link.rel = "stylesheet";
			link.type = "text/css";
			link.href = url;
			var head = document.getElementsByTagName("head")[0];
			head.appendChild(link);
	};
}(window);


