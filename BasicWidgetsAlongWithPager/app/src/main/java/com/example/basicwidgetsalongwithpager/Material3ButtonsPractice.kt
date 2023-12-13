package com.example.composepractice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PresentButtonsList(){

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
        // Filled buttons
        Button( onClick = { /*TODO*/ }) {
            Text(text = "Subscribe")
        }
        Spacer(modifier = Modifier.height(16.dp))
        // Elevated buttons
        ElevatedButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Outlined.Add, contentDescription = "add to cart",
                 modifier = Modifier.padding(end = 16.dp))
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "Add to list")
        }
        Spacer(modifier = Modifier.height(16.dp))
        FilledTonalButton(onClick = { /*TODO*/ }) {
            Text(text = "open in browser")
        }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Cancel")
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Learn More")
        }
    }
}