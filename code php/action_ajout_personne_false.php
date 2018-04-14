<meta charset="utf-8" />
<div align="right"><a href="index.php"><input type="submit" value="Retour acceuil"></a></div>
<?php
include 'connexion.php';
$test = connectBdd();
$idPersonneMVTP = $_GET['idPersonneMVTP'];
$titre = $_GET['titre'];
$nom = $_GET['nom'];
$prenom = $_GET['prenom'];
$mise_a_jour = $_GET['mise_a_jour'];
$adresse1 = $_GET['adresse_1'];
$adresse2 = $_GET['adresse_2'];
$adresse3 = $_GET['adresse_3'];
$code_postal = $_GET['code_postal'];
$ville = $_GET['ville'];
$departement = $_GET['departement'];
$departement_rattache = $_GET['departement_rattache'];
$date_de_naissance = $_GET['date_de_naissance'];
$lieu_de_naissance = $_GET['lieu_de_naissance'];
$numero_passeport = $_GET['numero_passeport'];
$date_passeport = $_GET['date_passeport'];
$prefecture = $_GET['prefecture'];
$fiche = $_GET['fiche'];
$petitionnaire = $_GET['petitionnaire'];
$elus = $_GET['elus'];
$retour = $_GET['retour'];
$mairie = $_GET['mairie'];
$bibliotheque = $_GET['bibliotheque'];
$etranger = $_GET['etranger'];
$remarque = $_GET['remarque'];



#récupération de l'idPersonne MAX.
$idPersonne = pg_query($test, "SELECT MAX(\"idPersonne\") FROM public.\"Personne\"");
$row_id_personne = pg_fetch_array($idPersonne);
$idPersonne_Bon = $row_id_personne[0]+1;

#Requête INSERT INTO Personne
$insert_into_personne = pg_query($test, "INSERT INTO public.\"Personne\"(
	\"idPersonne\",
	 \"idPersonneMVTP\",
	  \"Titre\",
	   \"Nom\",
	    \"Prenom\",
	     \"MiseAJour\",
	      \"Adresse1\",
	       \"Adresse2\",
	        \"Adresse3\",
	         \"CodePostal\",
	          \"Ville\",
	           \"Departement\",
	            \"DepartementRattache\",
	             \"dateNaissance\",
	              \"LieuDeNaissance\",
	               \"NumeroPasseport\",
	                \"DatePasseport\",
	                 \"Prefecture\",
	                  \"RefComite\",
	                   \"Fiche\",
	                    \"Petitionnaire\",
	                     \"Elus\",
	                      \"Retour\",
	                       \"Mairie\",
	                        \"Bibliotheque\",
	                         \"Etranger\",
	                          \"Remarque\")
	VALUES ('$idPersonne_Bon',
	 '$idPersonneMVTP',
	  '$titre',
	   '$nom',
	    '$prenom',
	     '$mise_a_jour',
	      '$adresse1',
	       '$adresse2',
	        '$adresse3',
	         '$code_postal',
	          '$ville',
	           '$departement',
	            '$departement_rattache',
	             '$date_de_naissance',
	              '$lieu_de_naissance',
	               '$numero_passeport',
	                '$date_passeport',
	                 '$prefecture',
	                  DEFAULT,
	                   '$fiche',
	                    '$petitionnaire',
	                     '$elus',
	                      '$retour',
	                       '$mairie',
	                        '$bibliotheque',
	                         '$etranger',
	                          '$remarque')");

#Requête pour afficher la personne qui vient d'être ajouté :
$resultat = pg_query($test, "SELECT * FROM public.\"Personne\" WHERE \"idPersonne\" = $idPersonne_Bon" );
$total = pg_num_rows($resultat);

if($total) {
    echo 'La Personne "' . $nom . '"' .'à bien été ajouté'. '<br><br>';
    echo '<table bgcolor="white"' . "\n";
    echo '<tr>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>idPersonne</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>idPersonneMVTP</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Titre</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Nom</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Prenom</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Mise à Jour</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Adresse1</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Adresse2</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Adresse3</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Code Postal</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Ville</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Departement</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Departement rattaché</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Date de Naissance</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Lieu de Naissance</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Numéro de Passeport</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Date du Passeport</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Prefecture</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Ref comité</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Fiche</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Petitionnaire</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Elus</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Retour</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Mairie</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Bibliothèque</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Etranger</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Remarque</u></b></font></td>';


    echo '</tr>' . "\n";

    while ($row3 = pg_fetch_array($resultat)) {
        echo '<tr>';
        echo '<td bgcolor="#dddddd">' . $row3["idPersonne"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["idPersonneMVTP"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["Titre"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["Nom"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["Prenom"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["MiseAJour"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["Adresse1"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["Adresse2"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["Adresse3"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["CodePostal"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["Ville"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["Departement"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["DepartementRattache"] . '</td>'.'<br>';
        echo '<td bgcolor="#dddddd">' . $row3["dateNaissance"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["LieuDeNaissance"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["NumeroPasseport"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["DatePasseport"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["Prefecture"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["RefComite"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["Fiche"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["Petitionnaire"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["Elus"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["Retour"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["Mairie"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["Bibliotheque"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["Etranger"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["Remarque"] . '</td>';

        echo '</tr>' . "\n";

    }
    echo '</table>' . "\n" . "<br><br><br>";
}
?>



