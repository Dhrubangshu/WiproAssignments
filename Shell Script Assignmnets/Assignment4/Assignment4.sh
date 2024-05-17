 mkdir -p TestDir
 for ((i = 1; i <= 10; i++))
  do
	 fname="File${i}.txt"
	 echo "$fname" > "TestDir/$fname"
 done
 echo "Files created"
