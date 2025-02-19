package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.MySQLConfig;
import entity.RoleEntity;
import entity.UserEntity;
import service.UserServices;

@WebServlet(name = "UserController", urlPatterns = { "/user", "/user-add", "/user-delete", "/user-update" })
public class UserController extends HttpServlet {
	private UserServices userServices = new UserServices();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String path = req.getServletPath();

		switch (path) {
		case "/user":
			// Logic code liên quan tới /user
			getUser(req, resp);
			break;

		case "/user-add":
			// Logic code liên quan tới /user-add
			userAdd(req, resp);
			break;

		case "/user-delete":
			deleteUser(req, resp);
			break;
			
		case "/user-update":
			showUpdateForm(req, resp);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String path = req.getServletPath();
		switch (path) {
		case "/user":
			break;

		case "/user-add":
			// Logic code liên quan tới /user-add
			String fullname = req.getParameter("fullname");
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			int idRole = Integer.parseInt(req.getParameter("role"));
			userServices.insertUser(fullname, password, email, phone, idRole);
			userAdd(req, resp);
			break;
			
		case "/user-delete":
			deleteUser(req, resp);
			break;

		case "/user-update":
			updateUser(req, resp);
			break;
		}
	}

	private void userAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<RoleEntity> roles = userServices.getRole();
		req.setAttribute("roles", roles);
		req.getRequestDispatcher("user-add.jsp").forward(req, resp);
	}

	private void getUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<UserEntity> listUser = userServices.getAllUser();
		req.setAttribute("listUser", listUser);
		req.getRequestDispatcher("user-table.jsp").forward(req, resp);
	}

	private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		userServices.deleteUser(id);
		resp.sendRedirect("user");
	}

	private void showUpdateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		UserEntity user = userServices.getUserById(id);
		List<RoleEntity> roles = userServices.getRole();
		req.setAttribute("user", user);
		req.setAttribute("roles", roles);
		req.getRequestDispatcher("user-update.jsp").forward(req, resp);
	}

	private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String fullname = req.getParameter("fullname");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		int roleId = Integer.parseInt(req.getParameter("role"));
		userServices.updateUser(id, fullname, email, phone, roleId);
		resp.sendRedirect("user");
	}
}
