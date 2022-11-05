package com.aya.pagingwithhilt.features.fragments.photos.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.aya.pagingwithhilt.base.BaseFragment
import com.aya.pagingwithhilt.core.extension.afterTextChanged
import com.aya.pagingwithhilt.core.extension.navigateSafe
import com.aya.pagingwithhilt.core.extension.observe
import com.aya.pagingwithhilt.databinding.FragmentPhotosBinding
import com.aya.pagingwithhilt.features.fragments.photos.data.PhotoItem
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class PhotosFragment : BaseFragment<FragmentPhotosBinding>(FragmentPhotosBinding::inflate) {
    private val mViewModel: PhotosViewModel by viewModels()
    override fun mShowBackBtn(): Boolean = true
    override fun mPageTitle(): String = "Photos"
    private val adapter = PhotosAdapter(::onItemClicked)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModel.getPhotos()

        observe(mViewModel.viewState) {
            when (it) {
                PhotosAction.OnBackButton -> closeFragment()
                is PhotosAction.ShowLoading -> showProgress(it.show)
                is PhotosAction.ShowMessage -> showToast(it.message)
                is PhotosAction.PhotosList -> {
                    showToast("Heyyyyy")
                    Log.d("Heyyyyy Mouaaaz ", "Twooooo")
                   // binding.rvPhotos.adapter = adapter
                    // adapter.submitList(it.photosList)
                }
                is PhotosAction.PhotoItemClicked -> {
                    // open image view paghe
                }
            }
        }
    }

    private fun onItemClicked(item: PhotoItem) {
        navigateSafe(PhotosFragmentDirections.actionPhotosFragmentToPhotoViewFragment(item.thumbnailUrl))
    }
}
