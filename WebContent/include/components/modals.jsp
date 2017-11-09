<!-- Modal -->
<div id="updateModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Modifica utente</h4>
      </div>
      <div class="modal-body">
        <p>Modifica data.</p>
        <input type="hidden" class="form-control" id="id_modifica">
        <label>Nome</label>
        <input type="text" class="form-control" id="nome_da_modificare">
        <label>Cognome</label>
        <input type="text" class="form-control" id="cognome_da_modificare">
        <label>Email</label>
        <input type="email" class="form-control" id="email_da_modificare">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success" onclick="SalvaModificaUtente();">Salva</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>