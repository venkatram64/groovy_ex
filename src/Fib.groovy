def fib(n){
    if(n == 1 || n == 2)
        1
    else fib(n - 1) + fib(n - 2)
}

def fib2 = fib2 = { n ->
    if(n == 1 || n == 2)
        1
    else fib(n - 1) + fib(n - 2)
}.memoize()

TimeIt.code {
    println fib2(400)
}
