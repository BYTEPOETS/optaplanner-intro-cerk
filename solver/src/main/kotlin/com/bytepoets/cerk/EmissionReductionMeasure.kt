package com.bytepoets.cerk

import org.drools.compiler.shade.org.eclipse.jdt.internal.compiler.parser.Parser.name
import org.optaplanner.core.api.domain.entity.PlanningEntity
import org.optaplanner.core.api.domain.variable.PlanningVariable

@PlanningEntity(difficultyComparatorClass = EntityComparator::class)
class EmissionReductionMeasure {
    lateinit var name: String

    lateinit var emissionReduction: EmissionReduction

    @PlanningVariable(valueRangeProviderRefs = ["selected"])
    var selected: Boolean? = null

    val isSelected: Boolean get() = selected ?: false

    override fun toString(): String {
        return "EmissionReductionMeasure(" +
            "name=$name, " +
            "selected=$selected, " +
            "reductionAmount=${emissionReduction.reductionAmount}, " +
            "cost=${emissionReduction.cost}" +
            ")"
    }
}

class EntityComparator : Comparator<EmissionReductionMeasure> {
    override fun compare(o1: EmissionReductionMeasure?, o2: EmissionReductionMeasure?): Int =
        compareBy<EmissionReductionMeasure> { it.emissionReduction.reductionAmount / it.emissionReduction.cost }
            .compare(o1, o2)
}
