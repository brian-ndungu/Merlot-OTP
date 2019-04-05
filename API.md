# API reference:
---
## OTP Authentication
Description Here
```javascript 
function validate(ID,pin)
if(retrieveOTP(ID)==pin)
	{
			RemoveOTP(ID)=null;
			console.log(arr);
			return "success";

	}else
	{
		return "failed";
	}
```
@return: Will return either Authenticated or throw an Exception
>**Authenticated**:return ({ "ClientID" : content.ClientID,"Success":"true","message":"Correct OTP"})
>
>**Exception**: Throws One of 3 Exception(TimeOut,IncorrectOTP or NetworkIssues)

@param:  
>**ClientID**: The ID of the client  





example usage: 
Java
```java
 var obj= {
	"ClientID":"1",
	"type":"generate"
}
async function type(type,content)
{
	switch(type.toLowerCase()){
		case "generate":{
				var pin = generatePin(content.ClientID);

				console.log("Pin generated: "+ pin)

				var result = await sendOTP(content.ClientID,pin);
				console.log(result);

	if(result.status == "success"){
		return ({ "Success":"true"})
	}else{
		return({ "Success":"false","message":"something went wrong"})
	}
				break;
		}
		case "validate":{
				console.log("Pin Entered: "+ content.pin);
				var result=validate(content.ClientID,content.pin);
				if(result == "success"){
					return ({ "ClientID" : content.ClientID,"Success":"true","message":"Correct OTP"})
				}else{
					return({"ClientID" : content.ClientID, "Success":"false","message":"Incorrect OTP or no OTP created"})
				}
			break;
		}
		default:{
			throw '{ "status": 400, "message":"Invalid Notification Type"}'
		}
	}

}

function generatePin(clientID)
{
	// Declare a digits variable  
    // which stores all digits 
    var digits = '0123456789'; 
    let OTP = ''; 
    for (let i = 0; i < 4; i++ ) { 
        OTP += digits[Math.floor(Math.random() * 10)]; 
    } 
     limit=limit+1;

     arr[clientID]=OTP;
   addLog(clientID,OTP);
   
    
    return OTP; 

}


async function sendOTP (clientID, pin){
	var url = "http://merlotnotification.herokuapp.com/";//"ec2-35-174-115-93.compute-1.amazonaws.com:5000";
	var otp = {
		"ClientID" : clientID,
		"Type" : "OTP",
		"Content" : {
			"pin": pin
		}
	}
	var options ={
		method :'POST',
		uri:url,
		body: otp,
		json: true

	};
	return await rp(options)
	.then(function (parseBody){
		return parseBody;
	})
	.catch(function(err)
	{
		console.log(err);

	});
}
```

