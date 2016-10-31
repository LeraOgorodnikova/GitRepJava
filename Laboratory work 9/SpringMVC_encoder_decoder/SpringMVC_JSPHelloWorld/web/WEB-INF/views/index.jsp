<!-- обратите внимание на spring тэги -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
  <title>Encoder_Decoder</title>
</head>

<body>
<spring:form method="post"  modelAttribute="decodeEncode" action="generateString">

  Enter line for encode: <spring:input path="lineEncode"/> <br/>
  Enter line for decode: <spring:input path="lineDecode"/>   <br/>
  <spring:button>Result</spring:button>

</spring:form>
</body>

</html>
