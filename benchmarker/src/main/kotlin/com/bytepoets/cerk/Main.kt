package com.bytepoets.cerk

import org.optaplanner.benchmark.api.PlannerBenchmarkFactory
import kotlin.random.Random

fun main() {
    val benchmarkFactory = PlannerBenchmarkFactory
        .createFromXmlResource("benchmarkConfig.xml")

    val dataset1 = Random(42).generateSolution(300, 1000)
    val dataset2 = Random(1337).generateSolution(400, 300)
    val dataset3 = Random(1234).generateSolution(500, 5000)
    val dataset4 = Random(0xDEADBEEF).generateSolution(100, 700)
    val benchmark = benchmarkFactory.buildPlannerBenchmark(dataset1, dataset2, dataset3, dataset4)
    benchmark.benchmarkAndShowReportInBrowser()
}

fun Random.generateSolution(numberOfMeasures: Int, measuresBudget: Int): CerkSolution = CerkSolution(
    measuresBudget = MeasuresBudget(measuresBudget),
    measures = (1..numberOfMeasures).map {
        emissionReductionMeasure(measureName = it.toString(), reductionAmount = nextInt(1, 700), cost = nextInt(1, 700))
    },
)

private fun emissionReductionMeasure(measureName: String, reductionAmount: Int, cost: Int): EmissionReductionMeasure =
    EmissionReductionMeasure()
        .apply {
            name = measureName
            emissionReduction = EmissionReduction(reductionAmount, cost)
        }
