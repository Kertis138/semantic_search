<div class="container-fluid bg-light">
  <div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand" href="#">LOGO</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>


      <div class="collapse navbar-collapse d-flex flex-row-reverse" id="navbarSupportedContent">

        @auth
        <ul class="nav">
          <li class="nav-item">
            <a class="nav-link" href="#">{{ Auth::user()->name }}</a>
          </li>
          <li class="nav-item">
          <a class="nav-link" href="{{ route('logout') }}" onclick="event.preventDefault(); document.getElementById('logout-form').submit();">Выход</a>
          <form id="logout-form" action="{{ route('logout') }}" method="POST" style="display: none;">{{ csrf_field() }}</form>
          </li>
        </ul>
        @else
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link" href="{{ route('login') }}">Вход</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="{{ route('register') }}">Регистрация</a>
            </li>
          </ul>
        @endauth

      </div>
    </nav>
  </div>
</div>