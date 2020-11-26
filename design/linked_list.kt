fun main() {
    val list = MyLinkedList()

    list.addAtIndex(0,1)
    list.addAtTail(3)
    list.printList()
    list.addAtIndex(2,2)
    list.printList()
    list.addAtTail(6)
    list.printList()
    list.deleteAtIndex(2)
    list.printList()
    list.addAtTail(7)
    list.printList()
    list.addAtHead(5)
    list.printList()
    list.addAtIndex(0,4)
    list.printList()
    list.addAtIndex(3,10)
    list.printList()
}

class Node(var `val`: Int) {
    var next : Node? = null
}

class MyLinkedList() {

    /** Initialize your data structure here. */
    private var head : Node? = null
    private var tail : Node? = null
    private var length = 0

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    fun get(index: Int): Int {
        if (!isIndexValid(index)) {
            return -1
        }
        return getNode(index)?.`val` ?: -1
    }

    private fun getNode(index: Int) : Node? {
        if (!isIndexValid(index)) {
            return null
        }
        var cur = head
        for (i in 0 until index) {
            cur = cur?.next
        }
        return cur
    }

    private fun isIndexValid(index: Int) = (index >= 0 && index <= length-1)

    fun printList() {
        var cur = head
        print("> ")
        while (cur != null) {
            print("${cur.`val`} ")
            cur = cur.next
        }
        println()
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    fun addAtHead(`val`: Int) {
        val newHead = Node(`val`)
        newHead.next = head
        head = newHead

        if (tail == null) {
            tail = head
        }

        length++
    }

    /** Append a node of value val to the last element of the linked list. */
    fun addAtTail(`val`: Int) {
        val newTail = Node(`val`)
        tail?.next = newTail
        tail = newTail

        if (head == null) {
            head = tail
        }

        length++
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    fun addAtIndex(index: Int, `val`: Int) {

        if (index == 0) {
            addAtHead(`val`)
        } else if (index == length) {
            addAtTail(`val`)
        } else if (isIndexValid(index)) {
            val newNode = Node(`val`)
            val prev = getNode(index-1)
            newNode.next = prev!!.next
            prev.next = newNode
            length++
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    fun deleteAtIndex(index: Int) {
        if (isIndexValid(index)) {
            if (index == 0) {
                head = head?.next
                if (head == null) {
                    tail == null
                }
            } else if (index == length-1) {
                tail = getNode(index-1)
                tail?.next = null
            } else {
                val prev = getNode(index-1)
                prev!!.next = prev.next?.next
            }

            length--
        }
    }

}
