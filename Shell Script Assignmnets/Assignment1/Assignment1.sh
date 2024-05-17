read -p "Enter the file name to be searched: " filename

if [ -e "$filename" ]
then
	echo "File exists"
else
	echo "File not found"
fi
