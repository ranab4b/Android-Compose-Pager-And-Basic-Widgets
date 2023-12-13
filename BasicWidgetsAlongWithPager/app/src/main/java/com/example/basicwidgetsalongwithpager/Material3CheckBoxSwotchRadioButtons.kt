package com.example.composepractice


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp

data class CheckBoxState(val isChecked: Boolean, val text: String)
@Composable
fun PresentCheckboxSwitchList(){

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        CheckBoxesList()
        Spacer(modifier = Modifier.height(16.dp))
        MyToggleButton()
        Spacer(modifier = Modifier.height(16.dp))
        RadioButtonsList()
    }
}

@Composable
fun CheckBoxesList() {
    val checkBoxes = remember {
        mutableStateListOf(
            CheckBoxState(false, "Photos"),
            CheckBoxState(false, "Videos"),
            CheckBoxState(false, "Audio"),
        )
    }

    
    var triState by remember { mutableStateOf(ToggleableState.Indeterminate) }

    val toggleTriState = {
        triState = when (triState) {
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }

        checkBoxes.indices.forEach { index ->
            checkBoxes[index] = checkBoxes[index].copy(isChecked = triState == ToggleableState.On)
        }
    }

    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable {
                toggleTriState()
            }
            .padding(end = 16.dp)) {
        TriStateCheckbox(state = triState, onClick =  toggleTriState )
        Text(text ="Select All")
    }
    
    checkBoxes.forEachIndexed { index, info ->
        Row(verticalAlignment = Alignment.CenterVertically,

        modifier = Modifier
            .padding(start = 32.dp)
            .clickable {
                checkBoxes[index] = info.copy(isChecked = !info.isChecked)
            }
            .padding(end = 16.dp)
        ) {
            Checkbox(checked = info.isChecked, onCheckedChange = {
                checkBoxes[index] = info.copy(isChecked = it)
            })
            Text(text = info.text)
        }
    }
}

@Composable
fun MyToggleButton(){
    var toggleState by remember { mutableStateOf(CheckBoxState(false, "Dark Mode Off")) }

    Row (verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable {
                toggleState = toggleState.copy(isChecked = !toggleState.isChecked)
            }
            .padding(end = 16.dp)) {
        Text(text = toggleState.text)
        Spacer(modifier = Modifier.weight(1f))
        Switch(checked = toggleState.isChecked, onCheckedChange = { isChecked ->
            toggleState = when(isChecked) {
                true -> toggleState.copy(isChecked = true, text = "Dark Mode On")
                false -> toggleState.copy(isChecked = false, text = "Dark Mode Off")
            }
        },
               thumbContent = {
                   Icon(
                       imageVector = if (toggleState.isChecked) {
                           Icons.Filled.Check
                       } else {
                           Icons.Filled.Close
                       }, contentDescription = null
                   )
               }
        )


    }
}

@Composable
fun RadioButtonsList() {
    val radioButtons = remember {
        mutableStateListOf(
            CheckBoxState(true, "Photos"),
            CheckBoxState(false, "Videos"),
            CheckBoxState(false, "Audio"),
        )
    }

    radioButtons.forEachIndexed { index, info ->
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable {
                    radioButtons.replaceAll { it.copy(isChecked = it.text == info.text) }
                }
                .padding(end = 16.dp)
        ) {
            RadioButton(selected = info.isChecked, onClick = {
                radioButtons.replaceAll { it.copy(isChecked = it.text == info.text) }
            })
            Text(text = info.text)
        }
    }
}