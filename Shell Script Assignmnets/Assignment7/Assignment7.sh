file="$1"
opfile="$2"
sed 's/old_text/new_text/g' "$file" > "$opfile"

echo "Replacement done"
