package com.bytepoets.cerk

import org.optaplanner.test.api.score.stream.ConstraintVerifier

fun givenConstraintVerifier(): ConstraintVerifier<EmissionReductionConstraintProvider, CerkSolution> =
    ConstraintVerifier.build(
        EmissionReductionConstraintProvider(),
        CerkSolution::class.java,
        EmissionReductionMeasure::class.java,
    )
