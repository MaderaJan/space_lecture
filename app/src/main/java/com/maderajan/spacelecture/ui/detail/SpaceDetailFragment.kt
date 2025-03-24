package com.maderajan.spacelecture.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.maderajan.spacelecture.repository.SpaceNewsRepository
import kotlinx.coroutines.launch

class SpaceDetailFragment : Fragment() {

    private val args: SpaceDetailFragmentArgs by navArgs()
    private val repository: SpaceNewsRepository by lazy {
        SpaceNewsRepository(requireContext())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        ComposeView(requireContext()).apply {
            this.setContent {
                var news by remember { mutableStateOf(args.news) }

                SpaceDetail(
                    news = news,
                    onArrowBackClicked = {
                        findNavController()
                            .navigateUp()
                    },
                    onFontChangedClicked = {
                        findNavController()
                            .navigate(SpaceDetailFragmentDirections.actionSpaceDetailFragmentToFontChangeBottomSheet())
                    },
                    onBookmarkClicked = {
                        lifecycleScope.launch {
                            repository.insertOrDeleteBookMark(news)
                        }

                        news = news.copy(isBookmarked = !news.isBookmarked)
                    }
                )
            }
        }
}

