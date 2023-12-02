// Element interface
interface Shape {
    fun accept(visitor: ShapeVisitor)
}

// Concrete elements
class Circle(val radius: Double) : Shape {
    override fun accept(visitor: ShapeVisitor) {
        visitor.visit(this)
    }
}

class Rectangle(val width: Double, val height: Double) : Shape {
    override fun accept(visitor: ShapeVisitor) {
        visitor.visit(this)
    }
}

// Visitor interface
interface ShapeVisitor {
    fun visit(circle: Circle)
    fun visit(rectangle: Rectangle)
}

// Concrete visitor
class AreaCalculator : ShapeVisitor {
    var totalArea: Double = 0.0

    override fun visit(circle: Circle) {
        val area = Math.PI * circle.radius * circle.radius
        println("Calculating area of Circle: $area")
        totalArea += area
    }

    override fun visit(rectangle: Rectangle) {
        val area = rectangle.width * rectangle.height
        println("Calculating area of Rectangle: $area")
        totalArea += area
    }
}

fun main() {
    val shapes: List<Shape> = listOf(
        Circle(radius = 5.0),
        Rectangle(width = 3.0, height = 4.0),
        Circle(radius = 2.5)
    )

    val areaCalculator = AreaCalculator()

    // Apply the visitor to all shapes
    shapes.forEach { it.accept(areaCalculator) }

    println("Total area: ${areaCalculator.totalArea}")
}
