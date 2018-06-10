class GroovyEx {

    static void main(String[] args){
        println "Hello World"

        println "5 + 4 = " + (5 + 4)
        println "5 - 4 = " + (5 - 4)
        println "5 * 4 = " + (5 * 4)
        println "5 / 4 = " + (5.intdiv(4))
        println "5 % 4 = " + (5 % 4)

        println "5.2 + 4.4 = " + (5.2.plus(4.4))
        println "5.2 - 4.4 = " + (5.2.minus(4.4))
        println "5.2 * 4.4 = " + (5.2.multiply(4))
        println "5.2 / 4.4 = " + (5.2 / 4.4)
    }
}
