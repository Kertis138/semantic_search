<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Driver as Driver;
use App\History as History;
use Illuminate\Support\Facades\Auth;

class UserController extends Controller
{
    public function __construct()
    {
        $this->middleware('auth');
    }

    public function dashboard() {
        $hst = History::where('user_id', Auth::user()->id)->get();
        $drs = Driver::where('user_id',Auth::user()->id)->get();
    	return view("dashboard",["drs"=>$drs, "hst"=>$hst]);
    }

    public function datamining() {
        $drs = Driver::where('user_id',Auth::user()->id)->get();
        $hst = History::where('user_id', Auth::user()->id)->get();
    	return view("datamining",["drs"=>$drs, "hst"=>$hst]);
    }

    public function add_script() {
        return view("add_script");
    }
}
