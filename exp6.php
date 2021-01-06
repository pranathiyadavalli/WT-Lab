<?php
    $a1=array(11,3,15,72,5);
    $a2=array(4,37,20,1,63);
    $num=array_merge($a1,$a2);
    array_multisort($num,SORT_DESC,SORT_NUMERIC);
	echo 'Sorted array in descending order : ';
    print_r($num);
?>