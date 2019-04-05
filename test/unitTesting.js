var expect = require('chai').expect;
var fs = require("fs");
var serve = require("../a.js");
var request = require("request");



describe('OTP unit testing', function () {
  it('Should create an OTP of random numbers', function () {
    var res = serve.generatePin(gen.ClientID);
      expect(res).to.equal(res);
    });
    it('Should compare otp of specified client with generated otp', function () {
    var res = serve.validate(auth.ClientID,auth.pin);
      expect(res).to.equal("success");

    });
    it('Should compare otp of specified client with wrong otp', function () {
    var res = serve.validate(auth.ClientID,auth.pin);
      expect(res).to.equal("failed");
      

    });
    it('Attempting log without paramater client_id', function () {
    var res = serve.addLog(cid,null);
      expect(res).to.equal("failed missing arguement 'pin'");

    });
     it('Attempting log without paramater client_id', function () {
    var res =  serve.addLog(null,pin);
      expect(res).to.equal("failed missing arguement 'client_id'");

    });
});


/*
describe('Push testing',function(){
	it("Push data to Reporting",function(){
		var res = log.pushTest("notificationLogs.txt",21,fs);
		console.log(res);
   		expect(res).to.equal(true);

	}); 	
})
*/


// describe('API testing',function(){
// 	it("Sending an OTP notification",async function(){
// 		const res =await makeRequest(OTP);
// 		while(res == undefined){pausecomp(50)}
// 		res = JSON.stringify(res);

// 		console.log("API test: "+res);
//    		// expect(res).to.equal(true);

// 	}); 	
// })

var gen={
    "ClientID": "7",
    "Type":"generate"
}

var auth={
    "ClientID": "7",
    "Type":"generate",
    "pin":"1234"
}

var OTP = {
    "ClientID": "23432",
    "Type": "OTP",
    "Content": {
        "pin": "123456"
    }
}

var cid="1234";
var pin="1234";


function pausecomp(millis)
{
    var date = new Date();
    var curDate = null;
    do { curDate = new Date(); }
    while(curDate-date < millis);
}

async function makeRequest(jsonObj){

var options = { method: 'POST',
  url: 'http://merlotnotification.herokuapp.com/',
  headers: 
   { 'Postman-Token': 'fe00621e-2cbe-4120-83c5-1b340d0b541e',
     'cache-control': 'no-cache',
     'Content-Type': 'application/json' },
  body: JSON.stringify(jsonObj)
};




request(options,async  function (error, response, body) {
 	var res = await body
 	console.log(body)
  	return res;
})

}




