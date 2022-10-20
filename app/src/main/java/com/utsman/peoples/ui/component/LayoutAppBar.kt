package com.utsman.peoples.ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LayoutAppBar(
    title: String,
    onBack:( () -> Unit)? = null,
    content: @Composable PaddingValues.() -> Unit
) {
    Scaffold(
        topBar = {
            if (onBack == null) {
                TopAppBar(
                    title = {
                        Text(text = title)
                    }
                )
            } else {
                TopAppBar(
                    title = {
                        Text(text = title)
                    },
                    navigationIcon = {
                        IconButton(
                            modifier = Modifier,
                            onClick = onBack
                        ) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "back",
                            )
                        }
                    }
                )
            }
        },
        content = {
            content.invoke(it)
        }
    )
}