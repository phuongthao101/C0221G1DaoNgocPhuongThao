package controller;

import model.bean.Product;
import model.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {

    private ProductService productService = new ProductService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                updateProduct(request, response);
                break;
            case "search":
                searchProductByName(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;

        }
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;

            default:
                listProduct(request, response);
                break;
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {

        List<Product> productList = productService.findByAll();
//        List<TypeCustomer> typeCustomerList = customerService.findAllTypeCustomer();

        request.setAttribute("products", productList);
//        request.setAttribute("typeCustomers", typeCustomerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {

        List<Product> productList = productService.findByAll();
        request.setAttribute("products", productList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {

        boolean check = false;
        String name = request.getParameter("product_name");

        String price = request.getParameter("price");

        String quantity = request.getParameter("quantity");
        String color = request.getParameter("color");

        String description = request.getParameter("description");

        String category = request.getParameter("category");


        Product product = new Product(name, price, quantity, color, description, category);
        check = productService.add(product);

        if (check) {
            request.setAttribute("message", "Create success");
        }
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/create.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchProductByName(HttpServletRequest request, HttpServletResponse response) {

        String name = request.getParameter("product_name");
        List<Product> productList = productService.findByName(name);

        request.setAttribute("products", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("product_id"));
        productService.remove(id);

        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("product_id"));
        List<Product> productList = productService.findByAll();
        request.setAttribute("products", productList);

        Product existingUser = productService.findById(id);
        request.setAttribute("product", existingUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/edit.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {

        boolean check = false;
        int id1 = Integer.parseInt(request.getParameter("product_id"));
        String name = request.getParameter("product_name");

        String price = request.getParameter("price");

        String quantity = request.getParameter("quantity");
        String color = request.getParameter("color");

        String description = request.getParameter("description");

        String category = request.getParameter("category");

        Product product = new Product(id1,name,price,quantity,color,description,category);
        check = productService.update(id1, product);
        if (check) {
            request.setAttribute("message", "Create success");
        }
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/edit.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
