package com.example.splitwise.core;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Address implements Serializable {
    String street;
    int houseNo;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Person implements Cloneable, Serializable {
    Address address;
    String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class DeepCopy {

    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("mark street", 1);
        Person person = new Person(address, "mark");

        Person copiedPerson = (Person) person.clone();
        copiedPerson.address.setStreet("sadiq");
        System.out.println(person.address.getStreet()); // this will print sadiq

        Person deepCopiedPerson = (Person) SerializationUtils.clone(person);

        deepCopiedPerson.address.setStreet("lastest");
        System.out.println(person.address.getStreet()); // this will still print sadiq

    }
}
