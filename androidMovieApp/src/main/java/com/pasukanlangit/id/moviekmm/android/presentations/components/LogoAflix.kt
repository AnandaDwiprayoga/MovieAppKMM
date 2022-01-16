package com.pasukanlangit.id.moviekmm.android.presentations.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.pasukanlangit.id.moviekmm.android.R

@Composable
fun LogoAflix(
    modifier: Modifier
){
    Image(
        painterResource(id = R.drawable.logo_aflix),
        contentDescription = "logo aflix",
        modifier = modifier,
        contentScale = ContentScale.Fit
    )
}