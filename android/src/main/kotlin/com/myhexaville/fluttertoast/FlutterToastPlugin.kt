package com.myhexaville.fluttertoast

import android.widget.Toast
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
      Toast toast = Toast.makeText(registrar.context(), message ?: "", Toast.LENGTH_LONG);
      View view = toast.getView();
view.setBackgroundResource(R.drawable.custom_background);
TextView text = (TextView) view.findViewById(android.R.id.message);
      text.setTextColor(Color.parseColor("#FF0000"));
      toast.show();
    } else {
      result.notImplemented()
    }
  }
}
