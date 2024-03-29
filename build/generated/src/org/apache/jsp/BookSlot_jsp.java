package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import dppackage.Dbconnector;
import java.sql.PreparedStatement;

public final class BookSlot_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
 boolean ispostback = false;
    if (request.getParameter("check") != null) {
        ispostback = true;
    }
    if (ispostback) {
      int sno=Integer.parseInt(request.getParameter("submit")); 
         PreparedStatement ps = Dbconnector.connection().prepareStatement("select* from bookingslot where sno=?");
         ps.setString(1,""+sno);
          ResultSet rs = ps.executeQuery();
          rs.next();
//          System.out.println(rs.getObject("status"));
          if(rs.getObject("status")=="Booked"){
              ps=Dbconnector.connection().prepareStatement("update bookingslot set status=?,patient=?,book_cancel=? where sno=?");
          ps.setString(1,"available");
          ps.setString(2,"--");
          ps.setString(3,"Booknow");
          ps.setString(4,""+sno);
          ps.executeUpdate();
          response.sendRedirect("Patient.jsp");
          }
        else{
System.out.println(sno);
response.sendRedirect("patient.jsp?sno="+sno);
        }
    }   

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container-fluid\" style=\"background-color: brown;\">\n");
      out.write("            <center>\n");
      out.write("                <table class=\"table-borderless\">\n");
      out.write("\n");
      out.write("                    <tr class=\"row ms-5 mt-5\">\n");
      out.write("                        <td class=\"col-2\"><button type=\"button\" class=\"btn btn-primary\" style=\"width: 9rem; height: 5rem; font-size: xx-large;\">S No</button></td>\n");
      out.write("                        <td class=\"col-2\"><button type=\"button\" class=\"btn btn-primary\" style=\"width: 9rem; height: 5rem; font-size: x-large;\">Start Time</button></td>\n");
      out.write("                        <td class=\"col-2\"><button type=\"button\" class=\"btn btn-primary\" style=\"width: 9rem; height: 5rem; font-size: x-large;\">End Time</button></td>\n");
      out.write("                        <td class=\"col-2\"><button type=\"button\" class=\"btn btn-primary\" style=\"width: 9rem; height: 5rem; font-size: x-large;\">Status</button></td>\n");
      out.write("                        <td class=\"col-2\"><button type=\"button\" class=\"btn btn-primary\" style=\"width: 9rem; height: 5rem; font-size: x-large;\">patient</button></td>\n");
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("                    ");
try{
                        PreparedStatement ps = Dbconnector.connection().prepareStatement("select* from bookingslot order by sno");
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                          
                    
      out.write("\n");
      out.write("                    <tr class=\"row ms-5 mt-5\">\n");
      out.write("                    <form method=\"post\">\n");
      out.write("                        <input type=\"hidden\" name=\"check\" >\n");
      out.write("                        <td class=\"col-2\"><button type=\"button\" class=\"btn btn-light\" style=\"width: 9rem; height: 5rem; font-size: x-large;\">");
      out.print(rs.getObject("sno"));
      out.write("</button></td>\n");
      out.write("                        <td class=\"col-2\"><button type=\"button\" class=\"btn btn-light\" style=\"width: 9rem; height: 5rem; font-size: x-large;\">");
      out.print(rs.getObject("starttime"));
      out.write("</button></td>\n");
      out.write("                        <td class=\"col-2\"><button type=\"button\" class=\"btn btn-light\" style=\"width: 9rem; height: 5rem; font-size: x-large;\">");
      out.print(rs.getObject("endtime"));
      out.write("</button></td>\n");
      out.write("                        <td class=\"col-2\"><button type=\"button\" class=\"btn btn-light\" style=\"width: 9rem; height: 5rem; font-size: x-large;\">");
      out.print(rs.getObject("status"));
      out.write("</button></td>\n");
      out.write("                        <td class=\"col-2\"><button type=\"button\" class=\"btn btn-light\"  style=\"width: 9rem; height: 5rem; font-size: x-large;\">");
      out.print(rs.getObject("patient"));
      out.write("</button></td>\n");
      out.write("                        ");

                        if((rs.getObject("book_cancel")).equals("Booknow")){
      out.write("\n");
      out.write("                        <td class=\"col-2\"><button type=\"submit\" class=\"btn btn-success\" name=\"submit\" value=\"");
      out.print(rs.getObject("sno"));
      out.write("\" style=\"width: 9rem; height: 5rem; font-size: x-large;\">");
      out.print(rs.getObject("book_cancel"));
      out.write("</button></td>\n");
      out.write("                               ");
}
                            else {
      out.write("\n");
      out.write("                          <td class=\"col-2\"><button type=\"submit\" class=\"btn btn-danger\" name=\"submit\" value=\"");
      out.print(rs.getObject("sno"));
      out.write("\" style=\"width: 9rem; height: 5rem; font-size: x-large;\">");
      out.print(rs.getObject("book_cancel"));
      out.write("</button></td>\n");
      out.write("\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                    </form>\n");
      out.write("                    </tr>            \n");
      out.write("                    ");
}
                     } 
                    catch(Exception ex){
                           out.println(ex);
                               }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                </table>\n");
      out.write("            </center>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4\" crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
