// Product interface
interface Document {
    fun create(): String
}

// Concrete products
class PdfDocument : Document {
    override fun create(): String {
        return "Creating a PDF document"
    }
}

class CsvDocument : Document {
    override fun create(): String {
        return "Creating a CSV document"
    }
}

// Creator interface with the factory method
interface DocumentCreator {
    fun createDocument(): Document
}

// Concrete creators implementing the factory method
class PdfDocumentCreator : DocumentCreator {
    override fun createDocument(): Document {
        return PdfDocument()
    }
}

class CsvDocumentCreator : DocumentCreator {
    override fun createDocument(): Document {
        return CsvDocument()
    }
}

fun main() {
    // Client code using the factory method
    val pdfCreator: DocumentCreator = PdfDocumentCreator()
    val pdfDocument: Document = pdfCreator.createDocument()
    println(pdfDocument.create())

    val csvCreator: DocumentCreator = CsvDocumentCreator()
    val csvDocument: Document = csvCreator.createDocument()
    println(csvDocument.create())
}
