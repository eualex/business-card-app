package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                BusinessCardAppTheme {
                    Scaffold(
                        bottomBar = {
                            ContactSection()
                        }
                    ) { innerPadding ->
                        Main(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                                .background(color = MaterialTheme.colorScheme.primary)
                            ,
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ContactInfo(
    content: String,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = icon,
            contentDescription = content,
            tint = Color.White
        )
        Text(
            text = content,
            fontSize = 12.sp,
            modifier = Modifier
                .padding(start = 12.dp)
                .width(120.dp),
            color = Color.White

        )
    }
}

@Composable
fun ContactSection(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        ContactInfo(
            content = "+55 98 99999 9999",
            icon = Icons.Default.Call,
        )
        Spacer(modifier = Modifier.height(8.dp))
        ContactInfo(
            content = "@JhonDoe",
            icon = Icons.Default.Share,
        )
        Spacer(modifier = Modifier.height(8.dp))
        ContactInfo(
            content = "jhon@doe.com",
            icon = Icons.Default.Email,
        )
        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun Main(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .size(220.dp)
                .background(MaterialTheme.colorScheme.tertiary)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Jhon Doe",
            fontSize = 40.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Specialist Android developer",
            fontSize = 12.sp,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardAppTheme {
        Scaffold(
            bottomBar = {
                ContactSection()
            }
        ) { innerPadding ->
            Main(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(color = MaterialTheme.colorScheme.primary)
                ,
            )
        }
    }
}