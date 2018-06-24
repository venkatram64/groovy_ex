def writer = {
    append 'Venkatram '
    append 'Hyderabad in India'
}

def append(String s){
    println "append() called with argument is $s"
}

writer()

/*StringBuffer sb = new StringBuffer()
writer.resolveStrategy = Closure.DELEGATE_FIRST
writer.delegate = sb
println writer()*/
