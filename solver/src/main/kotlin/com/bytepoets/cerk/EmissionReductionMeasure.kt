package com.bytepoets.cerk

import org.optaplanner.core.api.domain.entity.PlanningEntity
import org.optaplanner.core.api.domain.variable.PlanningVariable

@PlanningEntity
class EmissionReductionMeasure {
    val isSelected: Boolean get() = selected ?: false

    lateinit var emissionReduction: EmissionReduction

    @PlanningVariable(valueRangeProviderRefs = ["selected"])
    var selected: Boolean? = null

    override fun toString(): String {
        return "EmissionReductionMeasure(" +
            "selected=$selected, " +
            "reductionAmount=${emissionReduction.reductionAmount}, " +
            "cost=${emissionReduction.cost}" +
            ")"
    }
}
