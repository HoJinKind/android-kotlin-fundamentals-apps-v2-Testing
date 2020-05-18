package com.example.twoactivities

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

import androidx.test.rule.ActivityTestRule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ActivityInputOutputTest {

    @get:Rule
    var activityTestRule = ActivityTestRule(MainActivity::class.java)


    @get:Rule
    var instantiateExecutorRule = InstantTaskExecutorRule()

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.twoactivities", appContext.packageName)
    }
    @Test
    fun activityLaunch() {
        onView(withId(R.id.button_main
        )).perform(click())
        onView(withId(R.id.text_header)).check(matches(isDisplayed()))

        // now do stuff on sendActivity
        onView(withId(R.id.button_second)).perform(click())
        onView(withId(R.id.text_header_reply)).check(matches(isDisplayed()))

    }

    @Test
    fun textInputOutput() {
        onView(withId(R.id.editText_main)).perform(typeText("enter stuff"))
        onView(withId(R.id.button_main)).perform(click())
        onView(withId(R.id.text_message)).check(matches(withText("enter stuff")))
    }

}
