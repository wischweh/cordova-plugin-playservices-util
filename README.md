Cordova Plugin Google Playservices Google
======

This is a utility plugin to work with Google Playservices on android phones. You can use it to query the installed 
version of the play services, check the installed version, and query the installed WebView version and other packages.
At its core it is just a handy wrapper around GoogleApiAvailability and related call to the androids package manager.

# Usage
## Requirements 
just add the plugin to your cordova project:

## Example
```javascript
window.PlayservicesUtil.getWebviewVersionName(function (webviewVersion) {
          console.log('getWebviewVersionName:', webviewVersion);
        }, function (error) {
          console.error('getWebviewVersionName: could not query WebViewVersionName', error);
        });
```

# Features
- check installed version of Google Play Services (geting the version string which should be a semantic versioning)
- check installed version of the Webview (geting the version string which should be a semantic versioning)

# Missing Features / Upcoming
- querying of the version integers (in addition to the string)
- querying of full version information (string and number)
- querying for version info of any package as specified by parameter
- support for checking if a usable version of Google Play Services is installed 
  (see https://developers.google.com/android/reference/com/google/android/gms/common/GoogleApiAvailability.html#isGooglePlayServicesAvailable(android.content.Context) )
- support for checking the availability of several Google APIs mentioned in 
  https://developers.google.com/android/reference/com/google/android/gms/common/api/GoogleApi
- support for Androids native mechanisms to request the availability of Google Services 
  (see https://developers.google.com/android/reference/com/google/android/gms/common/GoogleApiAvailability.html#makeGooglePlayServicesAvailable(android.app.Activity)
  and related methods)
  
