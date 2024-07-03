package com.example.room_two

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel() {
    val tasks = mutableStateListOf<Task>()


    init {
        viewModelScope.launch {
            tasks.addAll(repository.getAllUser())
        }
    }

    fun addUser(name: String, age: Int) {
        viewModelScope.launch {
            val task = Task(name = name,age = age)
            repository.insertUser(task)
            tasks.add(task)
        }
    }

    fun deleteUser(task: Task) {
        viewModelScope.launch {
            repository.deleteUser(task)
            tasks.remove(task)
        }
    }

}