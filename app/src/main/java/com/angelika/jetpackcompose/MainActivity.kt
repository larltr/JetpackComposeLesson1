package com.angelika.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.angelika.jetpackcompose.ui.theme.Green
import com.angelika.jetpackcompose.ui.theme.Grey
import com.angelika.jetpackcompose.ui.theme.JetpackComposeTheme
import com.angelika.jetpackcompose.ui.theme.Rubik

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BoxContainer()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BoxContainer(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Text(
            modifier = with(Modifier) { padding(top = 16.dp, start = 16.dp) },
            text = stringResource(R.string.text_new_entry),
            fontSize = 34.sp,
            color = Color.Black,
            fontFamily = Rubik,
            fontWeight = FontWeight.Bold
        )
        Icon(
            modifier = Modifier
                .padding(top = 68.dp, start = 16.dp)
                .width(32.dp)
                .height(32.dp),
            painter = painterResource(id = R.drawable.ic_close),
            contentDescription = stringResource(id = R.string.icon_cancel)
        )
        Icon(
            modifier = Modifier
                .padding(top = 68.dp, end = 16.dp)
                .width(32.dp)
                .height(32.dp)
                .align(Alignment.TopEnd),
            painter = painterResource(id = R.drawable.ic_ready),
            contentDescription = stringResource(id = R.string.icon_ready)
        )

        val text = remember {
            mutableStateOf("")
        }
        OutlinedTextField(modifier = Modifier
            .padding(top = 120.dp, start = 16.dp, end = 16.dp)
            .height(54.dp)
            .fillMaxWidth()
            .border(
                border = BorderStroke(2.dp, Color.Black),
                shape = RoundedCornerShape(6.dp)
            ),
            value = text.value,
            placeholder = {
                Text(
                    text = stringResource(R.string.text_enter_entry),
                    fontFamily = Rubik,
                    fontWeight = FontWeight.Light,
                    color = Color(Grey.value),
                    fontSize = 18.sp
                )
            },
            onValueChange = {
                text.value = it
            })

        Button(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
                .height(54.dp)
                .fillMaxWidth()
                .shadow(6.dp, shape = RoundedCornerShape(10.dp)),
            onClick = { },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(Green.value)),
        ) {
            Text(
                text = stringResource(R.string.text_save),
                fontFamily = Rubik,
                fontWeight = FontWeight.Light,
                color = Color.Black,
                fontSize = 20.sp
            )
        }
    }
}

@Preview
@Composable
fun PreviewBoxContainer() {
    BoxContainer(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    )
}