package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Declare my variables
        val editTextTime = findViewById<EditText>(R.id.editTextTime)
        val buttonSuggest = findViewById<Button>(R.id.buttonSuggest)
        val buttonReset = findViewById<Button>(R.id.buttonReset)
        val textViewSuggestion = findViewById<TextView>(R.id.textViewSuggestion)
        //Author: Zahra Bulbulia

        // Set an onClickListener for the "Suggest" button
        buttonSuggest.setOnClickListener {
            val timeOfDay = editTextTime.text.toString().trim()
            //Author: Zahra Bulbulia

            // Get the input time of day, trim any extra spaces, and convert to lowercase for consistency
            val suggestion = when (timeOfDay.lowercase()) {

                // Determine meal suggestion based on the time of day
                "morning" -> "Avocado & smoked salmon on sourdough toast."
                "mid-morning" -> "Greek yogurt with honey and granola."
                "afternoon" -> "Spicy beef burrito bowl."
                "mid-afternoon" -> "Matcha pancakes with maple syrup."
                "dinner" -> "Teriyaki glazed salmon with jasmine rice."
                else -> "Please enter a valid time of day." // Default message for invalid input
                //Author: Zahra Bulbulia


            }
            // Display the meal suggestion in the TextView
            textViewSuggestion.text = suggestion
            //Author: Zahra Bulbulia

        }
        // Set an onClickListener for the "Reset" button
        buttonReset.setOnClickListener {
            // Clear the input field
            editTextTime.text.clear()
            // Reset the suggestion display
            textViewSuggestion.text = ""
            //Author: Zahra Bulbulia

        }

    }
}
