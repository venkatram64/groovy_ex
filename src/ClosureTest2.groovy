def c = {}

println c.class.name

println c instanceof Closure

def sayHello = {name ->
    println "Hello, $name"
}

sayHello("Venkatram")

def list = [12,13,14,15,16,17]

list.each ({n ->
    println n
})

//closures are the objects and last parameter

def timesTen(num, closure){
    closure(num * 10)
}

timesTen(10, {println it})

timesTen(7){
    println it
}

//closure that does not take any arguments

def noparams = {->
    println "no parameters"
}

noparams()

//var arg
def concat = {String... args ->
    args.join(' ')
}

println concat("Venkatram", "Veerareddy")


