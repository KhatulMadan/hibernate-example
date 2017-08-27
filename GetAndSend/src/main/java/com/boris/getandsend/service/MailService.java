package com.boris.getandsend.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by boris on 09.08.17.
 */
@Service
@Component
public class MailService extends FileProcessAbstractService {

@Override
    public void executeTask(String jsonString) throws IOException {
    FileDownloader myFile = new FileDownloader();
    JsonObject obj = new JsonParser().parse(jsonString).getAsJsonObject();
    String email = obj.get("target_email").getAsString();
    String link = obj.get("file_link").getAsString();
    String fileName = myFile.getFileName(link);
    myFile.downloadFile(link, "/Users/boris/Java/GetAndSend");
    SendMail myMail = new SendMail();
    myMail.send(email, fileName);

}

}
