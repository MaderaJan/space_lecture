package com.maderajan.spacelecture.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.maderajan.spacelecture.databinding.FragmentSpaceListBinding
import com.maderajan.spacelecture.repository.SpaceNewsRepository
import com.maderajan.spacelecture.ui.list.adapter.SpaceListAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SpaceListFragment : Fragment() {

    private lateinit var binding: FragmentSpaceListBinding
    private val repository: SpaceNewsRepository by lazy {
        SpaceNewsRepository(requireContext())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSpaceListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val adapter = SpaceListAdapter(
            onItemClicked = { item ->
                findNavController()
                    .navigate(
                        SpaceListFragmentDirections.actionSpaceListFragmentToSpaceDetailFragment(
                            news = item
                        )
                    )
            }, onBookMarkClicked = {
                // TODO (S) 14 use insertOrDeleteBookMark
            }
        )

        binding.recyclerView.adapter = adapter

        // TODO 10. Launching coroutines in scope
        lifecycleScope.launch {
            repository.getSpaceFlightsSortedByPublishAt()
                .collectLatest { news ->
                    adapter.submitList(news)
                }
        }
    }
}