<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
use App\User as User;
use App\Driver as Driver;

class History extends Model
{
    protected $table = 'history';

    protected $fillable = [
        'driver_id', 'user_id', 'status'
    ];

    public function user() {
    	return $this->hasMany('App\User', 'id')->first();
		}	

    public function getUser() {
        return User::where("id", $this->user_id)->first();
    }

    public function getDriver() {
    	return Driver::where("id", $this->driver_id)->first();
    }
}
