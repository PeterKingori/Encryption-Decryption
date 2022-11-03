    val lambda: (Long, Long) -> Long = { from: Long, to: Long ->
        var multiplication = 1L
        for (i in from..to) {
            multiplication *= i
        }
        multiplication
    }