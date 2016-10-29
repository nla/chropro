#!/bin/bash
[ -f browser_protocol.json ] || curl 'https://chromium.googlesource.com/chromium/src/+/master/third_party/WebKit/Source/core/inspector/browser_protocol.json?format=text' | base64 -d > browser_protocol.json
[ -f js_protocol.json ] || curl 'https://chromium.googlesource.com/v8/v8/+/master/src/inspector/js_protocol.json?format=text' | base64 -d > js_protocol.json
