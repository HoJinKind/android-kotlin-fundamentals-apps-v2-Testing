package com.example.twoactivities

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_spinner.*


class SpinnerActivity : AppCompatActivity(),
AdapterView.OnItemSelectedListener  {
    private lateinit var spinner: Spinner
    private val TAG = SpinnerActivity::class.java.simpleName


    private lateinit var adapter:ArrayAdapter<CharSequence>
    private lateinit var editText: EditText
    private lateinit var textView: TextView
    private var mSpinnerLabel = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)
        spinner = label_spinner
        textView =  text_phonelabel
        editText = editText_spinner
        spinner.onItemSelectedListener = this
        adapter = ArrayAdapter.createFromResource(
            this, R.array.labels_array,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner.
        spinner.adapter = adapter


    }

    /**
     * Retrieves the text and spinner item and shows them in text_phonelabel.
     *
     * @param view  The view containing editText_main.
     */
    fun showText(view: View?) {
        if (editText != null) {
            // Assign to showString both the entered string and mSpinnerLabel.
            val showString = editText.text.toString() +
                    " - " + mSpinnerLabel
            // Display a Toast message with showString
            Toast.makeText(this, showString, Toast.LENGTH_SHORT).show()
            // Set the TextView to showString.
            textView.text = showString
        }
    }

    override fun onItemSelected(
        adapterView: AdapterView<*>,
        view: View?, i: Int, l: Long
    ) {
        mSpinnerLabel = adapterView.getItemAtPosition(i).toString()
        showText(view)
    }

    /**
     * Logs the fact that nothing was selected in the spinner.
     *
     * @param adapterView   The adapter for the spinner, where the selection
     * should have occurred.
     */
    override fun onNothingSelected(adapterView: AdapterView<*>?) {
        Log.d(TAG, "onNothingSelected: ")
    }
}