
var exec = require('cordova/exec');

var PLUGIN_NAME = 'PlayservicesUtil';

var PlayservicesUtil = {
  getPlayservicesVersionNumber: function(cb) {
    exec(cb, null, PLUGIN_NAME, 'getPlayservicesVersionNumber', []);
  },
  getWebviewVersionNumber: function(cb) {
    exec(cb, null, PLUGIN_NAME, 'getWebviewVersionNumber', []);
  },


};

module.exports = PlayservicesUtil;
