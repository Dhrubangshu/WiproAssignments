lines(){
	fname="$1"
	l=$(wc -l < "$fname")
	echo "Lines in $fname: $l"
}
lines "file1.txt"
lines "file2.txt"
lines "file3.txt"




	
