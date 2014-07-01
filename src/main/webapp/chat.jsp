<%@ page import="tere.Person" %>
<%@ page import="tere.Manipulator" %>
<%@ page import="tere.Messager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>chat</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body bgcolor="#3579b9" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">

<%
    String myNameInJSP=request.getParameter("myName");
    Person person = new Person(myNameInJSP);
    Manipulator manipulator = Manipulator.getInstance();
    if(manipulator.checkAbilityToAddPersonToTeam(person) == false){
        String redirectURL = "indexChat.jsp";
        response.sendRedirect(redirectURL);
    }else {
        manipulator.adderPersonToTeam(person);
    }
%>
<script src="http://code.jquery.com/jquery-2.1.1.js"></script>
<script language="JavaScript" type="text/javascript" src="/js/jquery-1.2.6.min.js"></script>
<script language="JavaScript" type="text/javascript" src="/js/jquery-ui-personalized-1.5.2.packed.js"></script>
<script language="JavaScript" type="text/javascript" src="/js/sprinkle.js"></script>

<script language="JavaScript" type="text/javascript">
    var myVar=setInterval(function(){refreshHistory()},1000);
    var myVar=setInterval(function(){myTimer()},30000);


    function refreshHistory() {
        $.ajax({
            url: 'http://localhost:9099/?typeOfRequest=getHistory',
            contentType: "charset=UTF-8"
        })
                .done(function(response) {
                    console.log("--------------------------");
                    // response = {"dateString":"2012-03-06T02:18:25+00:00"}
                    //// "2012-03-06T02:18:25+00:00"

                    document.getElementById("messages").innerHTML=response;
                    console.log(response);
                });
        var block = document.getElementById("messages");
        block.scrollTop = block.scrollHeight;
    }


    function myTimer() {
        $.ajax({
            url: 'http://localhost:9099/?typeOfRequest=getUsersOnline',
            contentType: "charset=UTF-8"
        })
                .done(function(response) {
                    console.log("--------------------------");
                    // response = {"dateString":"2012-03-06T02:18:25+00:00"}
                    //// "2012-03-06T02:18:25+00:00"

                    document.getElementById("contacts").innerHTML=response;
                    console.log(response);
                });
    }


    function senderMessage(){
        var myUser = document.getElementById("myСontact").innerText;
        var message = document.getElementById("myMessage").value;
        $.ajax({
            url: 'http://localhost:9099/?typeOfRequest=sendMessage&message=' + message  + "&myUser=" + myUser,
            contentType: "charset=UTF-8"
        });
        console.log("@@@" + myUser);
        console.log("@@@" + message);
        document.getElementById("myMessage").value ="";
    }
</script>

<form>
<table align="center">
    <tr>
        <td background="http://upload.akusherstvo.ru/image650925.gif" width="1200" height="1098" alt=""align="right" >
            <div  style="height: 650px; width: 850px; border: 0px solid black; ">
                <div  style="height: 650px; width: 300px; border: 0px solid black; float: left; ">
                    <div id="myСontact" style="height: 65px; width: 300px; text-align: center;  border: 0px solid black; "><%=myNameInJSP%></div>
                    <div id="contacts" style="height: 580px; width: 300px; border: 0px solid black; ">  </div>
                </div>
                <div  style="height: 650px; width: 545px; border: 0px solid black; float: right; ">
                    <div align="left" id="messages" style="max-height:100%;overflow:auto; height: 580px; width: 543px; border: 0px solid black; "> </div>
                    <div  style="height: 65px; width: 545px; border: 0px solid black; float: left;">
                        <input align="center" type="text" name="myMessage" style="margin-left: 60px; float:left; " id="myMessage" MAXLENGTH=70" SIZE="45">
                        <input  align="center" type="button" name="send" style="margin-left: 5px; float:left; " value=" Send message " onClick="senderMessage();">
                    </div>
                </div>
            </div>
            <div  style=" height: 249px; width: 800px; border: 0px solid black; "></div>
        </td>
    </tr>
</table>
</form>
</body>
</html>




