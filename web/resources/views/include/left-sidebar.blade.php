<div class="simple-box">
  <div class="left-sidebar" style="min-height: 185px;">
      <span class="title">Аккаунт</span>
      <div class="img_block">
        <img src="images/userlogo.png">
        <span>{{ Auth::user()->name }}</span>
      </div>
      <ul class="nav flex-column">
        <li class="nav-item">
          <a class="nav-link active" href="#">
            <i class="fas fa-user-circle"></i>Профиль</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="#">
            <i class="fas fa-cogs"></i>Настройки</a>
        </li>    
        <li class="nav-item">
          <a class="nav-link active" href="#">
            <i class="fas fa-sign-out-alt"></i>Выход</a>
        </li>      
      </ul>
    </div>
</div>

<div class="simple-box">
  <div class="left-sidebar">
      <span class="title">Главное меню</span>
      <ul class="nav flex-column">
        <li class="nav-item">
          <a class="nav-link active" href="{{route('main-page')}}">
            <i class="fas fa-home"></i>Главная</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="{{route('dashboard')}}">
          <i class="fas fa-tachometer-alt"></i>Панель управления</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="{{route('datamining')}}">
          <i class="fas fa-wrench"></i>Сбор данных</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="{{route('add_script')}}">
          <i class="fas fa-plus-circle"></i>Установка драйвера</a>
        </li>      
        <li class="nav-item">
          <a class="nav-link" href="#">
          <i class="far fa-file-archive"></i>Компоновка</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">
          <i class="fas fa-cogs"></i>Настройки</a>
        </li>
      </ul>
    </div>
</div>


@if(isset($hst) && count($hst) != 0 )
<div class="simple-box">
  <div class="left-sidebar">
      <span class="title">История</span>
      <ul class="nav flex-column">

        <?php $ind = 1 ?>
        @foreach($hst as $h)
          <li class="nav-item">
            @if($h->status == 1)
              <span class="nav-link" href="#" style="color:green;">{{$ind}}) {{$h->getDriver()->name}}</span>
            @else
              <span class="nav-link" href="#" style="color:red;">{{$ind}}) {{$h->getDriver()->name}}</span>
            @endif
          </li>
          <?php $ind++; ?>
        @endforeach

      </ul>
    </div>
</div>
@endif