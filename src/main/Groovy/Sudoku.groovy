/**
 * Created by Ramshankar on 8/15/17.
 */

// This is the code to create a sudoku solver.
// Selecting data structure was little difficult. And decided to go with the Map<Map<Map>>
// (y(x(possible numbers i.e 1xxxxxxxxx)))

//Psudocode
ArrayList<String> rawInput = getInput()
displayRawInput(rawInput)
Map<Integer, Map<Integer, Map<Integer, Integer>>> input = decodeRawInput(rawInput)
displayMatrix(input, true)

processPossibleNumbers(input)

displayMatrix(input, true)

//displayMatrix(input,true)

//displayEligibleForChange(input)

//changeValuesForEligibleNumbers(input)

//displayMatrix(input)

//processPossibleNumbers(input)

//changeValuesForEligibleNumbers(input)

//displayMatrix(input)

while (changeValuesForEligibleNumbers(input)) {
    processPossibleNumbers(input)
    displayMatrix(input)
}
displayMatrix(input)

boolean changeValuesForEligibleNumbers(Map<Integer, Map<Integer, Map<Integer, Integer>>> input) {
    boolean hasChanged = false
    9.times { y ->
        9.times { x ->
            if (input.get(y).get(x).get(0) == 0) {
                println(y + " " + x + " " + input.get(y).get(x).get(0) + " " + input.get(y).get(x).get(1) + " " + Integer.bitCount(Integer.parseInt(input.get(y).get(x).get(1).toString(), 2)))
                if (Integer.bitCount(Integer.parseInt(input.get(y).get(x).get(1).toString(), 2)) == 2) {
                    input.get(y).get(x).put(0, getPossibleNumbersFromTheBitCount(input.get(y).get(x).get(1)))
                    input.get(y).get(x).put(1,1000000000)
                    println("Changed the number at ${y} ${x} as " + input.get(y).get(x).get(0))
                    hasChanged = true
                }
                println(y + " " + x + " " + input.get(y).get(x).get(0) + " " + input.get(y).get(x).get(1) + " " + Integer.bitCount(Integer.parseInt(input.get(y).get(x).get(1).toString(), 2)))
            }
        }
    }
    hasChanged
}

Integer getPossibleNumbersFromTheBitCount(Integer number) {
    number = number - 1000000000
    //println("number "+number)
    int possibleNumber = 0
    //huge chance that the this loop can go infinite
    //TODO optimize
    while (1) {
        possibleNumber++
        if (number == 1) {
            break
        } else {
            number = number / 10
        }
    }
    //println(possibleNumber)
    return 10 - possibleNumber
}

void displayEligibleForChange(Map<Integer, Map<Integer, Map<Integer, Integer>>> input) {
    9.times { y ->
        9.times { x ->
            if (input.get(y).get(x).get(0) == 0) {
                println(y + " " + x + " " + input.get(y).get(x).get(0) + " " + input.get(y).get(x).get(1) + " " + Integer.bitCount(Integer.parseInt(input.get(y).get(x).get(1).toString(), 2)))
            }
        }
    }
}

// Removing the possiblity of the numbers for in that corresponding box. The floor of the number is fetched and the loop starts from there.
// Removes the possiblity of the number across the row line and the column line.
// Happens only on non zero values.
void processPossibleNumbers(Map<Integer, Map<Integer, Map<Integer, Integer>>> input) {
    9.times { y ->
        9.times { x ->
            Integer currentValue = input.get(y).get(x).get(0)
            if (currentValue != 0) {
                //println("--------"+currentValue+" "+y+" "+x)

                //println("--- " + Math.floor(y/3)*3)
                //println("---- " + Math.floor(x/3)*3)

                // Removing the possiblity of the numbers for in that corresponding box. The floor of the number is fetched and the loop starts from there.
                Integer yAxixPad = Math.floor(y / 3) * 3
                Integer xAxixPad = Math.floor(x / 3) * 3
                3.times { boxY ->
                    3.times { boxX ->
                        input.get(yAxixPad + boxY).get(xAxixPad + boxX).put(1, removePossibilityOfNumber(input.get(yAxixPad + boxY).get(xAxixPad + boxX).get(1), currentValue))
                    }
                }

                //displayMatrix(input,true)
                //println("--- ")

                // Removes the possiblity of the number across the row line and the column line.
                9.times {
                    //  println("------------"+input.get(y).get(it) + " " + removePossibilityOfNumber(input.get(y).get(0).get(1),currentValue))
                    input.get(y).get(it).put(1, removePossibilityOfNumber(input.get(y).get(it).get(1), currentValue))
                    input.get(it).get(x).put(1, removePossibilityOfNumber(input.get(it).get(x).get(1), currentValue))
                    //println("---------------"+input.get(y).get(it))
                }
                //displayMatrix(input,true)
                //println("---------- ")
                //displayMatrix(input,true)
            } else {
                Integer yAxixPad = Math.floor(y / 3) * 3
                Integer xAxixPad = Math.floor(x / 3) * 3
                println("--- ${yAxixPad} ${y} ${xAxixPad} ${x} ")
                //if ((yAxixPad == y) && (xAxixPad ==x) ) {

                    //println("${yAxixPad} ${y} ${xAxixPad} ${x} ")
                    boolean isOnlyPossibleNumberInGrid = false
                //TODO place for optimization. No need to callculate the sum for all vacant values. One time for a 3x3 box is enough.
                Integer sumOfAllUnknownBox = 1000000000
                3.times { boxY ->
                    3.times { boxX ->
                        if (input.get(yAxixPad + boxY).get(xAxixPad + boxX).get(0) == 0) {
                            sumOfAllUnknownBox += (input.get(yAxixPad + boxY).get(xAxixPad + boxX).get(1)-1000000000)
                        }
                        //input.get(yAxixPad+boxY).get(xAxixPad+boxX).put(1,removePossibilityOfNumber(input.get(yAxixPad+boxY).get(xAxixPad+boxX).get(1),currentValue))
                    }
                }
                println("sumOfAllUnknownBox : " + sumOfAllUnknownBox)
                //}
                //Not every digit 1 has to be replaced.
                char[] sumChars = (1000000000-sumOfAllUnknownBox).toString().toCharArray()
                if(sumChars.contains("1")){
                    sumChars.eachWithIndex { it, charPos->
                        if(it == '1'){
                            println("ONe"+charPos)
                            3.times { boxY ->
                                3.times { boxX ->
                                    println(input.get(yAxixPad+boxY).get(xAxixPad+boxX).get(0)+" "+input.get(yAxixPad+boxY).get(xAxixPad+boxX).get(1)+" "+input.get(yAxixPad+boxY).get(xAxixPad+boxX).get(1).toString().charAt(charPos))

                                    println("condtion "+((input.get(yAxixPad+boxY).get(xAxixPad+boxX).get(0) == 0) && (input.get(yAxixPad+boxY).get(xAxixPad+boxX).get(1).toString().charAt(charPos) == '1')))
                                    if((input.get(yAxixPad+boxY).get(xAxixPad+boxX).get(0) == 0) && (input.get(yAxixPad+boxY).get(xAxixPad+boxX).get(1).toString().charAt(charPos) == '1')){
                                        Integer bitValue=1
                                        (9-charPos).times {
                                            println("trace")
                                            bitValue = bitValue * 10
                                        }
                                        println(charPos + " bitValue1 "+bitValue+" " + (1000000000+bitValue))
                                        input.get(yAxixPad+boxY).get(xAxixPad+boxX).put(1,(1000000000+bitValue))
                                    }
                                    println(input.get(yAxixPad+boxY).get(xAxixPad+boxX).get(0)+" "+input.get(yAxixPad+boxY).get(xAxixPad+boxX).get(1)+" "+input.get(yAxixPad+boxY).get(xAxixPad+boxX).get(1).toString().charAt(charPos))
                                    //}
                                    //input.get(yAxixPad+boxY).get(xAxixPad+boxX).put(1,)
                                }
                            }
                        }
                    }
                }
                //findNumberOneInGivenNumber(1000000000-sumOfAllUnknownBox)

            }
        }
    }
}

Integer findNumberOneInGivenNumber(Integer integer){
    println("Occurance od 1 : "+ integer.toString().toCharArray().contains("1"))
}

// Remove possiblilty of number. Eg (1111111111, 1) is 1011111111
Integer removePossibilityOfNumber(Integer number, Integer possibleNumber) {
    Integer possibleNumberInBits = 1
    if (number.toString().charAt(possibleNumber) != "0") {
        (9 - possibleNumber).times {
            possibleNumberInBits = possibleNumberInBits * 10
        }
    } else {
        return number
    }
    return (number - possibleNumberInBits)
}

// Display the matrix. Two options. 1. without possible values and 2. With possible values.
void displayMatrix(Map<Integer, Map<Integer, Map<Integer, Integer>>> input, Boolean withPossibleValues = false) {
    if (withPossibleValues) {
        9.times { x ->
            9.times { y ->
                print(" " + input.get(x).get(y))
            }
            println()
        }
    } else {
        9.times { x ->
            9.times { y ->
                print(" " + input.get(x).get(y).get(0))
            }
            println()
        }
    }
    println()
}

// Extracting the integer and storing the value into map as  row, column, 0:value/1:hardcoded 1111111111. 1111111111 means all numbers are possible
Map<Integer, Map<Integer, Map<Integer, Integer>>> decodeRawInput(ArrayList<String> rawInput) {
    Map<Integer, Map<Integer, Map<Integer, Integer>>> input = [:]
    rawInput.eachWithIndex { it, rowCount ->
        Map<Integer, Map<Integer, Integer>> rowMap = [:]
        ArrayList<Integer> currentRow = decodeInputRow(it)
        currentRow.eachWithIndex { singleValue, count ->
            if(singleValue > 0){
                rowMap.put(count, [0: singleValue, 1: 1000000000])
            } else {
                rowMap.put(count, [0: singleValue, 1: 1111111111])
            }
        }
        //println("---"+rowCount)
        input.put(rowCount, rowMap)
    }
    input
}

//Converting string to integer
ArrayList<Integer> decodeInputRow(String row) {
    ArrayList<Integer> rowList = []
    row.length().times { it ->
        rowList << Character.getNumericValue(row.charAt(it))
    }
    rowList
}

//Input sudoku problem
ArrayList<String> getInput() {
    ArrayList<String> input = []
/*    input << "029000300"
    input << "014050020"
    input << "078020946"
    input << "000009000"
    input << "000072009"
    input << "000300200"
    input << "007030680"
    input << "401608030"
    input << "000000001"*/
    input << "002000090"
    input << "805100000"
    input << "030000020"
    input << "010006000"
    input << "000092060"
    input << "500004007"
    input << "000000572"
    input << "400000000"
    input << "080307000"

/*    002000090
    805100000
    030000020
    010006000
    000092060
    500004007
    000000572
    400000000
    080307000*/
    input
}

void displayRawInput(ArrayList<Integer> input) {
    input.each {
        println(it)
    }
}