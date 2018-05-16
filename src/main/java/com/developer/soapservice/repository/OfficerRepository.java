package com.developer.soapservice.repository;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;

import com.developer.xml.generated.Officer;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class OfficerRepository {
    private static final Map<String, Officer> Officers = new HashMap<>();

    @PostConstruct
    public void initData() {

        Officer officer = new Officer();
        officer.setId(1);
        officer.setRank("Colonel");
        officer.setName("Sherman T Potter");
        officer.setGrade("O6");
        officer.setAddress("Hannibal, Missouri");
        Officers.put(officer.getName(), officer);

        officer = new Officer();
        officer.setId(2);
        officer.setRank("Captain");
        officer.setName("Hawkeye Pierce");
        officer.setGrade("O3");
        officer.setAddress("Crabapple Cove, Maine");
        Officers.put(officer.getName(), officer);

        officer = new Officer();
        officer.setId(3);
        officer.setRank("Captain");
        officer.setName("B J Hunnicutt");
        officer.setGrade("O3");
        officer.setAddress("Mill Valley, California");
        Officers.put(officer.getName(), officer);

        officer = new Officer();
        officer.setId(4);
        officer.setRank("Major");
        officer.setName("Margaret Houlihan");
        officer.setGrade("O4");
        officer.setAddress("Fort Ord, California");
        Officers.put(officer.getName(), officer);
    }

    public Officer findOfficer(String name) {
        Assert.notNull(name, "The Officer's name must not be null");
        return Officers.get(name);
    }
}

