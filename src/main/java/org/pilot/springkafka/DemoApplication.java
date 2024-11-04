package org.pilot.springkafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(DemoApplication.class);

        SpringApplication.run(DemoApplication.class, args);
        logger.info("INFO - info Spring demo Application Started");
        logger.warn("WARN - warn Spring demo Application Started");
        logger.error("ERROR - error Spring demo Application Started");
        logger.debug("DEBUG - debug Spring demo Application Started");
    }

}
