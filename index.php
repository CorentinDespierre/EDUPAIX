	<html>
	  <head>
		<title>Sample "Hello, World" Application</title>
	  </head>
	  <body bgcolor=white>

		<table border="0" cellpadding="10">
		  <tr>
			<td>
			  <img src="images/springsource.png">
			</td>
			<td>
			  <h1>Sample "Hello, World" Application</h1>
			</td>
		  </tr>
		</table>

		<p>This is the home page for the HelloWorld Web application. </p>
		<p>To prove that they work, you can execute either of the following links:
		<ul>
		  <li>To a <a href="hello.jsp">JSP page</a>.
		  <li>To a <a href="hello">servlet</a>.
		</ul>
		<?php

$con = "host=148.60.11.198 port=5432 dbname=Edupaixv1 user=Corentin password=EBEG1994";
$db = pg_connect($con) and die('connexion reussi') or die('connection failed');
echo 'Connected to: ', pg_dbname($db);
pg_dbname($db);
$resultat = pg_query($db, "SELECT * FROM Petition");
if (!$resultat) {
    echo "Erreur de requête.\n";
    exit;
}

while ($ligne = pg_fetch_array($resultat)) {
    echo "<li>".$ligne['prenom_client']." ".$ligne['nom_client']."</li>";
}
?>
	  </body>
	</html>