package com.peakfinn.task2

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_portal.view.*
import kotlin.reflect.KFunction1

/**
 * Created by Finn Bon on 25/03/2020.
 */
class PortalAdapter(
    private val portals: MutableList<Portal>,
    private val onClick: KFunction1<String, Unit>
) : RecyclerView.Adapter<PortalAdapter.ViewHolder>() {

    // In here, we bind a Portal instance to it's visual component
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(portal: Portal) {
            itemView.tvName.text = portal.name
            itemView.tvURL.text = portal.url
            itemView.setOnClickListener { onClick(portal.url) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_portal, parent, false)
        )
    }

    override fun getItemCount(): Int = portals.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(portals[position])
    }

}