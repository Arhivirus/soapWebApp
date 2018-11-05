package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import tutorialspoint.schemas.GetPilotRequest;
import tutorialspoint.schemas.GetPilotResponse;

@Endpoint
public class PilotEndpoint {
    private static final String NAMESPACE_URI = "http://tutorialspoint/schemas";

    private PilotRepo pilotRepository;

    @Autowired
    public PilotEndpoint(PilotRepo piotRepository) {
        this.pilotRepository = pilotRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPilotRequest")
    @ResponsePayload
    public GetPilotResponse getPilot(@RequestPayload GetPilotRequest request) {
        GetPilotResponse response = new GetPilotResponse();
        response.setPilot(pilotRepository.findPilot(request.getName()));
        return response;
    }
}
