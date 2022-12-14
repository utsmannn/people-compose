package com.utsman.peoples.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.utsman.peoples.data.model.People
import com.utsman.peoples.navigation.LocalNavigationProvider
import com.utsman.peoples.ui.component.LayoutAppBar
import com.utsman.peoples.ui.component.ProfilePicture

@Composable
fun DetailScreen(people: People) {
    val navigationProvider = LocalNavigationProvider.current

    LayoutAppBar(
        title = people.name,
        onBack = {
            navigationProvider.back()
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row {
                ProfilePicture(
                    modifier = Modifier
                        .size(100.dp),
                    name = people.name
                )
            }
            Divider(modifier = Modifier.padding(horizontal = 20.dp, vertical = 30.dp))
            Text(text = people.name, fontWeight = FontWeight.Bold)
            Text(text = people.email)
            Text(text = people.phone)
        }
    }
}