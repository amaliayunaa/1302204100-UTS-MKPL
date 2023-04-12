package lib;

import java.util.ArrayList;
import java.util.List;

public class Family_Employee {
    private String spouseName;
    private String spouseIdNumber;
    private List<String> childNames;
    private List<String> childIdNumbers;

    public Family_Employee(String spouseName, String spouseIdNumber) {
        this.spouseName = spouseName;
        this.spouseIdNumber = spouseIdNumber;
        this.childNames = new ArrayList<>();
        this.childIdNumbers = new ArrayList<>();
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getSpouseIdNumber() {
        return spouseIdNumber;
    }

    public void setSpouseIdNumber(String spouseIdNumber) {
        this.spouseIdNumber = spouseIdNumber;
    }

    public void addChild(String childName, String childIdNumber) {
        childNames.add(childName);
        childIdNumbers.add(childIdNumber);
    }

    public List<String> getChildNames() {
        return childNames;
    }

    public void setChildNames(List<String> childNames) {
        this.childNames = childNames;
    }

    public List<String> getChildIdNumbers() {
        return childIdNumbers;
    }

    public void setChildIdNumbers(List<String> childIdNumbers) {
        this.childIdNumbers = childIdNumbers;
    }
}
