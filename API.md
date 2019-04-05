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
>**Authenticated**: A Status
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

```

