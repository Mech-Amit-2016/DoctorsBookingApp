<%-- 
    Document   : patient
    Created on : Feb 2, 2023, 10:27:43 AM
    Author     : DELL
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="dppackage.Dbconnector"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PreparedStatement ps=Dbconnector.connection().prepareStatement("select* from bookingslot where sno=?");
    String sno=request.getParameter("sno");
      ps.setString(1,sno);
       ResultSet rs=ps.executeQuery();
       String starttime="",endtime="";
       if(rs.next()){
           starttime=""+rs.getObject("starttime");
           endtime=""+rs.getObject("endtime");
       }
boolean ispostback=false;
if(request.getParameter("check")!=null)
ispostback=true;


if(ispostback){
    sno=request.getParameter("sno");
     ps=Dbconnector.connection().prepareStatement("update bookingslot set patient=?,book_cancel=?,status=? where sno=?");
    ps.setString(1,request.getParameter("patient"));
    ps.setString(2,"cancel");
    ps.setString(3,"Booked");
    ps.setString(4,sno);
    int n=ps.executeUpdate();
    if(n!=0){
    out.println("slot booked");
    response.sendRedirect("printreceipt.jsp?sno="+sno);
    }
    else
        out.println("not booked");
}
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>patient details</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    </head>
    <body style="background-color: darkorange">
            
        <form method="get">
            
            <input type="hidden" name="check">
            <div class="form-floating mb-3">
                <input required type="text" class="form-control" id="floatingInput" placeholder="name@example.com" value="<%=sno%>" name="sno">
              <label for="floatingInput">Serial No</label>
</div>
            <br>
           
          <div class="form-floating mb-3">
              <input type="text" class="form-control" id="floatingName" placeholder="name@example.com" name="patient" value="">
          <label for="floatingName">Enter Patient Name</label>
          </div>
            <br>
             <div class="form-floating mb-3">
              <input type="text" class="form-control" id="floatstarttime" placeholder="name@example.com" name="starttime" value="<%=starttime%>">
          <label for="floatingName">Start time</label>
          </div>
            <br>
             <div class="form-floating mb-3">
              <input type="text" class="form-control" id="floatendtime" placeholder="name@example.com" name="endtime" value="<%=endtime%>">
          <label for="floatingName">End time</label>
          </div>
            <br>
            <button type="submit" class="btn btn-success" name="submit"  style="width: 9rem; height: 5rem; font-size: x-large;">Submit</button>
        </form>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

    </body>
</html>
