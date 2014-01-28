package org.tritsch.scala.android.first

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText

object FirstActivity {
  val TAG = "FirstActivity"
  val EXTRA_MESSAGE = "MESSAGE"
}

class FirstActivity extends Activity {
  override def onCreate(savedInstanceState: Bundle): Unit = {
    Log.d(FirstActivity.TAG, "Enter - onCreate()")
    super.onCreate(savedInstanceState)
    setContentView(R.layout.first)
  }

  def sendMessage(v: View): Unit = {
    Log.d(FirstActivity.TAG, "Enter - sendMessage()")
    val intent = new Intent(this, classOf[DisplayMessageActivity])
    val editText = findViewById(R.id.edit_message).asInstanceOf[EditText]
    val message = editText.getText.toString
    intent.putExtra(FirstActivity.EXTRA_MESSAGE, message)
    startActivity(intent)
  }
}
