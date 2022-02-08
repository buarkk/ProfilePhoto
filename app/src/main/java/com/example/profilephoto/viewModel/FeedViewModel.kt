package com.example.profilephoto.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.profilephoto.model.Photo

class FeedViewModel: ViewModel() {

    val photos = MutableLiveData<List<Photo>>()
    val photoError = MutableLiveData<Boolean>()
    val photoLoading = MutableLiveData<Boolean>()


    fun refreshData() {

        val photo1=Photo(1)
        val photo2=Photo(2)
        val photo3=Photo(3)
        val photo4=Photo(4)

        val photoList= arrayListOf<Photo>(photo1,photo2,photo3,photo4)

        photos.value=photoList
        photoError.value=false
        photoLoading.value=false
    }

}