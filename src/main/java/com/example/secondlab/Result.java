package com.example.secondlab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "calculateServlet", value = "/calculate")
public class Result extends HttpServlet {
    private String message;

    @Override
    public void init() {
        message = "Result: ";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        FirstFormula one = new FirstFormula();
        SecondFormula two = new SecondFormula();
        ThirdFormula three = new ThirdFormula();

        try (PrintWriter out = resp.getWriter()) {
            double a = Double.parseDouble(req.getParameter("aParam"));
            double b = Double.parseDouble(req.getParameter("bParam"));
            double c = Double.parseDouble(req.getParameter("cParam"));
            double d = Double.parseDouble(req.getParameter("dParam"));

            String resultData = null;
            String choice = req.getParameter("formula");

            switch (choice) {
                case "first":
                    resultData = String.valueOf(one.result(a, b, c, d));
                    break;
                case "second":
                    resultData = String.valueOf(two.result(a, b, c, d));
                    break;
                case "third":
                    resultData = String.valueOf(three.result(a, b, c, d));
                    break;
                default:
                    out.println("<h5>Wrong choice</h5>");
            }

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Result</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<link rel=\"stylesheet\" href=\"style.css\">");
            out.println("<p>" + message + resultData + "</p><br>");
            out.println("<button onclick=\"window.location.href='/secondLab_war_exploded/index.jsp';\">\n" +
                    "Go back\n" +
                    "</button>");
            out.println("</body>");
            out.println("</html>");
        } catch (NullPointerException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
    }

    public void destroy() {
    }
}