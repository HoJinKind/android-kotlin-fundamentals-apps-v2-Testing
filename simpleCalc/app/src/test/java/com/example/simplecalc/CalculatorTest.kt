package com.example.simplecalc

import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule

import org.hamcrest.CoreMatchers.*
import org.junit.Before
import org.junit.runner.RunWith

class CalculatorTest {

    private lateinit var calculator: Calculator

    @Before
    fun createCalculator() {
        calculator= Calculator()
    }
    @Test
    fun addTwoNumbers() {
        val value = calculator.add(1.0,2.0)
        assertThat(value, `is`(3.0))
    }

    @Test
    fun addTwoNumberNegative() {

        val value = calculator.add(-1.0,-2.0)
        assertThat(value, `is`(-3.0))
    }
    @Test
    fun addTwoNumbersFloats() {

        val value = calculator.add(-1.111,-1.111)
        assertThat(value, `is`(-2.222))
    }
    @Test
    fun subTwoNumbers() {
        val value = calculator.sub(1.0,1.0)
        assertThat(value, `is`(0.0))
    }


    @Test
    fun subWorksWithNegativeNumbers() {
        val value = calculator.sub(1.0,17.0)
        assertThat(value, `is`(-16.0))
    }

    @Test
    fun mulTwoNumbers() {
        val value = calculator.sub(2.0,5.0)
        assertThat(value, `is`(10.0))
    }

    @Test
    fun divTwoNumbers() {
        val value = calculator.div(32.0,2.0)
        assertThat(value, `is`(16.0))
    }

    @Test
    fun divTwoNumbersZero() {
        val value = calculator.div(32.0,0.0)
        assertThat(value, `is`(Double.POSITIVE_INFINITY))
    }
}