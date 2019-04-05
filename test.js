var express = require("express");
var app = express();
var server = require("http").createServer(app);
var os = require("os");
var bodyParser = require('body-parser');





const PORT = process.env.PORT || 5000;

var HostAddress = os.hostname();
console.log("============ Starting server ============");
console.log("Waiting for Incoming connections on "+HostAddress+":" + PORT);
console.log("--------------------------------------------------");
server.listen(PORT);
app.use(express.static(__dirname+ "js"));
app.use(bodyParser.json()); 
app.use(bodyParser.urlencoded({		extended: true		}));

app.post("/", async function(req,res){
	
	console.log(data);
	var data = req.body
	var pin = generatePin(data.clientID);

	console.log("Pin generated: "+ pin)
	var result = await sendOTP(data.clientID,pin);
	console.log(result);
	if(result.status == "success"){
		res.json({ "status":"success"})
	}else{
		res.json({ "status":"failed","message":"something went wrong"})
	}
	res.end();
});





async function sendOTP (clientID, pin){
	var url = "merlotnotification.herokuapp.com";
	var otp = {
		"ClientID" : clientID,
		"Type" : "OTP",
		"Content" : {
			"pin": pin
		}
	}
	let promise = new Promise(async(resolve,reject)=>{
		var xhr = new XMLHttpRequest();
		xhr.addEventListener("readystatechange", function () {
		  if (this.readyState === 4) {
		    resolve(this.responseText);
		  }
		});

		xhr.open("POST", "http://merlotnotification.herokuapp.com");
		xhr.setRequestHeader("Content-Type", "application/json");
		xhr.setRequestHeader("cache-control", "no-cache");
		xhr.setRequestHeader("Postman-Token", "4c91cfb9-ae78-468a-ab75-c7e3aaf65bba");

		xhr.send(data);
	})

	promise.then((successMessage)=>{
		return JSON.parse(successMessage);
	})
}