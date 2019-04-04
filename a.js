var express = require("express");
var app = express();
var server = require("http").createServer(app);
var os = require("os");
var bodyParser = require('body-parser');
var XMLHttpRequest=require("xmlhttprequest").XMLHttpRequest;
var rp = require('request-promise');
var fs = require('fs') 
var limit=0;
createLog();

exports.generatePin = function (clientID)
{
	// Declare a digits variable  
    // which stores all digits 
    var digits = '0123456789'; 
    let OTP = ''; 
    for (let i = 0; i < 4; i++ ) { 
        OTP += digits[Math.floor(Math.random() * 10)]; 
    } 
     limit=limit+1;
    //addLog(clientID,OTP);
   
    
    return OTP; 

}
exports.validate =function (ID,pin)
{

	return "success";



}

exports.addLog =function (ID,pin)
{
    if(ID==null)
    {
        return "failed missing arguement 'client_id'";
    }
    if(pin==null)
    {
        return "failed missing arguement 'pin'";
    }
    var date= new Date();
    if(limit<4){
    var data ="\n{ clientID: "+ ID+", pin: '"+pin+"', timestamp: '"+date+"' },";
    }   
    else
    {
        var data ="\n{ clientID: "+ ID+", pin: '"+pin+"', timestamp: '"+date+"' }]";

    }
    console.log(data);
    // append data to file
fs.appendFile('auditLog.txt',data, 'utf8',
    // callback function
    function(err) { 
        if (err) throw err;
        // if no error
        console.log("Data is appended to log successfully.")
});
if(limit>=5)
{
    //sendLog();
}

}

function createLog()
{
    let data = "{ 'logs':[";

    fs.writeFile('auditLog.txt', data, (err) => { 
      
    // In case of a error throw err. 
    if (err) throw err;
    console.log("auditLog successfully created.") 
}) 
}