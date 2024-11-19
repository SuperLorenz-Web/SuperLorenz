/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.33
 * Generated at: 2024-11-19 21:01:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class empleado_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>SuperLorenz - Empleado</title>\n");
      out.write("    <style>\n");
      out.write("        * {\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            box-sizing: border-box;\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        body {\n");
      out.write("            background-color: #ddd;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Encabezado */\n");
      out.write("        .header {\n");
      out.write("            display: flex;\n");
      out.write("            align-items: center;\n");
      out.write("            justify-content: space-between;\n");
      out.write("            background-color: #a168a3;\n");
      out.write("            padding: 10px;\n");
      out.write("            color: white;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .header .logo {\n");
      out.write("            display: flex;\n");
      out.write("            align-items: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .header .logo img {\n");
      out.write("            width: 40px;\n");
      out.write("            height: 40px;\n");
      out.write("            margin-right: 10px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .header .user-info {\n");
      out.write("            display: flex;\n");
      out.write("            gap: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Contenedor principal */\n");
      out.write("        .container {\n");
      out.write("            display: flex;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Barra lateral */\n");
      out.write("        .sidebar {\n");
      out.write("            width: 200px;\n");
      out.write("            background-color: #6a2f88; /* Color de fondo morado fuerte */\n");
      out.write("            padding: 20px 0;\n");
      out.write("            color: white;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .sidebar ul {\n");
      out.write("            list-style: none;\n");
      out.write("            padding: 0;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .sidebar ul li {\n");
      out.write("            padding: 15px 0;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .sidebar ul li:hover {\n");
      out.write("            background-color: #8c4ea8;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Sección de contenido */\n");
      out.write("        .content {\n");
      out.write("            flex-grow: 1;\n");
      out.write("            padding: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .content-header {\n");
      out.write("            display: flex;\n");
      out.write("            gap: 10px;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .content-header input[type=\"button\"] {\n");
      out.write("            background-color: #a168a3;\n");
      out.write("            color: white;\n");
      out.write("            padding: 10px 20px;\n");
      out.write("            border: none;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .content-header input[type=\"text\"] {\n");
      out.write("            padding: 10px;\n");
      out.write("            width: 200px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Tabla de contenido */\n");
      out.write("        .table-container {\n");
      out.write("            background-color: #b48ebf;\n");
      out.write("            padding: 10px;\n");
      out.write("            border-radius: 8px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .table-row {\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: space-between;\n");
      out.write("            background-color: #d8aad7;\n");
      out.write("            height: 40px;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("            padding: 0 10px;\n");
      out.write("            align-items: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .table-row:hover {\n");
      out.write("            background-color: #b78cd5;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .table-row .cell {\n");
      out.write("            flex: 1;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <!-- Encabezado -->\n");
      out.write("    <div class=\"header\">\n");
      out.write("        <div class=\"logo\">\n");
      out.write("            <img src=\"img/logo.png\" alt=\"Logo\">\n");
      out.write("            <h1>SuperLorenz</h1>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"user-info\">\n");
      out.write("            <span>¡Hola Juan!</span>\n");
      out.write("            <span>Cerrar Sesión</span>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Contenedor principal -->\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <!-- Barra lateral -->\n");
      out.write("        <div class=\"sidebar\">\n");
      out.write("            <ul>\n");
      out.write("                <li>Mi Cuenta</li>\n");
      out.write("                <li>Proveedores</li>\n");
      out.write("                <li>Clientes</li>\n");
      out.write("                <li>Pedidos</li>\n");
      out.write("                <li>Productos</li>\n");
      out.write("                <li>Informes de Ventas</li>\n");
      out.write("                <li>Gestión de Empleados</li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Sección de contenido -->\n");
      out.write("        <div class=\"content\">\n");
      out.write("            <!-- Encabezado de la sección de contenido -->\n");
      out.write("            <div class=\"content-header\">\n");
      out.write("                <input type=\"button\" value=\"Nuevo Pedido\">\n");
      out.write("                <input type=\"text\" placeholder=\"Buscar productos...\">\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Tabla de contenido -->\n");
      out.write("            <div class=\"table-container\">\n");
      out.write("                <!-- Filas de la tabla (simulación) -->\n");
      out.write("                <div class=\"table-row\">\n");
      out.write("                    <div class=\"cell\">Pedido #001</div>\n");
      out.write("                    <div class=\"cell\">Juan Pérez</div>\n");
      out.write("                    <div class=\"cell\">Pendiente</div>\n");
      out.write("                    <div class=\"cell\">Ver Detalles</div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"table-row\">\n");
      out.write("                    <div class=\"cell\">Pedido #002</div>\n");
      out.write("                    <div class=\"cell\">María López</div>\n");
      out.write("                    <div class=\"cell\">Enviado</div>\n");
      out.write("                    <div class=\"cell\">Ver Detalles</div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"table-row\">\n");
      out.write("                    <div class=\"cell\">Pedido #003</div>\n");
      out.write("                    <div class=\"cell\">Carlos García</div>\n");
      out.write("                    <div class=\"cell\">Pendiente</div>\n");
      out.write("                    <div class=\"cell\">Ver Detalles</div>\n");
      out.write("                </div>\n");
      out.write("                <!-- Más filas -->\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
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
