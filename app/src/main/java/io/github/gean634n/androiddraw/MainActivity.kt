package io.github.gean634n.androiddraw

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import io.github.gean634n.androiddraw.ui.theme.AndroidDrawTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidDrawTheme {
                DrawingScreen()
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DrawingScreen() {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            DrawingView(context, null)
        }
    )
}