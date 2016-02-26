def lines = [
   "# Tip I-14: Hold your breath", 
   "## Tip II-14: Hold your breath", 
   "### Tip III-14: Hold your breath", 
   "#### Tip IV-14: Hold your breath", 
   "abc", 
   "#### Tip IV-3:"]

lines.each{ line ->
   if (line =~ /^#{1,3} Tip/) {
       println "misformated tip error: $line"
   }    
}

true