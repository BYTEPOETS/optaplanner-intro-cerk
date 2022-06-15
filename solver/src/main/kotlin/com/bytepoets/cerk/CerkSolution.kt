package com.bytepoets.cerk

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty
import org.optaplanner.core.api.domain.solution.PlanningScore
import org.optaplanner.core.api.domain.solution.PlanningSolution
import org.optaplanner.core.api.domain.solution.ProblemFactProperty
import org.optaplanner.core.api.domain.valuerange.CountableValueRange
import org.optaplanner.core.api.domain.valuerange.ValueRangeFactory
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore

data class MeasuresBudget(val amount: Int)
data class EmissionReduction(val reductionAmount: Int, val cost: Int)

@PlanningSolution
class CerkSolution {
    @ProblemFactProperty
    lateinit var measuresBudget: MeasuresBudget

    @PlanningEntityCollectionProperty
    lateinit var measures: List<EmissionReductionMeasure>

    @ValueRangeProvider(id = "selected")
    val selectedValueRange: CountableValueRange<Boolean> = ValueRangeFactory.createBooleanValueRange()

    @PlanningScore
    var score: HardSoftScore? = null

    constructor() // required for optaplanner

    constructor(
        measuresBudget: MeasuresBudget,
        measures: List<EmissionReductionMeasure>,
    ) {
        this.measuresBudget = measuresBudget
        this.measures = measures
    }
}
