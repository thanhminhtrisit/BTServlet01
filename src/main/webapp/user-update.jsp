<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Cập nhật User</title>
<!-- Bootstrap Core CSS -->
<link href="bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Menu CSS -->
<link
	href="plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css"
	rel="stylesheet">
<!-- Animation CSS -->
<link href="css/animate.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="css/style.css" rel="stylesheet">
<!-- Color CSS -->
<link href="css/colors/blue-dark.css" id="theme" rel="stylesheet">
</head>
<body>
	<div id="wrapper">
		<!-- Navigation & Sidebar (similar to your other pages) -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row bg-title">
					<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
						<h4 class="page-title">Cập nhật User</h4>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2 col-xs-12"></div>
					<div class="col-md-8 col-xs-12">
						<div class="white-box">
							<form class="form-horizontal form-material" action="user-update"
								method="post">
								<!-- Hidden field for user id -->
								<input type="hidden" name="id" value="${user.id}" />
								<div class="form-group">
									<label class="col-md-12">Full Name</label>
									<div class="col-md-12">
										<input type="text" name="fullname" value="${user.fullname}"
											class="form-control form-control-line" required="required"
											placeholder="Full Name">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-12">Email</label>
									<div class="col-md-12">
										<input type="email" name="email" value="${user.email}"
											class="form-control form-control-line" required="required"
											placeholder="Email">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-12">Phone No</label>
									<div class="col-md-12">
										<input type="text" name="phone" value="${user.phone}"
											class="form-control form-control-line" required="required"
											placeholder="Phone">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-12">Select Role</label>
									<div class="col-md-12">
										<select name="role" class="form-control form-control-line"
											required="required">
											<c:forEach var="role" items="${roles}">
												<option value="${role.id}"
													${role.id == user.role_id ? 'selected="selected"' : ''}>${role.description}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-12">
										<button type="submit" class="btn btn-success">Cập
											nhật</button>
										<a href="user" class="btn btn-primary">Quay lại</a>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="col-md-2 col-xs-12"></div>
				</div>
			</div>
			<footer class="footer text-center">2018 &copy; myclass.com</footer>
		</div>
	</div>
	<!-- jQuery -->
	<script src="plugins/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- Menu Plugin JavaScript -->
	<script
		src="plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
	<!-- Slimscroll JavaScript -->
	<script src="js/jquery.slimscroll.js"></script>
	<!-- Wave Effects -->
	<script src="js/waves.js"></script>
	<!-- Custom Theme JavaScript -->
	<script src="js/custom.min.js"></script>
</body>
</html>
