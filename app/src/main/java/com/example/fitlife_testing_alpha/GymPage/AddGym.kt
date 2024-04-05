package com.example.fitlife_testing_alpha.GymPage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.fitlife_testing_alpha.GymContents


@Composable
fun all(
    viewModel: GymViewModel =androidx.lifecycle.viewmodel.compose.viewModel()
){
    var showDialog by remember { mutableStateOf(false) }
    var Items by remember { mutableStateOf(listOf<GymContents>()) }
    var exName by remember { mutableStateOf("") }
    var sets by remember { mutableStateOf(0) }
    var reps by remember { mutableStateOf(0) }
    var lift by remember { mutableStateOf(0) }
    val upisEditing by viewModel.isEditing.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { showDialog = true },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Add Item")
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(Items) { item ->
                list(
                    item = item,
                    onEditClick = { viewModel.startEditing(item.id) },
                    onDeleteClick = { Items = Items.filter { it.id != item.id } },
                    viewModel = viewModel
                )
            }
        }

        if (upisEditing) {
            Items.find { it.id == viewModel.getId() }?.let {
                edit(
                    item = it,
                    onDismiss = {
                        viewModel.endEditing()
                    },
                    viewModel = viewModel
                )
            }
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(onClick = {
                        if (exName.isNotBlank()) {
                            val newItem = GymContents(
                                name = exName,
                                reps = reps,
                                sets = sets,
                                id = Items.size + 1,
                                lift = lift
                            )
                            Items = Items + newItem
                            showDialog = false
                            exName = ""
                            reps = 0
                            sets = 0
                            lift = 0
                        }

                    }) {
                        Text("Add")
                    }
                    Button(onClick = { showDialog = false }) {
                        Text("Cancel")
                    }
                }

            },
            text = {
                Column {
                    OutlinedTextField(
                        label = { Text("Exercise Name") },
                        value = exName,
                        onValueChange = { exName = it },
                        singleLine = true,
                    )

                    Row {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(15.dp)
                                .height(50.dp)
                        ) {
                            Button(
                                contentPadding = PaddingValues(),
                                modifier = Modifier
                                    .size(width = 35.dp, height = 35.dp)
                                    .defaultMinSize(minWidth = 1.dp, minHeight = 1.dp),
                                onClick = { sets-- },
                                enabled = sets > 0
                            ) {
                                Text(text = "-")
                            }
                            Text(text = "$sets", modifier = Modifier.padding(8.dp))
                            Button(
                                contentPadding = PaddingValues(),
                                onClick = { sets++ },
                                modifier = Modifier
                                    .size(width = 35.dp, height = 35.dp)
                                    .defaultMinSize(minWidth = 1.dp, minHeight = 1.dp),
                            ) {
                                Text(text = "+")
                            }
                        }
                        OutlinedTextField(
                            value = if (reps == 0) "" else reps.toString(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            onValueChange = { reps = it.toIntOrNull() ?: 0 },
                            label = { Text("Rep") },
                            singleLine = true,
                            modifier = Modifier
                                .padding(8.dp)
                                .width(60.dp)
                                .height(55.dp)

                        )
                        OutlinedTextField(
                            value = if (lift == 0) "" else lift.toString(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            onValueChange = { lift = it.toIntOrNull() ?: 0 },
                            label = { Text("Lift") },
                            singleLine = true,
                            modifier = Modifier
                                .padding(8.dp)
                                .width(80.dp)
                                .height(55.dp)

                        )

                    }
                }
            }

        )

    }
}

