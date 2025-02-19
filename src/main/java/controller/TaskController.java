package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.JobEntity;
import entity.StatusEntity;
import entity.TaskEntity;
import entity.UserEntity;
import service.JobServiecs;
import service.StatusService;
import service.TaskServices;
import service.UserServices;

@WebServlet(name = "TaskController", urlPatterns = { "/task", "/task-add", "/task-delete", "/task-update" })
public class TaskController extends HttpServlet {
	private TaskServices taskServices = new TaskServices();
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private UserServices userServices = new UserServices();
	private JobServiecs jobServiecs = new JobServiecs();
	private StatusService statusService = new StatusService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String path = req.getServletPath();
		switch (path) {
		case "/task":
			listTasks(req, resp);
			break;
		case "/task-add":
			List<UserEntity> listUsers = userServices.getAllUser();
			List<JobEntity> listJobs = jobServiecs.getAllJobs();
			List<StatusEntity> listStatus = statusService.getAllStatus();
			req.setAttribute("listUsers", listUsers);
			req.setAttribute("listJobs", listJobs);
			req.setAttribute("listStatus", listStatus);
			req.getRequestDispatcher("task-add.jsp").forward(req, resp);
			break;
		case "/task-delete":
			deleteTask(req, resp);
			break;
		case "/task-update":
			showUpdateForm(req, resp);
			break;
		default:
			throw new IllegalArgumentException("Unexpected path: " + path);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String path = req.getServletPath();
		switch (path) {
		case "/task-add":
			addTask(req, resp);
			break;
		case "/task-update":
			updateTask(req, resp);
			break;
		default:
			throw new IllegalArgumentException("Unexpected path: " + path);
		}
	}

	private void listTasks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<TaskEntity> tasks = taskServices.getAllTasks();
		req.setAttribute("listTasks", tasks);
		req.getRequestDispatcher("task.jsp").forward(req, resp);
	}

	private void addTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String startDateStr = req.getParameter("start_date");
		String endDateStr = req.getParameter("end_date");
		int user_id = Integer.parseInt(req.getParameter("user_id"));
		int job_id = Integer.parseInt(req.getParameter("job_id"));
		int status_id = Integer.parseInt(req.getParameter("status_id"));
		try {
			Date start_date = sdf.parse(startDateStr);
			Date end_date = sdf.parse(endDateStr);
			taskServices.insertTask(name, start_date, end_date, user_id, job_id, status_id);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("task");
	}

	private void deleteTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		taskServices.deleteTask(id);
		resp.sendRedirect("task");
	}

	private void showUpdateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		List<UserEntity> listUsers = userServices.getAllUser();
		List<JobEntity> listJobs = jobServiecs.getAllJobs();
		List<StatusEntity> listStatus = statusService.getAllStatus();
		req.setAttribute("listUsers", listUsers);
		req.setAttribute("listJobs", listJobs);
		req.setAttribute("listStatus", listStatus);
		TaskEntity task = taskServices.getTaskById(id);
		req.setAttribute("task", task);
		req.getRequestDispatcher("task-update.jsp").forward(req, resp);
	}

	private void updateTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String startDateStr = req.getParameter("start_date");
		String endDateStr = req.getParameter("end_date");
		int user_id = Integer.parseInt(req.getParameter("user_id"));
		int job_id = Integer.parseInt(req.getParameter("job_id"));
		int status_id = Integer.parseInt(req.getParameter("status_id"));
		try {
			Date start_date = sdf.parse(startDateStr);
			Date end_date = sdf.parse(endDateStr);
			taskServices.updateTask(id, name, start_date, end_date, user_id, job_id, status_id);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("task");
	}
}
