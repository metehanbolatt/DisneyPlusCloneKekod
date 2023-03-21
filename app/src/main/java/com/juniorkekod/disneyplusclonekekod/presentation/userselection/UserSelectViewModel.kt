package com.juniorkekod.disneyplusclonekekod.presentation.userselection

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserSelectViewModel : ViewModel() {

    var userList = MutableStateFlow<List<UserSelectModel>?>(null)
    private var _userList: MutableStateFlow<List<UserSelectModel>?> = userList

    fun getUserList() = viewModelScope.launch {
        val list = listOf<UserSelectModel>(
            UserSelectModel("melike", null, false),
            UserSelectModel("mine", null, false),
            UserSelectModel("melisa", null, true),
            UserSelectModel("metin", null, true),
            UserSelectModel("melek", null, false),
            UserSelectModel("melisa", null, true),
            UserSelectModel("metin", null, true))
        _userList.value = list
    }
}