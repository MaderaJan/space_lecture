package com.maderajan.spacelecture.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class SpaceDetailFragment : Fragment() {

    private val args: SpaceDetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        ComposeView(requireContext()).apply {
            this.setContent {
                SpaceDetail(
                    news = args.news,
                    onArrowBackClicked = {
                        findNavController()
                            .navigateUp()
                    },
                    onFontChangedClicked = {
                        findNavController()
                            .navigate(SpaceDetailFragmentDirections.actionSpaceDetailFragmentToFontChangeBottomSheet())
                    },
                    onBookmarkClicked = {

                    }
                )
            }
        }
}

