package com.zipcodewilmington.streams.conversions;

import com.zipcodewilmington.streams.anthropoid.Person;
import com.zipcodewilmington.streams.anthropoid.PersonFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by leon on 5/25/17.
 */
public final class ArrayConverter extends PersonConversionAgent<Person[]> {
    Person[] arr;
    public ArrayConverter(Person... people) {

        super(people);
        this.arr=people;
    }

    public ArrayConverter(int collectionSize) {
        this(Stream
                .generate(new PersonFactory()::createRandomPerson)
                .limit(collectionSize)
                .toArray(Person[]::new));
    }

    //TODO
    public List<Person> toList() {
        List<Person> list= new ArrayList();
        IntStream.rangeClosed(0,arr.length).forEach(i->list.add(arr[i]));



        return list;
    }

    //TODO
    public Stream<Person> toStream() {
        return null;
    }

    @Override
    public Person[] toArray() {
        return super.objectSequence;
    }
}
