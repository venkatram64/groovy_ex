//prototypical inheritance

def greet = { name -> println "${toUpperCase()} $name"}

def salutations = ['hello','howdy']

for(salutation in salutations){
    greet.delegate = salutation
    greet('Venkatram')
}