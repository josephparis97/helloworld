<?php 
	include "fonctions.php";

	//controle de reception des paramètres
	if(isset($_REQUEST["operation"])){

		//demande de recuperation du dernier profil
		if ($_REQUEST["operation"]=="dernier") {
			try{
				print ("dernier%");
				$cnx=connexionPDO();
				$req = cnx->prepare("select * from logintable order by datemesure desc ");
				$req->execute();

				//s'il y a un profil déjà entré
				if($ligne = $require->fetch(PDO::FETCH_ASSOC)){
					print(json_encode($ligne));
				}


			}catch(PDOException $e){
				print "erreur".$e->getMessage();
				die();
			}
		}

		elseif ($_REQUEST["operation"]=="enreg") {
			
			try{
				//recuperationdes données en post
				$lesdonnees = $_REQUEST["lesdonnees"];
				$donnees = json_decode($lesdonnees);
				//$datemesure = $donnees[0];
				$login = "".$donnees[1];
				$mdp = "".$donnees[2];

				print ("enreg%");
				$cnx=connexionPDO();
				$larequete = "insert into logintable (datemesure, login, mdp)";
				//$larequete .= " values (\"$datemesure\", $login, $password)";
				$larequete .= " values (NOW(), \"$login\", \"$mdp\")";
				print ($larequete);
				$req = $cnx->prepare($larequete);
				$req->execute();

			}catch (PODException $e){
				print "erreur".$e->getMessage();
				die();
			}


		}
	}

?>