package com.boris.getandsend.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by boris on 13.08.17.
 */
@Service
@Component
public class FtpService extends FileProcessAbstractService {

    @Override
    public void executeTask(String jsonString) throws IOException {
        FileDownloader myFile = new FileDownloader();
        JsonObject obj = new JsonParser().parse(jsonString).getAsJsonObject();
        String hostname = obj.get("hostname").getAsString();
        String username = obj.get("user").getAsString();
        String password = obj.get("pass").getAsString();
        String link = obj.get("file_link").getAsString();
        String fileName = myFile.getFileName(link);
        myFile.downloadFile(link, "/Users/boris/Java/GetAndSend");
        UploadToFtp myFTP = new UploadToFtp();
        myFTP.upload(hostname, username, password, fileName);
    }


}
