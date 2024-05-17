h_error(){
	local error_sms="$1"
	echo "Error: $error_sms"
	exit 1
}
files(){
	local debug="$1"
	if [ -d "TestDir" ]
	then 
		h_error "Directory already present"
	fi
	mkdir -p TestDir || h_error "Failed to create directory"

	for ((i = 1; i <= 10; i++))
	do
		fname="File${i}.txt"
		echo "$fname" > "TestDir/$fname" || h_error "Failed tp create directory"
	if [ "$debug" = "true" ]
	then 
	echo "Created file: TestDir/$fname"
	fi
        done
	echo "Files created"
}
if [ "$1" = "--debug" ]
then
	debug="true"
else
	debug="false"
fi
files "$debug"
