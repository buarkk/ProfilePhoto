package com.example.profilephoto.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.profilephoto.R
import com.example.profilephoto.viewModel.FeedViewModel
import com.example.profilephoto.viewModel.photoViewModel
import kotlinx.android.synthetic.main.fragment_photo.*
import kotlinx.android.synthetic.main.photo_row.*


class PhotoFragment : Fragment() {

    private lateinit var viewModel : photoViewModel
    private var photoUuid=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(photoViewModel::class.java)
        viewModel.getDataFromRoom()


        arguments?.let {
            photoUuid=PhotoFragmentArgs.fromBundle(it).photoUuid
        }
        observeLiveData()

    }

   private fun observeLiveData(){

       viewModel.photoLiveData.observe(viewLifecycleOwner, Observer { photo->
           photo?.let {
               photoSelected.text=photo.photoNumber.toString()
           }
       })
    }


}