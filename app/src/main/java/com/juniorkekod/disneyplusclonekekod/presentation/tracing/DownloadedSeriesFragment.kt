package com.juniorkekod.disneyplusclonekekod.presentation.tracing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.juniorkekod.disneyplusclonekekod.R
import com.juniorkekod.disneyplusclonekekod.databinding.FragmentDownloadedSeriesBinding
import com.juniorkekod.disneyplusclonekekod.presentation.tracing.models.DownloadedSeason
import com.juniorkekod.disneyplusclonekekod.presentation.tracing.models.DownloadedSeries

class DownloadedSeriesFragment : Fragment() {

    private var fragmentDownloadedSeriesBinding: FragmentDownloadedSeriesBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentDownloadedSeriesBinding.inflate(inflater, container, false)
        fragmentDownloadedSeriesBinding = binding

        val dummyImage = ResourcesCompat.getDrawable(
            resources,
            R.drawable.iv_background,
            null
        ) // TODO (Ahmet) ---> It will be deleted

        val downloadedSeriesList = mutableListOf(
            DownloadedSeries(dummyImage, "Bölüm 1"),
            DownloadedSeries(dummyImage, "Bölüm 2"),
            DownloadedSeries(dummyImage, "Bölüm 3"),
            DownloadedSeries(dummyImage, "Bölüm 4"),
            DownloadedSeries(dummyImage, "Bölüm 5"),
        ) // TODO (Ahmet) ---> It will be deleted

        val downloadedSeasonList = listOf(
            DownloadedSeason("1. Sezon"),
            DownloadedSeason("2. Sezon"),
            DownloadedSeason("3. Sezon")
        ) // TODO (Ahmet) ---> It will be deleted

        val downloadedSeriesDetailMap =
            mutableMapOf<DownloadedSeason, List<DownloadedSeries>>()
                .apply {
                    this[downloadedSeasonList[0]] = downloadedSeriesList
                    this[downloadedSeasonList[1]] = downloadedSeriesList
                    this[downloadedSeasonList[2]] = downloadedSeriesList
                } // TODO (Ahmet) ---> It will be deleted

        binding.switchEditTracingDownloadedDetail.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.switchEditTracingDownloadedDetail.text = buildString {
                    append("İptal et")
                }
                binding.buttonSelectAllDetail.visibility = View.VISIBLE
                binding.ImageButtonCircleBack.visibility = View.GONE
                // TODO(Ahmet)---> When isChecked is true, every child of ExpandableListViewDownloadedSeries will have a CheckBox.
            }
            if (!isChecked) {
                binding.switchEditTracingDownloadedDetail.text = buildString {
                    append("Düzenle")
                }
                binding.buttonSelectAllDetail.visibility = View.GONE
                binding.ImageButtonCircleBack.visibility = View.VISIBLE
            }
        }

        val adapter = DownloadedSeriesAdapter(downloadedSeasonList, downloadedSeriesDetailMap)
        binding.expandableListViewDownloadedSeries.setAdapter(adapter)

        return binding.root
    }

    override fun onDestroyView() {
        fragmentDownloadedSeriesBinding = null
        super.onDestroyView()
    }
}