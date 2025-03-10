package com.maderajan.spacelecture.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.maderajan.spacelecture.databinding.FragmentSpaceListBinding
import com.maderajan.spacelecture.repository.SpaceNewsRepository
import com.maderajan.spacelecture.ui.list.adapter.SpaceListAdapter

class SpaceListFragment : Fragment() {

    private lateinit var binding: FragmentSpaceListBinding

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
                // ...
            }
        )

        binding.recyclerView.adapter = adapter

        adapter.submitList(SpaceNewsRepository().getSpaceNews())
    }
}