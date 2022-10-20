package com.utsman.peoples

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToIndex
import androidx.compose.ui.test.printToLog
import com.utsman.peoples.ui.theme.PeoplesTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PeopleTest {

    @get:Rule
    val composeRoleTest = createComposeRule()

    private val mainList = "main-list"
    private val peopleNameTag = "Melva Nixon"
    private val otherPeopleNameTag = "Burke Barlow"
    private val otherPeopleNameIndex = 20

    @Before
    fun setup() {
        composeRoleTest.setContent {
            PeoplesTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MainApp()
                }
            }
        }
        composeRoleTest.onRoot()
            .printToLog("KEREN")
    }

    @Test
    fun showPeopleList() {
        composeRoleTest.run {
            onRoot().printToLog("TEST-1")
            onNodeWithTag(mainList).assertIsDisplayed()
        }
    }

    @Test
    fun navigateToPeople() {
        composeRoleTest.run {
            onRoot().printToLog("TEST-2")
            onNodeWithTag(peopleNameTag).assertIsDisplayed()
            onNodeWithTag(peopleNameTag).performClick()

            val navIconTag = "nav-icon-$peopleNameTag"
            onNodeWithTag(navIconTag).assertIsDisplayed()
        }
    }

    @Test
    fun navigatePeopleToBack() {
        composeRoleTest.run {
            onRoot().printToLog("TEST-3")
            onNodeWithTag(peopleNameTag).performClick()

            val navIconTag = "nav-icon-$peopleNameTag"
            onNodeWithTag(navIconTag).assertIsDisplayed()
            onNodeWithTag(navIconTag).performClick()

            onNodeWithTag(mainList).assertIsDisplayed()
            onNodeWithTag(mainList).performScrollToIndex(otherPeopleNameIndex -1)
            onNodeWithTag(otherPeopleNameTag).assertIsDisplayed()
        }
    }

    @Test
    fun checkIconProfileInDetail() {
        composeRoleTest.run {
            onRoot(useUnmergedTree = false).printToLog("TEST-4")
            onNodeWithTag(peopleNameTag).performClick()
            onNodeWithTag("icon-$peopleNameTag").assertIsDisplayed()
        }
    }
}