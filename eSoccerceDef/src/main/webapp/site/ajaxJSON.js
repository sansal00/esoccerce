
function getXmlHttpRequest() {

	var xhr = false;
	var activeXoptions = new Array("Microsoft.XmlHttp", "MSXML4.XmlHttp",
			"MSXML3.XmlHttp", "MSXML2.XmlHttp", "MSXML.XmlHttp");

	try {
		xhr = new XMLHttpRequest();
		console.log("Get XML http request");
	} catch (e) {
	}

	if (!xhr) {
		var created = false;
		for (var i = 0; i < activeXoptions.length && !created; i++) {
			try {
				xhr = new ActiveXObject(activeXoptions[i]);
				created = true;
				console.log("Get ActiveXObject XML http request");
			} catch (e) {
			}
		}
	}
	return xhr;
}

function getReadyStateHandler(req, responseJSONHandler, id, timeout) {
	return function() {
		if(timeout > 0) {
			handleWait(req, new Date().getTime(), timeout);
		}
		
		if (req.readyState == 1) {
			console.log("Server connection");
		} else if ( req.readyState == 2 ) {
			console.log("Send request");
		} else if ( req.readyState == 3 ) {
				console.log("Receive response");
				wait(false);
		} else if (req.readyState == 4) {
			console.log("Request finished and response is ready");
			if (req.status == 200 || req.status == 304) {
				console.log("Send data to the handler");
				responseJSONHandler(req.responseText, id);
			} else {
				console.log("Response error "+ req.status + " " + req.statusText);
			}
		} else {
			wait(false);
		}
	};
}


function handleWait(req, start, maxTime) {

	if (req.owner) 
		return;
	else 
		req.owner = true; 
	
	checkTime = function() {

		if ( req.readyState == 4 ) {
			wait(false);
			return;
		}

		if((new Date().getTime() - start) > maxTime) {
			req.onreadystatechange = function(){
				console.log("Abort Ajax request"); 
				return;
			};
			req.abort();
			wait(false);
		} 
		else {
			setTimeout(checkTime, 100);
		}
	}
	checkTime();	
}


function ajaxCall(id, url, callback, parameter, parameter2, timeout) {
	var req = getXmlHttpRequest();
	try {
		wait(true);

		req.onreadystatechange = getReadyStateHandler(req, callback, id, timeout);
		req.open('POST', url, true);
		req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		console.log("Open and send request");
		req.send("param=" + parameter+"&param2=" + parameter2);
	} catch (e1) {
		wait(false);
	}
}

function wait(state) {
		var obj = document.getElementById("wait");
		if(obj != null) {
			if (state == true) {
				// Show wait
				obj.style.display = "inline";
				var left = document.documentElement.clientWidth /2 - 150;
				obj.style.left = left + "px";				   
			} else {
				// Hide wait
				obj.style.display = "none";				
			}	
		}
}


