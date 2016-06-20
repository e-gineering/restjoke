Configuring Service as Outgoing Webhook in Slack
===============================================
Navigation
----------
1. From your [slack home page][1], while logged in, choose _Customize Slack_ option in the drop-down menu at the top left corner of the page. A new __Customize Your Team__ window should be opened.
2. Click on the _Configure Apps_ option in the menu to the left. A new window with a list of apps should be opened.
3. Choose _Custom Integrations_ on the menu to the left.
4. In the list of integrations, choose _Outgoing Webhooks_. A list of current E-gineering Custom integrations will be listed.
5. If a Chuck Norris Configuration isn't already present, click the _Add Configuration button_, and follow the set-up instructions below. If one does exist, then just click on the edit button to the right of the current Chuck Norris configuration.

The settings for the service should be as follows:
==================================================
__Channel__: Any

__Trigger Words__: chucknorris (this will allow upper- and lowercase anywhere in the word, i.e. chuCkNorris will be accepted)

__URL__: URL of your service endpoint

__Token__: _Caution!_ This value should be changed during initial set up only:
  
  1. click the _Regenerate_ option just below the dialog box.  
  2. __Set the resulting token value to an environment variable named CN_EXPECTED_TOKEN available in whatever server is hosting the service.__  
  3. Any time the token is regenerated in the Slack configuration, it must also be updated in the system's environment  
  
__Descriptive Label__: appropriately describe the service. Currently: "A random, inexplicit Chuck Norris joke  can be delivered from the heavens in the same way that Check Norris delivers earth-shattering roundhouse kicks."  

__Customize Name__: Chuck Norris

__Customize Icon__: Use any icon you wish. A grayscale caricature of Chuck is a great option.

A preview of the bot will be shown. Check that it appears the way you want. Choose __Save Settings__ once the service is configured.

[1]: https://e-gineering.slack.com/ "Slack"