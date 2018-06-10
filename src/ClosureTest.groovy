def list = [1,2,3,4,5]

def list2 = [10,20,30,40,50]

def factor = 2

/*list.each{ e -> println e}  //lambda

println "\n"

def factor = 2
//closure => close over

list.each { e -> println e * factor}
*/

def printIt = { e-> println e * factor}

list.each  printIt

list2.each printIt


//sending closure
//closure is always last parameter
def foo(value, closure){
    closure(value * 2)
}

foo(3, {println it})

//or foo(3){println it}

