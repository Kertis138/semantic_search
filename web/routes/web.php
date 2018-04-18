<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});

Auth::routes();

Route::get('/main-page', 'HomeController@main_page')->name('main-page');
Route::get('/dashboard', 'UserController@dashboard')->name('dashboard');

Route::get("/api/status", "ApiController@status");
