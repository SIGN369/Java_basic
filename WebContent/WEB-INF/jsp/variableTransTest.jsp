	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	<%@ page  import ="javax.servlet.RequestDispatcher" %>
	<%@ page  import ="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
out.println("Your IP address is " + request.getRemoteAddr());

%>
<%
    Integer hitsCount = 
      (Integer)application.getAttribute("hitCounter");
    if( hitsCount ==null || hitsCount == 0 ){
       /* 第一次访问 */
       out.println("欢迎访问菜鸟教程!");
       hitsCount = 1;
    }else{
       /* 返回访问值 */
       out.println("欢迎再次访问菜鸟教程!");
       hitsCount += 1;
    }
    application.setAttribute("hitCounter", hitsCount);
%>

<p>页面访问量为: <%= hitsCount%></p>
<br>
今天的日期是: <%= (new java.util.Date()).toLocaleString()%>
<% String TeVat = "4545"; 
		request.setAttribute("name", "My name is xgx.");
		String address = request.getRemoteAddr();
	//关于域：
	/*
		page,request,session,application
	*/
	String decp = "Get variable from jsp";
	application.setAttribute("bar",decp );
%>
 <c:out value="&lt要显示的数据对象（未使用转义字符）&gt" escapeXml="true" default="默认值"></c:out>
 <c:out value="${bar }" escapeXml="true" default="默认值"></c:out>
 
 
 <%! 
  private int initVar=0;
  private int serviceVar=0;
  private int destroyVar=0;
%>
 <%!
  public void jspInit(){
    initVar++;
    System.out.println("jspInit(): JSP被初始化了"+initVar+"次");
  }
  public void jspDestroy(){
    destroyVar++;
    System.out.println("jspDestroy(): JSP被销毁了"+destroyVar+"次");
  }
%>

<%
  serviceVar++;
  System.out.println("_jspService(): JSP共响应了"+serviceVar+"次请求");

  String content1="初始化次数 : "+initVar;
  String content2="响应客户请求次数 : "+serviceVar;
  String content3="销毁次数 : "+destroyVar;
%>
<script type="text/javascript">
//js获取jsp中的变量，JSP需要服务器编译为java代码，也可以将变量存在域中使用jSTL表达式获取
//方法1：
	<%-- alert("<%= TeVat %>")
	alert("<%= address%>")
	//方法2：EL表达式获取
	alert('${name }')
	alert('${bar }') --%>
	//alert('${data }')
</script>
</body>
</html>