package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bonds;

import java.util.List;

public interface IDogsService
{
    public List<Bonds> getAllDogs();

    public Bonds addDog(Bonds theBonds);

    public long getNoOfDogs();

    public boolean removeDog(long uniqueId);

    public Bonds getDogById(long uniqueId);

    public Bonds getDogByName(String dogsName );

    public Bonds updateDogDetails(Bonds bondsToUpdate);
}
