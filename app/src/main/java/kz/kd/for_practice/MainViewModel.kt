package kz.kd.for_practice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val pin: MutableLiveData<List<ModelPin>> = MutableLiveData(listOf(ModelPin(0)))
    val pin2: LiveData<List<ModelPin>> = pin

    fun onButtonClicked() {
        val oldPin = pin2.value?: emptyList()
        val pinCount = oldPin.size
        val newPin = ModelPin(pin = pinCount + 1)
        pin.value = oldPin + newPin
    }
}