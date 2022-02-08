package com.example.profilephoto.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.profilephoto.R
import com.example.profilephoto.model.Photo
import com.example.profilephoto.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.photo_row.view.*

class photoAdapter(val photolist: ArrayList<Photo>) :
    RecyclerView.Adapter<photoAdapter.PhotoViewHolder>() {
    class PhotoViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.photo_row, parent, false)
        return PhotoViewHolder(view)
    }


    override fun getItemCount(): Int {
        return photolist.size
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.view.photosTW.text = photolist[position].photoNumber.toString()

        holder.view.setOnClickListener {
            val action=FeedFragmentDirections.actionFeedFragmentToPhotoFragment()
            Navigation.findNavController(it).navigate(action)
        }


    }


    fun updateCountryList(newPhotoList: List<Photo>) {
        photolist.clear()
        photolist.addAll(newPhotoList)
        notifyDataSetChanged()
    }
}
