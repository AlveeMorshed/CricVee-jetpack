//package com.alvee.cricvee_jetpack.presentation.viewmodel
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.alvee.cricvee_jetpack.domain.usecase.fixtures.FixtureUseCase
//import com.alvee.cricvee_jetpack.presentation.states.FixtureState
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.Job
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//@HiltViewModel
//class FixtureViewModel @Inject constructor(
//    private val fixtureUseCase: FixtureUseCase
//) : ViewModel() {
//    private val _state = MutableStateFlow(FixtureState())
//    val state = _state.asStateFlow()
//
////    private var fixtureJob: Job? = null
////
////    fun showRecentMatches(){
////        fixtureJob?.cancel()
////        fixtureJob = viewModelScope.launch {
////            fixtureUseCase.getRecentMatchesUseCase().collect{
////                _state.value = _state.value.copy(matchList = it)
////            }
////        }
////    }
//}