package com.example.smdassignment2



import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.smdassignment2.ui.theme.SMDAssignment2Theme
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context

@Composable
fun WeatherApp() {
    val context = LocalContext.current // Use LocalContext to get the context
    WeatherBackground(
        imagePainter = painterResource(R.drawable.wetherbg),
        context = context
    )
}

@Composable
private fun WeatherBackground(
    imagePainter: Painter,
    context: Context,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        // Display the background image
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(0.7f),
        ) {
            Image(
                painter = imagePainter,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )
        }

        // Add a button at the bottom
        Button(
            onClick = {
                // Handle button click action
                val intent = Intent(context, weatherMenu::class.java)
                context.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Choose Place")
        }

        // Display the horizontal LazyRow for weather forecast
        WeatherForecast()
    }
}
@Composable
private fun WeatherForecast() {
//    val svgPainter: Painter = painterResource(id = R.drawable.cloud)

    val weatherData = listOf(
        WeatherDay("Mon", R.drawable.cloud, 25),
        WeatherDay("Tue", R.drawable.cloud, 22),
        WeatherDay("Wed", R.drawable.sun, 18),
        WeatherDay("Thu", R.drawable.cloud, 25),
        WeatherDay("Fri", R.drawable.sun, 22),
        WeatherDay("Sat", R.drawable.cloud, 18),
        WeatherDay("Sun", R.drawable.sun, 25),
//        WeatherDay("Tue", R.drawable.sun, 22),
//        WeatherDay("Wed", R.drawable.clouds, 18),
    )

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        content = {
            items(weatherData) { day ->
                WeatherCard(day)
            }
        }
    )
}

@Composable
private fun WeatherCard(day: WeatherDay) {
    Card(
        modifier = Modifier
            .width(120.dp)
            .height(120.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize() // Center content horizontally and vertically
                .padding(4.dp)
                .background(Color.White),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = day.day)
            Image(
                painter = painterResource(id = day.icon),
                contentDescription = null,
                modifier = Modifier.size(48.dp).padding(3.dp)
            )
            Text(text = "${day.temperature}°C")
        }
    }
}


data class WeatherDay(val day: String, val icon: Int, val temperature: Int)
