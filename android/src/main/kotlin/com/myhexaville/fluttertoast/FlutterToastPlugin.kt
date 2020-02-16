package com.myhexaville.fluttertoast

import android.widget.Toast
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.PluginRegistry.Registrar
import android.view.View
import android.graphics.Color
import android.graphics.PorterDuff

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
      val bgcolor: Long? = call.argument("bgcolor")
      print("Kotlin")
      print(bgcolor.toString())
      print("end Kotlin")
      val toast = Toast.makeText(registrar.context(), bgcolor.toString(), Toast.LENGTH_LONG) //message ?: "", Toast.LENGTH_LONG)
      val view = toast.view
      view.background.setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN)
      toast.show()
    } else {
      result.notImplemented()
    }
  }
}
