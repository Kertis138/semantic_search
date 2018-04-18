<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class ApiController extends Controller
{

	public function __construct()
    {
        $this->middleware('auth');
    }

    public function status() {
		$ch = curl_init();
		curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
		curl_setopt($ch, CURLOPT_URL, 
		    'http://127.0.0.1:8080/api/status/myRequestCount'
		);
		$content1 = curl_exec($ch);
		if($content1 == false)
			return '{"status":"0"}';
		$json_content1 = json_decode($content1);


		curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
		curl_setopt($ch, CURLOPT_URL, 
		    'http://127.0.0.1:8080/api/status/allRequestCount'
		);
		$content2 = curl_exec($ch);
		if($content2 == false)
			return '{"status":"0"}';
		$json_content2 = json_decode($content2);
		$json_content2->requestCount = array_merge($json_content1->requestCount,$json_content2->requestCount);

    	return json_encode($json_content2);
    }
}
