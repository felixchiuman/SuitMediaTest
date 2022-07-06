package com.felix.suitmedia.ui.third

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.felix.suitmedia.data.api.repository.Repository
import com.felix.suitmedia.data.api.resource.Resource
import com.felix.suitmedia.model.GetListUserResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class ThirdPageViewModel(private val repository: Repository) : ViewModel() {

    private val _user = MutableLiveData<Resource<Response<GetListUserResponse>>>()
    val user : LiveData<Resource<Response<GetListUserResponse>>> get() = _user

    fun getUsers() {
        viewModelScope.launch {
            _user.postValue(Resource.loading())
            try {
                _user.postValue(Resource.success(repository.getUsers()))
            }catch (e: Exception) {
                _user.postValue(Resource.error(e.message ?: "Something went wrong"))
            }
        }
    }
}