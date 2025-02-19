<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" type="image/png" sizes="16x16"
	href="plugins/images/favicon.png">
<title>Pixel Admin</title>
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
	<!-- Preloader -->
	<div class="preloader">
		<div class="cssload-speeding-wheel"></div>
	</div>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top m-b-0">
			<div class="navbar-header">
				<a class="navbar-toggle hidden-sm hidden-md hidden-lg"
					href="javascript:void(0)" data-toggle="collapse"
					data-target=".navbar-collapse"> <i class="fa fa-bars"></i>
				</a>
				<div class="top-left-part">
					<a class="logo" href="index.html"> <b><img
							src="plugins/images/pixeladmin-logo.png" alt="home" /></b> <span
						class="hidden-xs"><img
							src="plugins/images/pixeladmin-text.png" alt="home" /></span>
					</a>
				</div>
				<ul class="nav navbar-top-links navbar-left m-l-20 hidden-xs">
					<li>
						<form role="search" class="app-search hidden-xs">
							<input type="text" placeholder="Search..." class="form-control">
							<a href=""><i class="fa fa-search"></i></a>
						</form>
					</li>
				</ul>
				<ul class="nav navbar-top-links navbar-right pull-right">
					<li>
						<div class="dropdown">
							<a class="profile-pic dropdown-toggle" data-toggle="dropdown"
								href="#"> <img src="plugins/images/users/varun.jpg"
								alt="user-img" width="36" class="img-circle" /> <b
								class="hidden-xs">Cybersoft</b>
							</a>
							<ul class="dropdown-menu">
								<li><a href="profile.html">Thông tin cá nhân</a></li>
								<li><a href="#">Thống kê công việc</a></li>
								<li class="divider"></li>
								<li><a href="#">Đăng xuất</a></li>
							</ul>
						</div>
					</li>
				</ul>
			</div>
		</nav>
		<!-- Left navbar-header -->
		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse slimscrollsidebar">
				<ul class="nav" id="side-menu">
					<li style="padding: 10px 0 0;"><a href="index.html"
						class="waves-effect"> <i class="fa fa-clock-o fa-fw"
							aria-hidden="true"></i> <span class="hide-menu">Dashboard</span>
					</a></li>
					<li><a href="groupwork.jsp" class="waves-effect"> <i
							class="fa fa-briefcase fa-fw" aria-hidden="true"></i> <span
							class="hide-menu">Jobs</span>
					</a></li>
					<!-- Additional sidebar items as needed -->
				</ul>
			</div>
		</div>
		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<!-- Page Title -->
				<div class="row bg-title">
					<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
						<h4 class="page-title">Update Job</h4>
					</div>
				</div>
				<!-- Update Job Form -->
				<div class="row">
					<div class="col-md-2 col-xs-12"></div>
					<div class="col-md-8 col-xs-12">
						<div class="white-box">
							<form class="form-horizontal form-material" action="job-update"
								method="post">
								<input type="hidden" name="id" value="${job.id}" />
								<div class="form-group">
									<label class="col-md-12">Job Name</label>
									<div class="col-md-12">
										<input type="text" placeholder="Enter job name"
											class="form-control form-control-line" name="name"
											value="${job.name}" required>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-12">Start Date</label>
									<div class="col-md-12">
										<input type="date" class="form-control form-control-line"
											name="start_date" value="${job.datestart_date}" required>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-12">End Date</label>
									<div class="col-md-12">
										<input type="date" class="form-control form-control-line"
											name="end_date" value="${job.end_date}" required>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-12">
										<button type="submit" class="btn btn-success">Update
											Job</button>
										<a href="job" class="btn btn-primary">Cancel</a>
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
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->
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

