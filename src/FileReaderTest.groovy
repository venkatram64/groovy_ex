import groovy.xml.MarkupBuilder

if(!(args.size() in 1..2)){
    println "Incorrect number of arguments"
    println()
    println "USAGE: textAnalyzer TEXTFILE [STRING]"
    System.exit 1
}

def content = new File(args[0]).text
def charCount = content.size()
def wordCount = content.split(/\W+/).size()

def stringCount
if(args.size() == 2){
    stringCount = content.count(args[1])
}

println "Character:".padRight(15) + charCount
println "Words".padRight(15) + wordCount

new File("text-report.xml").withWriter {Writer w ->
    def builder = new MarkupBuilder(w)
    builder.report {
        'char-count'(charCount)
        'word-count'(wordCount)
        if(stringCount){
            'string-search' {
                string(args[1])
                occurrences(stringCount)
            }
        }
    }
}
