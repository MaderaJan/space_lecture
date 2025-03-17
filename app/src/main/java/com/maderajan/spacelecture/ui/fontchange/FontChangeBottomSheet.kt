package com.maderajan.spacelecture.ui.fontchange

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FontChangeBottomSheet : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return ComposeView(requireContext()).apply {
            this.setContent {
                ChangeFontScreen(
                    onCancelClick = {
                        findNavController()
                            .navigateUp()
                    }
                )
            }
        }
    }
}
