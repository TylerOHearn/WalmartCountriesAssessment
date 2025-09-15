<h1 align="center">Walmart Countries Assessment</h1>
<h4 align="center"> Country Details Sorting App</h4>

## Description
Built for a coding exercise, given by a potential client, this app is designed to ingest API JSON response data and display details about the countries listed.

Written using [MVVM](https://medium.com/swlh/understanding-mvvm-architecture-in-android-aa66f7e1a70b) architecture with [ViewModels](https://developer.android.com/topic/libraries/architecture/viewmodel) and [LiveData](https://developer.android.com/topic/libraries/architecture/livedata), [Databinding](https://developer.android.com/topic/libraries/data-binding), [Retrofit](https://square.github.io/retrofit/) consuming a [RESTful API](https://medium.com/android-news/consuming-rest-api-using-retrofit-library-in-android-ed47aef01ecb). The App was written with best practices in mind.

## Client Requested Objectives
* Consume JSON from provided URL and display "name", "region", "code", and "capital" in format provided in assessment documentation
* Display above details in a scrollable RecyclerView
* Handle errors and edge cases
* Support device rotation

## Improvements
* Add HTTP response handling for messages (4xx, 5xx) and display error code if passed to device
* Add Light/Dark theme
* Offline details storage via ROOM if internet connection is dropped during usage
* Convert [XML](https://developer.android.com/develop/ui/views/layout/declaring-layout) to [Jetpack Compose](https://developer.android.com/jetpack/compose) after initial feedback from client, as client specifically requested to use XML

## License
	Copyright 2025 Tyler OHearn
	
	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at
	
	   http://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
