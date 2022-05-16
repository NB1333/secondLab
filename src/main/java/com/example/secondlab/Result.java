package com.example.secondlab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "calculateServlet", value = "/calculate")
public class Result extends HttpServlet {
    private String message;
    String[] parametersNames;

    @Override
    public void init() {
        message = "Result: ";
        parametersNames = new String[]{"aParam", "bParam", "cParam", "dParam"};
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        FirstFormula one = new FirstFormula();
        SecondFormula two = new SecondFormula();
        ThirdFormula three = new ThirdFormula();

        try (PrintWriter out = resp.getWriter()) {
            List<Double> parametersValues = new ArrayList<>();

            Validation paramCheck = new Validation();

            for (int i = 0; i < 4; i++) {
                paramCheck.validate(req.getParameter(parametersNames[i]));
                parametersValues.add(Double.parseDouble(req.getParameter(parametersNames[i])));
            }

            String resultData = null;
            String choice = req.getParameter("formula");

            switch (choice) {
                case "first":
                    resultData = String.valueOf(one.result(parametersValues.get(0), parametersValues.get(1),
                            parametersValues.get(2), parametersValues.get(3)));
                    break;
                case "second":
                    resultData = String.valueOf(two.result(parametersValues.get(0), parametersValues.get(1),
                            parametersValues.get(2), parametersValues.get(3)));
                    break;
                case "third":
                    resultData = String.valueOf(three.result(parametersValues.get(0), parametersValues.get(1),
                            parametersValues.get(2), parametersValues.get(3)));
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
            out.println("<p>" + message + paramCheck.validate(resultData) + "</p><br>");
            out.println("<button onclick=\"window.location.href='/secondLab_war_exploded/index.jsp';\">\n" +
                    "Go back\n" +
                    "</button>");
            out.println("</body>");
            out.println("</html>");

            for (String parametersName : parametersNames) {
                Cookie param = new Cookie(parametersName, req.getParameter(parametersName));
                //param.setValue(req.getParameter(parametersName));
                param.setMaxAge(48 * 60 * 60);
                param.setPath("\"http://localhost:8080/secondLab_war_exploded/\"");
                resp.addCookie(param);
            }

            Cookie formula = new Cookie("formula", choice);
            //formula.setValue(choice);
            formula.setMaxAge(48*60*60);
            formula.setPath("\"http://localhost:8080/secondLab_war_exploded/\"");
            resp.addCookie(formula);

        } catch (NullPointerException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {

    }

    public void destroy() {
    }
}