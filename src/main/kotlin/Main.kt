import kotlin.math.abs

// Класс точка
data class Point(val x: Double, val y: Double)

// Класс треугольник
data class Triangle(val a: Point, val b: Point, val c: Point)

// Функция для вычисления расстояния между двумя точками
fun distance(p1: Point, p2: Point): Double {
    val dx = p2.x - p1.x
    val dy = p2.y - p1.y
    return kotlin.math.sqrt(dx * dx + dy * dy)
}

// Функция для вычисления центра вписанной окружности и ее радиуса
fun calculateIncircle(triangle: Triangle): Pair<Point, Double> {
    val A = distance(triangle.b, triangle.c)
    val B = distance(triangle.a, triangle.c)
    val C = distance(triangle.a, triangle.b)

    val perimeter = A + B + C
    val centerX = (A * triangle.a.x + B * triangle.b.x + C * triangle.c.x) / perimeter
    val centerY = (A * triangle.a.y + B * triangle.b.y + C * triangle.c.y) / perimeter
    val center = Point(centerX, centerY)

    val radius = abs((A + B - C) * (B + C - A) * (C + A - B)) / (4 * perimeter)

    return Pair(center, radius)
}

fun main() {
    println("Введите координаты точек треугольника:")

    println("Введите координаты точки A:")
    val xA = readln().toDouble()
    val yA = readln().toDouble()
    val pointA = Point(xA, yA)

    println("Введите координаты точки B:")
    val xB = readln().toDouble()
    val yB = readln().toDouble()
    val pointB = Point(xB, yB)

    println("Введите координаты точки C:")
    val xC = readln().toDouble()
    val yC = readln().toDouble()
    val pointC = Point(xC, yC)

    val triangle = Triangle(pointA, pointB, pointC)

    val (center, radius) = calculateIncircle(triangle)

    println("Центр вписанной окружности имеет координаты (${center.x}, ${center.y})")
    println("Радиус вписанной окружности равен $radius")
}