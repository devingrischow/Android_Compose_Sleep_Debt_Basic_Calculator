package com.example.compose_sleep_debt_basic_calculator

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_sleep_debt_basic_calculator.ui.theme.Compose_Sleep_Debt_Basic_CalculatorTheme
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose_Sleep_Debt_Basic_CalculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->


                    MainView(innerPadding)


                }
            }
        }
    }
}


val sleepControlTag = "SLEEP_HOUR_CONTROLS"



//STARTING FUNCTION
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    //Gets the current screen zones space
    val configuration = LocalConfiguration.current

    //from the phones config, get the screens height + width in dp
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp










    //Input text to use
    //Remember is ussed to remember the value of the variable in betweeen recompositions,
    //the state of this is remembered throughout the state changes
    // https://developer.android.com/develop/ui/compose/text/user-input



    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally





    ) {

        //First 2 Text Fields Are for the first 2 days to calculate


    }//Bottom Of Collumn

}






@Composable
fun MainView(innerPadding:PaddingValues){
    //Days of the weekday hour variables
    var day1Hours by remember { mutableStateOf<String>("") }
    var day2Hours by remember { mutableStateOf<String>("") }
    var day3Hours by remember { mutableStateOf<String>("") }
    var day4Hours by remember { mutableStateOf<String>("") }
    var day5Hours by remember { mutableStateOf<String>("") }
    var day6Hours by remember { mutableStateOf<String>("") }
    var day7Hours by remember { mutableStateOf<String>("") }



    var daysBeingCalculated: MutableState<Int> = remember { mutableStateOf(2)}

    var hasCalculatedSleepDebt:MutableState<Boolean> = remember { mutableStateOf(false) }



    //A Users optimal sleep hours time
    var optimalSleepHourAmount by remember {
        mutableStateOf<String>("")
    }

    //Sleep debt amount that was calculated
    var calculatedSleepDebt:MutableState<String> = remember { mutableStateOf("")}


    //Variable checks for adding new varriables or not

    ///Context of local (for toast message)
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        //Android studio makes this much more readable, continue this format
        Text(text = "How many Hours Did you sleep on Each Day?",
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )


        //break the text fields into 2 SEPERATE nice rows for even text distribution
        //Text Field for inputting user data
        Row {
            TextField(value = day1Hours,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = { day1Hours = it },
                modifier = Modifier
                    .padding(8.dp)
                    .height(60.dp)
                    .width(75.dp),

                label = { Text("Day 1") })

            TextField(value = day2Hours,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = { day2Hours = it },
                modifier = Modifier
                    .padding(8.dp)
                    .height(60.dp)
                    .width(75.dp),


                label = { Text("Day 2") })


            if (daysBeingCalculated.value >= 3) {
                TextField(value = day3Hours,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    onValueChange = { day3Hours = it },
                    modifier = Modifier
                        .padding(8.dp)
                        .height(60.dp)
                        .width(75.dp),

                    label = { Text("Day 3") })
            }

            if (daysBeingCalculated.value >= 4) {
                TextField(value = day4Hours,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    onValueChange = { day4Hours = it },
                    modifier = Modifier
                        .padding(8.dp)
                        .height(60.dp)
                        .width(75.dp),

                    label = { Text("Day 4") })
            }
        }

        Row(modifier = Modifier
            .padding(5.dp) //Padding to seperate the 2 rows out a little more
        ) {
            if (daysBeingCalculated.value >= 5) {
                TextField(value = day5Hours,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    onValueChange = { day5Hours = it },
                    modifier = Modifier
                        .padding(9.dp)
                        .height(60.dp)
                        .width(75.dp),

                    label = { Text("Day 5") })
            }

            if (daysBeingCalculated.value >= 6) {
                TextField(value = day6Hours,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    onValueChange = { day6Hours = it },
                    modifier = Modifier
                        .padding(9.dp)
                        .height(60.dp)
                        .width(75.dp),

                    label = { Text("Day 6") })
            }

            if (daysBeingCalculated.value >= 7) {
                TextField(value = day7Hours,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    onValueChange = { day7Hours = it },
                    modifier = Modifier
                        .padding(9.dp)
                        .height(60.dp)
                        .width(75.dp),

                    label = { Text("Day 7") })
            }
        }




        //2 Buttons, 1 for Adding Another day, and another for removing the LAST day
        Row {
            Button(modifier = Modifier
                .padding(5.dp)
                ,onClick = {
                Log.d(sleepControlTag, "INCREMENT")
                if (daysBeingCalculated.value != 7){
                    daysBeingCalculated.value++
                }else{
                    //Above days of the week count, so dont track any more any let the user know they are above the limit
                    Toast.makeText(context, "You cant Add more than 7 Days", Toast.LENGTH_SHORT).show()
                }
            }) {
                Text("Add Another Day")
                //Bottom Of Button
            }

            Button(modifier = Modifier
                .padding(5.dp),
                onClick = {
                if (daysBeingCalculated.value != 2){
                    daysBeingCalculated.value--
                }else{
                    //Above days of the week count, so dont track any more any let the user know they are above the limit
                    Toast.makeText(context, "You cant Remove Less than 2 Days", Toast.LENGTH_SHORT).show()
                }


            }) {
                Text("Remove A Day")
                //Bottom Of Button
            }


        }//Bottom of Row

        //Text Entry for users optimal Sleep Hours
        TextField(value = optimalSleepHourAmount,

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = {optimalSleepHourAmount = it} ,
            modifier = Modifier
                .padding(20.dp),

            label = { Text("How many hours of sleep is the optimal amount for you?",
                textAlign = TextAlign.Center)}
        )

        //Button to calculate sleep debt
        Button(
            onClick = {

                Log.d("CALC SLEEP DEBT", "CALCULATING SLEEP DEBT, SWITCHING VARIABLE")

                //Calculate the users given sleep debt
                val calcSleepDebtValue = calculateSleepDebt(day1Hours, day2Hours, day3Hours, day4Hours, day5Hours, day6Hours, day7Hours, optimalSleepHourAmount.toDouble(), daysBeingCalculated.value)


                //set the calculated sleep debt display variable
                calculatedSleepDebt.value = calcSleepDebtValue.toString()


                hasCalculatedSleepDebt.value = true
        }) {
            Text("Calculate Sleep Debt!")
            //Bottom Of Button
        }

        //when calculated sleep debt is true, present a text view with the days sleep debt
        if (hasCalculatedSleepDebt.value){
            //Show the text box
            Text("You have a total sleep debt of ${calculatedSleepDebt.value}",
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(20.dp),
                fontSize = 20.sp
            )
        }






    }
}

//A function to calculate a persons sleep debt
fun calculateSleepDebt(day1Hours:String,
                       day2Hours:String,
                       day3Hours:String,
                       day4Hours:String,
                       day5Hours:String,
                       day6Hours:String,
                       day7Hours:String,
                       optimalSleep:Double,
                       toCalculateCount:Int): Double{


    //Total amount calculated during function run
    var totalSleepCombined:Double = 0.0

    //Put all the amounts into a array
    var toCalculateDays = arrayOf<String>(day1Hours, day2Hours, day3Hours, day4Hours, day5Hours, day6Hours, day7Hours)


    for (i in 0..<6){


        if (i < toCalculateCount) {
            totalSleepCombined += toCalculateDays[i].toDouble()
        }
    }
    //Take the users optimal sleep and multiply by the amount of days being calculated
    var step3Calculation = optimalSleep * toCalculateCount

    //sleep debt is calculated by taking the total sleep combined - the previous calculation
    var calculatedSleepDebt = totalSleepCombined - step3Calculation


    return calculatedSleepDebt


}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose_Sleep_Debt_Basic_CalculatorTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

            MainView(innerPadding)
        }
    }
}