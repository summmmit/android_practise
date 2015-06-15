<?php

require_once 'core/init.php';

$user = new User();

if(Session::exists('home')){
echo '<p>' .Session::exists('home') .'</p>';
}

if(Input::exists()){
if(Token::check(Input::get('token'))){
$validate = new Validate();
                
	$validation = $validate->check($_POST, array(
           'name' => array(
           	    'required' =>true,
                'min' => 2,
                'max' => 32,				
		)));
        
        if($validation->passed()){
            try{
			$user->update(array(
			'name' => Input::get('name')
			));
			
			Session::flash('home', 'you have successfully Updated your details');
                Redirect::to('index.php');
			
			}
			catch(Exception $e){
			die($e->getMessage());
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
         <label for="name">Name</label>
         <input type="text" name="name" id="name" value="<?php //echo escape($user->data()->name); ?>" autocomplete="off">
         
    </div>
    <input type="hidden" name="token" value="<?php echo Token::generate();  ?>">
    <div class="field">
         <input type="submit" value="Submit Form">
         
    </div>
<ul>
    <li><a href="index.php">Go to Profile Page</a></li>  	
</ul>


</form>