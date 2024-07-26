package com.example.starbucksui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.starbucksui.data.navigation.Navigation
import com.example.starbucksui.ui.theme.StarBucksUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StarBucksUITheme {
                Navigation()
            }
        }
    }
}



//@Composable
//fun LaunchedEffectWithKeyExample() {
//    var count by remember { mutableStateOf(0) }
//    var key by remember { mutableStateOf("initial") }
//
//    // This LaunchedEffect will run whenever `key` changes
//    LaunchedEffect(key) {
//        // Simulate a long-running task
//        delay(1000L)
//        count++
//    }
//
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(text = "Count: $count")
//        Spacer(modifier = Modifier.height(16.dp))
//        Button(onClick = { key = "key1" }) {
//            Text(text = "Change Key to key1")
//        }
//        Spacer(modifier = Modifier.height(16.dp))
//        Button(onClick = { key = "key2" }) {
//            Text(text = "Change Key to key2")
//        }
//    }
//}
