class MyMailer {

    def to(String adr){println('to')}
    def from(String adr){println('from')}
    def sub(String line){println('sub')}
    def body(String msg){println('body')}

    public static void send(closure){
        MyMailer mailer = new MyMailer()
        closure(mailer)
        println('Sending...')
    }

    public static void send2(closure){
        MyMailer mailer = new MyMailer()
        closure.delegate = mailer
        closure()
        println('Sending...')
    }

    public static void send3(closure){
        MyMailer mailer = new MyMailer()
        def closureClone = closure.clone()
        closureClone.delegate = mailer
        closureClone()
        println('Sending...')
    }

    public static void send4(closure){
        MyMailer mailer = new MyMailer()
        mailer.with  closure
        println('Sending...')
    }
}

MyMailer.send{ mailer ->
    mailer.to('venkat.veerareddy@gmail.com')
    mailer.from('venkat.veerareddy@gmail.com')
    mailer.sub('your code good')
    mailer.body('nice')
}
println "-----delegate---------"
MyMailer.send2{
    to 'venkat.veerareddy@gmail.com'
    from 'venkat.veerareddy@gmail.com'
    sub 'your code good'
    body 'nice'
}

println "-----delegate with clone---------"
MyMailer.send3{
    to 'venkat.veerareddy@gmail.com'
    from 'venkat.veerareddy@gmail.com'
    sub 'your code good'
    body 'nice'
}

println "-----with---------"
MyMailer.send4{
    to 'venkat.veerareddy@gmail.com'
    from 'venkat.veerareddy@gmail.com'
    sub 'your code good'
    body 'nice'
}
