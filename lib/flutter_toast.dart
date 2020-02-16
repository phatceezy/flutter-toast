import 'package:flutter/services.dart';

class FlutterToast {
  static const MethodChannel _channel = MethodChannel('flutter_toast');

  static showToast(String message, String bgcolor, String textcolor) {
    _channel.invokeMethod("showToast", {"message": message, "bgcolor": bgcolor, "textcolor": textcolor});
  }
}
