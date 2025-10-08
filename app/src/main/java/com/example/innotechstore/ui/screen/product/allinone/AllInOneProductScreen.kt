package com.example.innotechstore.ui.screen.product.allinone

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.innotechstore.helper.ViewModelFactory
import com.example.innotechstore.ui.common.UiState
import com.example.innotechstore.ui.component.AnimatedShimmerProduct
import com.example.innotechstore.ui.component.ProductCard2
import com.example.innotechstore.ui.screen.product.allinone.AllInOneProductViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AllInOneProductScreen(
    gridHeight: Dp = Dp.Unspecified,
    limit: Int,
    height: Dp,
    count: Int = 4,
    navigateToDetail: (Int) -> Unit,
    viewModel: AllInOneProductViewModel = viewModel(
        factory = ViewModelFactory.getInstance(
            context = LocalContext.current
        )
    ),
    snackbarHostState: SnackbarHostState,
    scope: CoroutineScope
) {
    val uiState = viewModel.uiState.observeAsState(initial = UiState.Loading).value

    when (uiState) {
        is UiState.Loading -> {
            // Panggil sekali saat masuk state Loading (hindari pemanggilan berulang saat recomposition)
            LaunchedEffect(limit) {
                viewModel.getProductByCategory("allinone", limit)
            }

            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .fillMaxWidth()
                    .height(height)
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(196.dp),
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .heightIn(min = gridHeight, max = gridHeight)
                ) {
                    items(count) { _ ->
                        AnimatedShimmerProduct()
                    }
                }
            }
        }

        is UiState.Success -> {
            val products = uiState.data
            LazyVerticalGrid(
                columns = GridCells.Adaptive(196.dp),
                modifier = Modifier.heightIn(min = gridHeight, max = gridHeight),
            ) {
                items(products) { product ->
                    ProductCard2(
                        image = product.image,
                        title = product.title,
                        modifier = Modifier.clickable {
                            navigateToDetail(product.id)
                        },
                        addToCart = {
                            viewModel.addToCart(product)
                            scope.launch {
                                snackbarHostState.showSnackbar(
                                    message = "Product added to cart"
                                )
                            }
                        },
                        rating = product.rating?.rate?.toString() ?: "0",
                        price = product.price.toString(),
                        category = product.category
                    )
                }
            }
        }

        is UiState.Error -> {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(text = uiState.errorMessage)
            }
        }
    }
}
