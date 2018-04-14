
<html>
<meta charset="utf-8" />
<head>
    <center> <h1>Ajout Personne :</h1></center>
    <div align="right"><a href="index.php"><input type="submit" value="Retour acceuil"></a></div>
</head>

<body bgcolor=white>
<form action="formulaire_ajout_personne_reponse_false.php" method="get">
    La personne appartiendra-t-elle à un comité ? :
    <input type="radio" name="appartient_comite" value="true" required> Oui
    <input type="radio" name="appartient_comite" value="false" required> Non<br><br>
    <input type="submit" value="Valider">
</form>


</body>
</html>