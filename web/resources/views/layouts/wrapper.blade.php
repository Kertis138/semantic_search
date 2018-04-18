@extends("layouts.app")

@section("wrapper")
<div class="container">
	<div class="row">
		<div class="col-3">
			<div class="simple-box =">
				@include("include.left-sidebar")
			</div>
		</div>
		<div class="col-9">
			<div class="simple-box">
				@yield("content-wrapper")
			</div>
		</div>
	</div>
</div>
@endsection