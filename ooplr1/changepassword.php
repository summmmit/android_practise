<?php

require_once 'core/init.php';

$user = new User();

if(!$user->isLoggedIn()){
Redirect::to('index.php');
}

if(Input::exists())
{
    if(Token::check(Input::get('token'))){
		$validate = new Validate();
                
	$validation = $validate->check($_POST, array(
           'password_current' => array(
		    'required' =>true,           	    
		   ),
		   'password_new' => array(
		    'required' =>true,
           	    'min' => 4,
		   ),
		   'password_again' => array(
		    'required' =>true,
           	    'min' => 2,
           	    'matches' => 'password_new'
				),
           	    
		));
        
        if($validation->passed()){
            
			if(Hash::make(Input::get('password_current'), $user->data()->salt)!=$user->data()->password){
			echo 'Your Current password is wrong ';
			}
			else{
			$salt = Hash::salt(32);
			
			$user->update(
			array(
			'password' => Hash::make(Input::get('password_current'),$salt),
			'salt' => $salt
			)
			);
			
			Session::flash('home', 'you have successfully changed password');
                Redirect::to('index.php');
			
			}
			
        }
 else {
            foreach ($validation->errors() as $errors){
                echo $errors.'<br>';
            }
 }
	}
}



?>


<form action="" method="post">
    <div class="field">
        <label for="password_current" >Your Current Password</label>
        <input type="password" name="password_current" id="password_current" value="" autocomplete="off">
         
    </div>

    <div class="field">
         <label for="password_new">Your New Password</label>
         <input type="password" name="password_new" id="password_new" value="" autocomplete="off">

    </div>

     <div class="field">
         <label for="password_again">Enter Again Your Password</label>
         <input type="password" name="password_again" id="password_again" value="" autocomplete="off">
    </div>
   
    <div class="field">
         <input type="submit" value="Submit Form">
       <input type="hidden" name="token" value="<?php echo Token::generate();  ?>">   
    </div>
</form>
<ul>
    <li><a href="index.php">Go to Profile Page</a></li>  	
</ul>