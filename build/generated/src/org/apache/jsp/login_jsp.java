package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>doTest - Login</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"./css/login.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container-login\">\n");
      out.write("        <div class=\"div-logo\">\n");
      out.write("            <a href=\"#\"><img src=\"./media/dotest.png\" alt=\"logo doTest\" width=\"40%\"/></a>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"main-login\">\n");
      out.write("            <div class=\"lg-left\">\n");
      out.write("                <p>Login</p>\n");
      out.write("                <form method=\"POST\" action=\"login\">\n");
      out.write("                    <p>Username:</p>\n");
      out.write("                    <input type=\"text\" placeholder=\"Enter username here\"/>\n");
      out.write("                    <p>Password:</p>\n");
      out.write("                    <input type=\"password\" placeholder=\"Enter password here\"/>\n");
      out.write("                    <input type=\"submit\" value=\"Login\"/>\n");
      out.write("                </form>\n");
      out.write("                <a href=\"#\">Don't you have any account?</a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"lg-right\">\n");
      out.write("                <p>About doTest?</p>\n");
      out.write("                <ul>\n");
      out.write("                    <li>doTest is a test generator that sports 4 question types, automatic grading. </li>\n");
      out.write("                    <li>doTest is a really simple interface and detailed reports.</li>\n");
      out.write("                    <li>doTest is totally free.</li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"fix-float\"></div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"footer\">\n");
      out.write("            <p>doTest company.</p>\n");
      out.write("            <p>&copy; Copyright 2018. All rights reserved. </p>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
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
