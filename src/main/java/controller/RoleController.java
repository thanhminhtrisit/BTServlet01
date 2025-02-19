package controller;

import java.io.IOException;
import java.util.List;

import javax.management.relation.Role;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.RoleEntity;
import service.RoleServices;

@WebServlet(name = "RoleController", urlPatterns = { "/role", "/role-add", "/role-delete", "/role-update" })
public class RoleController extends HttpServlet {
	private RoleServices roleServices = new RoleServices();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String path = req.getServletPath();
		switch (path) {
		case "/role":
			getRole(req, resp);
			break;
		case "/role-add":
			req.getRequestDispatcher("role-add.jsp").forward(req, resp);
			break;
		case "/role-delete":
			deleteRole(req, resp);
			getRole(req, resp);
			break;
		case "/role-update":
			showUpdateRoleForm(req, resp);
			;
			break;
		default:
			System.out.println("Error at: " + path);
			throw new IllegalArgumentException("Unexpected value: " + path);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String path = req.getServletPath();
		switch (path) {
		case "/role":
			getRole(req, resp);
			break;
		case "/role-add":
			String rollName = req.getParameter("roleName");
			String description = req.getParameter("description");
			roleServices.insertRole(rollName, description);
			resp.sendRedirect("role-add");
			break;
		case "/role-delete":
			deleteRole(req, resp);
			getRole(req, resp);
			break;
		case "/role-update":
			updateRole(req, resp);
			break;
		default:
			System.out.println("Error at: " + path);
			throw new IllegalArgumentException("Unexpected value: " + path);
		}
	}

	private void getRole(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<RoleEntity> roleEntities = roleServices.getRole();
		req.setAttribute("listRoles", roleEntities);
		req.getRequestDispatcher("role-table.jsp").forward(req, resp);
	}

	private void deleteRole(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		roleServices.deleteRole(id);
	}

	private void showUpdateRoleForm(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		RoleEntity role = roleServices.getRoleById(id);
		req.setAttribute("role", role);
		req.getRequestDispatcher("role-update.jsp").forward(req, resp);
	}

	private void updateRole(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String roleName = req.getParameter("roleName");
		String description = req.getParameter("description");
		roleServices.updateRole(id, roleName, description);
		resp.sendRedirect("role");
	}
}
