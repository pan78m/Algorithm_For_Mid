<?php
define('DBNAME','my_first_app');
define('DBUSER','root');
define('DBPASS','');
define('DBHOST','localhost');


try{
    $dbh = new PDO("mysql:host=$DBHOST;dbname=$DBNAME",$DBUSER, $DBPASS);
    $dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
   echo "Successfully connected to database";

}catch(PDOException $e){
    echo "Issue-> Connection failed: " . $e->getMessage();
}


?>