import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductDiscountCalculatorServlet", value = "/calculate")
public class ProductDiscountCalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productDescription = request.getParameter("ProductDescription");

        Double listPrice = Double.parseDouble(request.getParameter("ListPrice"))  ;
        Double discountPercent = Double.parseDouble(request.getParameter("DiscountPercent"))  ;

        Double discountAmount = listPrice * discountPercent * 0.01;


        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Product: " + productDescription + "</h1>");
        writer.println("<h1>Amount: " + discountAmount + "</h1>");
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
