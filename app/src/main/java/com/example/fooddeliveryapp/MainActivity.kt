package com.example.fooddeliveryapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.fooddeliveryapp.data.OrderState
import com.example.fooddeliveryapp.ui.screen.ProductDetailScreen
import com.example.fooddeliveryapp.ui.theme.AppTheme


private const val PRODUCT_PRICE_PER_UNIT = 12.99
private const val PRODUCT_CURRENCY = "$"

class MainActivity : ComponentActivity() {

    companion object {
        fun newIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                var amount by remember { mutableIntStateOf(5) }
                val totalPrice by remember {
                    derivedStateOf {
                        amount * PRODUCT_PRICE_PER_UNIT
                    }
                }
                ProductDetailScreen(
                    onCheckOutClicked = {},
                    onAddItemClicked = {
                        amount = amount.inc()
                    },
                    onRemoveItemClicked = {
                        if (amount > 0) {
                            amount = amount.dec()
                        }
                    },
                    orderState = OrderState(
                        amount = amount,
                        totalPrice = "$PRODUCT_CURRENCY $totalPrice"
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductDetailScreen(){

}

