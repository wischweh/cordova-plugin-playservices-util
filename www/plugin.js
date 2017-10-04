
var exec = require('cordova/exec');

var PLUGIN_NAME = 'PlayservicesUtil';

var PlayservicesUtil = {
  getPlayservicesVersionName: function(cb) {
    exec(cb, null, PLUGIN_NAME, 'getPlayservicesVersionName', []);
  },
  getWebviewVersionName: function(cb) {
    exec(cb, null, PLUGIN_NAME, 'getWebviewVersionName', []);
  },


};

module.exports = PlayservicesUtil;
