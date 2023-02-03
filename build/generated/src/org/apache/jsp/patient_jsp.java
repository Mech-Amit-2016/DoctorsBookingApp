package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import dppackage.Dbconnector;
import java.sql.PreparedStatement;

public final class patient_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    if(n!=0)
    out.println("slot booked");
    else
        out.println("not booked");
}

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>patient details</title>\n");
      out.write("            <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-color: darkorange\">\n");
      out.write("            \n");
      out.write("        <form method=\"get\">\n");
      out.write("            \n");
      out.write("            <input type=\"hidden\" name=\"check\">\n");
      out.write("            <div class=\"form-floating mb-3\">\n");
      out.write("                <input required type=\"text\" class=\"form-control\" id=\"floatingInput\" placeholder=\"name@example.com\" value=\"");
      out.print(sno);
      out.write("\" name=\"sno\">\n");
      out.write("              <label for=\"floatingInput\">Serial No</label>\n");
      out.write("</div>\n");
      out.write("            <br>\n");
      out.write("            <h3>enter patient name</h3>\n");
      out.write("            </br>\n");
      out.write("          <div class=\"form-floating mb-3\">\n");
      out.write("              <input type=\"text\" class=\"form-control\" id=\"floatingName\" placeholder=\"name@example.com\" name=\"patient\" value=\"\">\n");
      out.write("          <label for=\"floatingName\">Patient Name</label>\n");
      out.write("          </div>\n");
      out.write("            <br>\n");
      out.write("             <div class=\"form-floating mb-3\">\n");
      out.write("              <input type=\"text\" class=\"form-control\" id=\"floatstarttime\" placeholder=\"name@example.com\" name=\"starttime\" value=\"");
      out.print(starttime);
      out.write("\">\n");
      out.write("          <label for=\"floatingName\">Start time</label>\n");
      out.write("          </div>\n");
      out.write("            <br>\n");
      out.write("             <div class=\"form-floating mb-3\">\n");
      out.write("              <input type=\"text\" class=\"form-control\" id=\"floatendtime\" placeholder=\"name@example.com\" name=\"endtime\" value=\"");
      out.print(endtime);
      out.write("\">\n");
      out.write("          <label for=\"floatingName\">End time</label>\n");
      out.write("          </div>\n");
      out.write("            <br>\n");
      out.write("            <button type=\"submit\" class=\"btn btn-success\" name=\"submit\"  style=\"width: 9rem; height: 5rem; font-size: x-large;\">Submit</button>\n");
      out.write("        </form>\n");
      out.write("                <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4\" crossorigin=\"anonymous\"></script>\n");
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
