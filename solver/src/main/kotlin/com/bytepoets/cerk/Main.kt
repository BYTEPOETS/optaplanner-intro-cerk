package com.bytepoets.cerk

import org.optaplanner.core.api.score.ScoreManager
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore
import org.optaplanner.core.api.solver.SolverFactory

fun main() {
    println("Hello Optaplanner")
    println()

    val input = CerkSolution(
        measuresBudget = MeasuresBudget(100),
        measures = listOf(
            emissionReductionMeasure("More efficient AC", 20, 10),
            emissionReductionMeasure("Electrical car", 30, 50),
            emissionReductionMeasure("Thermal insulation for building", 40, 45),
        ) +
            (1..10).map { emissionReductionMeasure("M1 macbook", 30, 20) } +
            (1..20).map {
                emissionReductionMeasure("Buy food with lower carbon footprint", reductionAmount = 1, cost = 1)
            }
    )

    val solverFactory = SolverFactory.createFromXmlResource<CerkSolution>("solverConfig.xml")
    val solver = solverFactory.buildSolver()

    val result = solver.solve(input)

    println()
    println(result.measures.filter { it.isSelected }.joinToString(separator = ", "))
    println()
    println(ScoreManager.create<CerkSolution, HardSoftScore>(solverFactory).explainScore(result).toString())
    println()
    println("Bye Optaplanner")
}

private fun emissionReductionMeasure(measureName: String, reductionAmount: Int, cost: Int): EmissionReductionMeasure =
    EmissionReductionMeasure()
        .apply {
            name = measureName
            emissionReduction = EmissionReduction(reductionAmount, cost)
        }
