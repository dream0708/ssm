<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
<title>航天长征睿特科技有限公司上海分公司-首页</title>
<style type="text/css">
*{margin:0px;padding:0px;font-family: "微软雅黑";list-style-type:none}
.radius6{
   border-top-left-radius: 6px; 
   border-top-right-radius: 6px; 
   border-bottom-left-radius: 6px; 
   border-bottom-right-radius: 6px; 
   text-align:center;
}
.line{
    background-image: url('images/line.png');
    background-position: -100px -584px;
    background-repeat: repeat-x;
    width:400px;height:5px;
    clear:both;
    
}
a.news:link , a.news:visited{
    height: 25px;
    display:block;
    color:black;
    line-height:25px;
    overflow:hidden;
    font-size:20px;
    text-decoration: none;
}
a.news:hover{
    height: 25px;
    display:block;
    color:red;
    line-height:25px;
    overflow:hidden;
    font-size:20px;
    text-decoration:underline;
}
.lm a:link , .lm a:visited{
    font-size:14x;
	font-weight:600;
	text-decoration:none;
	color:RGB(11,11,11);
}
.lm a:hover{
    font-size:14x;
	text-decoration:underline;
	font-weight:600;
	color:RGB(100,11,11);
}
.lm{
    text-indent:15px;
	line-height:20px;
	font-weight:600;
	font-size:14px;
}
.contract{

    height:30px;
	width:100%;
	color:RGB(11,11,11);
	font-size:14px;
	font-weight:600;
	text-indent:15px;
}
a.tm:link, a.tm:visited{
    display:block;
	line-height:40px;
	text-indent:20px;
	text-decoration:none;
	color:RGB(11,11,11);
	font-weight:600;
}
a.tm:hover{
    text-decoration:underline;
	color:RGB(100,11,11);
}
ul li{
   width:120px;
   float:left;
   height:70px;
}
ul li a:link, ul li a:visited{
   text-decoration:none;
   color:RGB(11,11,11);
   font-size:14px;
   font-weight:700;
}
ul li a:hover{
   text-decoration:none;
   color:RGB(49,93,182);
   font-size:14px;
   font-weight:700;
}
ul li a:hover p{

   border-top-style:solid;border-top-color:RGB(98,138,220);width:100px;margin-top:5px;
}
</style>
</head>
<body>
<header style="width:100%;background-color:RGB(24,91,249);height:50px;">
	<div style="width:100%;max-width:1200px;margin:0 auto">
		<img src="<%=request.getContextPath() %>/resources/images/tel.png" style="display:block;float:left" width=40 height=50>
		<div style="color:RGB(228,228,228);font-weight:bold;line-height:50px;float:left">售前咨询:021-88888888  &nbsp;&nbsp;
		       QQ客服:3191058310
		</div>
		<img src="<%=request.getContextPath() %>/resources/images/weixin-logo.png" style="display:block;float:right" width=45 height=50>
		<div style="color:RGB(228,228,228);font-weight:bold;line-height:50px;float:right">企业官方微信扫一扫 &nbsp;
		</div>
	</div>
</header>
<div style="width:100%;background-color:RGB(255,255,255);height:120px;max-width:1200px;margin:0 auto">
      <div style="width:600px;height:120px;float:left" >
	     <div style="width:600px;height:25px;float:left"></div>
	     <img src="<%=request.getContextPath() %>/resources/images/logo.jpg" width=600 ></img>
	  </div>
	  <div style="width:600px;height:50px;float:left;padding:50px 0 20px 0;">
	    <ul>
		   <li><a href="#">首页<br>Home page<br><p ></p></a></li>
		   <li><a href="#">关于睿特<br>About us<br><p ></p></a></li>
		   <li><a href="#">服务项目<br>Service item<br><p></p></a></li>
		   <li><a href="#">资料下载<br>Data download<br><p></p></a></li>
		   <li><a href="#">睿特论坛<br>Ruite forum<br><p ></p></a></li>
        </ul>	
	  </div>
</div>
<div style="width:100%;margin-bottom:30px">
  <img src="<%=request.getContextPath() %>/resources/images/1.png" width=100%>
</div>
<div style="width:100%;max-width:1150px;margin:0 auto;height:150px;border-top-style:solid;border-top-color:RGB(98,138,220);padding-top:10px">
    <div style="background-color:RGB(99,189,243);width:195px;height:45px;line-height:45px;color:black;font-size:22px;font-weight:bold;float:left;margin-right:205px" class="radius6">行业新闻/睿特新闻</div>
	<div style="background-color:RGB(99,189,243);width:95px;height:45px;line-height:45px;color:black;font-size:22px;font-weight:bold;float:left" class="radius6">典型客户</div>

    <div style="clear:both"></div>
	<div style="height:100px;width:400px;float:left">
        <div  class="line"></div>
        <a href="#" class="news" title="xxxxx">1111111111111111111111111111111111111111111111111111111111</a>
        <div  class="line"></div>
        <a href="#" class="news" title="xxxxx">1111111111111111111111111111111111111111111111111111111111</a>
        <div  class="line"></div>
        <a href="#" class="news" title="xxxxx">1111111111111111111111111111111111111111111111111111111111</a>
        <div  class="line"></div>
	</div>
	<div style="height:100px;width:750px;float:left">
	   <img src="<%=request.getContextPath() %>/resources/images/customer.png" width=750 height=100>
	</div>
</div>
<div style="width:100%;height:140px;background:RGB(99,188,244);max-width:1150px;margin:0 auto;">
     <div style="height:140px;width:500px;float:left;">
	     <p style="height:40px;width:100%;font-size:20px;color:RGB(11,11,11);text-indent:15px;letter-spacing:5px;line-height:40px; font-family:宋体"><strong>为制造业提供最先进的技术引擎！</strong></p>
		 <p style="height:30px;width:100%;" class="lm">
		 <a href="#" target="_blank">企业简介</a> | <a href="#" target="_blank">企业文化</a> | <a href="#" target="_blank">公司荣誉</a> | <a href="#" target="_blank">发展历程</a> | <a href="#" target="_blank">联系我们</a> | <a href="#" target="_blank">公司地图</a>
		
	     </p>
		 <p style="height:30px;width:100%;" class="lm"> 
		  航天长征睿特科技有限公司上海分公司
		 </p>
		 <p style="height:30px;width:100%;" class="lm"> 
		  地址:&nbsp;上海市浦东新区张衡路180号1号楼2层A座
		 </p>
	 </div>
	 <div style="height:100px;width:300px;float:left;padding-top:40px;">
	     <div style="height:100%;width:40px;float:left;">
		      <img src="<%=request.getContextPath() %>/resources/images/tel.png" width=40 height=40 style="display:block;float:left">
		 </div>
		 <div style="height:100%;width:260px;float:left;">
		    
		    <p class="contract">客服电话：021-88888888</p>
		    <p class="contract">
		      在线 QQ：3191068310
		   </p>
		    <p class="contract">
		      传&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;真：021-50917557
		    </p>
		 </div>
	 </div>
	 
	  <div style="height:100px;width:200px;float:left;padding-top:40px;">
	        <img src="<%=request.getContextPath() %>/resources/images/mail-icon.png" style="display:block;float:left" width=40 height=40></img><a href="#" class="tm">企业邮箱</a>
			<div style="clear:both"></div>
	        <img src="<%=request.getContextPath() %>/resources/images/OA.png"  style="display:block;float:left" width=40 height=40></img><a href="http://218.244.157.172:88/" class="tm">OA登录</a>
	  </div>
	   <div style="height:120px;width:100px;float:left;padding-top:20px;">
	        <img src="<%=request.getContextPath() %>/resources/images/weixin.png" width=100 height=90></img>
			<div style="text-align:center;color:RGB(11,11,11);font-size:14px">企业微信<div>
	   <div>
</div>
<div style="width:100%;height:50px">
</div>

</body>
</html>