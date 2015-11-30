<?php 

$var = array(
0 => array(
'name' => 'Deepa Singh',
'city' => 'Kyoto'
),
1 => array(
'name' => 'Shivi Singh',
'city' => 'Mumbai'
),
2 => array(
'name' => 'Summiee Singh',
'city' => 'California'
),
3 => array(
'name' => 'Shivi Singh',
'city' => 'Delhi'
),
);

$user = array(
'users' => $var
);

print_r(json_encode($user));