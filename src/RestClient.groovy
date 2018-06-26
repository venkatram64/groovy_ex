import groovy.json.JsonOutput
import groovy.json.JsonParserType
import groovy.json.JsonSlurper
////https://stackoverflow.com/questions/12732422/adding-header-for-httpurlconnection
//https://stackoverflow.com/questions/16213242/how-do-i-make-a-call-to-the-yahoo-hourly-weather-forecast-api
//https://github.com/xmlking/nifi-scripting

/*
https://www.logicmonitor.com/support/terminology-syntax/scripting-support/access-a-website-from-groovy/

https://sites.google.com/a/athaydes.com/renato-athaydes/code/groovy---rest-client-without-using-libraries

https://www.codota.com/code/java/classes/java.net.HttpURLConnection

https://stackoverflow.com/questions/25692515/groovy-built-in-rest-http-client
 */

def weatherTest1() {

    def weather = new URL("https://query.yahooapis.com/v1/public/yql?q="
            + URLEncoder.encode("select wind from weather.forecast where woeid in " +
            "(select woeid from geo.places(1) where text = 'chicago,il')", "UTF-8")).text

    println weather
}

def weatherTest2(){
    def connection = new URL("https://query.yahooapis.com/v1/public/yql?q="
            + URLEncoder.encode("select wind from weather.forecast where woeid in " +
            "(select woeid from geo.places(1) where text = 'chicago,il')", "UTF-8"))
            .openConnection() as HttpURLConnection

    //set some headers

    connection.setRequestProperty('User-Agent', 'groovy-2.4.4')
    connection.setRequestProperty('Accept', 'application/json')

    println connection.responseCode + ": " + connection.inputStream.text
}

def weatherTest3(){
    def scanner = new Scanner(System.in) as Scanner
    println 'Enter Location'

    def location = scanner.nextLine()//System.console().readLine('Location:')
    def connection = new URL("https://query.yahooapis.com/v1/public/yql?q="
            + URLEncoder.encode("select wind from weather.forecast where woeid in " +
            "(select woeid from geo.places(1) where text = '$location')", "UTF-8"))
            .openConnection() as HttpURLConnection

    //set some headers

    connection.setRequestProperty('User-Agent', 'groovy-2.4.4')
    connection.setRequestProperty('Accept', 'application/json')

    println connection.responseCode + ": " + connection.inputStream.text
}

def weatherTest4(){

    //https://developer.yahoo.com/weather/
    def scanner = new Scanner(System.in) as Scanner

    println 'Enter Location'

    def location = scanner.nextLine()//System.console().readLine('Location:')
    def connection = new URL("https://query.yahooapis.com/v1/public/yql?q="
            + URLEncoder.encode("select wind from weather.forecast where woeid in " +
            "(select woeid from geo.places(1) where text = '$location')", "UTF-8"))
            .openConnection() as HttpURLConnection

    connection.setRequestProperty('User-Agent', 'groovy-2.4.4')
    connection.setRequestProperty('Accept', 'application/json')

    if(connection.responseCode == 200){
        //get the JSON response
        def json = connection.inputStream.withCloseable {inStream ->
            new JsonSlurper().parse(inStream)
        }
        //extract some data from the JSON, printing a report
        println json
        def channel = json.query.results.channel
        //println item.title


        //show some forecasts
        println "Wind: "

        channel.each{k,v->
            println " + ${v}"
        }
    }else{
        println connection.responseCode+ ": " + connection.inputStream.text
    }


}

def getToken(){

    def connection = new URL("https://reqres.in/api/login").openConnection() as HttpURLConnection
    def auth = [:]

    auth.email = "peter@klaven"
    auth.password = "cityslicka"

    def json = JsonOutput.toJson(auth)

    println json

    connection.setRequestMethod("POST");
    connection.setRequestProperty("User-Agent","Mozilla/5.0");
    connection.setRequestProperty("Content-Type","application/json; charset=UTF-8");
    connection.setRequestProperty("Content-Length",String.valueOf(json.getBytes("UTF-8").length));
    connection.setRequestProperty("Content-Language","en-US");
    connection.setDoOutput(true);

    connection.outputStream.withCloseable{outStream ->
        outStream.write(json.getBytes("UTF-8"))
    }

    if(connection.responseCode == 200){
        def jsonResponse = connection.inputStream.withCloseable{inStream ->
            new JsonSlurper().parse(inStream)
        }
        println jsonResponse
    }else{
        println "Response Code: " + connection.responseCode
        println "Response Message: " + connection.responseMessage
    }
}

//weatherTest1()
//weatherTest2()

//weatherTest3()  //Stockholm, Sweden

//weatherTest4()  //Stockholm, Sweden
//200: {"query":{"count":1,"created":"2018-06-24T06:35:52Z","lang":"en-US","results":{"channel":{"wind":{"chill":"64","direction":"290","speed":"14"}}}}}
//[query:[count:1, created:2018-06-24T07:11:26Z, lang:en-US, results:[channel:[wind:[chill:64, direction:290, speed:14]]]]]

getToken()