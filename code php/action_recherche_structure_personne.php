<meta charset="utf-8" />
<div align="right"><a href="index.php"><input type="submit" value="Retour acceuil"></a></div>
<?php
include 'connexion.php';
$test = connectBdd();
$idStructure = $_GET['idStructure'];


$resultat = pg_query($test, "SELECT * FROM public.\"Structure\" WHERE \"idStructure\" = $idStructure" );
$Personnes = pg_query($test, "SELECT * FROM public.\"Personne\" WHERE \"RefComite\" = $idStructure" );
$nbPersonnes =  pg_numrows($Personnes);
$total = pg_num_rows($resultat);

if(!$total){
    echo 'pas de résultat';
}




    echo 'Structure choisie'.'<br><br>';
    echo '<table bgcolor="white"' . "\n";
    echo '<tr>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>idStructure</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Nom</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Adresse</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Adresse2</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Niveau</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Déclarée</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Document Déclaration</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Actif</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Siret</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>RNA</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Contact</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Possession Local</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Date Parution JO</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Type</u></b></font></td>';
    echo '</tr>' . "\n";

    while ($row = pg_fetch_array($resultat)) {
        echo '<tr>';
        echo '<td bgcolor="#dddddd">' . $row["idStructure"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row["NomStructure"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row["Adresse"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row["Adresse2"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row["Niveau"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row["Declaree"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row["DocDeclaration"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row["Actif"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row["Siret"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row["RNA"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row["Contact"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row["PossessionLocal"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row["DateParutionJO"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row["Type"] . '</td>';
        echo '</tr>' . "\n";

    }
    echo '</table>' . "\n" . "<br><br><br>";

if($Personnes) {
    echo 'Il y a'.' '.$nbPersonnes.' '.'Personnes associées à cette structure'. '<br><br><br>';
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

    while ($row3 = pg_fetch_array($Personnes)) {
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
        echo '<td bgcolor="#dddddd">' . $row3["DepartementRattache"] . '</td>';
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