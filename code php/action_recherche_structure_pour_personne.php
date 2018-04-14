<meta charset="utf-8" />
<div align="right"><a href="index.php"><input type="submit" value="Retour acceuil"></a></div>
<?php
include 'connexion.php';
$test = connectBdd();
$nom = $_GET['nom'];

$resultat = pg_query($test, "SELECT * FROM public.\"Structure\" WHERE \"NomStructure\" ILIKE ('%$nom%')" );

$total = pg_num_rows($resultat);

if(!$total){
    echo 'pas de résultat';
}



if($total) {
    echo 'Les Structures qui contiennent le mot : "'.$nom.'"'.'<br><br>';
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

    while ($row3 = pg_fetch_array($resultat)) {
        echo '<tr>';
        echo '<td bgcolor="#dddddd">' . $row3["idStructure"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["NomStructure"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["Adresse"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["Adresse2"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["Niveau"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["Declaree"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["DocDeclaration"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["Actif"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["Siret"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["RNA"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["Contact"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["PossessionLocal"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["DateParutionJO"] . '</td>';
        echo '<td bgcolor="#dddddd">' . $row3["Type"] . '</td>';
        echo '</tr>' . "\n";

    }
    echo '</table>' . "\n" . "<br><br><br>";

    ?>
    <form action="formulaire_ajout_personne_reponse_true.php" method="get">
        Veuillez entrer "idStructure" correspondant à votre choix ! :<input type="number" name="idStructure_pour_personne" required><br><br>
        <input type="submit" value="Valider">
    </form>
    <?php
}
?>