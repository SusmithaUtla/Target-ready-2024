package singleLL

import array.readInt

class Node(var data: Int) {
    var next: Node? = null;
}

class SinglyLinkedList { // O(n)
    private var length = 0

    private var head: Node? = null

    fun print() {

        print("start -> ")
        var temp = head // O(1)
        while (temp != null) { // O(n)
            print("${temp.data} -> ")
            temp = temp.next // O(1)
        }
        println("end")
    }

    fun append(value: Int) {
        length++
        val newNode = Node(value) // O(1)

        if (head == null) { // O(1)
            head = newNode // O(1)
            return // O(1)
        }

        var temp = head // O(1)
        while (temp?.next != null) { // O(n)
            temp = temp.next // O(1)
        }
        temp?.next = newNode // O(n)
    }

    fun prepend(value: Int) {
        length++
        val newNode = Node(value) // O(1)
        newNode.next = head // O(1)
        head = newNode // O(1)
    } // O(1)

    fun reverse() {
        var prev: Node? = null // O(1)
        var curr = head // O(1)
        var next: Node? // O(1)

        while (curr != null) { // O(n)
            next = curr.next // O(1)
            curr.next = prev // O(1)
            prev = curr // O(1)
            curr = next // O(1)
        }
        head = prev // O(1)
    } // O(n)
    fun insertAtIndex(index: Int, value: Int) {
        if (index < 0 || index > length) {
            println("Invalid index, index should be in between 0 to $length for insertion")
            return
        }
        val newNode = Node(value)
        if (index == 0) {
            prepend(value)
            return
        }

        // Check if index is the last position, then just append
        if (index == length) {
            append(value)
            return
        }

        var temp = head
        var prevNode: Node? = null
        var i = index

        while (i > 0 && temp != null) {
            prevNode = temp
            temp = temp.next
            i--
        }

        prevNode?.next = newNode
        newNode.next = temp

        length++
    }


    fun deleteAtIndex(index: Int) {
        if(length ==0){
            println("Linked List is Empty, Can not delete from empty linked list")
            return
        }
        if(index<0 || index>=length){
            println("Invalid index, index should be in between 0 to ${length - 1} for deletion")
            return
        }
        length--
        var temp = head
        if(index==0){
            head = temp?.next
            return
        }
        var i =index
        while(i>1){
            i--
            temp =temp?.next
        }
        temp?.next = temp?.next?.next


    }

    fun searchByValue(value: Int) :Int{
        if(length == 0){
            println("Linked list is empty can not Search elements in empty list")
        }
        var temp = head
        var i =0;

        while(temp != null){
            if(temp.data == value){
                return i
            }
            temp = temp.next
            i++
        }
        return -1



    }
}

fun main() {
    val list = SinglyLinkedList()

    do {
        list.print()

        println("0. Exit")
        println("1. Append")
        println("2. Prepend")
        println("3. Reverse")
        println("4. Insert a number at a given index")
        println("5. Delete a number at a given index")
        println("6. Search a number in the list")
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
                list.reverse()
            }
            4 -> {
                val index = readInt("Enter the  Idx to insert : ")
                val value = readInt("Enter value to insert at index: $index : ")
                list.insertAtIndex(index,value)
            }
            5 -> {
                val index = readInt("Enter the idx to delete: ")
                list.deleteAtIndex(index)

            }
            6 -> {
                val value = readInt("Enter a value to Search in linked list : ")
                val index = list.searchByValue(value)
                if(index == -1){
                    println("$value is not found in the Linked List.")
                }
                else{
                    println("$value is found at index = $index ")
                }
            }

            else -> println("Invalid choice")
        }

    } while (choice != 0)
}