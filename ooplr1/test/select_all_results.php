<?php

require_once 'core/init.php';

//DB::getInstances();


$user = DB::getInstances()->get('users', array('username', '=', 'summmmit'));

if(!$user->count()){
echo 'No User';
}
else
{
	echo $user->first()->username;
	/*
	//    this loop will loop through all the queries returned .
	//     just use $user = DB::getInstances()->query("select * from users");
	foreach($user->results() as $user){
		echo $user->username. '<br>';
	}*/
}








