
def people = [
        [name:'Jane',city:"New York City"],
        [name:'John',city:"Cleveland"],
        [name:'Mary',city:"New York City"],
        [name:'Dan',city:"Cleveland"],
        [name:'Tom',city:"New York City"],
        [name:'Frank',city:"New York City"],
        [name:'Jason',city:"Cleveland"]
]

println people.find{person -> person.city == "Cleveland"}

println people.findAll{person -> person.city == "Cleveland"}

println people.any{person -> person.city == "Cleveland"}
println people.every{person -> person.city == "Cleveland"}
println people.every{person -> person.name.size() >= 3}

def peopleByCity = people.groupBy {person -> person.city}
println peopleByCity