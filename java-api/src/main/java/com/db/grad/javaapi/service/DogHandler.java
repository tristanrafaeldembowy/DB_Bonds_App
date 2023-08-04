package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bonds;
import com.db.grad.javaapi.repository.DogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogHandler implements IDogsService
{
    private DogsRepository itsDogsRepo;

    @Autowired
    public DogHandler( DogsRepository dogRepo )
    {
        itsDogsRepo = dogRepo;
    }

    @Override
    public List<Bonds> getAllDogs()
    {
        return itsDogsRepo.findAll();
    }

    @Override
    public Bonds addDog(Bonds theBonds)
    {
        return itsDogsRepo.save(theBonds);
    }

    @Override
    public long getNoOfDogs()
    {
        return itsDogsRepo.count();
    }

    @Override
    public boolean removeDog(long uniqueId)
    {
        boolean result = false;

        Optional<Bonds> theDog = itsDogsRepo.findById(uniqueId);
        if(theDog.isPresent())
        {
            itsDogsRepo.delete(theDog.get());
            result = true;
        }

        return  result;
    }

    @Override
    public Bonds getDogById(long uniqueId)
    {
        return itsDogsRepo.findById(uniqueId).get();
    }

    @Override
    public Bonds getDogByName(String dogsName )
    {
        Bonds bondsToFind = new Bonds();
        bondsToFind.setName(dogsName);
        List<Bonds> bonds = itsDogsRepo.findByName(bondsToFind);
        Bonds result = null;

        if( bonds.size() == 1)
            result = bonds.get(0);

        return result;
    }

    @Override
    public Bonds updateDogDetails(Bonds bondsToUpdate)
    {
        return itsDogsRepo.save(bondsToUpdate);
    }
}
