# chropro

Java client library for the [Chrome Debugging Protocol](https://developer.chrome.com/devtools/docs/debugger-protocol). The client is code generated from Chromium's JSON protocol description.

See [Renderer.java](webapp/src/chropro/Renderer.java) in the included thumbnailer webapp for an example of usage.

## Usage with Chrome --headless mode

[Download a Linux Chrome snapshot](https://download-chromium.appspot.com/?platform=Linux_x64&type=snapshots)

```sh
cd chrome-linux

# Set chrome-sandbox setuid root (alternatively live dangerously with --no-sandbox)
mv chrome_sandbox chrome-sandbox
sudo chown root chrome-sandbox
sudo chmod 4755 chrome-sandbox

# Fire up Chrome in headless mode
./chrome --headless --disable-gpu --remote-debugging-port=9292 &

# Run the example webapp
./bin/chropro-webapp
```

## Usage with headless_shell

See [build instructions](https://chromium.googlesource.com/chromium/src/+/lkgr/headless/README.md)

```sh
headless_shell --remote-debugging-port=9292 &
./bin/chropro-webapp
```

## License

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this software except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
