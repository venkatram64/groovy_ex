
def person = [first:"Venkatram",last:"Veerareddy",email:"venkat.veerareddy@gmail.com"]

person.twitter = "@venkatram64"

println person

println person.getClass().getName()

person.each{k,v ->
    println k + ", " + v
}

for(key in person.keySet()){
    println "$key: ${person[key]}"
}