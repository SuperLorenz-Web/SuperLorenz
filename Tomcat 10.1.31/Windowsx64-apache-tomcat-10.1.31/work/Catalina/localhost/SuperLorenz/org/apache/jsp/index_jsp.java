/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.31
 * Generated at: 2024-11-13 22:31:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"es\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>SuperLorenz</title>\r\n");
      out.write("    <style>\r\n");
      out.write("        body {\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            font-family: Arial, sans-serif;\r\n");
      out.write("            background-color: #333;\r\n");
      out.write("            color: white;\r\n");
      out.write("        }\r\n");
      out.write("        .header {\r\n");
      out.write("            background-color: #B07CB6;\r\n");
      out.write("            padding: 10px 20px;\r\n");
      out.write("            display: flex;\r\n");
      out.write("            justify-content: space-between;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("        }\r\n");
      out.write("        .header .logo {\r\n");
      out.write("            display: flex;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("        }\r\n");
      out.write("        .header img {\r\n");
      out.write("            height: 40px;\r\n");
      out.write("            margin-right: 10px;\r\n");
      out.write("        }\r\n");
      out.write("        .header input[type=\"text\"] {\r\n");
      out.write("            padding: 5px;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("            border: none;\r\n");
      out.write("            width: 300px;\r\n");
      out.write("        }\r\n");
      out.write("        .header .nav-links {\r\n");
      out.write("            display: flex;\r\n");
      out.write("            gap: 15px;\r\n");
      out.write("        }\r\n");
      out.write("        .carousel-container {\r\n");
      out.write("            background-color: #4C1166;\r\n");
      out.write("            padding: 15px;\r\n");
      out.write("            display: flex;\r\n");
      out.write("            justify-content: space-between;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("            margin-bottom: 20px;\r\n");
      out.write("        }\r\n");
      out.write("        .carousel-item {\r\n");
      out.write("            background-color: #6D217F;\r\n");
      out.write("            padding: 15px;\r\n");
      out.write("            border-radius: 8px;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            color: white;\r\n");
      out.write("            flex: 1;\r\n");
      out.write("            margin: 0 10px;\r\n");
      out.write("            display: flex;\r\n");
      out.write("            flex-direction: column;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("        }\r\n");
      out.write("        .carousel-item .image-container {\r\n");
      out.write("            height: 100px;\r\n");
      out.write("            width: 100px;\r\n");
      out.write("            margin-bottom: 10px;\r\n");
      out.write("            display: flex;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("            justify-content: center;\r\n");
      out.write("            background-color: #E7D845;\r\n");
      out.write("            clip-path: polygon(50% 0%, 100% 25%, 82% 100%, 18% 100%, 0% 25%);\r\n");
      out.write("        }\r\n");
      out.write("        .carousel-buttons {\r\n");
      out.write("            color: #E7D845;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            font-size: 30px;\r\n");
      out.write("        }\r\n");
      out.write("        .container {\r\n");
      out.write("            width: 80%;\r\n");
      out.write("            display: grid;\r\n");
      out.write("            grid-template-columns: repeat(2, 1fr);\r\n");
      out.write("            gap: 20px;\r\n");
      out.write("            background-color: #4C1166;\r\n");
      out.write("            padding: 20px;\r\n");
      out.write("            border-radius: 8px;\r\n");
      out.write("            margin: 0 auto;\r\n");
      out.write("        }\r\n");
      out.write("        .product-card {\r\n");
      out.write("            background-color: #6D217F;\r\n");
      out.write("            padding: 15px;\r\n");
      out.write("            border-radius: 8px;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            color: white;\r\n");
      out.write("            display: flex;\r\n");
      out.write("            flex-direction: column;\r\n");
      out.write("            justify-content: space-between;\r\n");
      out.write("        }\r\n");
      out.write("        .product-card .image-container {\r\n");
      out.write("            height: 100px;\r\n");
      out.write("            width: 100px;\r\n");
      out.write("            margin: 0 auto;\r\n");
      out.write("            display: flex;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("            justify-content: center;\r\n");
      out.write("            background-color: #E7D845;\r\n");
      out.write("            clip-path: polygon(50% 0%, 100% 25%, 82% 100%, 18% 100%, 0% 25%);\r\n");
      out.write("        }\r\n");
      out.write("        .product-card .image-container span {\r\n");
      out.write("            color: #6D217F;\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("        }\r\n");
      out.write("        .product-info {\r\n");
      out.write("            margin: 10px 0;\r\n");
      out.write("        }\r\n");
      out.write("        .plus-btn {\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            font-size: 20px;\r\n");
      out.write("            color: #E7D845;\r\n");
      out.write("            background: none;\r\n");
      out.write("            border: none;\r\n");
      out.write("            padding: 5px;\r\n");
      out.write("            margin-top: 10px;\r\n");
      out.write("            align-self: center;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <header class=\"header\">\r\n");
      out.write("        <div class=\"logo\">\r\n");
      out.write("            <img src=\"logo.png\" alt=\"SuperLorenz Logo\">\r\n");
      out.write("            <span>SuperLorenz</span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <input type=\"text\" placeholder=\"Buscar producto...\">\r\n");
      out.write("        <div class=\"nav-links\">\r\n");
      out.write("            <a href=\"#\">Empleado</a>\r\n");
      out.write("            <a href=\"#\">Proveedor</a>\r\n");
      out.write("            <a href=\"#\">Carrito</a>\r\n");
      out.write("            <a href=\"#\">Ingresar</a>\r\n");
      out.write("        </div>\r\n");
      out.write("    </header>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"carousel-container\">\r\n");
      out.write("        <span class=\"carousel-buttons\">&lt;</span>\r\n");
      out.write("        <div class=\"carousel-item\">\r\n");
      out.write("            <div class=\"image-container\">\r\n");
      out.write("                <span>Imagen de Producto</span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <strong>Nombre Producto</strong><br>\r\n");
      out.write("            Descripción de producto.<br>\r\n");
      out.write("            Precio producto.\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"carousel-item\">\r\n");
      out.write("            <div class=\"image-container\">\r\n");
      out.write("                <span>Imagen de Producto</span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <strong>Nombre Producto</strong><br>\r\n");
      out.write("            Descripción de producto.<br>\r\n");
      out.write("            Precio producto.\r\n");
      out.write("        </div>\r\n");
      out.write("        <span class=\"carousel-buttons\">&gt;</span>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <!-- Card 1 -->\r\n");
      out.write("        <div class=\"product-card\">\r\n");
      out.write("            <div class=\"image-container\">\r\n");
      out.write("                <span>Imagen de Producto</span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"product-info\">\r\n");
      out.write("                <strong>Nombre Producto</strong><br>\r\n");
      out.write("                Descripción de producto.<br>\r\n");
      out.write("                Precio producto.\r\n");
      out.write("            </div>\r\n");
      out.write("            <button class=\"plus-btn\">+</button>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Card 2 -->\r\n");
      out.write("        <div class=\"product-card\">\r\n");
      out.write("            <div class=\"image-container\">\r\n");
      out.write("                <span>Imagen de Producto</span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"product-info\">\r\n");
      out.write("                <strong>Nombre Producto</strong><br>\r\n");
      out.write("                Descripción de producto.<br>\r\n");
      out.write("                Precio producto.\r\n");
      out.write("            </div>\r\n");
      out.write("            <button class=\"plus-btn\">+</button>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Card 3 -->\r\n");
      out.write("        <div class=\"product-card\">\r\n");
      out.write("            <div class=\"image-container\">\r\n");
      out.write("                <span>Imagen de Producto</span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"product-info\">\r\n");
      out.write("                <strong>Nombre Producto</strong><br>\r\n");
      out.write("                Descripción de producto.<br>\r\n");
      out.write("                Precio producto.\r\n");
      out.write("            </div>\r\n");
      out.write("            <button class=\"plus-btn\">+</button>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Card 4 -->\r\n");
      out.write("        <div class=\"product-card\">\r\n");
      out.write("            <div class=\"image-container\">\r\n");
      out.write("                <span>Imagen de Producto</span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"product-info\">\r\n");
      out.write("                <strong>Nombre Producto</strong><br>\r\n");
      out.write("                Descripción de producto.<br>\r\n");
      out.write("                Precio producto.\r\n");
      out.write("            </div>\r\n");
      out.write("            <button class=\"plus-btn\">+</button>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
