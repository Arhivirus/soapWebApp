package hello;

import org.springframework.stereotype.Component;
import tutorialspoint.schemas.Pilot;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class PilotRepo {
    private static final List<Pilot> pilots = new ArrayList<Pilot>();

    @PostConstruct
    public void initData() {

        Pilot pilotOne = new Pilot();
        pilotOne.setName("Ivan");
        pilotOne.setLicence("K123456XYZ");
        pilotOne.setAge(44);

        pilots.add(pilotOne);

        Pilot pilotTwo = new Pilot();
        pilotOne.setName("Petro");
        pilotOne.setLicence("X321321KYB");
        pilotOne.setAge(25);

        pilots.add(pilotTwo);

        Pilot pilotThree = new Pilot();
        pilotOne.setName("Vasia");
        pilotOne.setLicence("C575851XWZ");
        pilotOne.setAge(67);

        pilots.add(pilotThree);
    }

    public Pilot findPilot(String name) {

        Pilot result = null;

        for (Pilot pilot : pilots) {
            if (name.equals(pilot.getName())) {
                result = pilot;
            }
        }

        return result;
    }

}
