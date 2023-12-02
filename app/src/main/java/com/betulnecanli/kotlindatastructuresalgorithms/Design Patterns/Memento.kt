// Originator class
class TextEditor(var content: String) {
    fun createMemento(): Memento {
        return Memento(content)
    }

    fun restoreMemento(memento: Memento) {
        content = memento.state
    }

    fun printContent() {
        println("Current Content: $content")
    }
}

// Memento class
data class Memento(val state: String)

// Caretaker class
class History {
    private val mementos = mutableListOf<Memento>()

    fun addMemento(memento: Memento) {
        mementos.add(memento)
    }

    fun getMemento(index: Int): Memento {
        return mementos[index]
    }
}

fun main() {
    val editor = TextEditor("Hello, World!")
    val history = History()

    // Save initial state
    history.addMemento(editor.createMemento())

    // Make changes
    editor.content = "Updated content"
    editor.printContent()

    // Save changes to history
    history.addMemento(editor.createMemento())

    // Make more changes
    editor.content = "Another update"
    editor.printContent()

    // Restore to a previous state
    editor.restoreMemento(history.getMemento(0))
    editor.printContent()
}
