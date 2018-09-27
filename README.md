# AdapterIntegration


To Run this project :
1. Install maven if it is not already present in your machine
2. Run mvn clean install at the same level as pom.xml
3. Copy the AdapterIntegration.war from the target folder and deploy it on any tomcat instance

The following API's are exposed:
  1. Get List of Files and Folders inside a Folder
  2. Download a File in Folder
  3. Upload a File to a Folder
  
 These API's are implemented for BOX provider . And infra is provided to add new providers easily like Google Drive, DropBox
 
 For BOX the implementation is done using Developer Token which is hardcoded to an invalid value in BoxConstants.JAVA
 For Testing this implementation, create a custom app and generate the developer token and replace hardcoded value with that token
 
 GET LIST OF FILES/FOLDER:

http://<hostUrl:port>/AdapterIntegration/box/listFiles

POST

Accepts : Application/JSON
Produces : Application/JSON

Payload : {"folderId":"0"}["0" is for root folder in Box , for getting list of files and folder inside a folder replace with folderId]

Typical Response:

[
    {
        "name": "hackathon",
        "type": "FOLDER",
        "fileId": "379073212365"
    },
    {
        "name": "abhi.docx",
        "type": "FILE",
        "fileId": "322012323458"
    },
    {
        "name": "Adi.pdf",
        "type": "FILE",
        "fileId": "32112308006"
    }
]

Download File:

http://<hostUrl:port>/AdapterIntegration/box/download

POST

Accepts : Application/JSON
Produces : Application/OCTET-STREAM

Payload : {"fileId":"<fileId to download>"}

No Response; Can extrapolate the same for downloading multiple files. File gets downloaded to the bin folder of the tomcat

Upload File:

http://<hostUrl:port>/AdapterIntegration/box/upload

POST

Content-Type : multipart/Form-data

Takes a part with parentFolderId containing the folderId as to where upload has to be done
Takes a part with file key with uploaded File doc

No Response; Can extrapolate the same for uploading multiple files


***********************************************************************************
Havent implemented any Error Handling
No Logging
No Tests
*********************************************************************************

