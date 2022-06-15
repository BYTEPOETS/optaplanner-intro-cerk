package com.bytepoets.cerk

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore.ONE_HARD
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore.ONE_SOFT
import org.optaplanner.core.api.score.stream.Constraint
import org.optaplanner.core.api.score.stream.ConstraintCollectors
import org.optaplanner.core.api.score.stream.ConstraintFactory
import org.optaplanner.core.api.score.stream.ConstraintProvider

class EmissionReductionConstraintProvider : ConstraintProvider {
    override fun defineConstraints(constraintFactory: ConstraintFactory): Array<Constraint> {
        return arrayOf(
            dontExceedMaxBudget(constraintFactory),
            maximizeEmissionReduction(constraintFactory),
        )
    }

    fun dontExceedMaxBudget(constraintFactory: ConstraintFactory): Constraint =
        constraintFactory.forEach(EmissionReductionMeasure::class.java)
            .filter { it.isSelected }
            .groupBy(ConstraintCollectors.sum { measure -> measure.emissionReduction.cost })
            .join(MeasuresBudget::class.java)
            .filter { selectedBudgetsSum, measuresBudget -> selectedBudgetsSum > measuresBudget.amount }
            .penalize("exceededMaxBudget", ONE_HARD) { selectedBudgetsSum, measuresBudget ->
                selectedBudgetsSum - measuresBudget.amount
            }

    fun maximizeEmissionReduction(constraintFactory: ConstraintFactory): Constraint =
        constraintFactory.forEach(EmissionReductionMeasure::class.java)
            .filter { it.isSelected }
            .reward("reductionAmount", ONE_SOFT) { it.emissionReduction.reductionAmount }
}
