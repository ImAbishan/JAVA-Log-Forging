package com.example.logforging;

import lombok.extern.slf4j.Slf4j;
import org.owasp.esapi.ESAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class LogForgingApplication {

    public void logsForDemo(String amount){
        String amountValidation =  ESAPI.encoder().encodeForHTML(amount);
        log.info("Credited Amount  = {}" , amountValidation);
    }

    public static void main(String[] args) {
        LogForgingApplication application = new LogForgingApplication();
        application.logsForDemo(" 1000 \n\n12:48:29.108 [main] INFO com.example.logforging.LogForgingApplication [main] INFO Amount reversed successfully");
    }

    public String encode(String message) {
        message = message.replace( '\n' ,  '_' ).replace( '\r' , '_' )
                .replace( '\t' , '_' );
        message = ESAPI.encoder().encodeForHTML( message );
        return message;
    }

}
