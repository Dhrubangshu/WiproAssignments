while true
do 
	read -p "Enter a number(enter 0 to exit): " n
	if [ "$n" -eq 0 ]
	then
		echo "Script Ended"
	break
	fi
	if [ $((n % 2)) -eq 0 ] 
	then
		echo "Even number"
	else
		echo "Odd number"
	fi
done
