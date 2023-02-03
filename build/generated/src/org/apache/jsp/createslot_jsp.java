package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dppackage.Dbconnector;
import java.sql.PreparedStatement;
import sourcefile.Slots;

public final class createslot_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("            <table class=\"table-borderless\">\n");
      out.write("               \n");
      out.write("                 <tr class=\"row ms-5 mt-5\">\n");
      out.write("                      <td class=\"col-2\"><button type=\"button\" class=\"btn btn-primary\" style=\"width: 9rem; height: 5rem; font-size: xx-large;\">S No</button></td>\n");
      out.write("                      <td class=\"col-2\"><button type=\"button\" class=\"btn btn-primary\" style=\"width: 9rem; height: 5rem; font-size: x-large;\">Start Time</button></td>\n");
      out.write("                      <td class=\"col-2\"><button type=\"button\" class=\"btn btn-primary\" style=\"width: 9rem; height: 5rem; font-size: x-large;\">End Time</button></td>\n");
      out.write("                      <td class=\"col-2\"><button type=\"button\" class=\"btn btn-primary\" style=\"width: 9rem; height: 5rem; font-size: x-large;\">Status</button></td>\n");
      out.write("                  </tr>\n");
      out.write("                ");
 int x=0;
                 int starthour=11,startminutes=30;
     int endhour=17,endminutes=30;
     int duration=20,breakduration=5;
     int totalstartminutes=Slots.convertHoursAndMinutesToMinutes(starthour, startminutes);
     int totalendminutes=Slots.convertHoursAndMinutesToMinutes(endhour, endminutes);
     int totalduration=duration+breakduration;
     int sno=1;
                 while(totalstartminutes+totalduration<=totalendminutes){
         int a[]=Slots.convertMinutesToHourAndMinutes(totalstartminutes);
         int hour=a[0],minute=a[1];
          int endmin=totalstartminutes+duration;                         
           int b[]=Slots.convertMinutesToHourAndMinutes(endmin);
           int h=b[0],m=b[1];
                
      out.write("\n");
      out.write("        <tr class=\"row ms-5 mt-5\">\n");
      out.write("                      <td class=\"col-2\"><button type=\"button\" class=\"btn btn-light\" style=\"width: 9rem; height: 5rem; font-size: x-large;\">");
      out.print(sno);
      out.write("</button></td>\n");
      out.write("                      <td class=\"col-2\"><button type=\"button\" class=\"btn btn-light\" style=\"width: 9rem; height: 5rem; font-size: x-large;\">");
      out.print(hour);
      out.write(':');
      out.print(minute);
      out.write("</button></td>\n");
      out.write("                      <td class=\"col-2\"><button type=\"button\" class=\"btn btn-light\" style=\"width: 9rem; height: 5rem; font-size: x-large;\">");
      out.print(h);
      out.write(':');
      out.print(m);
      out.write("</button></td>\n");
      out.write("                      <td class=\"col-2\"><button type=\"button\" class=\"btn btn-light\" style=\"width: 9rem; height: 5rem; font-size: x-large;\">Available</button></td>\n");
      out.write("                      <td class=\"col-2\"><button type=\"button\" class=\"btn btn-success\" style=\"width: 9rem; height: 5rem; font-size: x-large;\">Book</button></td>\n");
      out.write("                  </tr>            \n");
      out.write("                 \n");
  
    PreparedStatement ps=Dbconnector.connection().prepareStatement("insert into bookingslot values(?,?,?,?,?)");   
    ps.setString(1,""+sno);
    ps.setString(2,""+hour+":"+minute);
    ps.setString(3,""+h+":"+m);
    ps.setString(4,"available");
    ps.setString(5,"-");
    ps.executeUpdate();
    
     sno++;
         totalstartminutes+=totalduration;
}
                
      out.write("\n");
      out.write("              \n");
      out.write(" </table>\n");
      out.write("            </center>\n");
      out.write("        </div>\n");
      out.write("      \n");
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
