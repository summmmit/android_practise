<?php

class User {

    private $_db,
            $_data,
            $_sessionName,
            $_cookieName,
            $_isLoggedIn;
    
    public function __construct($user = null) {
        $this->_db = DB::getInstances();

        $this->_sessionName = Config::get('session/session_name');
        $this->_cookieName = Config::get('remember/cookie_name');

        if(!$user) {
            if(Session::exists($this->_sessionName)){
                $user = Session::get($this->_sessionName);
                if($this->find($user)){
                    $this->_isLoggedIn = true;
                }else{
                    
                }
            }
        } else{
            $this->find($user);
        }
    }

    public function create($fields = array()) {
        if (!$this->_db->insert('users', $fields)) {
            throw new Exception('Problem in creating account');
        }
    }

    public function find($user = null) {
        if ($user) {
            $field = (is_numeric($user)) ? 'id' : 'username';
            $data = $this->_db->get('users', array($field, '=', $user));
            if ($data->count()) {
                $this->_data = $data->first();
                return true;
            }
            return false;
        }
    }

    public function login($username, $password, $remember = false) {
        $user = $this->find($username);
		
	if ($user) {   
            if ($this->data()->password === Hash::make($password, $this->data()->salt)) {
                Session::put($this->_sessionName, $this->data()->id);
                
                if($remember){
                    $hash = Hash::unique();
                    
                    $hashCheck = $this->_db->get('users_session', array('user_id', '=', $this->data()->id));
                    if(!$hashCheck->count()){
                        $this->_db->insert('users_session' , array(
                            'user_id' => $this->data()->id,
                        'hash' => $hash
                        ));
                    }  else {
                    $hash = $hashCheck->first()->hash;    
                    }
                    
                    Cookie::put($this->_cookieName, $hash, Config::get('remember/cookie_expiry'));
                }
                
                return true;
                
            }
        }

        return false;
    }
	
	public function hasPermissions($key){
	/*
	print_r($this->data()->group);
	exit;
	
	$group = $this->_db->get('groups', array('id', '=', $this->data()->group));
	print_r($group->first());
	exit;
	*/
	}
	
	public function update($fields = array(), $id = null){
	
	if(!$id && $this->_isLoggedIn){
	$id = $this->data()->id;
	}
	
	if(!$this->_db->update('users', $id, $fields)){
	throw new Exception('Problem in Updating');
	}
	
	}

   public function data(){
   	       return $this->_data[0];
   }
    
    public function logout(){
        Session::delete($this->_sessionName);
    }


    public function isLoggedIn(){
        return $this->_isLoggedIn;
    }
}