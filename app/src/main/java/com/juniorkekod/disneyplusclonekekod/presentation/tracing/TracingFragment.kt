package com.juniorkekod.disneyplusclonekekod.presentation.tracing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.juniorkekod.disneyplusclonekekod.R
import com.juniorkekod.disneyplusclonekekod.databinding.FragmentTracingBinding
import com.juniorkekod.disneyplusclonekekod.presentation.tracing.models.DownloadedMovies
import com.juniorkekod.disneyplusclonekekod.presentation.tracing.models.DownloadedSeries

class TracingFragment : Fragment() {

    private var fragmentTracingBinding: FragmentTracingBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTracingBinding.inflate(inflater, container, false)
        fragmentTracingBinding = binding

        val dummyImage = ResourcesCompat.getDrawable(
            resources,
            R.drawable.iv_background,
            null
        ) // TODO (Ahmet) ---> It will be deleted

        val downloadedSeriesLists = mutableListOf(
            DownloadedSeries(dummyImage, "Bölüm 1"),
            DownloadedMovies(dummyImage, "Arabalar 3"),
            DownloadedSeries(dummyImage, "Bölüm 3"),
            DownloadedMovies(dummyImage, "Ejderhanı Nasıl Eğitirsin"),
            DownloadedMovies(dummyImage, "Star Wars: Imparatorun Dönüşü"),
        ) // TODO (Ahmet) ---> It will be deleted

        val adapter = DownloadedItemAdapter(downloadedSeriesLists)
        binding.recyclerViewTracingDownloaded.adapter = adapter

        binding.switchSelectTracingDownloaded.setOnCheckedChangeListener { _, isChecked -> // TODO (Ahmet)---> The font of switchSelectTracingDownloaded have to change.
            if (isChecked) {
                binding.switchSelectTracingDownloaded.text = buildString {
                    append("İptal et")
                }
                binding.buttonTracingSelectAll.visibility = View.VISIBLE
                // TODO (Ahmet)---> When isChecked is true, every item of recyclerViewTracingDownloaded will have a CheckBox.
            }
            if (!isChecked) {
                binding.switchSelectTracingDownloaded.text = buildString {
                    append("Düzenle")
                }
                binding.buttonTracingSelectAll.visibility = View.GONE
            }
        }

        binding.recyclerViewTracingDownloaded.setHasFixedSize(true)

        return binding.root
    }

    override fun onDestroyView() {
        fragmentTracingBinding = null
        super.onDestroyView()
    }
}