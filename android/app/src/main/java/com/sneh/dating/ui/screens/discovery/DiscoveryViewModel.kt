package com.sneh.dating.ui.screens.discovery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class UserProfile(
    val id: String,
    val name: String,
    val age: Int,
    val city: String,
    val bio: String,
    val imageUrl: String,
    val verified: Boolean = true
)

@HiltViewModel
class DiscoveryViewModel @Inject constructor() : ViewModel() {

    private val _profiles = MutableStateFlow<List<UserProfile>>(emptyList())
    val profiles: StateFlow<List<UserProfile>> = _profiles.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    init {
        loadProfiles()
    }

    fun loadProfiles() {
        _isLoading.value = true
        _profiles.value = listOf(
            UserProfile(
                id = "1",
                name = "Simran Kaur",
                age = 24,
                city = "Amritsar",
                bio = "Coffee lover, graphic designer, and fond of poetry.",
                imageUrl = "https://images.unsplash.com/photo-1534528741775-53994a69daeb?auto=format&fit=crop&w=800&q=80"
            ),
            UserProfile(
                id = "2",
                name = "Amanpreet Sharma",
                age = 26,
                city = "Chandigarh",
                bio = "Software engineer who loves weekend road trips and good music.",
                imageUrl = "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?auto=format&fit=crop&w=800&q=80"
            ),
            UserProfile(
                id = "3",
                name = "Harleen Gill",
                age = 23,
                city = "Ludhiana",
                bio = "Foodie, traveler, always up for spontaneous plans.",
                imageUrl = "https://images.unsplash.com/photo-1517841905240-472988babdf9?auto=format&fit=crop&w=800&q=80"
            )
        )
        _isLoading.value = false
    }

    fun onSwipeRight(profile: UserProfile) {
        _profiles.value = _profiles.value.filter { it.id != profile.id }
    }

    fun onSwipeLeft(profile: UserProfile) {
        _profiles.value = _profiles.value.filter { it.id != profile.id }
    }

    fun resetFilters() {
        loadProfiles()
    }
}
