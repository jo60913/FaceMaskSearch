package com.example.facemask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.facemask.data.Feature
import com.example.facemask.databinding.ActivityPharmacyDetailBinding


class PharmacyDetailActivity : AppCompatActivity() {

    private val data by lazy { intent.getSerializableExtra("data") as? Feature }

    private val name by lazy { data?.properties?.name }
    private val maskAdultAmount by lazy { data?.properties?.mask_adult }
    private val maskChildAmount by lazy { data?.properties?.mask_child }
    private val phone by lazy { data?.properties?.phone }
    private val address by lazy { data?.properties?.address }
    private val note by lazy {data?.properties?.note}
    private val updatetime by lazy { data?.properties?.updated }

    private lateinit var binding: ActivityPharmacyDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_pharmacy_detail)

        binding = ActivityPharmacyDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

    }

    private fun initView() {
        binding.tvName.text = name ?: "資料發生錯誤"
        binding.tvAdultAmount.text = maskAdultAmount.toString()
        binding.tvChildAmount.text = maskChildAmount.toString()
        binding.tvPhone.text = phone
        binding.tvAddress.text = address
        binding.tvNote.text = note
        binding.tvUpdateTime.text = updatetime?.replace("/","")
    }
}