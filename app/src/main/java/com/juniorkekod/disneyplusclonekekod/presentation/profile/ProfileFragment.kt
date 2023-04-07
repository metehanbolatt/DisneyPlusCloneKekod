package com.juniorkekod.disneyplusclonekekod.presentation.profile

import android.widget.Toast
import com.juniorkekod.disneyplusclonekekod.R
import com.juniorkekod.disneyplusclonekekod.base.BaseFragment
import com.juniorkekod.disneyplusclonekekod.databinding.FragmentProfileBinding
import com.juniorkekod.disneyplusclonekekod.presentation.profile.adapter.SettingsListAdapter
import com.juniorkekod.disneyplusclonekekod.presentation.profile.adapter.UserImageAdapter


class ProfileFragment : BaseFragment<FragmentProfileBinding>(
    FragmentProfileBinding::inflate
) {
    private val userImageAdapter = UserImageAdapter()
    private val settingsListAdapter = SettingsListAdapter()

    override fun setInitialize() {
        val pInfo = requireContext().packageManager.getPackageInfo(
            requireContext().packageName, 0
        )
        val version = pInfo.versionName

        binding.profileVersionInfoTv.text = requireContext().getString(R.string.key_profile_version_info,version)
    }

    override fun setAdapter() {
        val userImageList = mutableListOf<Int>()
        userImageList.add(R.drawable.otp_image)
        userImageList.add(R.drawable.otp_image)
        userImageList.add(R.drawable.otp_image)
        userImageList.add(R.drawable.otp_image)
        userImageAdapter.updateList(userImageList)
        val settingsList = mutableListOf<String>()
        settingsList.add("İzleme Listem")
        settingsList.add("Uygulama Ayarları")
        settingsList.add("Hesap")
        settingsList.add("Yasal")
        settingsList.add("Oturumu Kapat")
        settingsListAdapter.updateList(settingsList)
        settingsListAdapter.settingsListClickItem {
            Toast.makeText(requireContext(), "Tiklandı", Toast.LENGTH_SHORT).show()
        }
        binding.apply {
            profileUserImageRv.adapter = userImageAdapter
            profileSettingsListRv.adapter = settingsListAdapter
        }
    }
    override fun setListeners() {

    }

    override fun setObserve() {

    }
}