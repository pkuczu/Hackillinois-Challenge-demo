package com.example.hackillinoisdemoreal

data class Event(
    val description: String,
    val displayOnStaffCheckIn: Boolean,
    val endTime: Int,
    val eventType: String,
    val id: String,
    val isAsync: Boolean,
    val isPrivate: Boolean,
    val locations: List<Location>,
    val name: String,
    val points: Int,
    val sponsor: String,
    val startTime: Int
)