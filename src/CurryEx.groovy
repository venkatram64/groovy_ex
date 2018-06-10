
//Haskel Curry  Lambda Calculus

def log = {level, date, msg ->
    println "$level $date $msg"
}

def today = new Date()

//log 'Warning', today, 'starting'
//log 'Warning', today, 'running'

def logWarningToday = log.curry('Warning',today) //cached two parameters

logWarningToday 'starting'

logWarningToday 'running'


def langs = ['C++': 'Stroustrup','Java': 'Gosling','Lisp': 'McCarth', 'Ruby':'Matz']

langs.each { entry -> println entry}

langs.each {k,v -> println "$k --- $v"}


def factorial(number){
    def result = 1
    for(i in 1..number){
        retult *= i
    }
    result
}

//println factorial(5)

def fact(number){
    if(number == 1)
        1
    else
        number * fact(number - 1)
}

//println fact(5)

//SICP    Structure an interpretation computer programming

//TCO  tail call optimization

def foo = foo = {fact, n ->
    if(n == 1)
        fact
    else
        return foo.trampoline(fact*n, n-1)
}.trampoline()

println foo(1,5)