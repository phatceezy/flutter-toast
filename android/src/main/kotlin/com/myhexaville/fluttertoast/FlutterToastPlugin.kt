package com.myhexaville.fluttertoast

import android.widget.Toast
import android.widget.TextView
import android.view.View
import android.graphics.Color
import android.graphics.PorterDuff

import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.PluginRegistry.Registrar

class FlutterToastPlugin(val registrar: Registrar) : MethodCallHandler {
  companion object {
    @JvmStatic
    fun registerWith(registrar: Registrar): Unit {
      val channel = MethodChannel(registrar.messenger(), "flutter_toast")
      channel.setMethodCallHandler(FlutterToastPlugin(registrar))
    }
  }

  override fun onMethodCall(call: MethodCall, result: Result): Unit {
    if (call.method.equals("showToast")) {
      val message: String? = call.argument("message")
      val bgcolor: String? = call.argument("bgcolor")
      val textcolor: String? = call.argument("textcolor")
      
      val toast = Toast.makeText(registrar.context(), bgcolor.toString(), Toast.LENGTH_LONG) //message ?: "", Toast.LENGTH_LONG)
      val view = toast.view
      
      
      val text = view.findViewById(android.R.id.message) as TextView
      text.setTextColor(Color.parseColor(textcolor))
      view.background.setColorFilter(Color.parseColor(bgcolor), PorterDuff.Mode.SRC_IN)
      
      toast.show()
    } else {
      result.notImplemented()
    }
  }
}
