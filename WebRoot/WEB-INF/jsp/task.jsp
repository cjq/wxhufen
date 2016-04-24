<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>微信公众号互粉平台-任务发布</title>
  <base href="<%=basePath%>">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="">
  <meta name="keywords" content="">
  <meta name="viewport"
        content="width=device-width, initial-scale=1">

  <!-- Set render engine for 360 browser -->
  <meta name="renderer" content="webkit">

  <!-- No Baidu Siteapp-->
  <meta http-equiv="Cache-Control" content="no-siteapp"/>

  <link rel="icon" type="image/png" href="assets/i/favicon.png">

  <link rel="stylesheet" href="assets/css/amazeui.min.css">
  <link rel="stylesheet" href="assets/css/app.css">
</head>
	<script src="assets/js/jquery.min.js"></script>
	<!-- 显示文件名字 -->
	<script>
	  $(function() {
		$('#doc-form-file').on('change', function() {
		  var fileNames = '';
		  $.each(this.files, function() {
			fileNames += '<span class="am-badge">' + this.name + '</span> ';
		  });
		  $('#file-list').html(fileNames);
		});
	  });
</script>
	
<body>
<!-- 头部 -->
  <header class="am-topbar am-topbar-inverse am-topbar-fixed-top">
  <h1 class="am-topbar-brand">
    <a href="#">wxhufen</a>
  </h1>

  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#doc-topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

  <div class="am-collapse am-topbar-collapse" id="doc-topbar-collapse">
    <ul class="am-nav am-nav-pills am-topbar-nav">
      <li><a href="${pageContext.request.contextPath }/mp">公众号互粉</a></li>
	  <li><a href="#">图文求阅读</a></li>
      <li class="am-active"><a href="${pageContext.request.contextPath }/task/add">发布任务</a></li>
	  <li><a href="${pageContext.request.contextPath }/course">使用说明</a></li>
    </ul>
    
    <div class="am-topbar-right">
    	<br/>
    	用户:${user.username }
    	ID:${user.userid }
    	积分:${user.point }
    </div>
    
  </div>
</header>
<!-- 头部结束 -->

<!-- 主体 -->
<div class="am-g">
  <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
	
	<!-- 分割线 -->
	<hr data-am-widget="divider" style="" class="am-divider am-divider-default"/>
	
	<form action="${pageContext.request.contextPath }/task/verify" method="post" class="am-form" enctype="multipart/form-data">

	<div id="file-list"></div>
	<div class="am-form-group am-form-file">
		<button type="button" class="am-btn am-btn-danger am-btn-sm">
		<i class="am-icon-cloud-upload"></i>选择二维码图片</button>
		<input id="doc-form-file" type="file" name="imagefile" multiple>
		<p class="am-text-danger">${errors["imagefile"] }</p>
	</div>
	
	<p><input type="text" name="mpname" class="am-form-field am-radius" placeholder="微信公众号名称" value="${mp.mpname }" /></p><p class="am-text-danger">${errors["mpname"] }</p>
	<p><input type="text" name="mpid" class="am-form-field am-radius" placeholder="原始ID" value="${mp.mpid }" /></p><p class="am-text-danger">${errors["mpid"] }</p>
	<p><input type="text" name="taskpoint" class="am-form-field am-radius" placeholder="任务积分(10-50分之间,任务积分越多，排名靠前，获得粉丝越快)" value="${mp.taskpoint }" /></p><p class="am-text-danger">${errors["mptaskpoint"] }</p>
	<p><input type="text" name="totalcount" class="am-form-field am-radius" placeholder="任务执行总次" value="${mp.totalcount }" /></p><p class="am-text-danger">${errors["totalcount"] }</p>
	
	<p class="am-text-secondary">1.请前往 微信公众号平台(mp.weixin.qq.com)-(开发)基本配置-服务器配置-修改如下信息:</p>
	<p class="am-text-success">URL(服务器地址):http://www.wxhufen.com/verify</p>
	<p class="am-text-success">Token(令牌):wxhufen</p>
	
	<p class="am-text-danger">2.以上配置好后给微信公众号发条任意信息</p>
	
	<p>
		<button type="submit" class="am-btn am-btn-default">检验和提交</button>
		<a href="${pageContext.request.contextPath }/course" target=_blank>使用指南</a>
	</p>
	
	</form>	
	<!-- 分割线 -->
	<hr data-am-widget="divider" style="" class="am-divider am-divider-default"/>
		
  </div>
</div>
<!-- 主体结束 -->

<script src="assets/js/amazeui.min.js"></script>

</body>
</html>
