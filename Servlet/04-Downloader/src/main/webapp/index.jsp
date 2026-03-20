<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
		<title>Simple Downloader</title>
	</head>
	<body>
		<h1 class="ps-5 mt-4">Simple Downloader</h1>
		<div class="container mt-3 pt-4 pb-4">
			<form method="post" action="download">
				<p class="h5">Choose a file</p>
				
				<div class="form-check">
					  <input class="form-check-input" type="radio" name="option" id="image" value="image" required>
					  <label class="form-check-label" for="image">image.jpg</label>
				</div>
				<div class="form-check">
					  <input class="form-check-input" type="radio" name="option" id="video" value="video" required>
					  <label class="form-check-label" for="video">video.mp4</label>
				</div>
				<div class="form-check">
					  <input class="form-check-input" type="radio" name="option" id="pdf" value="pdf" required>
					  <label class="form-check-label" for="pdf">file.pdf</label>
				</div>
				<button type="submit" class="mt-2 btn btn-primary">Download</button>							
			</form>
		</div>	
 		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
	</body>
</html>