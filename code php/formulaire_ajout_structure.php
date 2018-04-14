
<html>
<meta charset="utf-8" />
<head>
   <center> <h1>Ajout structure :</h1></center>
    <div align="right"><a href="index.php"><input type="submit" value="Retour acceuil"></a></div>
</head>

<body bgcolor=white>



<?php
include 'connexion.php';
$test = connectBdd();
$niveau = pg_query($test, "SELECT * FROM public.\"Niveau\"");
$commune = pg_query($test, "SELECT * FROM public.\"Commune\"");
?>


<form action="action_ajout_structure.php" method="get">
    Nom Structure*:<input type="text" name="nom" required><br><br>
    Adressse: <input type="text" name="adresse"><br><br>
    Adressse2: <input type="text" name="adresse2"><br><br>
    Niveau*:
    <select name="niveau" required>
        <?php
        while($row = pg_fetch_array($niveau)) {
            ?>
            <option value=<?php echo $row["idNiveau"]?>><?php echo $row["Libelle"]?></option>
            <?php
        }
        ?>
        <?php
        #Fin de la création du menu déroulant
        ?>
    </select><br><br>
    Declaree ? *:
    <input type="radio" name="declaree" value="true" required> Oui
    <input type="radio" name="declaree" value="false" required> Non<br><br>

    DocDeclaration ? *:
    <input type="radio" name="doc_declaration" value="true" required> Oui
    <input type="radio" name="doc_declaration" value="false" required> Non<br><br>

    Actif ? *:
    <input type="radio" name="actif" value="true" required> Oui
    <input type="radio" name="actif" value="false" required> Non<br><br>

    Siret :<input type="text" name="siret"><br><br>
    RNA :<input type="text" name="rna"><br><br>
    Contact :<input type="text" name="contact"><br><br>

    Possession Local*:
    <input type="radio" name="possession_local" value="true" required> Oui
    <input type="radio" name="possession_local" value="false" required> Non<br><br>

    Date Parution Journal Officiel (yyyy-mm-dd):<input type="text" name="date_parution_journal_offiel" placeholder="annee-mois-jour" value="9999-01-01"><br><br>
    Type :<input type="text" name="type"><br><br>




    Commune :
    <select name="commune" required>
        <?php
        while($row2 = pg_fetch_array($commune)){
        ?>
        <option value=<?php echo $row2["idCommune"] ?>><?php echo $row2["Nom"] ?></option>
        <?php
        }
        ?>
    </select><br><br>



    Date de création* (yyyy-mm-dd): <input type="text" name="date_creation" required placeholder='année-mois-jour' value="9999-01-01"><br><br>



    Portable: <input type="text" name="portable"><br><br>
    Fixe :<input type="text" name="fixe"><br><br>
    FixeProfessionnel :<input type="text" name="fixe_professionnel"><br><br>
    Mobile :<input type="text" name="mobile"><br><br>
    Fax :<input type="text" name="fax"><br><br>
    FaxProfessionnel :<input type="text" name="fax_professionnel"><br><br>
    Mail :<input type="text" name="mail"><br><br>
    <input type="submit" value="Valider">
</form>


</body>
</html>