<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <base href="<%=basePath%>">
    
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="">
  <meta name="keywords" content="">
  <meta name="viewport"
        content="width=device-width, initial-scale=1">
  <title>微信公众号互粉平台-用户注册</title>

  <!-- Set render engine for 360 browser -->
  <meta name="renderer" content="webkit">

  <!-- No Baidu Siteapp-->
  <meta http-equiv="Cache-Control" content="no-siteapp"/>

  <link rel="icon" type="image/png" href="assets/i/favicon.png">

  <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/amazeui.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/app.css">
  
</head>
<body>

<script src="${pageContext.request.contextPath }/assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/amazeui.min.js"></script>

<div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
<form action="${pageContext.request.contextPath }/regisSubmit" class="am-form" id="doc-vld-msg" method="post">
  <fieldset>
    <legend>用户注册</legend>
    <div class="am-form-group">
      <label for="doc-vld-name-2-1">用户名：</label>
      <input type="text" id="doc-vld-name-2-1" name="username" minlength="3" placeholder="输入用户名（至少 3 个字符）" required/><p class="am-text-danger">${errors["username"] }</p>
	  <p class="am-text-danger"></p>
    </div>
	
	<div class="am-form-group">
      <label for="doc-vld-pwd-1">密码：</label>
      <input type="password" id="doc-vld-pwd-1" name="password" placeholder="请输入长度为6以上的密码" required/><p class="am-text-danger">${errors["password"] }</p>
	  <p class="am-text-danger"></p>
    </div>

    <div class="am-form-group">
      <label for="doc-vld-pwd-2">确认密码：</label>
      <input type="password" id="doc-vld-pwd-2" name="samePassword" placeholder="请与上面输入的值一致" data-equal-to="#doc-vld-pwd-1" required/><p class="am-text-danger">${errors["samePassword"] }</p>
	  <p class="am-text-danger"></p>
    </div>
	
    <div class="am-form-group">
      <label for="doc-vld-email-2-1">邮箱：</label>
      <input type="email" id="doc-vld-email-2-1" name="email" placeholder="输入邮箱" required/><p class="am-text-danger">${errors["email"] }</p>
	  <p class="am-text-danger"></p>
    </div>

    <button class="am-btn am-btn-secondary" type="submit">提交</button>
  </fieldset>
</form>
<div>
<p>© 2016 3.5 www.wxhufen.com</p>
</body>
</html>
