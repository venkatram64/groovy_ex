class Person {

    String first
    String last
    def languages = []

    void work(){
        println "$first $last knows $languages"
    }

    static void main(String[] args){
        Person p = new Person()
        p.first = "Venkatram"
        p.setLast("Veerareddy")
        p.languages << "Groovy"
        p.languages << "Java"

        p.work()
    }
}

