package com.example.profilephoto.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.profilephoto.model.Photo

class photoViewModel: ViewModel() {
    val photoLiveData = MutableLiveData<Photo>()

    fun getDataFromRoom(){
        val photo=Photo(33)
        photoLiveData.value=photo
    }

}