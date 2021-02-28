package com.hb.rickandmortyapollo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.hb.rickandmortyapollo.presentation.characters.CharactersActivity
import com.schibsted.spain.barista.assertion.BaristaImageViewAssertions.assertHasDrawable
import com.schibsted.spain.barista.assertion.BaristaListAssertions.assertDisplayedAtPosition
import com.schibsted.spain.barista.interaction.BaristaListInteractions
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep

@RunWith(AndroidJUnit4ClassRunner::class)
class CharactersActivityTests {

    @get:Rule
    val activityRule = ActivityScenarioRule(CharactersActivity::class.java)

    @Test
    fun verifyViews() {
        assertHasDrawable(R.id.img_background, R.drawable.rick_morty_wallpaper)
    }

    @Test
    fun testViewsVisibility() {
        onView(withId(R.id.rv_rick_and_morty)).check(matches(isDisplayed()))
    }

    @Test
    fun testListListenerAndRecyclerView() {
        sleep(4000)
        assertDisplayedAtPosition(R.id.rv_rick_and_morty, 0, R.id.tv_character, "Rick Sanchez")
        BaristaListInteractions.clickListItem(R.id.rv_rick_and_morty, 0)
    }
}