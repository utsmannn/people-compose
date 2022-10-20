package com.utsman.peoples.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.utsman.peoples.R
import com.utsman.peoples.data.datasources.PeopleDataSources
import com.utsman.peoples.navigation.LocalNavigationProvider
import com.utsman.peoples.ui.component.LayoutAppBar
import com.utsman.peoples.ui.component.ProfilePicture

@Composable
fun HomeScreen() {
    val navigationProvider = LocalNavigationProvider.current
    val context = LocalContext.current

    val peoples = rememberSaveable {
        PeopleDataSources().getPeoples()
    }

    LayoutAppBar(title = context.getString(R.string.app_name)) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(6.dp)
        ) {
            items(peoples) { people ->
                Row(
                    modifier = Modifier
                        .padding(3.dp)
                        .clickable {
                            navigationProvider.navigateToDetail(people)
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ProfilePicture(
                        modifier = Modifier.size(40.dp),
                        name = people.name
                    )
                    Text(
                        modifier = Modifier
                            .padding(6.dp)
                            .fillMaxWidth(),
                        text = people.name,
                    )
                }
            }
        }
    }
}