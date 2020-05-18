package com.example.twoactivities

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.containsString
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class SpinnerSelectionTest {

    @get:Rule
    var activityTestRule = ActivityTestRule(SpinnerActivity::class.java)


    @get:Rule
    var instantiateExecutorRule = InstantTaskExecutorRule()

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.twoactivities", appContext.packageName)
    }

    @Test
    fun iterateSpinnerTest() {
        val myArray = activityTestRule.activity.resources.getStringArray(R.array.labels_array)
        val size = myArray.size
        for (i in myArray.indices) {
            onView(withId(R.id.label_spinner)).perform(click())

            onData(`is`(myArray[i])).perform(click())
            onView(withId(R.id.text_phonelabel)).check(matches(withText(containsString(myArray[i]))))
        }
    }
}
