package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PizzaServlet
 */
@WebServlet("/PizzaServlet")
public class PizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String req = request.getParameter("req");
		
		String[] menu = request.getParameterValues("menu");
		String[] topping = request.getParameterValues("topping");
		String[] sideMenu = request.getParameterValues("sideMenu");
		
		request.setAttribute("userName", userName);
		request.setAttribute("phone", phone);
		request.setAttribute("address", address);
		request.setAttribute("req", req);
		request.setAttribute("menu", menu);
		request.setAttribute("topping", topping);
		request.setAttribute("sideMenu", sideMenu);
		
		
		request.getRequestDispatcher("views/pizza/orderResult.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
