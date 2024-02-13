package com.alvee.cricvee_jetpack.presentation.states

import com.moinul.cricvee.model.fixtures.FixtureData

data class FixtureState(
    val matchList: List<FixtureData> = emptyList()
)
