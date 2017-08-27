package com.boris.getandsend.tasks;

import com.boris.getandsend.service.FtpService;
import com.boris.getandsend.service.MailService;
import org.springframework.stereotype.Component;


/**
 * Created by boris on 07.08.17.
 */
@Component
public enum TaskType {


        MAIL(1, MailService.class),
        FTP (2, FtpService.class);



    private int id;
        private Class providerClass;



        TaskType(int id, Class clz) {
            this.id = id;
            this.providerClass = clz;
        }


        public int getId() {
            return id;
        }

        public Class getProviderClass() {
            return providerClass;
        }


}
