println("UW Complex Kotlin homework")

// write a lambda using map and fold to solve "FIZZBUZZ" for the first fifteen numbers (0..15)
// use map to return a list with "", "FIZZ" or "BUZZ" as necessary
// use fold to compress the array of strings down into a single string
// the final string should look like FIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ
//
// In the first section, you will be using the collection methods `map` and `fold` to perform the "FIZZBUZZ test". This is a simple algorithm, usually used as part of an interview process as a way of verifying developer skill (and rather poorly at that). FIZZBUZZ goes like this: Iterate across a sequence of numbers (1 to 15), and any number that is divisible by 3 returns "FIZZ", and any number divisible by 5 returns "BUZZ". Numbers which are divisible by both 3 and 5 return "FIZZBUZZ". Use the `map` function to transform the range of numbers into an list of strings (either "FIZZ", "BUZZ" or the empty string ""), and then use `fold` to combine them all down into a single String. The end result should be "FIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ". (This is an exercise in understanding how `map` and `fold` work, as they are commonly used in Kotlin code, along with `filter`. You are free to use `filter` as well, if you so choose, but you do not need to in order to pass the tests.)

val fizzList =  (1..15).map { num -> stringify(num) }
val mapFoldResults : String = fizzList.fold("") { sum, word -> sum + word}
    
 fun stringify (num : Int): String {   
    if  (num % 3 == 0 && num % 5 == 0) {
        return "FIZZBUZZ"
    } else if (num % 5 == 0) {
        return "BUZZ"
    } else if (num % 3 == 0) {
        return "FIZZ"
    } else {
        return ""
    }
}


// This is a utility function for your use as you choose, and as an
// example of an extension method
fun Int.times(block: () -> Unit): Unit {
    for (it in 1..this) {
        block()
    }
}

// In the second section, your job is to use the process function defined in the script to generate strings. The process function takes a parameter and a block of code. Your job is to write the call to process such that the tests for r1 and r2 pass. (This is an exercise in getting the "block syntax" correct.)

// Use this function
fun process(message: String, block: (String) -> String): String {
    return ">>> ${message}: {" + block(message) + "}"
}
val r1 = process("FOO", {"BAR"}) // call process() with message "FOO" and a block that returns "BAR"


val r2_message = "wooga"
val r2 = process("FOO", { r2_message.toUpperCase().repeat(3)}) 

// call process() with message "FOO" and a block that upper-cases 
// r2_message, and repeats it three times with no spaces: "WOOGAWOOGAWOOGA"


// write an enum-based state machine between talking and thinking


//enum class Philosopher { }

// create an class "Command" that can be used as a function (provide an "invoke()" function)
// that takes a single parameter ("message" of type String)
// primary constructor should take a String argument ("prompt")
// when called, the Command object should return a String containing the prompt and then the message



//class Command(val prompt: String) {
//}




// ================================
 println("map fold test: " + if (mapFoldResults == "FIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ") "." else "!")

 println("r1 test: " + if (r1 == ">>> FOO: {BAR}") "." else "!")

 println("r2 test: " + if (r2 == ">>> FOO: {WOOGAWOOGAWOOGA}") "." else "!")

// var seneca = Philosopher.THINKING
// print("Seneca, talk! ")
// seneca = seneca.signal()
// println(if (seneca.toString() == "Allow me to suggest an idea...") "." else "!")
// print("Seneca, think! ")
// seneca = seneca.signal()
// println(if (seneca.toString() == "Deep thoughts....") "." else "!")
// print("Seneca, talk! ")
// seneca = seneca.signal()
// println(if (seneca.toString() == "Allow me to suggest an idea...") "." else "!")

// print("Command tests: ")
// print(if (Command("")("") == "") "." else "!")
// print(if (Command("> ")("Hello!") == "> Hello!") "." else "!")
// println("")



