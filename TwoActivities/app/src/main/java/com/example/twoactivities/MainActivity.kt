package com.example.twoactivities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    // Class name for Log tag
    private val LOG_TAG = MainActivity::class.java.simpleName

    companion object {

        // Unique tag required for the intent extra
        val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"
    }

    // Unique tag for the intent reply
    val TEXT_REQUEST = 1

    // EditText view for the message
    private lateinit var mMessageEditText: EditText

    // TextView for the reply header
    private lateinit var mReplyHeadTextView: TextView

    // TextView for the reply body
    private lateinit var mReplyTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mMessageEditText = editText_main
        mReplyHeadTextView = text_header_reply
        mReplyTextView = text_message_reply

    }
    fun launchSecondActivity(view: View?) {
        Log.d(LOG_TAG, "Button clicked!")
        val intent = Intent(this, SecondActivity::class.java)
        val message = mMessageEditText.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivityForResult(intent, TEXT_REQUEST)
    }

    fun toSpinnerActivity(view: View?) {

        Log.d(LOG_TAG, "Button clicked!")
        val intent = Intent(this, SpinnerActivity::class.java)
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Test for the right intent reply.
        if (requestCode == TEXT_REQUEST) {
            // Test to make sure the intent reply result was good.
            if (resultCode == Activity.RESULT_OK) {
                val reply = data!!.getStringExtra(SecondActivity.EXTRA_REPLY)

                // Make the reply head visible.
                mReplyHeadTextView.visibility = View.VISIBLE

                // Set the reply and make it visible.
                mReplyTextView.text = reply
                mReplyTextView.visibility = View.VISIBLE
            }
        }
    }

}
