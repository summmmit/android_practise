<?php

echo 'i am in Index.php'."<br>";
require_once 'core/init.php';

//DB::getInstances();


$user = DB::getInstances()->update('users', 1, array(
             
             'username' => 'deepa',
             'password' => 'passsw',
             'salt' => 'salts'


	));








