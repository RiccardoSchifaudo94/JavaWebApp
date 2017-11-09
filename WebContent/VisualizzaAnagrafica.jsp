<%@include  file="include/components/header.jsp" %>
<div class="container">
	<div class="row">
		<div class="jumbotron">
			<h1 align="center">Java Web App</h1>
			<div class="row">
				<div class="col-md-6 col-sm-6 col-xs-12">
					<h3 class="text-info">Visulizza anagrafica utente</h3>
						<label>Nome</label>
						<input class="form-control" name="nome" value="<%= session.getAttribute("nome") %>"readonly>
						<label>Cognome</label>
						<input class="form-control" name="cognome" value="<%= session.getAttribute("cognome") %>" readonly>
						<label>Email</label>
						<input class="form-control" name="email" value="<%= session.getAttribute("email") %>" readonly>
						<br/>
						<a href="HomePage.jsp" class="btn btn-success">Torna indietro</a>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include  file="include/components/footer.jsp" %>