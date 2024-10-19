package mk.ukim.finki.webprograming.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

@WebServlet(urlPatterns = "/categories")
public class CategoriesServlet extends HttpServlet {
    @AllArgsConstructor
    @Getter
    @Setter
    @Data
    class Category {
        private String name;
        private String description;
    }

    private Set<Category> categories;
    SpringTemplateEngine templateEngine;

    public CategoriesServlet(SpringTemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    public void init() throws ServletException {
        categories = new HashSet<>();
        categories.add(new Category("Category1", "Description1"));
        categories.add(new Category("Category2", "Description2"));
    }

    private void addCategory(String name, String description) {
        categories.add(new Category(name, description));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);
        context.setVariable("ipAddress", req.getRemoteAddr());
        context.setVariable("categories", categories);
        templateEngine.process("/categories", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String desc = req.getParameter("description");
        if (name.isBlank() || desc.isBlank()) {
            return;
        }
        this.addCategory(name, desc);
        resp.sendRedirect("/categories");
    }
}
