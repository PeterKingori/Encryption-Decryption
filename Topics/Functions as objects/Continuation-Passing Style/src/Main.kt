fun square(value: Int, context: Any, continuation: (Int, Any) -> Unit) {
    val sq = value * value
    continuation(sq, context)
}