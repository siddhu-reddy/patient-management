package com.pm.analyticsservice.kafka;

import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;

@Service
public class KafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics="patient", groupId="analytics-service-v2")
    public void consumerEvent(byte[] event){
        log.info("listeningggggggggggggggg");
        try {
            PatientEvent patientEvent=PatientEvent.parseFrom(event);
            System.out.println(patientEvent.getName());
        } catch (InvalidProtocolBufferException e) {
            log.error("error deserialization from the kafka ");
        }

    }
}
