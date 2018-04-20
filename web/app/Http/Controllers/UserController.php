<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Driver as Driver;
use Illuminate\Support\Facades\Auth;

class UserController extends Controller
{
    public function __construct()
    {
        $this->middleware('auth');
    }

    public function dashboard() {
    	return view("dashboard");
    }

    public function datamining() {
        $drs = Driver::where('user_id',Auth::user()->id)->get();
    	return view("datamining",["drs"=>$drs]);
    }

    public function add_script() {
        return view("add_script");
    }
}
