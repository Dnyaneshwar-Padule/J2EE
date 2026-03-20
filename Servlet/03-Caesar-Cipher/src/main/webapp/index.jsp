<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Caesar Cipher</title>
		 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
	</head>
	<body>
		<h1 class="ps-5 mt-4">Caesar Cipher</h1>
		<div class="container bg-body-secondary mt-3 pt-4 pb-4">
			<form action="caesarCipher" method="post">
	 			<div class="mb-3">
				 	<label for="shift" class="form-label">Shift (k)</label>
				 	<input type="number" class="form-control" min="1"  max="25" name="shift" id="shift" placeholder="3">
				</div>
				<div class="mb-3">
				 	<label for="message" class="form-label">Message</label>
				 	<textarea class="form-control" name="message" id="message" rows="3"></textarea>
				</div>
				<button type="submit" class="btn btn-primary">Encrypt</button>			
			</form>
			
			<%
				String cipherText = (String)request.getAttribute("cipherText");
				if(cipherText != null && ! cipherText.isBlank()) {
			%>
				<div class="container bg-body-secondary mt-3 pt-4 pb-4">
					<div class="mb-3">
				 		<label for="message" class="form-label">Cipher Text</label>
				 		<textarea class="form-control" name="cipherText" id="cipherText" rows="3" disabled readonly><%= cipherText %></textarea>
					</div>
				</div>
			<% } %>
 		</div>
 		
 		<div class="container bg-body-secondary mt-3 pt-4 pb-4">
 			<form method="post" action="decryptCaesarCipher">
 				<div class="mb-3">
				 	<label for="message" class="form-label">Cipher Message</label>
				 	<textarea class="form-control" name="cipherMessage" id="cipherMessage" rows="3"></textarea>
				</div>
				<button type="submit" class="btn btn-primary">Decrypt</button>	
 			</form>
 			
 			<%
 				ArrayList<String> possibilities = (ArrayList<String>)request.getAttribute("possibilities");
				if( possibilities != null && ! possibilities.isEmpty()){
			%>
						<div class="container bg-body-secondary mt-3 pt-4 pb-4">
					<%
						for(String result: possibilities){
 					%>
 						<textarea class="form-control" name="cipherText" id="cipherText" rows="3" disabled readonly><%= result %></textarea>
 					<%} %>
 					</div>
 			<% } %>
 			
 		</div>
 		
 		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
	</body>
</html>