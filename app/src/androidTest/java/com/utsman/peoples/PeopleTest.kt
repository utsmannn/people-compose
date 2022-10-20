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
    private val contactNameTag = "Melva Nixon"
    private val otherContactNameTag = "Burke Barlow"
    private val otherContactNameIndex = 20

    @Before
    fun setup() {
        composeRoleTest.setContent {
            PeoplesTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MainApp()
                }
            }
        }

        composeRoleTest.onRoot().printToLog("KEREN")
    }

    @Test
    fun showContactList() {
        composeRoleTest.run {
            onRoot().printToLog("TEST-1")
            onNodeWithTag(contactNameTag).assertIsDisplayed()
        }
    }

    @Test
    fun navigateToContact() {
        composeRoleTest.run {
            onRoot().printToLog("TEST-2")
            onNodeWithTag(contactNameTag).assertIsDisplayed()
            onNodeWithTag(contactNameTag).performClick()

            val navIconTag = "nav-icon-$contactNameTag"
            onNodeWithTag(navIconTag).assertIsDisplayed()
        }
    }

    @Test
    fun navigateContactToBack() {
        composeRoleTest.run {
            onRoot().printToLog("TEST-3")
            onNodeWithTag(contactNameTag).performClick()

            val navIconTag = "nav-icon-$contactNameTag"
            onNodeWithTag(navIconTag).assertIsDisplayed()
            onNodeWithTag(navIconTag).performClick()

            onNodeWithTag(mainList).assertIsDisplayed()
            onNodeWithTag(mainList).performScrollToIndex(otherContactNameIndex -1)
            onNodeWithTag(otherContactNameTag).assertIsDisplayed()
        }
    }

    @Test
    fun checkIconProfileInDetail() {
        composeRoleTest.run {
            onRoot(useUnmergedTree = false).printToLog("TEST-4")
            onNodeWithTag(contactNameTag).performClick()
            onNodeWithTag("icon-$contactNameTag").assertIsDisplayed()
        }
    }
}