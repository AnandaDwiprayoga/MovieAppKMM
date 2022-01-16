package com.pasukanlangit.id.moviekmm.android.presentations.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.pasukanlangit.id.moviekmm.domain.model.GenericMessageInfo
import com.pasukanlangit.id.moviekmm.domain.model.UIComponentType
import com.pasukanlangit.id.moviekmm.domain.utils.Queue
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun PageScreen(
    isLoading: Boolean = false,
    errorQueue: Queue<GenericMessageInfo.Builder> = Queue(mutableListOf()),
    removeHeadFromQueue: () -> Unit,
    content: @Composable () -> Unit
){
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        errorQueue.peek()?.let { message ->
            if(message.uiComponentType == UIComponentType.DIALOG){
                GenericDialog(
                    genericMessageInfo = message.build(),
                    removeHeadQueue = removeHeadFromQueue
                )
            }else if(message.uiComponentType == UIComponentType.ALERT){
                coroutineScope.launch {
                    val toast = Toast.makeText(context, message.description, Toast.LENGTH_SHORT)
                    toast.show()
                    delay(toast.duration + 500L)
                    removeHeadFromQueue()
                }
            }
        }
        content()
        if(isLoading){
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}