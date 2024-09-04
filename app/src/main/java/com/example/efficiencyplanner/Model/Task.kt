package com.example.efficiencyplanner.Model

data class Task(
    val id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val priority: String? = null,
    val status: String? = "Open",
    val taskList: List<TaskList>? = null
)
