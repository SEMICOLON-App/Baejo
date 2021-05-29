package com.example.baejo.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.baejo.R
import com.example.domain.entity.DeliveryInformationData

class DeliveryProgressListAdapter : RecyclerView.Adapter<DeliveryProgressListAdapter.ViewHolder>() {

    private var deliveryProgressList: List<DeliveryInformationData> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DeliveryProgressListAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_delivery_info, parent, false))
    }

    override fun onBindViewHolder(holder: DeliveryProgressListAdapter.ViewHolder, position: Int) {
        val date = deliveryProgressList[position].date.substring(0,10)
        val time = deliveryProgressList[position].date.substring(11)

        holder.tvDate.text = date
        holder.tvTime.text = time
        holder.tvLocation.text = deliveryProgressList[position].location
        holder.tvState.text = deliveryProgressList[position].detailState
    }

    override fun getItemCount(): Int =
        deliveryProgressList.size

    fun setDeliveryProgressList(deliveryProgressList: List<DeliveryInformationData>){
        this.deliveryProgressList = deliveryProgressList
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvDate: TextView = itemView.findViewById(R.id.tv_date_item_delivery_info)
        val tvTime: TextView = itemView.findViewById(R.id.tv_time_item_delivery_info)
        val tvLocation: TextView = itemView.findViewById(R.id.tv_location)
        val tvState: TextView = itemView.findViewById(R.id.tv_state)
    }
}