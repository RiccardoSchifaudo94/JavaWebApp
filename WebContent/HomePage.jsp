<%@include  file="include/components/header.jsp" %>

<div class="container">
	<div class="row">
		<div class="jumbotron" style="margin-top:50px;">
			<h1 align="center">Java Web App</h1>
			<div class="row">
				<div class="col-md-6 col-sm-6 col-xs-12">
					<h3 class="text-info">Crea anagrafica utente</h3>
					<form action="/WebAppJava/MyServlet" method="POST">
						<label>Nome</label>
						<input class="form-control" name="nome">
						<label>Cognome</label>
						<input class="form-control" name="cognome">
						<label>Email</label>
						<input class="form-control" name="email">
						<br/>
						<button class="btn btn-primary" type="submit">Procedi</button>
					</form>	
				</div>
			</div>
		</div>
	</div>
</div>
<%@include  file="include/components/footer.jsp" %>