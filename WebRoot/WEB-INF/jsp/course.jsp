<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <base href="<%=basePath%>">
  <title>微信公众号互粉平台-使用教程</title>
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
	<script src="assets/js/amazeui.min.js"></script>
	<body>
<div class="am-panel-group" id="accordion">

  <div class="am-panel am-panel-default">
    <div class="am-panel-hd">
      <h4 class="am-panel-title" data-am-collapse="{parent: '#accordion', target: '#do-not-say-1'}">
   		     如何关注微信公众号获得积分？
      </h4>
    </div>
    <div id="do-not-say-1" class="am-panel-collapse am-collapse">
      <div class="am-panel-bd">
        <p class="am-text-danger">1.扫描二维码并关注<img src="assets/image/mp.png"/></p><hr style="height:1px;border:none;border-top:1px solid #000000;" />
		<p class="am-text-danger">2.发送你的ID<img src="assets/image/mp1.png" height="300" width="200"/></p><hr style="height:1px;border:none;border-top:1px solid #000000;" />
		<p class="am-text-danger">3.发送后即可获得积分<img src="assets/image/mp2.png" height="300" width="200"/></p><hr style="height:1px;border:none;border-top:1px solid #000000;" />
      </div>
    </div>
  </div>
  
  <div class="am-panel am-panel-default">
    <div class="am-panel-hd">
      <h4 class="am-panel-title" data-am-collapse="{parent: '#accordion', target: '#do-not-say-2'}">
  		      如何阅读图文获得积分？
      </h4>
    </div>
    <div id="do-not-say-2" class="am-panel-collapse am-collapse">
      <div class="am-panel-bd">
        ...
      </div>
    </div>
  </div>
  
  <div class="am-panel am-panel-default">
    <div class="am-panel-hd">
      <h4 class="am-panel-title" data-am-collapse="{parent: '#accordion', target: '#do-not-say-3'}">
		    如何发布任务？
	  </h4>
    </div>
    <div id="do-not-say-3" class="am-panel-collapse am-collapse">
      <div class="am-panel-bd">
        <P class="am-text-danger">1.登录微信公众号:<a  target="_black" href="https://mp.weixin.qq.com">微信公众号平台</a></P><hr style="height:1px;border:none;border-top:1px solid #000000;" />
     	<p class="am-text-danger">2.获取基本信息-点击进入公众号设置<img src="assets/image/setting1.png"/></p><hr style="height:1px;border:none;border-top:1px solid #000000;" />
     	<p class="am-text-danger">在这里可以下载公众号二维码获取到公众号名称和原始ID这些字段在发布任务的时候都是必须的<img src="assets/image/setting2.png"/></p><hr style="height:1px;border:none;border-top:1px solid #000000;" />
      	<p class="am-text-danger">3.设置服务器-点击进入(开发)基本配置<img src="assets/image/setting3.png"/></p><hr style="height:1px;border:none;border-top:1px solid #000000;" />
      	<p class="am-text-danger">在这里设置如图信息<img src="assets/image/setting4.png"/></p><hr style="height:1px;border:none;border-top:1px solid #000000;" />
      	<p class="am-text-danger">4.用自己的微信号给微信公众号发条信息以确定服务器是否配置好</p><hr style="height:1px;border:none;border-top:1px solid #000000;" />
      </div>
    </div>
  </div>
  
</div>
</body>
</html>