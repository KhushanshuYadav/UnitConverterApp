package com.example.unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme

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


@Composable
fun UnitConverter() {
    Column (modifier= Modifier.fillMaxSize(),
        //below both helps to move child composable inside the parent
        verticalArrangement = Arrangement.Center,
        horizontalAlignment =Alignment.CenterHorizontally ){


        Text( text="UNIT CONVERTER");

        Spacer(modifier = Modifier.padding(16.dp)) //between above text and below box

        OutlinedTextField(value = "", onValueChange = {});

        Spacer(modifier = Modifier.height(16.dp))  //spacer with height

        Row {
            val context= LocalContext.current; //cannot  pass it directly
            /*Button(onClick = { Toast.makeText(context,"Button clicked", Toast.LENGTH_LONG).show() }) {
                Text(text = "Click")
                
            }*/

            Box{
                Button(onClick = { /*TODO*/ }) {
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown, "Drop down arrow")



                }

                DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(text = { Text(text = "Centimeter") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Meter") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Feet") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Millimeter") }, onClick = { /*TODO*/ })
                    
                }
            }

            Spacer(modifier = Modifier.width(16.dp)) //spacer with width

            Box{
                Button(onClick = { /*TODO*/ }) {
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown, "Drop down arrow")

                }

                DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(text = { Text(text = "Centimeter") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Meter") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Feet") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Millimeter") }, onClick = { /*TODO*/ })

                }

            }




        }



        Text("Result", modifier = Modifier.padding(16.dp))  //here we used padding instead of spacing


    }


}


@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverter();


}