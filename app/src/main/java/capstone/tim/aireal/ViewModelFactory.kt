package capstone.tim.aireal

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import capstone.tim.aireal.data.pref.UserPreference
import capstone.tim.aireal.ui.addProduct.AddProductViewModel
import capstone.tim.aireal.ui.akun.AkunViewModel
import capstone.tim.aireal.ui.detailProduct.DetailProductViewModel
import capstone.tim.aireal.ui.editProfile.EditProfileViewModel
import capstone.tim.aireal.ui.editShop.EditShopViewModel
import capstone.tim.aireal.ui.home.HomeViewModel
import capstone.tim.aireal.ui.keranjang.KeranjangViewModel
import capstone.tim.aireal.ui.login.LoginViewModel
import capstone.tim.aireal.ui.orderHistory.OrderHistoryViewModel
import capstone.tim.aireal.ui.shopDisplay.ShopDisplayViewModel
import capstone.tim.aireal.ui.toko.TokoViewModel

class ViewModelFactory(private val pref: UserPreference, private val context: Context) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(pref, context) as T
            }

            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(pref, context) as T
            }

            modelClass.isAssignableFrom(DetailProductViewModel::class.java) -> {
                DetailProductViewModel(pref, context) as T
            }

            modelClass.isAssignableFrom(OrderHistoryViewModel::class.java) -> {
                OrderHistoryViewModel(pref, context) as T
            }

            modelClass.isAssignableFrom(KeranjangViewModel::class.java) -> {
                KeranjangViewModel(pref, context) as T
            }

            modelClass.isAssignableFrom(EditProfileViewModel::class.java) -> {
                EditProfileViewModel(pref, context) as T
            }

            modelClass.isAssignableFrom(EditShopViewModel::class.java) -> {
                EditShopViewModel(pref, context) as T
            }

            modelClass.isAssignableFrom(AddProductViewModel::class.java) -> {
                AddProductViewModel(pref, context) as T
            }

            modelClass.isAssignableFrom(ShopDisplayViewModel::class.java) -> {
                ShopDisplayViewModel(pref, context) as T
            }

            modelClass.isAssignableFrom(AkunViewModel::class.java) -> {
                AkunViewModel(pref, context) as T
            }

            modelClass.isAssignableFrom(TokoViewModel::class.java) -> {
                TokoViewModel(pref, context) as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }

}
