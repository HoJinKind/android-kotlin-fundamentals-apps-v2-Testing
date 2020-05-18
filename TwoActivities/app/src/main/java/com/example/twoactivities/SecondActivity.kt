package com.example.twoactivities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*


class SecondActivity : AppCompatActivity() {

    // Unique tag for the intent reply.

    companion object {
        var EXTRA_REPLY: String = "com.example.android.twoactivities.extra.REPLY"
    }

    private lateinit var mReply: EditText
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)
        mReply = editText_second
        textView = text_message
        val intent = getIntent()
        var message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
        textView.setText(message)
    }

    fun returnReply(view: View?) {
        // Get the reply message from the edit text.

        // Get the reply message from the edit text.
        val reply = mReply.text.toString()

        // Create a new intent for the reply, add the reply message to it
        // as an extra, set the intent result, and close the activity.

        // Create a new intent for the reply, add the reply message to it
        // as an extra, set the intent result, and close the activity.
        val replyIntent = Intent()
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(Activity.RESULT_OK, replyIntent)
        finish()

    }

}