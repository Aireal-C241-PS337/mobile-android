package capstone.tim.aireal.ui.editShop

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import capstone.tim.aireal.api.ApiConfig
import capstone.tim.aireal.data.pref.UserModel
import capstone.tim.aireal.data.pref.UserPreference
import capstone.tim.aireal.response.EditShopResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditShopViewModel(
    private val pref: UserPreference,
    private val context: Context
) : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _isError = MutableLiveData<Boolean>()
    val isError: LiveData<Boolean> = _isError

    fun updateShop(
        token: String,
        shopId: String,
        userId: RequestBody,
        name: RequestBody,
        description: RequestBody,
        street: RequestBody,
        city: RequestBody,
        province: RequestBody,
        image: MultipartBody.Part
    ) {
        _isLoading.value = true
        val client = ApiConfig.getApiService().updateShop(
            token,
            shopId,
            userId,
            name,
            description,
            street,
            city,
            province,
            image
        )
        client.enqueue(object : Callback<EditShopResponse> {
            override fun onResponse(
                call: Call<EditShopResponse>,
                response: Response<EditShopResponse>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _isError.value = false
                    Log.d(TAG, "onResponse: ${response.body()?.message}")
                } else {
                    _isError.value = true
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<EditShopResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }

    fun craeteShop(
        token: String,
        userId: RequestBody,
        name: RequestBody,
        description: RequestBody,
        street: RequestBody,
        city: RequestBody,
        province: RequestBody,
        image: MultipartBody.Part
    ) {
        _isLoading.value = true
        val client = ApiConfig.getApiService().createShop(
            token,
            userId,
            name,
            description,
            street,
            city,
            province,
            image
        )
        client.enqueue(object : Callback<EditShopResponse> {
            override fun onResponse(
                call: Call<EditShopResponse>,
                response: Response<EditShopResponse>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _isError.value = false
                    Log.d(TAG, "onResponse: ${response.body()?.message}")
                } else {
                    _isError.value = true
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<EditShopResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }

    fun getUser(): LiveData<UserModel> {
        return pref.getUser().asLiveData()
    }

    companion object {
        private const val TAG = "EditShopViewModel"
    }
}