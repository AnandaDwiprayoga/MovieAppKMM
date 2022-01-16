package com.pasukanlangit.id.moviekmm.android.presentations.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.pasukanlangit.id.moviekmm.android.R

private val Roboto = FontFamily(
    Font(R.font.roboto_regular, FontWeight.W300),
    Font(R.font.roboto_medium, FontWeight.W600),
    Font(R.font.roboto_bold, FontWeight.W900)
)

val RobotoTypography = Typography(
    h1 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.W900,
        fontSize = 26.sp,
        color = Color.White
    ),
    h2 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.W600,
        fontSize = 16.sp,
        color = Color.White
    ),
    h3 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.W600,
        fontSize = 14.sp,
        color = Color.Gray
    ),
//    h3 = TextStyle(
//        fontFamily = QuickSand,
//        fontWeight = FontWeight.W500,
//        fontSize = 20.sp,
//    ),
//    h4 = TextStyle(
//        fontFamily = QuickSand,
//        fontWeight = FontWeight.W400,
//        fontSize = 18.sp,
//    ),
//    h5 = TextStyle(
//        fontFamily = QuickSand,
//        fontWeight = FontWeight.W400,
//        fontSize = 16.sp,
//    ),
//    h6 = TextStyle(
//        fontFamily = QuickSand,
//        fontWeight = FontWeight.W400,
//        fontSize = 14.sp,
//    ),
    subtitle1 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.W300,
        fontSize = 12.sp,
        color = GreyColor
    ),
    subtitle2 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.W300,
        fontSize = 10.sp,
        color = Color.White
    ),
    body1 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.W600,
        fontSize = 18.sp,
        color = Color.White
    ),
//    body2 = TextStyle(
//        fontFamily = QuickSand,
//        fontSize = 14.sp
//    ),
//    button = TextStyle(
//        fontFamily = QuickSand,
//        fontWeight = FontWeight.W400,
//        fontSize = 15.sp,
//        color = Color.White
//    ),
//    caption = TextStyle(
//        fontFamily = QuickSand,
//        fontWeight = FontWeight.Normal,
//        fontSize = 12.sp
//    ),
//    overline = TextStyle(
//        fontFamily = QuickSand,
//        fontWeight = FontWeight.W400,
//        fontSize = 12.sp
//    )
)