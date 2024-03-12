package structure.adapter

import structure.adapter.adapters.SquarePegAdapter
import structure.adapter.round.RoundHole
import structure.adapter.round.RoundPeg
import structure.adapter.square.SquarePeg


fun main() {
    // Круглое к круглому — всё работает.
    val hole = RoundHole(5.0)
    val rpeg = RoundPeg(5.0)
    if (hole.fits(rpeg)) println("Round peg r5 fits round hole r5.")

    val smallSqPeg = SquarePeg(2.0)
    val largeSqPeg = SquarePeg(20.0)
    // hole.fits(smallSqPeg); // Не скомпилируется.

    // Адаптер решит проблему.
    val smallSqPegAdapter = SquarePegAdapter(smallSqPeg)
    val largeSqPegAdapter = SquarePegAdapter(largeSqPeg)
    if (hole.fits(smallSqPegAdapter)) println("Square peg w2 fits round hole r5.")
    if (!hole.fits(largeSqPegAdapter)) println("Square peg w20 does not fit into round hole r5.")

}
//Результат выполнения
//Round peg r5 fits round hole r5.
//Square peg w2 fits round hole r5.
//Square peg w20 does not fit into round hole r5.