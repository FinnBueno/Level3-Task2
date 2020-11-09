package com.peakfinn.task2

import androidx.fragment.app.setFragmentResultListener
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.fragment_portals.*

const val ADD_PORTAL_REQUEST = "add_portal_request"
const val NEW_PORTAL = "new_portal"

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PortalsFragment : Fragment() {

    private val portals = mutableListOf<Portal>()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_portals, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        rvPortalList.adapter = PortalAdapter(portals, ::onItemClicked)
        initiateFragmentResultListener()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initiateFragmentResultListener() {
        setFragmentResultListener(ADD_PORTAL_REQUEST) { _, bundle ->
            val portal = bundle.getParcelable<Portal>(NEW_PORTAL)
            portals.add(portal!!)
            rvPortalList.adapter?.notifyDataSetChanged()
        }
    }

    private fun onItemClicked(url: String) {
        val builder = CustomTabsIntent.Builder()
        context?.let {
            builder.setToolbarColor(ContextCompat.getColor(it, R.color.colorPrimary))
            val customTabsIntent = builder.build();
            customTabsIntent.launchUrl(it, Uri.parse(url));
        }
    }
}