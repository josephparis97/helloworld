<?php 
function connexionPDO()
{
	$login="id5068369_root";
	$mdp="root123";
	$bd="id5068369_logintable";
	$server="localhost";
	try{
		$conn=new PDO("mysql:host=$server;dbname=$bd", $login, $mdp);
		
		
		return $conn;

	}catch(PDOException $e){
		print "erreur de connection";
		die();
	}
}

?>