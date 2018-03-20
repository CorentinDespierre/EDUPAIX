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
$con="host=148.60.11.198 port=5432 dbname=Edupaixv1 user=Corentin password=EBEG1994";
$db=pg_connect($con) or die('connection failed');
echo 'Connected to: ', pg_dbname($db);
$result = pg_query($db, "SELECT * FROM premiertest");
echo "insertinto";
if (!$result) {
  echo "Une erreur s'est produite.\n";
  exit;
}

while ($row = pg_fetch_row($result)) {
  echo "Auteur: $row[0]  E-mail: $row[1]";
  echo "<br />\n";
}
?>
  </body>
</html>