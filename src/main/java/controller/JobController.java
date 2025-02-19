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
import service.JobServiecs;

@WebServlet(name = "JobController", urlPatterns = { "/job", "/job-add", "/job-delete", "/job-update" })
public class JobController extends HttpServlet {
	private JobServiecs jobServiecs = new JobServiecs();
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String path = req.getServletPath();
		switch (path) {
		case "/job":
			listJobs(req, resp);
			break;
		case "/job-add":
			req.getRequestDispatcher("groupwork-add.jsp").forward(req, resp);
			break;
		case "/job-delete":
			deleteJob(req, resp);
			break;
		case "/job-update":
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
		case "/job-add":
			addJob(req, resp);
			break;
		case "/job-update":
			updateJob(req, resp);
			break;
		default:
			throw new IllegalArgumentException("Unexpected path: " + path);
		}
	}

	private void listJobs(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<JobEntity> jobs = jobServiecs.getAllJobs();
		req.setAttribute("listJobs", jobs);
		req.getRequestDispatcher("groupwork.jsp").forward(req, resp);
	}

	private void addJob(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String startDateStr = req.getParameter("start_date");
		String endDateStr = req.getParameter("end_date");
		try {
			Date start_date = sdf.parse(startDateStr);
			Date end_date = sdf.parse(endDateStr);
			jobServiecs.insertJob(name, start_date, end_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("job");
	}

	private void deleteJob(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		jobServiecs.deleteJob(id);
		resp.sendRedirect("job");
	}

	private void showUpdateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		JobEntity job = jobServiecs.getJobById(id);
		req.setAttribute("job", job);
		req.getRequestDispatcher("workgroup-update.jsp").forward(req, resp);
	}

	private void updateJob(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String startDateStr = req.getParameter("start_date");
		String endDateStr = req.getParameter("end_date");
		try {
			Date start_date = sdf.parse(startDateStr);
			Date end_date = sdf.parse(endDateStr);
			jobServiecs.updateJob(id, name, start_date, end_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("job");
	}
}