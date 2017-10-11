println(removePossibilityOfNumber(1111111011, 9))


Integer removePossibilityOfNumber(Integer number, Integer possibleNumber) {
    Integer possibleNumberInBits = 1
    if (number.toString().charAt(possibleNumber) != "0") {
        (9 - possibleNumber).times {
            possibleNumberInBits = possibleNumberInBits * 10
        }
    } else {
        return number
    }
    return (number-possibleNumberInBits)
}