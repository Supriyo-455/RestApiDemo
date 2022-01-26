package com.example.restapidemonstration.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restapidemonstration.data.Destination
import com.example.restapidemonstration.data.Message
import com.example.restapidemonstration.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){
    private val repo = MainRepository()

    private val _destinations = MutableLiveData<List<Destination>?>()
    val destinations : LiveData<List<Destination>?> = _destinations

    private val _destination = MutableLiveData<Destination?>()
    val destination : LiveData<Destination?> = _destination

    private val _message = MutableLiveData<Message?>()
    val message : LiveData<Message?> = _message


    fun getDestinations() =
        viewModelScope.launch(Dispatchers.IO){
            _destinations.postValue(repo.getDestinations())
        }

    fun getDestination(id : Int) =
        viewModelScope.launch(Dispatchers.IO) {
            _destination.postValue(repo.getDestination(id))
        }

    fun getWelcomeMessage() =
        viewModelScope.launch(Dispatchers.IO) {
            _message.postValue(repo.getWelcomeMessage())
        }

    fun editDestination(id : Int, destination: Destination) =
        viewModelScope.launch(Dispatchers.IO) {
            _destination.postValue(repo.editDestination(id, destination))
        }

    fun createDestination(destination: Destination) =
        viewModelScope.launch(Dispatchers.IO){
            _destination.postValue(repo.createDestination(destination))
        }

    fun deleteDestination(id: Int) =
        viewModelScope.launch(Dispatchers.IO) {
            _destination.postValue(repo.deleteDestination(id))
        }
}