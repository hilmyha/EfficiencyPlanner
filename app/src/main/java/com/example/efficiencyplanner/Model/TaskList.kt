package com.example.efficiencyplanner.Model

data class TaskList(
    val id: String? = null,
    val name: String? = null,
    val services: List<Service>? = null
)
