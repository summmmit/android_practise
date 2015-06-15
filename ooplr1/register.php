<?php

require_once 'core/init.php';

if(Input::exists())
{
    if(Token::check(Input::get('token'))){
	$validate = new Validate();
                
	$validation = $validate->check($_POST, array(
           'username' => array(
           	    'required' =>true,
           	    'min' => 2,
           	    'max' => 20,
           	    'unique' => 'users'

           	),
           'password' => array(
           	    'required' =>true,
           	    'min' => 6

           	),
           'password_again' => array(
                 'required' =>true,
                 'matches' => 'password'
           	),
           'name' => array(
           	     'required' =>true,
           	     'min' => 2,
           	     'max' => 50

           	)

		));
        
        if($validation->passed()){
            $user = new User();
            $salt = Hash::salt(32);
            try{
                $user->create(array(
                    'username' => Input::get('username'),
                    'password' => Hash::make(Input::get('password'), $salt),
                    'salt' => $salt,
                    'name' => Input::get('name'),
                    'joined' => date('Y-m-d H:i:s'),
                    'group' => 1,
                    
                ));
                
                Session::flash('home', 'you have successfully registered now go to login page');
                Redirect::to('index.php');
                
            } catch (Exception $ex) {
                
                die($ex->getMessage());
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
        <label for="username" >Username</label>
        <input type="text" name="username" id="username" value="<?php echo escape(Input::get('username')); ?>" autocomplete="off">
         
    </div>

    <div class="field">
         <label for="password">Choose a password</label>
         <input type="password" name="password" id="password">

    </div>
    <div class="field">
         <label for="password_again">Enter your password again</label>
         <input type="password" name="password_again" id="password_again" value="" autocomplete="off">
         
    </div>
    <div class="field">
         <label for="name">Name</label>
         <input type="text" name="name" id="name" value="<?php echo Input::get('name'); ?>" autocomplete="off">
         
    </div>
    <input type="hidden" name="token" value="<?php echo Token::generate();  ?>">
    <div class="field">
         <input type="submit" value="Submit Form">
         
    </div>
<ul>
    <li><a href="login.php">Log In</a></li>  	
</ul>


</form>