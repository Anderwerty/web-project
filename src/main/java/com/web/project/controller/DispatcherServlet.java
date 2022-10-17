package com.web.project.controller;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Блинов java пример
//DispatcherServlet is from Spring MVC, it is Front Controller

public class DispatcherServlet extends HttpServlet {
    // init. work, destroy
    // user GET, POST
    Map<String, List<Pair<String, RequestExecutor>>> urlToPair = new HashMap<>();
    {

    }

    @Override

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String httpMethod = req.getMethod();
        String uri = req.getRequestURI();

        urlToPair.get(uri).stream().filter(x-> httpMethod.equals(x.key)).findAny().get().value.execute(req, resp);
    }
}

class Pair<K, V> {
    K key;
    V value;
}
interface RequestExecutor{
    void execute(HttpServletRequest req, HttpServletResponse resp);
}

// bank/transaction/all - GET
// bank/transaction/{id} -GET
// bank/transaction - POST

