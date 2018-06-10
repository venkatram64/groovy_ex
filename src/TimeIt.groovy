class TimeIt {

    def static code(codeBlock){
        def start = System.nanoTime()
        try{
            codeBlock()
        }finally{
            def end = System.nanoTime()
            println "Time taken ${(end - start)/1.0e9}"
        }
    }
}
