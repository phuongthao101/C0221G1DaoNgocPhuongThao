package Servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/Calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float result = 0;
        try {

           float firstNumber = Float.parseFloat(request.getParameter("firstNumber"));
           float secondNumber = Float.parseFloat(request.getParameter("secondNumber"));
           String operator = request.getParameter("operator");


           switch (operator){
               case "+":
                   result = firstNumber + secondNumber;
                   break;
               case "-":
                   result = firstNumber - secondNumber;
                   break;
               case "*":
                   result = firstNumber * secondNumber;
                   break;
               case "/":
                   try{
                       if(secondNumber==0){
                           throw new Exception("Lỗi chia cho 0");
                       }
                       result = firstNumber / secondNumber;
                   }catch (Exception e){
                       request.setAttribute("result",e.getMessage());
                       request.getRequestDispatcher("calculator.jsp").forward(request,response);
                   }
           }
       }catch (Exception e){
           request.setAttribute("result",e.getMessage());
           request.getRequestDispatcher("calculator.jsp").forward(request,response);
       }

        request.setAttribute("result",result);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("calculator.jsp");
        requestDispatcher.forward(request,response);

    }
}
