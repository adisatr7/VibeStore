package com.example.innotechstore.helper

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.innotechstore.data.repository.InnotechStoreRepository
import com.example.innotechstore.di.Injection
import com.example.innotechstore.ui.screen.address.AddressViewModel
import com.example.innotechstore.ui.screen.address.add_address.AddAddressViewModel
import com.example.innotechstore.ui.screen.checkout.CheckoutViewModel
import com.example.innotechstore.ui.screen.detail.DetailViewModel
import com.example.innotechstore.ui.screen.favourite.FavouriteViewModel
import com.example.innotechstore.ui.screen.foryou.ForYouViewModel
import com.example.innotechstore.ui.screen.home.HomeViewModel
import com.example.innotechstore.ui.screen.main.MainViewModel
import com.example.innotechstore.ui.screen.mycart.MyCartViewModel
import com.example.innotechstore.ui.screen.notification.NotificationViewModel
import com.example.innotechstore.ui.screen.ourproduct.OurProductViewModel
import com.example.innotechstore.ui.screen.payment.PaymentViewModel
import com.example.innotechstore.ui.screen.payment.success_payment.SuccessPaymentViewModel
import com.example.innotechstore.ui.screen.product.all.AllProductViewModel
import com.example.innotechstore.ui.screen.product.smartscreen.SmartScreenProductViewModel
import com.example.innotechstore.ui.screen.product.allinone.AllInOneProductViewModel
import com.example.innotechstore.ui.screen.product.laptop.LaptopProductViewModel
import com.example.innotechstore.ui.screen.product.server.ServerProductViewModel
import com.example.innotechstore.ui.screen.profile.ProfileViewModel
import com.example.innotechstore.ui.screen.registration.login.LoginViewModel
import com.example.innotechstore.ui.screen.registration.signup.SignUpViewModel
import com.example.innotechstore.ui.screen.registration.welcome.WelcomeViewModel
import com.example.innotechstore.ui.screen.yourorder.YourOrderViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val limit: Int = 20,
    private val repository: InnotechStoreRepository,
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(AllProductViewModel::class.java) ->
                AllProductViewModel(repository) as T
            modelClass.isAssignableFrom(SmartScreenProductViewModel::class.java) ->
                SmartScreenProductViewModel(repository) as T
            modelClass.isAssignableFrom(AllInOneProductViewModel::class.java) ->
                AllInOneProductViewModel(repository) as T
            modelClass.isAssignableFrom(LaptopProductViewModel::class.java) ->
                LaptopProductViewModel(repository) as T
            modelClass.isAssignableFrom(ServerProductViewModel::class.java) ->
                ServerProductViewModel(repository) as T
            modelClass.isAssignableFrom(ForYouViewModel::class.java) ->
                ForYouViewModel(repository) as T
            modelClass.isAssignableFrom(DetailViewModel::class.java) ->
                DetailViewModel(repository) as T
            modelClass.isAssignableFrom(OurProductViewModel::class.java) ->
                OurProductViewModel(repository) as T
            modelClass.isAssignableFrom(SignUpViewModel::class.java) ->
                SignUpViewModel(repository) as T
            modelClass.isAssignableFrom(LoginViewModel::class.java) ->
                LoginViewModel(repository) as T
            modelClass.isAssignableFrom(ProfileViewModel::class.java) ->
                ProfileViewModel(repository) as T
            modelClass.isAssignableFrom(MainViewModel::class.java) ->
                MainViewModel(repository) as T
            modelClass.isAssignableFrom(WelcomeViewModel::class.java) ->
                WelcomeViewModel(repository) as T
            modelClass.isAssignableFrom(MyCartViewModel::class.java) ->
                MyCartViewModel(repository) as T
            modelClass.isAssignableFrom(HomeViewModel::class.java) ->
                HomeViewModel(repository) as T
            modelClass.isAssignableFrom(FavouriteViewModel::class.java) ->
                FavouriteViewModel(repository) as T
            modelClass.isAssignableFrom(AddAddressViewModel::class.java) ->
                AddAddressViewModel(repository) as T
            modelClass.isAssignableFrom(AddressViewModel::class.java) ->
                AddressViewModel(repository) as T
            modelClass.isAssignableFrom(CheckoutViewModel::class.java) ->
                CheckoutViewModel(repository) as T
            modelClass.isAssignableFrom(PaymentViewModel::class.java) ->
                PaymentViewModel(repository) as T
            modelClass.isAssignableFrom(SuccessPaymentViewModel::class.java) ->
                SuccessPaymentViewModel(repository) as T
            modelClass.isAssignableFrom(YourOrderViewModel::class.java) ->
                YourOrderViewModel(repository) as T
            modelClass.isAssignableFrom(NotificationViewModel::class.java) ->
                NotificationViewModel(repository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }

    companion object {
        fun getInstance(
            context: Context,
            limit: Int = 20,
        ) = ViewModelFactory(
            limit,
            Injection.provideRepository(context)
        )
    }
}
