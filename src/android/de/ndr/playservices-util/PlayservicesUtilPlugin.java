/**
 */
package de.ndr.playservices-util;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;

import java.util.Date;

public class PlayservicesUtilPlugin extends CordovaPlugin {
  private static final String TAG = "MyCordovaPlugin";

  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

    Log.d(TAG, "Initializing MyCordovaPlugin");
  }

  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONExcepti
    if(action.equals("getPlayservicesVersion")) {
    final PluginResult result = new PluginResult(PluginResult.Status.OK, String.valueOf(this.getPlayservicesVersion()));
    callbackContext.sendPluginResult(result);
    } else if(action.equals("getDate")) {
    final PluginResult result = new PluginResult(PluginResult.Status.OK, String.valueOf(this.getWebviewVersion()));
    callbackContext.sendPluginResult(result);
    }
    return true;
  }

  private int getPlayservicesVersion() {
    return -1;
  }

  private int getWebviewVersion() {
    return -1;
  }

}
