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
Route::get('/datamining', 'UserController@datamining')->name('datamining');
Route::get('/add_script', 'UserController@add_script')->name('add_script');

Route::get("/api/status", "ApiController@status");
Route::get("/api/status/requestCount", "ApiController@requestCount");
Route::post("/api/script_add", "ApiController@script_add");
Route::get("/api/driver_run/{id}", "ApiController@driver_run");