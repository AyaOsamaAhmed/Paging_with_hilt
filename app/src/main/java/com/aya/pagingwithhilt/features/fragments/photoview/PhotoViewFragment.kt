package com.aya.pagingwithhilt.features.fragments.photoview

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import coil.load
import com.aya.pagingwithhilt.base.BaseFragment
import com.aya.pagingwithhilt.databinding.ActivityMainBinding.inflate
import com.aya.pagingwithhilt.databinding.FragmentPhotoViewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotoViewFragment :
    BaseFragment<FragmentPhotoViewBinding>(FragmentPhotoViewBinding::inflate) {
    private val args by navArgs<PhotoViewFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.photoView.load(args.photoUrl)

        binding.btnShare.setOnClickListener {
            sharePhoto(args.photoUrl)
        }
    }

    private fun sharePhoto(photoUrl: String) {

        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_STREAM, photoUrl)
            type = "image/*"
        }
        startActivity(Intent.createChooser(shareIntent, "App Sent This photo to you"))
    }
}
