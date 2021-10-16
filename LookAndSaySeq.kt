// function to generate the sequence
private fun generateLookAndSaySeq(len: Int) {
  var first = "1"
  
  println("First $len terms of the 'Look and Say Sequence are:'")

  // loop from 0 until given num (len)  
  (0 until len).forEach { _ ->
    // print seq term
     println(first)
    
    // update  
    first = first.let {
   
      "(\\d)\\1*".toRegex() // regex
       .findAll(it, 0) // find all matches
       .map { // match results
          mR ->
            // length of subStr found by match
            mR.value.length.toString()
            .plus (
               // first char of matched subStr
               mR.value[0] 
            )
       }
       .joinToString("") // join
    }
  }
}


// main function
fun main() {
  
  val input: Int = 
    
    try {
      // try to read an integer.
      readLine()!!.toInt()

    } catch (error: Throwable) {
       // error msg
       println(
       "Enter a number.\nUsing default value: 10\n")
     
       // default value in case of bad input.
       10
    }
  
  // generate seq upto given number
  generateLookAndSaySeq(input);
}

