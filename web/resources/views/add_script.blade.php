@extends("layouts.wrapper")
@section("bodyclass","add_script")

@section("content-wrapper")
<div class="container">
		<h1>Установка драйвера</h1>
		<hr>
		<div id="status-wrapper">
			<h5>Статус сервера:</h5>
			<div id="server-status-span"></div>
		</div>
</div>
<div class="container">
	<h6><b>Для добавления драйвера используйте данную форму: </b></h6>
	<input type="text" placeholder="Название драйвера" id="add_script_name">
	<textarea id="add_script_textarea" placeholder="Опции драйвера"></textarea>
	<div class="d-flex flex-row-reverse">
		<button type="button" class="btn btn-primary" id="add_script_button">Установить</button>
	</div>
</div>


<div class="modal" tabindex="-1" role="dialog" id="add_script_modal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Информация</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" id="add_script_modal_body">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
      </div>
    </div>
  </div>
</div>

@endsection