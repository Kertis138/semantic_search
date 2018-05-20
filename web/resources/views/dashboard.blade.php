@extends("layouts.wrapper")
@section("bodyclass","dashboard")

@section("content-wrapper")
<div class="container">
		<h1>Панель управления</h1>
		<hr>
		<div id="status-wrapper">
			<h5>Статус сервера:</h5>
			<div id="server-status-span"></div>
		</div>

		<canvas id="server-status-canvas" width="400" height="150"></canvas>

	<br/>
	<h5>История</h5>
	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Пользователь</th>
	      <th scope="col">Драйвер</th>
	      <th scope="col">Статус</th>
	    </tr>
	  </thead>
	  <tbody>

	  	<?php $ind = 1 ?>
	  	@foreach($hst as $h)
		    <tr>
		      <th scope="row">{{$ind}}</th>
		      <td>{{$h->getUser()->name}}</td>
		      <td>{{$h->getDriver()->name}}</td>
		      <td>{{$h->status == 1?'Успешно':'С ошибкой'}}</td>
		    </tr>
	    	<?php $ind++; ?>
			@endforeach
	  </tbody>
	</table>
	
</div>
@endsection