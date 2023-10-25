package com.example.smdassignment2

import android.os.Bundle
import android.text.style.BackgroundColorSpan
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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smdassignment2.ui.theme.SMDAssignment2Theme
import kotlin.text.Typography.section

class weatherMenu : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SMDAssignment2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NewPageContent()
                }
            }
        }
    }
}
@Composable
private fun NewPageContent() {
    LazyColumn {
        item {
            // Top Section
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.padding(8.dp, 8.dp, 8.dp, 8.dp)
                ) {
                    Image(
                painter = painterResource(R.drawable.arrowleft),
                contentDescription = "Back Arrow",
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        // Handle back arrow click here
                    }
            )
                    Text(
                        text = "LOCATIONS",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Some Text Here",
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    // "Choose Place" button with light grey background
                    Button(
                        onClick = { /* Handle button click here */ },
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(Color.LightGray)
                    ) {
                        Text(text = "Choose Place")
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))


                // Right Subsection
                Box(
                    modifier = Modifier
                        .weight(1f) // Adjust the weight to control width
                        .background(Color.LightGray)
                        .height(220.dp), // Adjust the height as needed
                    contentAlignment = Alignment.Center
                ) {


                    Text(
                        text = "Add Place",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    )
                    Image(
                        painter = painterResource(R.drawable.arrowleft),
                        contentDescription = "Plus Icon",
                        modifier = Modifier
                            .size(24.dp)
                            .padding(8.dp)
                            .clickable {
                                // Handle plus icon click here
                            }
                    )
                }
            }
        }

        // List of Sections
        items(4) { sectionIndex ->
            section(sectionIndex)
        }
    }
}

@Composable
private fun section(sectionIndex: Int) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // City
        Text(text = "Mumbai", fontSize = 18.sp, fontWeight = FontWeight.Medium)

        // Humidity
        Text(text = "Humidity: 51%", fontSize = 18.sp, fontWeight = FontWeight.Medium)

        // 28, Sunny (right-aligned)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "28,Sunny",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.End,
                modifier = Modifier.weight(1f)
            )
        }

        // Add spacing between sections
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    SMDAssignment2Theme {
        NewPageContent()
    }
}