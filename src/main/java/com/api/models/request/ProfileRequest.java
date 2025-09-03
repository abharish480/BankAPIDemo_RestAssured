package com.api.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
	

     //Private constructor to enforce usage of Builder
//    private ProfileRequest(Builder builder) {
//        this.firstName = builder.firstName;
//        this.lastName = builder.lastName;
//        this.email = builder.email;
//        this.mobileNumber = builder.mobileNumber;
//    }
//
//    // Getters
//    public String getFirstName() {
//        return firstName;
//    }
//    public String getLastName() {
//        return lastName;
//    }
//    public String getEmail() {
//        return email;
//    }
//    public String getMobileNumber() {
//        return mobileNumber;
//    }
//
//    // toString
//    @Override
//    public String toString() {
//        return "User{" +
//                "firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", email='" + email + '\'' +
//                ", mobileNumber='" + mobileNumber + '\'' +
//                '}';
//    }
//
//    // Static Builder class
//    public static class Builder {
//        private String firstName;
//        private String lastName;
//        private String email;
//        private String mobileNumber;
//
//        public Builder setFirstName(String firstName) {
//            this.firstName = firstName;
//            return this;
//        }
//
//        public Builder setLastName(String lastName) {
//            this.lastName = lastName;
//            return this;
//        }
//
//        public Builder setEmail(String email) {
//            this.email = email;
//            return this;
//        }
//
//        public Builder setMobileNumber(String mobileNumber) {
//            this.mobileNumber = mobileNumber;
//            return this;
//        }
//
//        public ProfileRequest build() {
//            return new ProfileRequest(this);
//        }
//    }
}

