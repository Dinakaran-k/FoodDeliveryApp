package com.example.fooddeliveryapp.ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.data.ProductPreviewState
import com.example.fooddeliveryapp.ui.theme.AppTheme

@Composable
fun ProductPreviewSection(
    modifier: Modifier = Modifier,
    state: ProductPreviewState
){
    Box(modifier=modifier.height(IntrinsicSize.Max)) {
        ProductBackground(
            modifier = Modifier.padding(bottom = 24.dp)
        )
        Content(
            state = state,
            modifier = Modifier
                .statusBarsPadding()
                .padding(top = 24.dp)
        )
    }
}

@Composable
fun ProductBackground(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(
                color = AppTheme.colors.background,
                shape = RoundedCornerShape(
                    bottomStart = 32.dp,
                    bottomEnd = 32.dp
                )
            ).fillMaxSize(),
    )
}


@Composable
fun Content(
    modifier: Modifier = Modifier,
    state: ProductPreviewState
) {
    ConstraintLayout(
        modifier = modifier.fillMaxWidth()
    ) {
        val (actionBar, highlights, productImg) = createRefs()

        ActionBar(
            headline = "Pizza",
            modifier=Modifier
                .padding(horizontal = 18.dp)
                .constrainAs(actionBar){
                top.linkTo(parent.top)
            }
        )

        Image(painter = painterResource(id = R.drawable.img_burger),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .height(256.dp)
                .constrainAs(productImg) {
                    end.linkTo(parent.end)
                    top.linkTo(anchor = actionBar.bottom, margin = 20.dp)
                }
        )

        ProductHighlights(
            highlights = state.highlights,
            modifier = Modifier.constrainAs(highlights){
                start.linkTo(
                    anchor = parent.start,
                    margin = 19.dp)
                top.linkTo(anchor = productImg.top)
            }
        )
    }
}

@Composable
fun ActionBar(
    modifier: Modifier = Modifier,
    headline : String,
){
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = headline,
            style = AppTheme.typography.headline,
            color = AppTheme.colors.onSecondarySurface
        )

        CloseButton()
    }
}

@Composable
fun CloseButton(
    modifier: Modifier = Modifier
){
    Surface(
        modifier = modifier.size(44.dp),
        shape = RoundedCornerShape(16.dp),
        color = AppTheme.colors.actionSurface,
        contentColor = AppTheme.colors.secondarySurface
    ) {
        Box(
            modifier =Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.close),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}