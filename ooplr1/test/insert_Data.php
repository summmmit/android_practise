<?php

echo 'i am in Index.php'."<br>";
require_once '../core/init.php';

//DB::getInstances();


$user = DB::getInstances()->insert('users',array(
             
             'username' => 'deepa',
             'password' => 'pass',
             'salt' => 'salt'


	));








