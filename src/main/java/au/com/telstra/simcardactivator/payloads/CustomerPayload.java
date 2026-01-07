package au.com.telstra.simcardactivator.payloads;
import au.com.telstra.simcardactivator.model.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class CustomerPayload {

    private static final String ACTUATOR_URL = "http://localhost:8444/actuate";
    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/activate")
    public void activateSim(@RequestBody Product product) {

        // Log incoming request
        System.out.println("Received activation request: " + product);

        // Build actuator request
        ActuatorRequest actuatorRequest =
                new ActuatorRequest(product.getIccid());

        // Call actuator microservice
        Response actuatorResponse =
                restTemplate.postForObject(
                        ACTUATOR_URL,
                        actuatorRequest,
                        Response.class
                );

        // Print activation result
        if (actuatorResponse != null && actuatorResponse.isSuccess()) {
            System.out.println(
                    "SIM activation SUCCESS for ICCID: " + product.getIccid()
            );
        } else {
            System.out.println(
                    "SIM activation FAILED for ICCID: " + product.getIccid()
            );
        }
    }


}
