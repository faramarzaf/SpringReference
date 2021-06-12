package com.spring.LoginWebApp;


public class train_security {
    /**
     * 5 things that you should know
     *
     *  Security guard asks you first... 1- Who are your? -Here my ID/password (unique).
     *  "Knowledge base authentication" (password/ping-code/answer to a secret/personal question)
     *
     *  "Possession(malekiat) base authentication" : phone/text messages, key cards and badges, access token device
     *      Possession + Knowledge = Multi factor authentication: enter password and send your otp message
     *  1- is Authentication
     *
     *
     * 2- What do you want?(Can this user do this?) -I want access that service
     *  2- is Authorization---->
     *
     *
     * 3- Principal
     * It means currently logged in user.
     *
     * 4-Granted Authority
     *Think of a GrantedAuthority as being a "permission" or a "right".
     *  Those "permissions" are (normally) expressed as strings (with the getAuthority() method).
     *  Those strings let you identify the permissions and let your voters decide if they grant access to something.
     *
     *5- Role
     *
     *
     *
     *
     */



    /**
     * authorization strategies-->
     * jwt.io
     *      1- Session token
     *      2- Json Web Token
     *
     *    SessionId + Cookies --> Most popular mechanism for  authorization
     *
     *    Three parts of JWT
     *
     *        1- Header
     *        2- Payload  --> Your data that server knows you with that. (encoded with base-64)
     *        3- Signature. Server signs the web token with signature.
     *  When user with any of authentication ways , login to the server, server makes JWT for future authorization purposes.
     *  JWT comes when authentication is done. So server sends JWT to client. Then client saves this into local storage or,
     *  cookie. then Client should sends JWt with every single request
     *
     */


    /**
     *  OAuth ----> Authorization between services
     *
     *  For example we have upload image service that can upload images from user's google drive account, So we can't say,client gie me your
     *  google account credential, we should communicate with services across OAuth.
     *
     *  So like this----> when upload service request to the google drive service, google drive service asks client to confirm access and
     *  Limited access , then user confirm. So now google service says ok, I give  a authorization token (Limited access) to you.
     *  So after that every time that upload service want to request, it does that with TOKEN.
     *
     *  Terminology
     *
     *
     *  1- Resource --> My photos
     *  2- Resource owner ---> Client
     *  3- Resource server ---> Google drive
     *  4- Client --> Upload service
     *  5- Authorization server --> Google drive server that issuing access tokens to the client (upload service)
     *
     */









}
