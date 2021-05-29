package com.example.baejo.presentation.ui

import android.view.View
import android.widget.Toast
import com.example.baejo.R
import com.example.baejo.databinding.ActivityResultBinding
import com.example.baejo.presentation.adapter.DeliveryProgressListAdapter
import com.example.baejo.presentation.base.BaseActivity
import com.example.baejo.presentation.viewmodel.ResultViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

const val KEY_COURIER_SERVICE_NAME = "CourierServiceName"
const val KEY_WAYBILL_NUMBER = "WaybillNumber"

class ResultActivity : BaseActivity<ActivityResultBinding>() {


    private val resultViewModel: ResultViewModel by viewModel()

    override val layoutResId: Int
        get() = R.layout.activity_result

    override fun init() {
        val courierServiceName = intent.getStringExtra(KEY_COURIER_SERVICE_NAME)
        val waybillNumber = intent.getStringExtra(KEY_WAYBILL_NUMBER)
        val deliveryProgressListAdapter = DeliveryProgressListAdapter()

        binding.btnBackResult.setOnClickListener {
            finish()
        }

        resultViewModel.deliveryProgress.observe(this, {
            binding.tvCarrierResult.text = courierServiceName
            binding.tvWaybillNumResult.text = waybillNumber
            binding.tvReceiveResult.text = it!!.receive
            binding.tvDispatchResult.text = it.dispatch
            binding.tvStateResult.text = it.deliveryState

            when (it.deliveryState) {
                "상품준비중" -> binding.pbStateResult.progress = 20
                "상품인수" -> binding.pbStateResult.progress = 40
                "상품이동중" -> binding.pbStateResult.progress = 60
                "배송출발" -> binding.pbStateResult.progress = 80
                "배송완료" -> binding.pbStateResult.progress = 100
                else -> binding.pbStateResult.progress = 0
            }

            binding.rvDeliveryInfoResult.adapter = deliveryProgressListAdapter
            deliveryProgressListAdapter.setDeliveryProgressList(it.deliveryInformation)
        })

        resultViewModel.successEvent.observe(this, {
            binding.shimmerDetailResult.visibility = View.INVISIBLE
            binding.shimmerProgressResult.visibility = View.INVISIBLE

            binding.clDetailResult.visibility = View.VISIBLE
            binding.clProgressResult.visibility = View.VISIBLE
        })

        resultViewModel.failEvent.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            finish()
        })

        resultViewModel.getDeliveryProgress(
            courierServiceName.toString(), waybillNumber.toString()
        )
    }
}