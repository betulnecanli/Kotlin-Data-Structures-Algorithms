// Handler interface
interface Approver {
    fun processRequest(request: PurchaseRequest)
}

// Concrete handler
class Manager(private val nextApprover: Approver? = null) : Approver {
    override fun processRequest(request: PurchaseRequest) {
        if (request.amount <= 1000) {
            println("Manager approves purchase request #${request.id}")
        } else {
            nextApprover?.processRequest(request)
        }
    }
}

class Director(private val nextApprover: Approver? = null) : Approver {
    override fun processRequest(request: PurchaseRequest) {
        if (request.amount <= 5000) {
            println("Director approves purchase request #${request.id}")
        } else {
            nextApprover?.processRequest(request)
        }
    }
}

class VicePresident(private val nextApprover: Approver? = null) : Approver {
    override fun processRequest(request: PurchaseRequest) {
        if (request.amount <= 10000) {
            println("Vice President approves purchase request #${request.id}")
        } else {
            nextApprover?.processRequest(request)
        }
    }
}

// Client class
class PurchaseRequest(val id: Int, val amount: Double)

fun main() {
    // Create the chain of approvers
    val manager = Manager()
    val director = Director()
    val vicePresident = VicePresident()

    // Set up the chain of responsibility
    manager.processRequest(PurchaseRequest(1, 800))
    manager.processRequest(PurchaseRequest(2, 2500))
    manager.processRequest(PurchaseRequest(3, 12000))
}
