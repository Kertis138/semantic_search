<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
use App\User as User;

class Driver extends Model
{
    protected $table = 'drivers';

    protected $fillable = [
        'text', 'user_id', 'name'
    ];

    public function user() {
    	return $this->hasMany('App\User', 'id')->first();
	}	

    public function getUser() {
        return User::where("id", $this->user_id)->first();
    }
}
