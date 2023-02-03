
<%@page import="java.sql.ResultSet"%>
<%@page import="dppackage.Dbconnector"%>
<%@page import="java.sql.PreparedStatement"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% boolean ispostback = false;
    if (request.getParameter("check") != null) {
        ispostback = true;
    }
    if (ispostback) {
int sno=Integer.parseInt(request.getParameter("submit"));
System.out.println(sno);
response.sendRedirect("patient.jsp?sno="+sno);
    }   
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    </head>
    <body>
        <div class="container-fluid" style="background-color: brown;">
            <center>
                <table class="table-borderless">

                    <tr class="row ms-5 mt-5">
                        <td class="col-2"><button type="button" class="btn btn-primary" style="width: 9rem; height: 5rem; font-size: xx-large;">S No</button></td>
                        <td class="col-2"><button type="button" class="btn btn-primary" style="width: 9rem; height: 5rem; font-size: x-large;">Start Time</button></td>
                        <td class="col-2"><button type="button" class="btn btn-primary" style="width: 9rem; height: 5rem; font-size: x-large;">End Time</button></td>
                        <td class="col-2"><button type="button" class="btn btn-primary" style="width: 9rem; height: 5rem; font-size: x-large;">Status</button></td>
                        <td class="col-2"><button type="button" class="btn btn-primary" style="width: 9rem; height: 5rem; font-size: x-large;">patient</button></td>

                    </tr>
                    <%try{
                        PreparedStatement ps = Dbconnector.connection().prepareStatement("select* from bookingslot order by sno");
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                          
                    %>
                    <tr class="row ms-5 mt-5">
                    <form method="post">
                        <input type="hidden" name="check" >
                        <td class="col-2"><button type="button" class="btn btn-light" style="width: 9rem; height: 5rem; font-size: x-large;"><%=rs.getObject("sno")%></button></td>
                        <td class="col-2"><button type="button" class="btn btn-light" style="width: 9rem; height: 5rem; font-size: x-large;"><%=rs.getObject("starttime")%></button></td>
                        <td class="col-2"><button type="button" class="btn btn-light" style="width: 9rem; height: 5rem; font-size: x-large;"><%=rs.getObject("endtime")%></button></td>
                        <td class="col-2"><button type="button" class="btn btn-light" style="width: 9rem; height: 5rem; font-size: x-large;"><%=rs.getObject("status")%></button></td>
                        <td class="col-2"><button type="button" class="btn btn-light"  style="width: 9rem; height: 5rem; font-size: x-large;"><%=rs.getObject("patient")%></button></td>
                        <%
                        if((rs.getObject("book_cancel")).equals("Booknow")){%>
                        <td class="col-2"><button type="submit" class="btn btn-success" name="submit" value="<%=rs.getObject("sno")%>" style="width: 9rem; height: 5rem; font-size: x-large;"><%=rs.getObject("book_cancel")%></button></td>
                               <%}
                            else {%>
                          <td class="col-2"><button type="submit" class="btn btn-danger" name="submit" value="<%=rs.getObject("sno")%>" style="width: 9rem; height: 5rem; font-size: x-large;"><%=rs.getObject("book_cancel")%></button></td>

                            <%}%>
                    </form>
                    </tr>            
                    <%}
                     } 
                    catch(Exception ex){
                           out.println(ex);
                               }%>


                </table>
            </center>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

    </body>
</html>
