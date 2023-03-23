package com.example.demolab1.servlet;

import com.example.demolab1.entity.Fruit;
import com.example.demolab1.repository.FruitRepository;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="fruitservlet", value = "/fruits")

public class FruitServlet extends HttpServlet {

    @Inject
    FruitRepository repository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Fruit fruit = new Fruit();
        fruit.setName("Mango");
        repository.insertFruit(fruit);


        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h>" + "Created new fruit" + "</h>");
        out.println("</body></html>");
    }
}
