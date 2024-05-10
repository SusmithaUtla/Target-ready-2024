package DoubleLL

import array.readInt


class DLLNode(var data: Int) {
    var prev: DLLNode? = null
    var next: DLLNode? = null
}


class DoublyLinkedList {
    private var length:Int =0
    private var head: DLLNode? = null
    private var tail: DLLNode? = null

    fun append(value: Int) {
        val newNode = DLLNode(value) // O(1)

        length++
        if (head == null) { // O(1)
            head = newNode // O(1)
            tail = newNode // O(1)
            return // O(1)
        }

        tail?.next = newNode // O(1)
        newNode.prev = tail // O(1)
        tail = newNode // O(1)
    }  // O(1)

    fun prepend(value: Int) {
        val newNode = DLLNode(value)

        length++;
        if (head == null) { // O(1)
            head = newNode // O(1)
            tail = newNode // O(1)
            return // O(1)
        }

        head?.prev = newNode // O(1)
        newNode.next = head // O(1)
        head = newNode // O(1)
    } // O(1)

    fun printForward() {

        print("start <-> ")
        var temp = head // O(1)
        while (temp != null) { // O(n)
            print("${temp.data} <-> ")
            temp = temp.next // O(1)
        }
        println("end")
    }

    fun printBackward() {
        print("end <-> ")
        var temp = tail
        while (temp != null) {
            print("${temp.data} <-> ")
            temp = temp.prev
        }
        println("start")
    }

    fun deleteValue(value: Int): Boolean {
        var temp = head // O(1)
        var found = false // O(1)
        while (temp != null) { // O(n)
            if (temp.data == value) { // O(1)
                found = true
                delete(temp)
                break //  O(1)
            }
            temp = temp.next // O(1)
        }

        return found // O(1)
    }

    fun insertAtIndex(index: Int, value: Int) {
        if (index < 0 || index > length) {
            println("Invalid index, index must be between zero and $length")
            return
        }

        val newNode = DLLNode(value)

        if (index == 0) {
            prepend(value)
            return
        }

        if (index == length) {
            append(value)
            return
        }

        var temp: DLLNode? = if (index > length / 2) tail else head
        var i = if (index > length / 2) length - index else index

        while (i > 0) {
            temp = if (index > length / 2) temp?.prev else temp?.next
            i--
        }

        newNode.next = temp?.next
        temp?.next?.prev = newNode
        temp?.next = newNode
        newNode.prev = temp
        length++
    }



    fun deleteByIndex(index: Int) {
        if (length == 0) {
            println("Linked list is empty,Can't delete from an empty list")
            return
        }

        if (index < 0 || index >= length) {
            println("Invalid index, index must be between zero and ${length - 1}")
            return
        }

        var temp: DLLNode? = if (index > length / 2) tail else head
        var i = if (index > length / 2) length - index else index

        while (i > 0) {
            temp = if (index > length / 2) temp?.prev else temp?.next
            i--
        }

        delete(temp)
    }

    private fun delete(curr: DLLNode?) {
        if (curr?.prev != null) {
            curr.prev!!.next = curr.next
        } else {
            head = curr?.next
        }

        if (curr?.next != null) {
            curr.next!!.prev = curr.prev
        } else {
            tail = curr?.prev
        }

        curr?.prev = null
        curr?.next = null
        length--
    }

    fun searchInDLL(value: Int): Int {

        if(length ==0){
            println("Linked list is Empty,Can not search in empty list")
            return -2
        }
        var temp = head
        var index =0

        while(temp!=null){
            if(temp.data == value){
                return index
            }
            temp = temp.next
            index++
        }
        return -1


    }

}


fun main() {
    val list = DoublyLinkedList()

    do {
        list.printForward()

        println("0. Exit")
        println("1. Append")
        println("2. Prepend")
        println("3. Print backwards")
        println("4. Insert a number at a given index") // Assignment task
        println("5. Delete a number at a given index") // Assignment task
        println("6. Delete a number by value")
        println("7. Search a number in the list") // Assignment task
        val choice = readInt("Enter your choice: ")

        when (choice) {
            0 -> {
                println("Exiting...")
            }

            1 -> {
                val value = readInt("Enter value to append: ")
                list.append(value)
            }

            2 -> {
                val value = readInt("Enter value to prepend: ")
                list.prepend(value)
            }

            3 -> {
                list.printBackward()
            }

            4 -> {
                val index = readInt("Enter the INDEX : ")
                val value = readInt("Enter value to enter at $index : ")
                list.insertAtIndex(index,value)

            }
            5 -> {
                val index = readInt("Enter the Index of the Elemnet to be deleted : ")
                list.deleteByIndex(index)
            }
            6 -> {
                val value = readInt("Enter value to delete: ")
                if(!list.deleteValue(value)){
                    println("$value not found in the list")
                }
            }
            7 -> {
                val value = readInt("Enter value to search:")
                val index = list.searchInDLL(value)
                if(index == -1){
                    println("$value is not present in linked list")
                }
                else if (index != -2){
                    println("$value is present at index = $index")
                }
            }

            else -> println("Invalid choice")
        }

    } while (choice != 0)
}
