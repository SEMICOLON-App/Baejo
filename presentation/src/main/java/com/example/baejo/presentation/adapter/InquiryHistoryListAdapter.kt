package com.example.baejo.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.baejo.R
import com.example.domain.entity.SearchHistoryData

class InquiryHistoryListAdapter(
    private val onItemClickListener: OnItemClickListener,
    private val onItemLongClickListener: OnItemLongClickListener
) : RecyclerView.Adapter<InquiryHistoryListAdapter.ViewHolder>() {

    private var inquiryHistoryList: List<SearchHistoryData> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_inquiry_history, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvCarrierName.text = inquiryHistoryList[position].courierServiceName
        holder.tvWaybillNum.text = inquiryHistoryList[position].waybillNumber
        holder.tvDate.text = inquiryHistoryList[position].date
    }

    override fun getItemCount() =
        inquiryHistoryList.size

    fun getInquiryHistoryList() =
        inquiryHistoryList

    fun setInquiryHistoryList(inquiryHistoryList: List<SearchHistoryData>) {
        this.inquiryHistoryList = inquiryHistoryList
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvCarrierName: TextView =
            itemView.findViewById(R.id.tv_carrier_name_item_inquiry_history)
        val tvWaybillNum: TextView =
            itemView.findViewById(R.id.tv_waybill_num_item_inquiry_history)
        val tvDate: TextView =
            itemView.findViewById(R.id.tv_date_item_inquiry_history)

        init {
            itemView.setOnClickListener {
                itemView.setOnClickListener {
                    onItemClickListener.onItemClick(it, adapterPosition)
                }

                itemView.setOnLongClickListener {
                    onItemLongClickListener.onItemLongClick(it, adapterPosition)
                    return@setOnLongClickListener false
                }
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(v: View, position: Int)
    }

    interface OnItemLongClickListener {
        fun onItemLongClick(v: View, position: Int)
    }
}