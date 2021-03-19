val test = Map(
  0 -> List(1, 2, 3),
  1 -> List(4, 5, 6),
  2 -> List(4, 2, 6),
  3 -> List(2, 4, 6),
  4 -> List(3, 4, 6),
  5 -> List(2, 2, 2),
  6 -> List(4, 4, 4)
)

val check = List(2, 4)
for ((k, v) <- test) {
  println(k, v, check.foldLeft(true) {
    case (result, n) => {
      (if (v.indexOf(n) > -1) (result && true) else (result && false))
    }
  })
}
