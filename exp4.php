<?php
$number = 2 ;
while ($number < 51 )
{
$div_count=0;
for ( $i=1;$i<=$number;$i++)
{
if (($number%$i)==0)
{
$div_count++;
}
}
if ($div_count<3)
{
echo $number." , ";
}
$number=$number+1;
}
?>