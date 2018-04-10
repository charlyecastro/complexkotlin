
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
val r1 = process("FOO", {"BAR"}) 
// call process() with message "FOO" and a block that returns "BAR"


val r2_message = "wooga"
val r2 = process("FOO", { r2_message.toUpperCase().repeat(3)}) 

// call process() with message "FOO" and a block that upper-cases 
// r2_message, and repeats it three times with no spaces: "WOOGAWOOGAWOOGA"

// In the third section, you are to create an enum class called Philosopher. This is going to be a peculiar use of enum, however, as we are going to model a very simple state machine: as everybody knows, philosophers split their time between THINKING and TALKING, and only shift from one state to the other when told to do so via the method call signal. Additionally, each state should override the toString function so that when THINKING, a philosopher will return "Deep thoughts..." and when TALKING, a philosopher will return "Allow me to suggest an idea...". If you are not sure of the syntax here, check out the Kotlin reference page on Enum classes. Modeling state machines in a mobile application is a very common occurrence, so it's worth taking the time to give this exercise a shot.

// write an enum-based state machine between talking and thinking


enum class Philosopher { 
    THINKING {
        override fun signal() = TALKING
        override fun toString() = "Deep thoughts...."
    },

    TALKING {
        override fun signal() = THINKING
        override fun toString() = "Allow me to suggest an idea..."
    };

    abstract fun signal(): Philosopher
}

// In the fourth section, create a class called Command that can be used as a function. This means you will need to provide a invoke method on the class. The primary constructor should take a String parameter (prompt), and the invoke operator should also take a String parameter (message), and simply return a concatenation of the two.

// create an class "Command" that can be used as a function (provide an "invoke()" function)
// that takes a single parameter ("message" of type String)
// primary constructor should take a String argument ("prompt")
// when called, the Command object should return a String containing the prompt and then the message


class Command(val prompt: String) {
    operator fun invoke(message: String):String {
        return prompt + message
    }
}

// (By the way, I will give a bonus point to anyone who can find out who Seneca the Younger was, an additional point if you can tell me which school of philosophy he is commonly associated with, and a third point if you can summarize that school of philosophy in a single sentence. On another note, when you have some time to kill, play "The Wikipedia Game"--pick any random subject on Wikipedia, and click the first link on that page. On the page that comes up, click the first link on that page. Continue doing this until you have reached the Wikipedia page on Philosophy, and marvel at how everything in human existence essentially traces its roots back to philosophy and a bunch of dead Greeks in togas.)

// 1. Seneca the Younger was a Roman Stoic Philosopher, Statesman, dramatist and satirist
// Many people attempted to kill him, but failed. He finally died when he was ordered to // kill himself because he was accused of being part of the pisonian conspiracy
// 2. Seneca the Younger was associated with Stoicism
// 3. Stoicism is the philosophy of acheving happiness through practicing virtue ethics  
// Sources: Wikipedia.org, britannica.com, ancient-literature.com




// ================================
 println("map fold test: " + if (mapFoldResults == "FIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ") "." else "!")

 println("r1 test: " + if (r1 == ">>> FOO: {BAR}") "." else "!")

 println("r2 test: " + if (r2 == ">>> FOO: {WOOGAWOOGAWOOGA}") "." else "!")

var seneca = Philosopher.THINKING
print("Seneca, talk! ")
seneca = seneca.signal()
println(if (seneca.toString() == "Allow me to suggest an idea...") "." else "!")
print("Seneca, think! ")
seneca = seneca.signal()
println(if (seneca.toString() == "Deep thoughts....") "." else "!")
print("Seneca, talk! ")
seneca = seneca.signal()
println(if (seneca.toString() == "Allow me to suggest an idea...") "." else "!")

print("Command tests: ")
print(if (Command("")("") == "") "." else "!")
print(if (Command("> ")("Hello!") == "> Hello!") "." else "!")
println("")



