package com.peakfinn.task2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_add_portal.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddPortalFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_portal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addPortalButton.setOnClickListener {
            addPortal()
        }
    }

    private fun addPortal() {
        val portal = Portal(tiName.text.toString(), tiUrl.text.toString())

        setFragmentResult(
            ADD_PORTAL_REQUEST,
            bundleOf(
                Pair(
                    NEW_PORTAL,
                    portal
                )
            )
        )
        findNavController().popBackStack()
    }
}