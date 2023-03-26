package com.example.demolab1.servlet;

import com.example.demolab1.entity.Fruit;
import com.example.demolab1.repository.FruitRepository;
import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="fruitservlet", value = "/fruits/*")

public class FruitServlet extends HttpServlet {

    @Inject
    FruitRepository repository;
    @Inject
    Jsonb jsonb;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");

        out.println("<h1>" + "Fruits" + "</h1>");

        for(Fruit fruit : repository.findAll())
            out.println("<div>" + fruit.getId() + ":" + fruit.getName() + "</div>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StringBuffer jb = new StringBuffer();
        String line = null;
        try {

            BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) { /*report an error*/}

        Jsonb jsonb = JsonbBuilder.create();

        Fruit fruit = jsonb.fromJson(jb.toString(), Fruit.class);
        repository.insertFruit(fruit);
    }

}
