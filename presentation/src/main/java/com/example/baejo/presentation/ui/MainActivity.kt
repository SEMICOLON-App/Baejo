package com.example.baejo.presentation.ui

import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.baejo.R
import com.example.baejo.databinding.ActivityMainBinding
import com.example.baejo.presentation.IntentExtraKey
import com.example.baejo.presentation.adapter.InquiryHistoryListAdapter
import com.example.baejo.presentation.base.BaseActivity
import com.example.baejo.presentation.dialog.DeleteDialog
import com.example.baejo.presentation.dialog.LoadingDialog
import com.example.baejo.presentation.viewmodel.MainViewModel
import com.example.domain.entity.CarrierData
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val mainViewModel: MainViewModel by viewModel()
    private val loadingDialog = LoadingDialog(this)

    private var isAbleToInquiry = false
    private var curCourierService: CarrierData? = null

    private lateinit var inquiryHistoryListAdapter: InquiryHistoryListAdapter
    private lateinit var courierServiceList: List<CarrierData>


    override val layoutResId: Int
        get() = R.layout.activity_main

    override fun init() {
        loadingDialog.callDialog()

        inquiryHistoryListAdapter = InquiryHistoryListAdapter(

            object : InquiryHistoryListAdapter.OnItemClickListener {
                override fun onItemClick(v: View, position: Int) {
                    val curInquiryHistory =
                        inquiryHistoryListAdapter.getInquiryHistoryList()[position]
                    val courierName = curInquiryHistory.courierServiceName
                    val waybillNum = curInquiryHistory.waybillNumber

                    startResultActivity(courierName, waybillNum)
                }
            },
            object : InquiryHistoryListAdapter.OnItemLongClickListener {
                override fun onItemLongClick(v: View, position: Int) {
                    DeleteDialog(
                        this@MainActivity,
                        "삭제",
                        "조회 기록을 삭제하시겠습니까?",
                        object : DeleteDialog.OnDialogButtonClickListener {
                            override fun onDeleteClick() {
                                mainViewModel.deleteSearchHistory(
                                    inquiryHistoryListAdapter.getInquiryHistoryList()[position]
                                )
                            }

                            override fun onNoClick() {
                                makeToast("취소되었습니다")
                            }
                        }
                    ).callDialog()
                }
            }
        )
        binding.rvInquiryHistoryMain.adapter = inquiryHistoryListAdapter

        binding.btnDeleteInquiryHistoryMain.setOnClickListener {
            DeleteDialog(
                this,
                "삭제",
                "모든 조회 기록을 삭제하시겠습니까?",
                object : DeleteDialog.OnDialogButtonClickListener {

                    override fun onDeleteClick() {
                        mainViewModel.deleteAllSearchHistory()
                    }

                    override fun onNoClick() {
                        makeToast("취소되었습니다")
                    }

                }
            ).callDialog()
        }

        binding.btnInquiryMain.setOnClickListener {
            val curWaybillNum = binding.etWaybillNumMain.text.toString()

            if (isAbleToInquiry) return@setOnClickListener
            if (curWaybillNum.isEmpty()) return@setOnClickListener
            if (curCourierService == null) return@setOnClickListener

            startResultActivity(curCourierService!!.carrierId, curWaybillNum)
        }

        binding.spinnerCourierMain.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    curCourierService = courierServiceList[position]
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    curCourierService = null
                    makeToast("택배사를 선택해주세요")
                }
            }

        mainViewModel.carrierList.observe(this, {
            binding.spinnerCourierMain.adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                getCourierNameArray(it!!)
            )
            binding.spinnerCourierMain.setSelection(0)

            isAbleToInquiry = true
            loadingDialog.dismissDialog()

            binding.progressLoadInquiryHistoryMain.visibility = View.VISIBLE
            mainViewModel.getSearchHistory()
        })

        mainViewModel.searchHistoryList.observe(this, {
            inquiryHistoryListAdapter.setInquiryHistoryList(it!!)
            binding.progressLoadInquiryHistoryMain.visibility = View.INVISIBLE
            binding.rvInquiryHistoryMain.visibility = View.VISIBLE
        })

        mainViewModel.messageEvent.observe(this, {
            makeToast(it)
        })

        mainViewModel.emptySearchHistoryEvent.observe(this, {
            binding.progressLoadInquiryHistoryMain.visibility = View.INVISIBLE
            binding.linearNoInquiryHistoryMain.visibility = View.VISIBLE
        })

        mainViewModel.deleteSuccessEvent.observe(this, {
            mainViewModel.getSearchHistory()
        })

        mainViewModel.getCarrier()
    }

    private fun startResultActivity(courierName: String, waybillNum: String) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra(IntentExtraKey.KEY_COURIER_SERVICE_NAME, courierName)
        intent.putExtra(IntentExtraKey.KEY_WAYBILL_NUMBER, waybillNum)
        startActivity(intent)
    }

    private fun getCourierNameArray(carrierDataList: List<CarrierData>): Array<String> {
        val courierNameList = ArrayList<String>()
        for (carrierDate in carrierDataList) {
            courierNameList.add(carrierDate.carrierName)
        }
        return courierNameList.toTypedArray()
    }

    private fun makeToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}