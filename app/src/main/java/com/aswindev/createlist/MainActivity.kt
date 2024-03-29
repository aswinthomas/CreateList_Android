package com.aswindev.createlist

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aswindev.createlist.ui.theme.CreateListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CreateListTheme {

                var name by remember { mutableStateOf("") }
                var names by remember { mutableStateOf(listOf<String>()) }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    names = setTopRow(name, names)
                    SetNameList(names)
                }
            }
        }
    }

    @Composable
    private fun setTopRow(
        name: String,
        names: List<String>
    ): List<String> {
        var name1 = name
        var names1 = names
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = name1,
                onValueChange = { text ->
                    name1 = text
                },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = {
                if (name1.isNotBlank()) {
                    names1 = names1 + name1
                    Log.i("MyInfo", names1.toString())
                    name1 = ""
                }
            }) {
                Text(text = "Add")
            }
        }
        return names1
    }

    @Composable
    private fun SetNameList(names: List<String>) {
        LazyColumn {
            items(names) { currName ->
                Text(
                    text = currName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                Divider()
            }
        }
    }
}
