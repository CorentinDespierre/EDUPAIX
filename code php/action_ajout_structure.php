<meta charset="utf-8" />
<div align="right"><a href="index.php"><input type="submit" value="Retour acceuil"></a></div>
<?php
include 'connexion.php';
$test = connectBdd();
$nom = $_GET['nom'];
$adresse = $_GET['adresse'];
$adress2 = $_GET['adresse2'];
$niveau = $_GET['niveau'];
$declaree = $_GET['declaree'];
$doc_declaration = $_GET['doc_declaration'];
$actif = $_GET['actif'];
$siret = $_GET['siret'];
$rna = $_GET['rna'];
$contact = $_GET['contact'];
$possessionLocal = $_GET['possession_local'];
$dateParutionJO = $_GET['date_parution_journal_offiel'];
$type = $_GET['type'];
$idCommune = $_GET['commune'];
$dateCration = $_GET['date_creation'];
$portable = $_GET['portable'];
$fixe = $_GET['fixe'];
$fixeProfessionnel = $_GET['fixe_professionnel'];
$mobile = $_GET['mobile'];
$fax = $_GET['fax'];
$faxProfessionnel = $_GET['fax_professionnel'];
$mail = $_GET['mail'];

#récupération de l'idStrucure MAX.
$idStructure = pg_query($test, "SELECT MAX(\"idStructure\") FROM public.\"Structure\"");
$row_id_structure = pg_fetch_array($idStructure);
$idStructureBon = $row_id_structure[0]+1;

#récupération de l'idStructure_commune MAX.
$idLiaisonSCo = pg_query($test, "SELECT MAX(\"idLiaisonSCo\") FROM public.\"Structure_Commune\"");
$row_idLiaisonSCo = pg_fetch_array($idLiaisonSCo);
$idLiaisonSCo_bon = $row_idLiaisonSCo[0] + 1;








#Requête INSERT INTO Structure :
$insert_into_Structure = pg_query($test, "INSERT INTO public.\"Structure\"(
	\"idStructure\", \"NomStructure\", \"Adresse\", \"Adresse2\", \"Niveau\", \"Declaree\", \"DocDeclaration\", \"Actif\", \"Siret\", \"RNA\", \"Contact\", \"PossessionLocal\", \"DateParutionJO\", \"Type\")
	VALUES ('$idStructureBon', '$nom', '$adresse', '$adress2', '$niveau', '$declaree', '$doc_declaration', '$actif', '$siret', '$rna', '$contact', '$possessionLocal', '$dateParutionJO', '$type')");







#Requête INSERT INTO Structure_Commune :
$insert_into_StructureCommune = pg_query($test, "INSERT INTO public.\"Structure_Commune\"(
	\"idLiaisonSCo\", \"idStructure\", \"idCommune\")
	VALUES ('$idLiaisonSCo_bon', '$idStructureBon', '$idCommune')");




#Requête INSERT INTO Structure_TypeContact

if($portable){
    #récupération de l'idLiaisonSTC MAX.
    $idLiaisonSTC = pg_query($test, "SELECT MAX(\"idLiaisonSTC\") FROM public.\"Structure_TypeContact\"");
    $row_idLiaisonSTC = pg_fetch_array($idLiaisonSTC);
    $idLiaisonSTC_bon = $row_idLiaisonSTC[0] +1;

    $insert_into_Structure_TypeContact_portable = pg_query($test, "INSERT INTO public.\"Structure_TypeContact\"(
	\"idLiaisonSTC\", \"idStructure\", \"idTypeContact\", information)
	VALUES ('$idLiaisonSTC_bon', '$idStructureBon', '1', '$portable')");
}

if($fixe){
    #récupération de l'idLiaisonSTC MAX.
    $idLiaisonSTC = pg_query($test, "SELECT MAX(\"idLiaisonSTC\") FROM public.\"Structure_TypeContact\"");
    $row_idLiaisonSTC = pg_fetch_array($idLiaisonSTC);
    $idLiaisonSTC_bon = $row_idLiaisonSTC[0] +1;

    $insert_into_Structure_TypeContact_fixe = pg_query($test, "INSERT INTO public.\"Structure_TypeContact\"(
	\"idLiaisonSTC\", \"idStructure\", \"idTypeContact\", information)
	VALUES ('$idLiaisonSTC_bon', '$idStructureBon', '2', '$fixe')");
}

if($fixeProfessionnel){
    #récupération de l'idLiaisonSTC MAX.
    $idLiaisonSTC = pg_query($test, "SELECT MAX(\"idLiaisonSTC\") FROM public.\"Structure_TypeContact\"");
    $row_idLiaisonSTC = pg_fetch_array($idLiaisonSTC);
    $idLiaisonSTC_bon = $row_idLiaisonSTC[0] +1;

    $insert_into_Structure_TypeContact_fixeProfessionnel = pg_query($test, "INSERT INTO public.\"Structure_TypeContact\"(
	\"idLiaisonSTC\", \"idStructure\", \"idTypeContact\", information)
	VALUES ('$idLiaisonSTC_bon', '$idStructureBon', '3', '$fixeProfessionnel')");
}

if($mobile){
    #récupération de l'idLiaisonSTC MAX.
    $idLiaisonSTC = pg_query($test, "SELECT MAX(\"idLiaisonSTC\") FROM public.\"Structure_TypeContact\"");
    $row_idLiaisonSTC = pg_fetch_array($idLiaisonSTC);
    $idLiaisonSTC_bon = $row_idLiaisonSTC[0] +1;

    $insert_into_Structure_TypeContact_mobile = pg_query($test, "INSERT INTO public.\"Structure_TypeContact\"(
	\"idLiaisonSTC\", \"idStructure\", \"idTypeContact\", information)
	VALUES ('$idLiaisonSTC_bon', '$idStructureBon', '4', '$mobile')");
}

if($fax){
    #récupération de l'idLiaisonSTC MAX.
    $idLiaisonSTC = pg_query($test, "SELECT MAX(\"idLiaisonSTC\") FROM public.\"Structure_TypeContact\"");
    $row_idLiaisonSTC = pg_fetch_array($idLiaisonSTC);
    $idLiaisonSTC_bon = $row_idLiaisonSTC[0] +1;

    $insert_into_Structure_TypeContact_fax = pg_query($test, "INSERT INTO public.\"Structure_TypeContact\"(
	\"idLiaisonSTC\", \"idStructure\", \"idTypeContact\", information)
	VALUES ('$idLiaisonSTC_bon', '$idStructureBon', '5', '$fax')");
}

if($faxProfessionnel){
    #récupération de l'idLiaisonSTC MAX.
    $idLiaisonSTC = pg_query($test, "SELECT MAX(\"idLiaisonSTC\") FROM public.\"Structure_TypeContact\"");
    $row_idLiaisonSTC = pg_fetch_array($idLiaisonSTC);
    $idLiaisonSTC_bon = $row_idLiaisonSTC[0] +1;

    $insert_into_Structure_TypeContact_faxProfessionnel = pg_query($test, "INSERT INTO public.\"Structure_TypeContact\"(
	\"idLiaisonSTC\", \"idStructure\", \"idTypeContact\", information)
	VALUES ('$idLiaisonSTC_bon', '$idStructureBon', '6', '$faxProfessionnel')");
}

if($mail){
    #récupération de l'idLiaisonSTC MAX.
    $idLiaisonSTC = pg_query($test, "SELECT MAX(\"idLiaisonSTC\") FROM public.\"Structure_TypeContact\"");
    $row_idLiaisonSTC = pg_fetch_array($idLiaisonSTC);
    $idLiaisonSTC_bon = $row_idLiaisonSTC[0] +1;

    $insert_into_Structure_TypeContact_mail = pg_query($test, "INSERT INTO public.\"Structure_TypeContact\"(
	\"idLiaisonSTC\", \"idStructure\", \"idTypeContact\", information)
	VALUES ('$idLiaisonSTC_bon', '$idStructureBon', '7', '$mail')");
}






#Affichage de la structure qui à été rajoutée.
$resultat3 = pg_query($test, "SELECT * FROM public.\"Structure\" WHERE \"idStructure\"=$idStructureBon ");
$total = pg_num_rows($resultat3);
if($total) {
    echo 'La Structure "'.$nom.'" à bien été ajouté à la base'.'<br><br>';
    echo '<table bgcolor="white"' . "\n";
    echo '<tr>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>idStructure</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Nom</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Adresse</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Adresse2</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Niveau</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Declarée</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>DocDeclaration</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Actif</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Siret</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>RNA</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Contact</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Possession Local</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Date Parution JO</u></b></font></td>';
    echo '<td bgcolor="#006498"><font color="white"><b><u>Type</u></b></font></td>';

    echo '</tr>' . "\n";
    while ($row3 = pg_fetch_array($resultat3)) {
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
    echo '</table>' . "\n";
}
?>
