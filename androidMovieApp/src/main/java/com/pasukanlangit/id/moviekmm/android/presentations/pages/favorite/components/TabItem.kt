package com.pasukanlangit.id.moviekmm.android.presentations.pages.favorite.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pasukanlangit.id.moviekmm.android.presentations.theme.GreyColor

@Composable
fun TabItem(
    label: String,
    isSelected: Boolean
){
    Text(
        text = label,
        color = if(isSelected) Color.White else GreyColor,
        textAlign = TextAlign.Center,
        fontSize = 14.sp,
        fontWeight = if(isSelected) FontWeight.W900 else FontWeight.W600,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = if (isSelected) MaterialTheme.colors.secondary else MaterialTheme.colors.primaryVariant)
            .padding(8.dp),
    )
}