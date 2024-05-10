package array

fun main() {
    var array = arrayOf(1,2,3,4,5,8,9)

    do {
        println("Array content -> ${array.joinToString()}")

        println("0. Exit")
        println("1. Insert a number at a given index")
        println("2. Delete a number at a given index")
        println("3. Search for a specific number in the array")
        println("4. Reverse the array content")
        println("5. Accept values for a sub array and insert at given index") // done
        println("6. Delete a sub array at a given index") // done
        println("7. Check if the given sub array exists") // done
        val choice = readInt("Enter your choice: ")

        when (choice) {
            0 -> {
                println("Exiting...")
            }
            1 -> {
                val index = readInt("Enter the index to insert: ")
                val value = readInt("Enter the value to insert: ")
                array = insertAtIndex(array, index, value)
            }

            2 -> {
                val index = readInt("Enter the index to delete at: ")
                array = deleteAtIndex(array, index)
            }

            3 -> {
                val number = readInt("Enter the value to search: ")
                val index = findIndexOfNumber(array, number)
                if (index == -1) {
                    println("$number not found in the array")
                } else {
                    println("$number was found at index $index of the array")
                }
            }

            4 -> {
                // there is an extension function in Array class to do this
                // no need to reinvent the wheel in Kotlin


                array = reverseArray(array)
            }
            5 -> {

                array = insertSubArrayAtIndex(array)

            }
            6 -> {
                array = deleteSubArrayAtIndex(array)
            }
            7 -> {
                val subArray = getSubArray()
                if(subArray.isEmpty()) {
                    println("invalid sub array")
                    continue
                }
                val index = searchSubArray(array,subArray)
                if(index==-1){
                    println("${subArray.joinToString()} not in the array")
                } else {
                    println("${subArray.joinToString()} was found at index $index of the array")
                }
            }

            else -> {
                println("Invalid choice.")
            }
        }

    } while (choice != 0)
}

fun readInt(input: String): Int {
    print(input)
    return readln().toInt()
}

fun insertAtIndex(array: Array<Int>, index: Int, value: Int): Array<Int> {
    if (index !in 0..array.size) { // if(index !in 0..array.size){
        println("`index` must be between 0 and ${array.size}")
        return array
    }

    val newArray = Array(array.size + 1) { 0 }
    for (i in 0..<index) { // for(i in 0..<index){
        newArray[i] = array[i]
    }
    newArray[index] = value

    for (i in index..<array.size) {
        newArray[i + 1] = array[i]
    }

    return newArray
} // O(n)

fun deleteAtIndex(array: Array<Int>, index: Int): Array<Int> {
    if (index !in 0..array.size) { // if(index !in 0..array.size){
        println("`index` must be between 0 and ${array.size}")
        return array
    }

    val newArray = Array(array.size - 1) { 0 }
    for (i in 0..<index) { // for(i in 0..<index){
        newArray[i] = array[i]
    }

    for (i in index..<newArray.size) {
        newArray[i] = array[i + 1]
    }

    return newArray
} // O(n)

fun findIndexOfNumber(array: Array<Int>, number:Int):Int{
    var idx=-1
    for(i in 0..array.size){
        if(array[i]==number){
            idx=i
            break
        }
    }
    return idx

} // O(n)



fun reverseArray(array: Array<Int>): Array<Int> {
    val newArray = Array<Int>(array.size){0} // O(1)
    var j = array.size-1 // O(1)
    for(i in array.indices){ // O(n)
        newArray[j--] = array[i] // O(1)
    }
    return newArray // O(1)
} // O(n)

private fun getSubArray(): Array<Int> {
    val noOfValues = readInt("Enter number of values of the sub array: ")
    if (noOfValues <= 0) {
        println("Number of Values must be greater than zero 0")
        return Array(0) { 0 }
    }
    val subArray = Array(noOfValues) { 0 }
    for (i in 1..noOfValues) {
        val x = readInt("enter value $i :")
        subArray[i - 1] = x
    }
    return subArray
}

fun insertSubArrayAtIndex(array: Array<Int>): Array<Int> {

    val index = readInt("Enter the index to Enter at: ")

    if (index !in 0..array.size) { // if(index !in 0..array.size){
        println("`index` must be between 0 and ${array.size}")
        return array
    }
    val subArray = getSubArray()


    val newArray = Array(array.size + subArray.size) { 0 }
    for (i in 0..<index) {
        newArray[i] = array[i]
    }

    for (i in subArray.indices){
        newArray[i+index] = subArray[i]
    }

    for (i in index..<array.size){
        newArray[i+subArray.size] = array[i]
    }

    return newArray

}

fun deleteSubArrayAtIndex(array: Array<Int>): Array<Int> {

    val index = readInt("Enter the index to deleted the sub-array at: ")
    if (index !in 0..array.size) {
        println("`index` must be between 0 and ${array.size}")
        return array
    }

    val sz = readInt("Enter the length of sub array to be deleted: ")

    if(sz<0 || sz>(array.size-index)){
        println("invalid length of sub-array. For given index = $index length should be in between zero to ${array.size-index}")
        return array
    }

    val newArray = Array(array.size-sz){0}

    for(i in 0..<index){
        newArray[i] = array[i]
    }
    var j = index
    for (i in index+sz..<array.size){
        newArray[j] = array[i]
        j++
    }
    return newArray

}

fun searchSubArray(array: Array<Int>, subArray: Array<Int>): Int {

    if (subArray.size > array.size) return -1

    for (i in 0..array.size - subArray.size) {
        if (array[i] == subArray[0]) {
            var count = 0
            for (j in subArray.indices) {
                if (array[i + j] != subArray[j]) {
                    break
                } else {
                    count++
                }
            }

            if (count == subArray.size) return i
        }
    }

    return -1
}















