package com.riteshbhavsar.bhavsarreshimgathi.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;


/**
 * Created by ritesh.bhavsar on 07-07-2017.
 */

public class Males implements Parcelable {

    private int id;
    private String fullname;
//    @Required
//    private String firstName;
//    @Required
//    private String middleName;
//    @Required
//    private String lastName;
    private String mothersName;
    private String dobStr;
    private String dotStr;
    private Date dob;
//    private Time dot;

    private float height;//foot.inch
    private float weight;//kg
    private int noOfSiblings;
    private int noOfSiblings_bro;

    private String occupation;
    private long salary;
    private String education;
    private String bloodGrp;
    private String address;
    private String contactNo;
    private String kul;
    private String mameKul;
    private String gender;//M, F, T

    private String candidateId;
    private String status;//vidhur, new, vidhva
    private String profileLogo;
    private byte[] profileLogoByte;

    private String birthPlace;
    private String expectation;
    private String fathersFullName;
    private String fathersOccupation;
    private String fullNameOfMama;
    private String raas;
    private String nakshatra;
    private String faceColor;
    String updatedBy;
    boolean isVerified;

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public static Creator<Males> getCREATOR() {
        return CREATOR;
    }

    Males(){

    }
    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public int getNoOfSiblings_bro() {
        return noOfSiblings_bro;
    }

    public void setNoOfSiblings_bro(int noOfSiblings_bro) {
        this.noOfSiblings_bro = noOfSiblings_bro;
    }

    public String getFaceColor() {
        return faceColor;
    }

    public void setFaceColor(String faceColor) {
        this.faceColor = faceColor;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getExpectation() {
        return expectation;
    }

    public void setExpectation(String expectation) {
        this.expectation = expectation;
    }

    public String getFathersFullName() {
        return fathersFullName;
    }

    public void setFathersFullName(String fathersFullName) {
        this.fathersFullName = fathersFullName;
    }

    public String getFathersOccupation() {
        return fathersOccupation;
    }

    public void setFathersOccupation(String fathersOccupation) {
        this.fathersOccupation = fathersOccupation;
    }

    public String getFullNameOfMama() {
        return fullNameOfMama;
    }

    public void setFullNameOfMama(String fullNameOfMama) {
        this.fullNameOfMama = fullNameOfMama;
    }

    public String getRaas() {
        return raas;
    }

    public void setRaas(String raas) {
        this.raas = raas;
    }

    public String getNakshatra() {
        return nakshatra;
    }

    public void setNakshatra(String nakshatra) {
        this.nakshatra = nakshatra;
    }

    public byte[] getProfileLogoByte() {
        return profileLogoByte;
    }

    public void setProfileLogoByte(byte[] profileLogoByte) {
        this.profileLogoByte = profileLogoByte;
    }

    public String getProfileLogo() {
        return profileLogo;
    }

    public void setProfileLogo(String profileLogo) {
        this.profileLogo = profileLogo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getMiddleName() {
//        return middleName;
//    }
//
//    public void setMiddleName(String middleName) {
//        this.middleName = middleName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public String getDobStr() {
        return dobStr;
    }

    public void setDobStr(String dobStr) {
        this.dobStr = dobStr;
    }

    public String getDotStr() {
        return dotStr;
    }

    public void setDotStr(String dotStr) {
        this.dotStr = dotStr;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

//    public Time getDot() {
//        return dot;
//    }
//
//    public void setDot(Time dot) {
//        this.dot = dot;
//    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getNoOfSiblings() {
        return noOfSiblings;
    }

    public void setNoOfSiblings(int noOfSiblings) {
        this.noOfSiblings = noOfSiblings;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getBloodGrp() {
        return bloodGrp;
    }

    public void setBloodGrp(String bloodGrp) {
        this.bloodGrp = bloodGrp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getKul() {
        return kul;
    }

    public void setKul(String kul) {
        this.kul = kul;
    }

    public String getMameKul() {
        return mameKul;
    }

    public void setMameKul(String mameKul) {
        this.mameKul = mameKul;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(fullname);
        parcel.writeString(gender);
        parcel.writeString(fathersFullName);
        parcel.writeString(fathersOccupation);
        parcel.writeString(mothersName);
        parcel.writeString(dobStr);
        parcel.writeString(dotStr);
        parcel.writeString(birthPlace);
        parcel.writeFloat(height);
        parcel.writeFloat(weight);
        parcel.writeString(raas);
        parcel.writeString(nakshatra);
        parcel.writeString(bloodGrp);
        parcel.writeString(education);
        parcel.writeString(occupation);
        parcel.writeLong(salary);
        parcel.writeString(faceColor);
        parcel.writeString(kul);
        parcel.writeString(fullNameOfMama);
        parcel.writeString(mameKul);
        parcel.writeInt(noOfSiblings);
        parcel.writeInt(noOfSiblings_bro);
        parcel.writeString(address);
        parcel.writeString(contactNo);
        parcel.writeString(status);
        parcel.writeString(expectation);
        parcel.writeString(candidateId);
        parcel.writeString(profileLogo);
        parcel.writeString(updatedBy);


    }
    public Males(Parcel parcel){
        id = parcel.readInt();
        fullname = parcel.readString();
        gender = parcel.readString();
        fathersFullName = parcel.readString();
        fathersOccupation = parcel.readString();
        mothersName = parcel.readString();
        dobStr = parcel.readString();
        dotStr = parcel.readString();
        birthPlace = parcel.readString();
        height = parcel.readFloat();
        weight = parcel.readFloat();
        raas = parcel.readString();
        nakshatra = parcel.readString();
        bloodGrp = parcel.readString();
        education = parcel.readString();
        occupation = parcel.readString();
        salary = parcel.readLong();
        faceColor = parcel.readString();
        kul = parcel.readString();
        fullNameOfMama = parcel.readString();
        mameKul = parcel.readString();
        noOfSiblings = parcel.readInt();
        noOfSiblings_bro = parcel.readInt();
        address = parcel.readString();
        contactNo = parcel.readString();
        status = parcel.readString();
        expectation = parcel.readString();
        candidateId = parcel.readString();
        profileLogo = parcel.readString();
        updatedBy = parcel.readString();
    }

    //used when un-parceling our parcel (creating the object)
    public static final Parcelable.Creator<Males> CREATOR = new Parcelable.Creator<Males>(){

        @Override
        public Males createFromParcel(Parcel parcel) {
            return new Males(parcel);
        }

        @Override
        public Males[] newArray(int size) {
            return new Males[0];
        }
    };
}