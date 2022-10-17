package com.web.project.controller;

import com.web.project.injector.Injector;
import com.web.project.service.TimeService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "badexample", urlPatterns = {"/examplea", "/exampleb"},
        initParams = {
                @WebInitParam(name = "dburl", value = "url/to/db")
        }
)

public class BadExampleServlet extends HttpServlet {
    private TimeService timeService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        String dburl = config.getInitParameter("dburl");
        timeService = Injector.getBean("timeServiceA", TimeService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("<html>");
//        out.println("<body>");
//        out.println("<head>");
//        out.println("<title>Request Information Example</title>");
//        out.println("</head>");
//        out.println("<body>");
//        out.println("<h3>Request Information Example</h3>");
//        out.println("Method: " + request.getMethod());
//        out.println("Request URI: " + request.getRequestURI());
//        out.println("Protocol: " + request.getProtocol());
//        out.println("PathInfo: " + request.getPathInfo());
//        out.println("Remote Address: " + request.getRemoteAddr());
//        out.println("</body>");
//        out.println("</html>");

        request.getRequestDispatcher("page1.jsp").forward(request, response);

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
