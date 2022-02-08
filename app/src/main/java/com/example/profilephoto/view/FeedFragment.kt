package com.example.profilephoto.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.profilephoto.R
import com.example.profilephoto.adapter.photoAdapter
import com.example.profilephoto.viewModel.FeedViewModel
import kotlinx.android.synthetic.main.fragment_feed.*


class FeedFragment : Fragment() {

    private lateinit var viewModel: FeedViewModel
    private val photoAdapter = photoAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        viewModel.refreshData()



        photoList.layoutManager = LinearLayoutManager(context)
        photoList.adapter = photoAdapter

        observeLiveData()

    }

   private fun observeLiveData() {
        viewModel.photos.observe(viewLifecycleOwner, Observer { photos ->

            photos?.let {
                photoList.visibility = View.VISIBLE
                photoAdapter.updateCountryList(photos)
            }

        })

        viewModel.photoError.observe(viewLifecycleOwner, Observer { error ->
            error?.let {
                if (it) {
                    photoError.visibility = View.VISIBLE
                } else {
                    photoError.visibility = View.GONE
                }
            }
        })

        viewModel.photoLoading.observe(viewLifecycleOwner, Observer { loading ->
            loading?.let {
                if (it) {
                    photoLoading.visibility = View.VISIBLE
                    photoList.visibility = View.GONE
                    photoError.visibility = View.GONE
                } else {
                    photoLoading.visibility = View.GONE
                }
            }
        })
    }

}