package com.utsman.peoples.ui.screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.utsman.peoples.R
import com.utsman.peoples.data.datasources.PeopleDataSources
import com.utsman.peoples.data.model.People
import com.utsman.peoples.navigation.LocalNavigationProvider
import com.utsman.peoples.navigation.NavigationProvider
import com.utsman.peoples.ui.component.LayoutAppBar
import com.utsman.peoples.ui.component.ProfilePicture

@Composable
fun HomeScreen() {
    val navigationProvider = LocalNavigationProvider.current
    val context = LocalContext.current

    val peoples = remember {
        val dataSources = PeopleDataSources()
        dataSources.getPeoples()
    }

    var clickPosition by remember {
        mutableStateOf(0)
    }

    val isBottomClicked by remember {
        derivedStateOf { clickPosition == peoples.size - 1 }
    }

    if (isBottomClicked) {
        LaunchedEffect(Unit) {
            Toast.makeText(context, "is bottom", Toast.LENGTH_SHORT).show()
        }
    }

    LayoutAppBar(title = stringResource(R.string.app_name)) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(6.dp)
        ) {
            itemsIndexed(peoples, key = { _, people ->
                people.id
            }) { index, people ->
                ItemPeopleScreen(people = people) {
                    clickPosition = index
                    navigationProvider.navigateToDetail(people)
                }
            }
        }
    }
}

@Composable
fun ItemPeopleScreen(
    people: People,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(3.dp)
            .clickable(onClickLabel = stringResource(R.string.desc_nav_to_detail)) {
                onClick.invoke()
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