package com.bytepoets.cerk

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class MaximizeEmissionReductionConstraintTest {
    companion object {
        @JvmStatic
        fun dontExceedMaxBudgetTestData(): List<Arguments> {
            return listOf(
                Arguments.of(
                    "one selected measure not exceeding budget I",
                    arrayOf(
                        EmissionReductionMeasure()
                            .apply {
                                name = "Buy food with lower carbon footprint"
                                selected = false
                                emissionReduction = EmissionReduction(reductionAmount = 5, cost = 3)
                            },
                        EmissionReductionMeasure()
                            .apply {
                                name = "Buy more efficient AC"
                                selected = true
                                emissionReduction = EmissionReduction(reductionAmount = 10, cost = 10)
                            }
                    ),
                    10,
                ),
                Arguments.of(
                    "one selected measure not exceeding budget II",
                    arrayOf(
                        EmissionReductionMeasure()
                            .apply {
                                name = "Buy food with lower carbon footprint"
                                selected = true
                                emissionReduction = EmissionReduction(reductionAmount = 5, cost = 3)
                            },
                        EmissionReductionMeasure()
                            .apply {
                                name = "Buy more efficient AC"
                                selected = false
                                emissionReduction = EmissionReduction(reductionAmount = 10, cost = 10)
                            }
                    ),
                    5,
                ),
                Arguments.of(
                    "two measures exceeding budget by 3",
                    arrayOf(
                        EmissionReductionMeasure()
                            .apply {
                                name = "Buy food with lower carbon footprint"
                                selected = true
                                emissionReduction = EmissionReduction(reductionAmount = 5, cost = 3)
                            },
                        EmissionReductionMeasure()
                            .apply {
                                name = "Buy more efficient AC"
                                selected = true
                                emissionReduction = EmissionReduction(reductionAmount = 10, cost = 10)
                            }
                    ),
                    15,
                ),
            )
        }
    }

    @ParameterizedTest(name = "{index} ==> {0} should be penalized by {2}")
    @MethodSource("dontExceedMaxBudgetTestData")
    fun `should penalize time constraint violations correctly`(
        @Suppress("UNUSED_PARAMETER") testName: String,
        givenMeasures: Array<EmissionReductionMeasure>,
        expectedAmountRewarded: Long
    ) {
        givenConstraintVerifier()
            .verifyThat(EmissionReductionConstraintProvider::maximizeEmissionReduction)
            .given(*givenMeasures, givenMeasuresBudget())
            .rewardsWith(expectedAmountRewarded)
    }
}

private fun givenMeasuresBudget(): MeasuresBudget = MeasuresBudget(amount = 10)
