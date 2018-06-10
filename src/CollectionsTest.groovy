
def list = [12,13,15,17,18,19,20]

list.eachWithIndex{ int entry, int i ->
    println "$entry, $i"
}

List days = ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"]

List weekEnd = days.findAll{it.startsWith("S")}

weekEnd.each{println it}

List newList = list.collect{num -> num * 10}

println newList