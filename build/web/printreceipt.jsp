<%@page import="java.sql.ResultSet"%>
<%@page import="dppackage.Dbconnector"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Receipt</title>
        <script>
            function doPrint() {
                let x = document.getElementById("bttnprint");
                x.style.visibility = "hidden";

                print();

                x.style.visibility = "visible";

            }

        </script>
    </head>
    <body>
        <%PreparedStatement ps=Dbconnector.connection().prepareStatement("select* from bookingslot where sno=?");
        String sno=request.getParameter("sno");
        ps.setString(1,sno);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
        %>
        
          <div class="form-floating mb-3"> 
              <input type="text" class="form-control" id="floatingName" placeholder="name@example.com" name="patient" value="<%=rs.getObject("patient")%>">
          <label for="floatingName">Patient Name</label>
          </div>
            <br>
             <div class="form-floating mb-3">
              <input type="text" class="form-control" id="floatstarttime" placeholder="name@example.com" name="starttime" value="<%=rs.getObject("starttime")%>">
          <label for="floatingName">Start time</label>
          </div>
            <br>
             <div class="form-floating mb-3">
              <input type="text" class="form-control" id="floatendtime" placeholder="name@example.com" name="endtime" value="<%=rs.getObject("endtime")%>">
          <label for="floatingName">End time</label>
          </div>
            <br>
        <input type="button" value="Print" onclick="doPrint()" id="bttnprint"/>
        <%}%>
    </body>
</html>
