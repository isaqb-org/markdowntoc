def TIPFORMAT = /#### Tip*/
def WRONGTIPFORMAT = /^#{1,3} Tip/

def lines = [
   "# Tip I-14: bad", 
   "## Tip II-14: badder", 
   "### Tip III-14: very bad indeed", 
   "#### Tip IV-14: Great tip", 
   "abc", 
   "#### Tip IV-3: Another good one"]

lines.each{ line ->
   println line
   println ((line =~ TIPFORMAT) == true)
   
   if (line =~ /^#{1,3} Tip/) {
       println "misformated tip error: $line"
       
    }    
}

true