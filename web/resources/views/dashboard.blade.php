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
</div>
@endsection