package com.example.bmicalculator

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmicalculator.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val mContext = LocalContext.current

            var weight by remember {
                mutableStateOf("")
            }
            var ans_bmi by remember {
                mutableStateOf("")
            }
            var height by remember {
                mutableStateOf("")
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(DeepBlue))
            {
                Column {
                    GreetingSection()
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = "Weight",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 25.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 30.dp, bottom = 20.dp)
                    )
                    Row() {
                        TextField(
                            value = weight,
                            label = {
                                Text(text = "Weight", color = Color.White)
                            },
                            onValueChange = {
                                weight = it
                            },
                            textStyle = TextStyle(color = Color.White, fontSize = 21.sp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                            singleLine = true,
                            modifier = Modifier
                                .width(250.dp)
                                .padding(start = 30.dp),
                        )
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .width(100.dp)
                                .padding(start = 15.dp, top = 3.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(
                                    DarkerButtonBlue
                                )
                                .padding(15.dp)
                        ) {

                            Text(text = "Kg", color = Color.White)

                        }
                    }
                    Spacer(modifier = Modifier.height(60.dp))
                    Text(
                        text = "Height",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 25.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 30.dp, bottom = 20.dp)
                    )
                    Row() {
                        TextField(
                            value = height,
                            label = {
                                Text(text = "Height", color = Color.White)
                            },
                            onValueChange = {
                                height = it
                            },
                            textStyle = TextStyle(color = Color.White, fontSize = 21.sp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                            singleLine = true,
                            modifier = Modifier
                                .width(250.dp)
                                .padding(start = 30.dp),
                        )
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .width(100.dp)
                                .padding(start = 15.dp, top = 3.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(
                                    DarkerButtonBlue
                                )
                                .padding(15.dp)
                        ) {

                            Text(text = "Cm", color = Color.White)

                        }
                    }
                    Spacer(modifier = Modifier.height(60.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .fillMaxWidth(0.6f)
                                .height(60.dp)
                                .clip(RoundedCornerShape(30.dp))
                                .background(LightRed)
                                .padding(16.dp)
                                .clickable {
                                    val one = weight.toDouble()
                                    val two = height.toDouble()
                                    val m_two = two/100;
                                    val ans = one/Math.pow(m_two,2.0)
                                    val solution:Double = String.format("%.2f", ans).toDouble()
                                    ans_bmi = "Your BMI is "+solution.toString()+"."
                                }
                        ){
                            Text(
                                text = "Calculate" ,
                                fontSize = 21.sp ,
                                color = Color.White ,)
                        }
                        Spacer(modifier = Modifier.height(40.dp))
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                        ){
                            Text(
                                text = ans_bmi ,
                                fontSize = 22.sp ,
                                color = Color.White ,)
                        }

                    }
                }

            }

        }
    }
}

@Composable
fun GreetingSection() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "BMI Calculator",
                style = MaterialTheme.typography.h4,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "made by Amit Maity",
                style = MaterialTheme.typography.body1,
                color = Color.White ,
            )

        }
    }
}

private fun mToast(context: Context , name: String){
    Toast.makeText(context, "Ans $name", Toast.LENGTH_LONG).show()
}

