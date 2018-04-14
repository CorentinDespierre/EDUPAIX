<html>
<meta charset="utf-8" />
<head>
    <center> <h1>Ajout Personne :</h1></center>
    <div align="right"><a href="index.php"><input type="submit" value="Retour acceuil"></a></div>
</head>

<body bgcolor=white>



<?php
include 'connexion.php';
$test = connectBdd();
$niveau = pg_query($test, "SELECT * FROM public.\"Niveau\"");
$refComite = pg_query($test, "SELECT * FROM public.\"Structure\"");
$idStructure_pour_personne = $_GET['idStructure_pour_personne']
?>

 <form action="action_ajout_personne_true.php" method="get">
        id Mouvement :<input type="number" name="idPersonneMVTP"><br><br>
        Titre :<select name="titre" required>
            <option>Mme</option>
            <option>Mr</option>
        </select><br><br>

        Nom :<input type="text" name="nom"><br><br>
        Prenom :<input type="text" name="prenom"><br><br>
        Mise à jour (yyyy-mm-dd):<input type="text" name="mise_a_jour" value="9999-01-01"><br><br>
        Adresse 1:<input type="text" name="adresse_1"><br><br>
        Adresse 2:<input type="text" name="adresse 2"><br><br>
        Adresse 3:<input type="text" name="adresse_3"><br><br>
        Code Postal :<input type="number" name="code_postal" value="0"><br><br>
        Ville :<input type="text" name="ville"><br><br>
        Departement :<input type="number" name="departement" value="0"><br><br>
        Departement Rattaché :<input type="number" name="departement_rattache" value="0"><br><br>
        Date de Naissance (yyyy-mm-dd):<input type="text" name="date_de_naissance" value="9999-01-01"><br><br>
        Lieu de Naissance :<input type="text" name="lieu_de_naissance"><br><br>
        Numéro de passeport :<input type="text" name="numero_passeport"><br><br>
        Date Passeport (yyyy-mm-dd):<input type="text" name="date_passeport" value="9999-01-01"><br><br>
        Prefecture :<input type="text" name="prefecture"><br><br>
        Ref comite :<input type="number" name="idStructure_pour_personne" value=<?php echo $idStructure_pour_personne?>><br><br>



        Possession Local:
        <input type="radio" name="possession_local" value="true" required> Oui
        <input type="radio" name="possession_local" value="false" required> Non<br><br>

        Fiche :
        <input type="radio" name="fiche" value="true" required> Oui
        <input type="radio" name="fiche" value="false" required> Non<br><br>

        Petitionnaire :
        <input type="radio" name="petitionnaire" value="true" required> Oui
        <input type="radio" name="petitionnaire" value="false" required> Non<br><br>

        Elus :
        <input type="radio" name="elus" value="true" required> Oui
        <input type="radio" name="elus" value="false" required> Non<br><br>

        Retour :
        <input type="radio" name="retour" value="true" required> Oui
        <input type="radio" name="retour" value="false" required> Non<br><br>

        Mairie :
        <input type="radio" name="mairie" value="true" required> Oui
        <input type="radio" name="mairie" value="false" required> Non<br><br>

        Bibliothèque :
        <input type="radio" name="bibliotheque" value="true" required> Oui
        <input type="radio" name="bibliotheque" value="false" required> Non<br><br>

        Etranger :
        <input type="radio" name="etranger" value="true" required> Oui
        <input type="radio" name="etranger" value="false" required> Non<br><br>

        Remarque :<input type="text" name="remarque"><br><br>

        <input type="submit" value="Valider">
    </form>





</body>
</html>