package com.example.explorecotedazur.ui.mainFragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.explorecotedazur.R
import com.example.explorecotedazur.domain.models.CategoriesData
import com.example.explorecotedazur.domain.models.MainCategoriesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import javax.inject.Inject

@HiltViewModel
class MainCategoriesViewModel @Inject constructor(
    private val repository: MainCategoriesRepository,
) : ViewModel() {

    private val _liveData = MutableLiveData<List<CategoriesData>>()
    val liveData: LiveData<List<CategoriesData>> get() = _liveData

    private val _errorLiveData = MutableLiveData<Int>()
    val errorLiveData: LiveData<Int> get() = _errorLiveData

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        when (throwable) {
            is SocketTimeoutException -> _errorLiveData.value = R.string.connection_error
            else -> _errorLiveData.value = R.string.unknown_error
        }
    }

    private val _loadingLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean> get() = _loadingLiveData

    fun getMainCategories() {
        viewModelScope.launch(exceptionHandler) {
            val categoryInfo = repository.getMainCategories()
            _liveData.value = categoryInfo
        }
    }
}