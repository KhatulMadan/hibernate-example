package com.boris.getandsend.service;


import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by boris on 13.08.17.
 */
public class UploadToFtp {

    private static final int BUFFER_SIZE = 4096;

    public void upload(String hostname, String username, String password, String filename) {
        String server = hostname;
        int port = 21;
        String user = username;
        String pass = password;

        FTPClient ftpClient = new FTPClient();
        try {

            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            File localFile = new File("/Users/boris/Java/GetAndSend/" + filename);

            String remoteFile = filename;
            InputStream inputStream = new FileInputStream(localFile);

            System.out.println("Start uploading the file");
            boolean done = ftpClient.storeFile(remoteFile, inputStream);
            inputStream.close();
            if (done) {
                System.out.println("The file is uploaded successfully.");


            }

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }


        }

    }
}