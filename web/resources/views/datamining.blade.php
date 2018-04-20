@extends("layouts.wrapper")
@section("bodyclass","datamining")

@section("content-wrapper")
<div class="container">
		<h1>Сбор данных</h1>
		<hr>
		<div id="status-wrapper">
			<h5>Статус сервера:</h5>
			<div id="server-status-span"></div>
		</div>
</div>
<div class="container">
	<div class="form-group">
	  <label for="sel1"><b>Выберите драйвер:</b></label>
	  @if(count($drs) == 0)
	  	Вы еще не добавили ни одного драйвера. <a href="{{route("add_script")}}">Добавить?</a>
	  @else
		  <select class="form-control" id="datamining_select">
		    	@foreach($drs as $dr)
		    		<option data="{{$dr->id}}">{{$dr->name}}</option>
		    	@endforeach
		  </select>
		<div class="d-flex flex-row-reverse">
			<button type="button" class="btn btn-primary" id="datamining_start">Запустить</button>
		</div>
	  @endif
	</div>
</div>


<div class="modal" tabindex="-1" role="dialog" id="datamining_modal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Информация</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" id="datamining_modal_body">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
      </div>
    </div>
  </div>
</div>


@endsection
