@file:OptIn(ExperimentalMaterial3Api::class)

package com.akashnavik.unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akashnavik.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitCovUI()
                }
            }
        }
    }
}

@Composable
fun NUM() {
    val res = remember {
        mutableStateOf( 0 )
    }
    val context = LocalContext.current
    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Result : ${res.value}")
        Button(onClick = {
            res.value +=1
            Toast.makeText(context,"One Added",Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Plus One")
        }
        Button(onClick = {
            res.value +=2
            Toast.makeText(context,"Two Added",Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Plus One")
        }
        Button(onClick = {
            res.value +=3
            Toast.makeText(context,"Three Added",Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Plus One")
        }
        Button(onClick = {
            res.value +=4
            Toast.makeText(context,"Four Added",Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Plus One")
        }
        Button(onClick = {
            res.value =0
            Toast.makeText(context,"Clear Selected",Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Clear But")
        }
    }
}

@Composable
fun Captiongame() {

    val t = remember {
        mutableStateOf(0)
    }
    val direction = remember {
        mutableStateOf("North")
    }
    val stormOrTres = remember {
        mutableStateOf("")
    }
    val storm = remember {
        mutableStateOf(0)
    }

    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Treasure Found: ${t.value}")
        Text(text = "Storm: ${storm.value}")
        Text(text = "Current Location : ${direction.value}")
        Text(text = "Storm or Tresure : ${stormOrTres.value}")
        Button(onClick = { direction.value ="East"
        if(Random.nextBoolean()){
            t.value +=1
            stormOrTres.value = "Treasure"
        }else{
            storm.value +=1
            stormOrTres.value = "Storm"
        }
        }) {
            Text(text = "Sail East")
        }
        Button(onClick = { direction.value ="West"
            if(Random.nextBoolean()){
                t.value +=1
                stormOrTres.value = "Treasure"
            }else{
                storm.value +=1
                stormOrTres.value = "Storm"
            }}) {
            Text(text = "Sail West")
        }
        Button(onClick = { direction.value ="South"
            if(Random.nextBoolean()){
                t.value +=1
                stormOrTres.value = "Treasure"
            }else{
                storm.value +=1
                stormOrTres.value = "Storm"
            }}) {
            Text(text = "Sail South")
        }
        Button(onClick = { direction.value ="North"
            if(Random.nextBoolean()){
                t.value +=1
                stormOrTres.value = "Treasure"
            }else{
                storm.value +=1
                stormOrTres.value = "Storm"
            }}) {
            Text(text = "Sail North")
        }

    }
    
}



@Composable
fun UnitCovUI() {

    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputSelected by remember { mutableStateOf("Meter") }
    var outputSelected by remember { mutableStateOf("Meter") }
    var iExpand by remember { mutableStateOf(false) }
    var oExpand by remember { mutableStateOf(false) }
    var conversionfactor = remember { mutableStateOf(1.00) }
    var oconversionfactor = remember { mutableStateOf(1.00) }
    val context = LocalContext.current


    fun Solution (){
        val ivD = inputValue.toDoubleOrNull() ?: 0.0
        val result  = (ivD * conversionfactor.value * 100.0/oconversionfactor.value).roundToInt()/100.0
        outputValue = result.toString()
    }


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Unit Converter",
            modifier = Modifier
                .fillMaxWidth()
            , textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value =inputValue,
            onValueChange ={
                inputValue =it
                Solution() },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number),
            label  = { Text(text = "Enter Value")

            }
        )

        Spacer(modifier = Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
            Box {
                Button(
                    onClick = { iExpand =true},
                ) {
                    Text(text = inputSelected, textAlign = TextAlign.Center)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                }
                DropdownMenu(expanded = iExpand, onDismissRequest = { iExpand = false}) {
                    DropdownMenuItem(text = { Text(text = "Centimeter") },
                        onClick = {
                            iExpand = false
                            inputSelected = "Centimeter"
                            conversionfactor.value = 0.01
                            Solution()
                            Toast.makeText(context,"Centimeter", Toast.LENGTH_SHORT).show() })
                    DropdownMenuItem(text = { Text(text = "Meter") },
                        onClick = {
                            iExpand = false
                            inputSelected = "Meter"
                            conversionfactor.value = 1.0
                            Solution()
                            Toast.makeText(context,"Meter", Toast.LENGTH_SHORT).show() })
                    DropdownMenuItem(text = { Text(text = "Feet") },
                        onClick = {
                            iExpand = false
                            inputSelected = "Feet"
                            conversionfactor.value = 0.3048
                            Solution()
                            Toast.makeText(context,"Feet", Toast.LENGTH_SHORT).show() })
                    DropdownMenuItem(text = { Text(text = "Millimeter") },
                        onClick = {
                            iExpand = false
                            inputSelected = "Millimetre"
                            conversionfactor.value = 0.001
                            Solution()
                            Toast.makeText(context,"Millimeter", Toast.LENGTH_SHORT).show() })
                }
            }
            Spacer(modifier = Modifier.width(20.dp))
            Box {
                Button(
                    onClick = { oExpand = true}
                ) {
                    Text(text = outputSelected, textAlign = TextAlign.Center)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                }
                DropdownMenu(expanded = oExpand, onDismissRequest = { oExpand =false }) {
                    DropdownMenuItem(text = { Text(text = "Cm") }, onClick = {
                        oExpand = false
                        outputSelected = "Centimeter"
                        oconversionfactor.value = 0.01
                        Solution()
                    })
                    DropdownMenuItem(text = { Text(text = "Meter") }, onClick = {
                        oExpand = false
                        outputSelected = "Meter"
                        oconversionfactor.value = 1.00
                        Solution()
                    })
                    DropdownMenuItem(text = { Text(text = "Feet") }, onClick = {
                        oExpand = false
                        outputSelected = "Feet"
                        oconversionfactor.value = 0.3048
                        Solution()

                    })
                    DropdownMenuItem(text = { Text(text = "Millimeter") }, onClick = {
                        oExpand = false
                        outputSelected = "Millimeter"
                        oconversionfactor.value = 0.001
                        Solution()
                    })
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Result : ${outputValue} ${outputSelected} " , fontSize = 16.sp, fontWeight = FontWeight.W600,)

    }
}