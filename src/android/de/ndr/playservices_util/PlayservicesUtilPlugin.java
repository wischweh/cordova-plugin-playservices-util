/**
 */
package de.ndr.playservices_util;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.pm.PackageManager;
import android.util.Log;

import com.google.android.gms.common.GoogleApiAvailability;

public class PlayservicesUtilPlugin extends CordovaPlugin {

    private static final String TAG = "PlayservicesUtilPlugin";

    private static final String PACKAGE_WEBVIEW="com.google.android.webview";


  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

    Log.d(TAG, "Initializing PlayservicesUtilPlugin");
  }

  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    if(action.equals("getPlayservicesVersionName")) {
        resolvePackageVersionName(GoogleApiAvailability.GOOGLE_PLAY_SERVICES_PACKAGE,callbackContext);
    } else if(action.equals("getWebviewVersionName")) {
        resolvePackageVersionName(PACKAGE_WEBVIEW,callbackContext);
    } else {
        final PluginResult result = new PluginResult(PluginResult.Status.INVALID_ACTION,"action unknown: "+action);
        Log.e(TAG,"plugin error: invalid action");
        callbackContext.sendPluginResult(result);

    }
    return true;
  }


  private void resolvePackageVersionName(final String packageName, final CallbackContext callbackContext) {
      cordova.getThreadPool().execute(new Runnable() {
          @Override
          public void run() {
              try {
                  String versionName=cordova.getActivity().getPackageManager().getPackageInfo(packageName,0).versionName;
                  int versionNumber=cordova.getActivity().getPackageManager().getPackageInfo(packageName,0).versionCode;
                  final PluginResult result = new PluginResult(PluginResult.Status.OK, versionName);
                  Log.d(TAG,"sending result: "+versionName+" ("+versionNumber+")");
                  callbackContext.sendPluginResult(result);
              } catch (PackageManager.NameNotFoundException nameNotFound) {
                  final PluginResult result = new PluginResult(PluginResult.Status.ERROR, "Package Name Not found: "+packageName+": "+nameNotFound);
                  Log.e(TAG,"plugin error",nameNotFound);
                  callbackContext.sendPluginResult(result);
              }
          }
      });
  }

}
