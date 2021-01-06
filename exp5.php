<html>
<head>
<title></title>
</head>
<body>
<form method="post">
<input type="text" name="name" placeholder="Enter a string"/><br><br>
<input type="text" name="word" placeholder="Enter a search word"/><br><br>
<input type="submit" name="OK" />
</form>
<?php
function Reverse($str){ 
    return strrev($str); 
} 
if(isset($_POST['OK'])){
$str = $_POST['name'];
$str1 = $_POST['word'];
echo 'Length of string = ';
echo strlen($str); 
echo '<br>';
echo 'Number of words in string = ';
echo str_word_count($str);
echo '<br>';
echo 'Reverse of string = ';
echo Reverse($str);
echo '<br>';
if (strpos($str,$str1) !== false) 
 {
    echo 'The search word is present.';
 }
else
 {
    echo 'The search word is not present.';
 }
}

?>

</body>
</html>