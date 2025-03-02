package com.maderajan.spacelecture.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.maderajan.spacelecture.databinding.FragmentSpaceListBinding

class SpaceListFragment: Fragment() {

    private lateinit var binding: FragmentSpaceListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSpaceListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    // TODO 3. onViewCreated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO 3. Setup Adapter
        // TODO 3. Setup LayoutManager
    }
}