<?php
function connectBdd()
{
    $con = "host=148.60.11.198 port=5432 dbname=Edupaixv1 user=Corentin password=EBEG1994";
    $db = pg_connect($con) or die('connection failed');
    return $db;
}


?>