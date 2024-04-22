package com.alvee.cricvee_jetpack.presentation.states

import com.moinul.cricvee.model.fixtures.FixtureRunData

data class FixtureState(
    val matchList: List<FixtureRunData> = emptyList(),
)
