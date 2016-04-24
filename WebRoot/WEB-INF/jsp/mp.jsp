<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
  <title>微信公众号互粉平台</title>

  <!-- Set render engine for 360 browser -->
  <meta name="renderer" content="webkit">

  <!-- No Baidu Siteapp-->
  <meta http-equiv="Cache-Control" content="no-siteapp"/>

  <link rel="icon" type="image/png" href="assets/i/favicon.png">


<!-- http://cdn.amazeui.org/amazeui/1.0.1/css/amazeui.css -->
  <link rel="stylesheet" href="http://cdn.amazeui.org/amazeui/1.0.1/css/amazeui.css">
</head>

<script src="${pageContext.request.contextPath }/assets/js/jquery.min.js"></script>

<!-- 登录成功显示 -->
<c:choose>
	<c:when test="${user!=null }">
		<script type="text/javascript">
			$(function(){
				$(".userField").show();
				$(".regisField").hide();
			});
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			$(function(){
				$(".userField").hide();
			});
		</script>
	</c:otherwise>
</c:choose>

<!-- 登录跳转 -->
<script type="text/javascript">
	function login(){
		window.location = "${pageContext.request.contextPath }/login";
	}
</script>
<!-- 注册跳转 -->
<script type="text/javascript">
	function regis(){
		window.location = "${pageContext.request.contextPath }/regis";
	}
</script>

<!-- 页码点击 -->
<script type="text/javascript">
	function opclick(id){
		window.location=$('#'+id).val();
	}
</script>

<!-- 刷新点击 -->
<script type="text/javascript">
	$(document).ready(function(){ 
 		$("#fresh").on("click", function(){
			$.ajax({
			   type: "POST",
			   url: "${pageContext.request.contextPath }/fresh",
			   data: "username=${user.username }",
			   dataType:"text",
			   success: function(msg){
			     $("#point").text(msg);
			   }
			});
		});		  	 
 	}); 
</script>

<body>

<!-- 头部 -->
  <header class="am-topbar am-topbar-inverse">
  <h1 class="am-topbar-brand">
    <a>wxhufen</a>
  </h1>

  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#doc-topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

  <div class="am-collapse am-topbar-collapse" id="doc-topbar-collapse">
    <ul class="am-nav am-nav-pills am-topbar-nav">
      <li class="am-active"><a href="${pageContext.request.contextPath }/mp">公众号互粉</a></li>
	  <li><a href="#">图文求阅读</a></li>
      <li><a href="${pageContext.request.contextPath }/task/add">发布任务</a></li>
	  <li><a href="${pageContext.request.contextPath }/course">使用说明</a></li>
    </ul>

    <div class="am-topbar-right">
      <button class="am-btn am-btn-primary am-topbar-btn am-btn-sm am-btn-secondary regisField" onclick="regis()">注册</button>
    </div>

    <div class="am-topbar-right">
      <button class="am-btn am-btn-primary am-topbar-btn am-btn-sm regisField" onclick="login()">登录</button>
    </div>
    
    <div class="am-topbar-right userField">
    	<br/>
    	用户:${user.username }
    	ID:${user.userid }
    	积分:<a id="point">${user.point }</a>
    	<a id="fresh">刷新</a>
    </div>
    
    
    
  </div>
</header>
<!-- 头部结束 -->

<!-- 主体 -->
<div class="am-g">
  <div class="col-sm-8 col-lg-centered">
	
	<!-- 分割线 -->
	<hr data-am-widget="divider" style="" class="am-divider am-divider-default"/>
		
		<ul class="sm-block-grid-3">
		<c:forEach items="${page.list }" var="list">
		  <li><div>
			<div><img src="/imagefile/${list.qrcode}" height="100" width="170" align="left"/></div>
			<div style="background-color:#FFFAE7;">
				<p>
					<p class="am-icon-weixin am-text-secondary">${list.mpname }</p><br/>
					<font>获得粉丝:</font><font color="#FF65A2">${list.fnumber }</font> <br/>
					<font>可获积分:</font> <font color="#3366FF">${list.taskpoint }</font> <br/>
					<font>时间:<fmt:formatDate value="${list.time}" pattern="yy-MM-dd HH:mm:ss"/> </font> <br/>
				<p/> 
			</div>
		</div></li>
		</c:forEach>
		</ul>
		
	<!-- 分割线 -->
	<hr data-am-widget="divider" style="" class="am-divider am-divider-default"/>
		
		 <!-- 设置页码显示 -->
 		  <script type="text/javascript"> 
 		  	 $(document).ready(function(){ 
 			  	  var id = ${page.pageCode }; 
 				  $('#'+id).attr("selected","selected"); 
 			 }); 
 		 </script> 
		
		<!-- 分页 -->
		<ul data-am-widget="pagination" class="am-pagination am-pagination-select">
		  
		  <c:choose>
		  	<c:when test="${page.pageCode<=1 }">
			  	<li class="am-pagination-prev am-disabled">
				<a href="${pageContext.request.contextPath }/mp?pagecode=${page.pageCode-1}">上一页</a>
			    </li>
		  	</c:when>
		  	
		  	<c:otherwise>
			  	<li class="am-pagination-prev">
				<a href="${pageContext.request.contextPath }/mp?pagecode=${page.pageCode-1}">上一页</a>
			    </li>	
		  	</c:otherwise>
		  </c:choose>
		  
		  <!-- 设置页面显示 -->
		  		 
		  <li class="am-pagination-select">
			<select>
			<c:forEach var="pagecode" begin="1" end="${page.totalPage }">
			  <option value="${pageContext.request.contextPath }/mp?pagecode=${pagecode}" id="${pagecode}" onclick="opclick(${pagecode})" >${pagecode} / ${page.totalPage }</option>
			</c:forEach>
			</select>
		  </li>
		  
		  
		  <c:choose>
		  	<c:when test="${page.pageCode>=page.totalPage }">
			  	<li class="am-pagination-next am-disabled">
				<a href="${pageContext.request.contextPath }/mp?pagecode=${page.pageCode+1}">下一页</a>
			    </li>
		  	</c:when>
		  	
		  	<c:otherwise>
			  	<li class="am-pagination-next ">
				<a href="${pageContext.request.contextPath }/mp?pagecode=${page.pageCode+1}">下一页</a>
			    </li>	
		  	</c:otherwise>
		  </c:choose>
		  
		</ul>
		<!-- 分页结束 -->
		
  </div>
</div>

<div class="am-alert" data-am-alert>
  <button type="button" class="am-close">&times;</button>
  <p>扫描二维码关注后发送你的用户ID即可获得积分。</p>
</div>
<!-- 主体结束 -->
<script src="${pageContext.request.contextPath }/assets/js/amazeui.min.js"></script>
</body>
</html>