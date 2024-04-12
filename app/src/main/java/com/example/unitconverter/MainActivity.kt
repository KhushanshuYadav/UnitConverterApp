package com.example.unitconverter

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DismissValue
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)  //first run onCreate implementation  of parent class i.e ComponentActivity
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme

                //surface is the backGround of our application
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //content of surface or backGround
                    UnitConverter()

                }
            }
        }
    }
}




val custom= TextStyle(
    color=Color.Red ,
    fontSize = 32.sp,
    fontFamily =FontFamily.Cursive
)

@Composable
fun UnitConverter() {

    var inputValue by remember{ mutableStateOf("") }
    var outputValue by remember{ mutableStateOf("") }
    var inputUnit by remember{ mutableStateOf("Meter") } //by default taking it as centimeter
    var outputUnit by remember{ mutableStateOf("Meter") } //by default taking it as centimeter
    var iExp by remember{ mutableStateOf(false) }
    var oExp by remember{ mutableStateOf(false) }
    val iConversionFactor= remember { mutableStateOf(1.0) } //not taking as "by" as we do not want to modify its default value
    val oConversionFactor= remember { mutableStateOf(1.0) }

    fun convert(){
        val inputValueD=inputValue.toDoubleOrNull()?:0.0;  //elvis operator
        val result=(inputValueD*iConversionFactor.value*100.0/oConversionFactor.value).roundToInt()/100.0;
        outputValue=result.toString();

    }

    Column (
        modifier= Modifier.fillMaxSize(),
        //below both helps to move child composable inside the parent
        verticalArrangement = Arrangement.Center,
        horizontalAlignment =Alignment.CenterHorizontally
    ){


        Text( text="UNIT CONVERTER",style=MaterialTheme.typography.headlineLarge, color = Color.Green);

        Spacer(modifier = Modifier.padding(16.dp)) //between above text and below box

        OutlinedTextField(value = inputValue,
            onValueChange = {
            inputValue=it;
            convert()
        },
            label = {Text("Enter Value")},
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number )// Set keyboard type to numeric
        );

        Spacer(modifier = Modifier.height(16.dp))  //spacer with height

        Row {
            val context = LocalContext.current; //cannot  pass it directly

            /*Button(onClick = { Toast.makeText(context,"Button clicked", Toast.LENGTH_LONG).show() }) {
                Text(text = "Click")
                
            }*/
            
            //input box
            Box {
                Button(onClick = { iExp=true }, colors =ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black)) {
                    Text(inputUnit);
                    Icon(Icons.Default.ArrowDropDown, "Drop down arrow")
                }

                DropdownMenu(expanded = iExp, onDismissRequest = { iExp=false }) {
                    DropdownMenuItem(text = { Text(text = "Centimeter") }, onClick = {
                        iExp=false;
                        inputUnit="Centimeter";
                        iConversionFactor.value=0.01;  //cm to m
                        convert();
                    })
                    DropdownMenuItem(text = { Text(text = "Meter") }, onClick = {
                        iExp=false;
                        inputUnit="Meter";
                        iConversionFactor.value=1.0;  //cm to m
                        convert(); })
                    DropdownMenuItem(text = { Text(text = "Feet") }, onClick = {
                        iExp=false;
                        inputUnit="Feet";
                        iConversionFactor.value=0.3048;  //cm to m
                        convert();
                    })
                    DropdownMenuItem(text = { Text(text = "Millimeter") }, onClick = {
                        iExp=false;
                        inputUnit="Millimeter";
                        iConversionFactor.value=0.001;  //cm to m
                        convert();
                    })

                }
            }

            Spacer(modifier = Modifier.width(16.dp)) //spacer with width

            //output box
            Box {
                Button(onClick = { oExp=true }) {
                    Text(outputUnit)
                    Icon(Icons.Default.ArrowDropDown, "Drop down arrow")

                }

                DropdownMenu(expanded = oExp, onDismissRequest = { oExp=false }) {
                    DropdownMenuItem(text = { Text(text = "Centimeter") }, onClick = {
                        oExp=false;
                        outputUnit="Centimeter";
                        oConversionFactor.value=0.01;
                        convert();
                    })
                    DropdownMenuItem(text = { Text(text = "Meter") }, onClick = {
                        oExp=false;
                        outputUnit="Meter";
                        oConversionFactor.value=1.00;
                        convert();
                    })
                    DropdownMenuItem(text = { Text(text = "Feet") }, onClick = {
                        oExp=false;
                        outputUnit="Feet";
                        oConversionFactor.value=0.3048;
                        convert(); })
                    DropdownMenuItem(text = { Text(text = "Millimeter") }, onClick = {
                        oExp=false;
                        outputUnit="Millimeter";
                        oConversionFactor.value=0.001;
                        convert();
                    })

                }

            }

        }

        Text("Result : ${outputValue} ${outputUnit}", modifier = Modifier.padding(16.dp), style = custom)  //here we used padding instead of spacing


    }


}


@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverter();


}