package com.juniorkekod.disneyplusclonekekod.presentation.tracing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.juniorkekod.disneyplusclonekekod.databinding.ItemDownloadedSeriesBinding
import com.juniorkekod.disneyplusclonekekod.databinding.ItemSeasonGroupBinding
import com.juniorkekod.disneyplusclonekekod.presentation.tracing.models.DownloadedSeason
import com.juniorkekod.disneyplusclonekekod.presentation.tracing.models.DownloadedSeries

class DownloadedSeriesAdapter( // TODO (Ahmet) ---> The custom_white_indicator_arrow in the item_season_group view will be edited. I think we can delete this directly.
    private val groupList: List<DownloadedSeason>,
    private val childList: MutableMap<DownloadedSeason, List<DownloadedSeries>>
) : BaseExpandableListAdapter() {

    private lateinit var bindingSeasonGroup: ItemSeasonGroupBinding
    private lateinit var bindingDownloadedSeries: ItemDownloadedSeriesBinding

    override fun getGroupCount(): Int {
        return groupList.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return childList[groupList[groupPosition]]?.size ?: 0
    }

    override fun getGroup(groupPosition: Int): DownloadedSeason {
        return groupList[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): DownloadedSeries {
        return childList[groupList[groupPosition]]?.get(childPosition) ?: DownloadedSeries(
            null,
            null,
            null,
            null,
            null,
            null
        )
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        bindingSeasonGroup = ItemSeasonGroupBinding.inflate(LayoutInflater.from(parent?.context))
        bindingSeasonGroup.textViewItemSeasonGroup.text = getGroup(groupPosition).season
        return bindingSeasonGroup.root
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        bindingDownloadedSeries =
            ItemDownloadedSeriesBinding.inflate(LayoutInflater.from(parent?.context))

        bindingDownloadedSeries.apply {
            imageViewDownloadedImage.setImageDrawable(
                getChild(
                    groupPosition,
                    childPosition
                ).image
            )
            textViewDownloadedName.text = getChild(groupPosition, childPosition).name
            textViewDownloadedSeriesDetail.text = getChild(
                groupPosition,
                childPosition
            ).name // TODO (Ahmet) ---> This part will be edited with string inputs (size, episodeNumber, time).
            progressBarDownloadedSeriesProgress.progress =
                getChild(groupPosition, childPosition).watchProgress ?: 0

            return bindingDownloadedSeries.root
        }
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    // TODO (Ahmet) ---> Swipe-to-Delete feature will be added for ChildView.

}