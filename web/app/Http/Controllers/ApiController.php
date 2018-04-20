<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Driver as Driver;
use Illuminate\Support\Facades\Auth;

class ApiController extends Controller
{

	public function __construct()
    {
        $this->middleware('auth');
    }

    public function requestCount() {
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

    public function status() {
		$ch = curl_init();
		curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
		curl_setopt($ch, CURLOPT_URL, 
		    'http://127.0.0.1:8080/api/status'
		);
		$content1 = curl_exec($ch);
		curl_close ($ch);
		if($content1 == false)
			return '{"status":"0"}';
		return $content1;
    }

    public function script_add(Request $request) {
		if (!$request->has('script') || !$request->has('name')) {
		    return 0;
		}

    	$script = $request->post('script');
    	$name = $request->post('name');
    	if($script == null || $name == null)
    		return 0;

		Driver::create(["name" => $name, "text"=>htmlentities($script), "user_id"=>Auth::user()->id]);

    	return 1;
    }

    public function driver_run($id) {
 		$ch = curl_init();
		curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
		curl_setopt($ch, CURLOPT_URL, 
		    'http://127.0.0.1:8080/api/execute/script/?driver_id='.$id
		);
		$content = curl_exec($ch);
		curl_close ($ch);
		if($content == false)
			return 0;
		
		$json_content = json_decode($content);
		if ($json_content->status != 1)
			return 0;
		return 1;   	
    }
}
