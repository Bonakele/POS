package com.pos.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pos.dao.inter.ItemInterface;
/**
 * Servlet implementation class MainController
 */
@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ItemInterface itemInterface;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("itemList", itemInterface.view());

		RequestDispatcher dispatch = request
				.getRequestDispatcher("mainForm.jsp");
		dispatch.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setAttribute("itemList", itemInterface.view());

		RequestDispatcher dispatch = request
				.getRequestDispatcher("mainForm.jsp");
		dispatch.forward(request, response);

		// String [] items = request.getParameterValues("items");
	}

}
