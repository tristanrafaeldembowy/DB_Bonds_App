package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bonds;
import com.db.grad.javaapi.repository.DogsRepository;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DogsHandlerTest
{
    @Mock
    private DogsRepository itsDogsRepo;

    @InjectMocks
    private DogHandler cut;

    @Test
    public  void    add_a_dog_return_number_of_dogs_in_repo_is_one()
    {
        // arrange
        Bonds theBonds = new Bonds();
        theBonds.setName("Bruno");
        Mockito.when(itsDogsRepo.save(theBonds)).thenReturn(theBonds);
        Mockito.when(itsDogsRepo.count()).thenReturn(1L);
        cut.addDog(theBonds);

        int expectedResult = 1;

        // act
        long actualResult = cut.getNoOfDogs();

        // assert
        assertEquals( expectedResult, actualResult );
    }

    @Test
    public  void    add_several_dogs_return_number_of_dogs_match_number_added()
    {
        // arrange
        Bonds theBonds = new Bonds();
        theBonds.setName("Bruno");
        cut.addDog(theBonds);
        theBonds = new Bonds();
        theBonds.setName("Frank");
        cut.addDog(theBonds);
        theBonds = new Bonds();
        theBonds.setName("Penny");
        cut.addDog(theBonds);
        Mockito.when(itsDogsRepo.count()).thenReturn(3L);

        int expectedResult = 3;

        // act
        long actualResult = cut.getNoOfDogs();

        // assert
        assertEquals( expectedResult, actualResult );
    }

    @Ignore
    @Test
    public  void    add_dog_and_remove_dog_return_number_of_dogs_is_zero()
    {
        // arrange
        Bonds theBonds = new Bonds();
        theBonds.setName("Bruno");
        Mockito.when(itsDogsRepo.save(theBonds)).thenReturn(theBonds);
        Bonds uniqueBonds = cut.addDog(theBonds);

        Optional<Bonds> opt = Optional.of(theBonds);
        Mockito.when(itsDogsRepo.findById(theBonds.getId())).thenReturn(opt);

        long expectedResult = 0;
        boolean expectedStatus = true;

        // act
        boolean actualStatus = cut.removeDog( uniqueBonds.getId() );
        long actualResult = cut.getNoOfDogs();

        // assert
        assertEquals( expectedStatus, actualStatus);
        assertEquals( expectedResult, actualResult );
        verify(itsDogsRepo, times(1)).delete(theBonds);
    }

    // This test covers the other logic path in cut.removeDog()
    @Ignore
    @Test
    public  void    add_dog_and_remove_dog_that_doess_not_exist_return_number_of_dogs_is_one()
    {
        // arrange
        Bonds theBonds = new Bonds();
        theBonds.setName("Bruno");
        Bonds uniqueBonds = cut.addDog(theBonds);

        long invalidId = 33;
        long expectedResult = 1;
        boolean expectedStatus = false;

        Optional<Bonds> opt = Optional.empty();
        Mockito.when(itsDogsRepo.findById(invalidId)).thenReturn(opt);

        Mockito.when(itsDogsRepo.count()).thenReturn(1L);

        // act
        // There is no dog with ID == 33
        boolean actualStatus = cut.removeDog( invalidId );
        long actualResult = cut.getNoOfDogs();

        // assert
        assertEquals( expectedStatus, actualStatus);
        assertEquals( expectedResult, actualResult );
        verify(itsDogsRepo, times(0)).delete(theBonds);
    }

    @Test
    public  void    find_dog_by_valid_id_returns_one_dog()
    {
        // arrange
        Bonds theBonds = new Bonds();
        theBonds.setName("Bruno");
        cut.addDog(theBonds);
        theBonds = new Bonds();
        theBonds.setName("Frank");
        Mockito.when(itsDogsRepo.save(theBonds)).thenReturn(theBonds);
        Bonds addedBonds = cut.addDog(theBonds);
        Bonds expectedBonds = theBonds;
        theBonds = new Bonds();
        theBonds.setName("Penny");
        cut.addDog(theBonds);

        Bonds jpaBonds = addedBonds;
        Optional<Bonds> opt = Optional.of(addedBonds);
        Mockito.when(itsDogsRepo.findById(addedBonds.getId())).thenReturn(opt);

        // act
        Bonds actualResult = cut.getDogById( addedBonds.getId() );

        // assert
        assertEquals( expectedBonds.getId(), actualResult.getId() );
        assertEquals( expectedBonds.getName(), actualResult.getName() );
    }

    @Ignore
    @Test
    public  void    find_dog_by_invalid_id_returns_null_dog()
    {
        // arrange
        Bonds theBonds = new Bonds();
        theBonds.setName("Bruno");
        cut.addDog(theBonds);
        theBonds = new Bonds();
        theBonds.setName("Frank");
        cut.addDog(theBonds);
        theBonds = new Bonds();
        theBonds.setName("Penny");
        cut.addDog(theBonds);
        long invalidId = 33;

        Optional<Bonds> opt = Optional.empty();
        Mockito.when(itsDogsRepo.findById(invalidId)).thenReturn(opt);

        // act
        assertThrows(NoSuchElementException.class, () -> {
            cut.getDogById( invalidId );
        });
    }

    @Test
    public  void    find_dog_by_name_returns_one_dog()
    {
        // arrange
        Bonds theBonds = new Bonds();
        theBonds.setName("Bruno");
        cut.addDog(theBonds);
        theBonds = new Bonds();
        theBonds.setName("Frank");
        cut.addDog(theBonds);
        Bonds expectedBonds = theBonds;
        String dogToFind = "Frank";
        theBonds = new Bonds();
        theBonds.setName("Penny");
        cut.addDog(theBonds);
        ArrayList<Bonds> expectedList = new ArrayList<>();
        expectedList.add(expectedBonds);
        Mockito.when(itsDogsRepo.findByName(Mockito.any())).thenReturn(expectedList);

        // act
        Bonds actualResult = cut.getDogByName( dogToFind );

        // assert
        assertEquals( expectedBonds.getId(), actualResult.getId() );
        assertEquals( expectedBonds.getName(), actualResult.getName() );
    }


    @Test
    public  void    find_dog_by_name_returns_null_because_many_dogs_with_same_name()
    {
        // arrange
        Bonds theBonds = new Bonds();
        theBonds.setName("Bruno");
        cut.addDog(theBonds);
        theBonds = new Bonds();
        theBonds.setName("Bruno");
        cut.addDog(theBonds);
        Bonds expectedBonds = theBonds;
        String dogToFind = "Bruno";
        theBonds = new Bonds();
        theBonds.setName("Penny");
        cut.addDog(theBonds);
        ArrayList<Bonds> expectedList = new ArrayList<>();
        Mockito.when(itsDogsRepo.findByName(Mockito.any())).thenReturn(expectedList);

        // act
        Bonds actualResult = cut.getDogByName( dogToFind );

        // assert
        assertNull( actualResult );
    }

    @Test
    public  void    find_dog_by_invalid_name_returns_null_dog()
    {
        // arrange
//        DogHandler cut = new DogHandler();
        Bonds theBonds = new Bonds();
        theBonds.setName("Bruno");
        cut.addDog(theBonds);
        theBonds = new Bonds();
        theBonds.setName("Frank");
        cut.addDog(theBonds);
        theBonds = new Bonds();
        theBonds.setName("Penny");
        cut.addDog(theBonds);
        ArrayList<Bonds> expectedList = new ArrayList<>();
        Mockito.when(itsDogsRepo.findByName(Mockito.any())).thenReturn(expectedList);

        // act
        Bonds actualResult = cut.getDogByName( "Selvyn" );

        // assert
        assertNull( actualResult );
    }

    @Ignore
    @Test
    public  void    update_dog_that_exists_returns_dog_id()
    {
        // arrange
        Bonds theBonds = new Bonds();
        theBonds.setName("Bruno");
        cut.addDog(theBonds);
        theBonds = new Bonds();
        theBonds.setName("Frank");
        Mockito.when(itsDogsRepo.save(theBonds)).thenReturn(theBonds);
        Bonds expectedBonds = cut.addDog(theBonds);
        Bonds bondsToUpdate = theBonds;
        String dogToFind = "Frank";
        theBonds = new Bonds();
        theBonds.setName("Penny");
        cut.addDog(theBonds);
        Mockito.when(itsDogsRepo.save(bondsToUpdate)).thenReturn(bondsToUpdate);

        // act
        bondsToUpdate.setName("Charlie");
        Bonds actualBonds = cut.updateDogDetails(bondsToUpdate);

        // assert
        assertEquals(expectedBonds, actualBonds);
    }
}
