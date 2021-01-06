<?php
$myfile = fopen("newfile.txt", "r") or die("Unable to open file");
$text = fread($myfile, filesize("newfile.txt"));
fclose($myfile);
$myfile = fopen("newfile2.txt", "w") or die("Unable to open file");
fwrite($myfile, $text);
echo"Successfully read from file 1 and written to file 2";
fclose($myfile);
?>
