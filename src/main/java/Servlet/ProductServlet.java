package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Product;

@WebServlet(name = "PoginServlet", urlPatterns = { "/product" })
public class ProductServlet extends HttpServlet {

	private static Product spA = new Product("01", "Điện thoại Nokia", 20, 1500000);
	private static Product spB = new Product("02", "Điện thoại Samsung", 50, 5500000);
	private static Product spC = new Product("02", "Điện thoại Xiaomi", 80, 8500000);

	private List<Product> addProduct(List<Product> products) {
		products.add(spA);
		products.add(spB);
		products.add(spC);
		return products;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Product> list = new ArrayList<Product>();
		this.addProduct(list);
		request.setAttribute("list", list);
		request.getRequestDispatcher("product.jsp").forward(request, response);
	}
}
