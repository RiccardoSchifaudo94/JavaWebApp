/**
 * 
 */
$("document").ready(function(){
	$.ajax({
		type:"POST",
		url:"ListaUserServlet",
		data:"action=stampaUtenti",
		success:function(response){
			$.each(response,function(key,val){
				$("tbody").append("<tr><td id='nome_"+val.id+"'>"+val.nome+"</td><td id='cognome_"+val.id+"'>"+val.cognome+"</td><td id='email_"+val.id+"'>"+val.email+"</td><td><button class='btn btn-warning' onclick='modificaUtente("+val.id+")'>Modifica</button></td><td><button class='btn btn-danger'>Cancella</button></td></tr>");
			});
		},
		error:function(){
			alert("errors");
		}
	});
});
function modificaUtente(id){
	$("#updateModal").modal("show");
	$("#id_modifica").val(id);
	$("#nome_da_modificare").val($("#nome_"+id).text());
	$("#cognome_da_modificare").val($("#cognome_"+id).text());
	$("#email_da_modificare").val($("#email_"+id).text());
}
function SalvaModificaUtente(){
	var id = encodeURIComponent($("#id_modifica").val());
	var nome = encodeURIComponent($("#nome_da_modificare").val());
	var cognome = encodeURIComponent($("#cognome_da_modificare").val());
	var email = encodeURIComponent($("#email_da_modificare").val());
	var data = "&action=modificaUtente&id="+id+"&nome="+nome+"&cognome="+cognome+"&email="+email;
	console.log(data);
	$.ajax({
		url:"ListaUserServlet",
		data:data,
		type:"POST",
		success:function(response){
			$("tbody").html("");
			$.each(response,function(key,val){
				$("tbody").append("<tr><td>"+val.nome+"</td><td>"+val.cognome+"</td><td>"+val.email+"</td><td><button class='btn btn-warning' onclick='modificaUtente("+val.id+")'>Modifica</button></td><td><button class='btn btn-danger'>Cancella</button></td></tr>")
			});
			$("#updateModal").modal("hide");
		},
		error:function(){
			alert("Errore");
		}
	});
}