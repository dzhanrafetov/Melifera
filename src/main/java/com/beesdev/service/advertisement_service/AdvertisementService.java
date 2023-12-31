package com.beesdev.service.advertisement_service;

import com.beesdev.dto.advertisement_dtos.advertisement_dto.*;
import com.beesdev.dto.advertisement_dtos.advertisement_dto.advertisement_dto_converters.AdvertisementDtoConverter;
import com.beesdev.dto.advertisement_dtos.advertisement_dto.advertisement_dto_converters.AdvertisementUserDtoConverter;
import com.beesdev.dto.advertisement_dtos.advertisement_dto.advertisement_dto_requests.CreateAdvertisementRequest;
import com.beesdev.dto.advertisement_dtos.advertisement_dto.advertisement_dto_requests.UpdateAdvertisementRequest;
import com.beesdev.model.advertisement_model.Advertisement;
import com.beesdev.model.advertisement_model.Category;
import com.beesdev.repository.advertisement_repository.AdvertisementRepository;
import com.beesdev.exception.AdvertisementNotArchivedException;
import com.beesdev.exception.NotFoundException;
import com.beesdev.exception.UserNotActiveException;
import com.beesdev.model.user_model.User;
import com.beesdev.service.user_service.UserService;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.List;

@Service
public class AdvertisementService {


    private  final AdvertisementRepository repository;
    private final AdvertisementDtoConverter converter;
    private final AdvertisementUserDtoConverter advertisementUserDtoConverter;

    private final UserService userService;
    private final CategoryService categoryService;

    public AdvertisementService(AdvertisementRepository advertisementRepository,
                                AdvertisementDtoConverter converter,
                                AdvertisementUserDtoConverter advertisementUserDtoConverter,
                                UserService userService,
                                CategoryService categoryService) {
        this.repository = advertisementRepository;
        this.converter = converter;
        this.advertisementUserDtoConverter = advertisementUserDtoConverter;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    public AdvertisementDto createAdvertisement(CreateAdvertisementRequest request) {
        User user = userService.findUserById(userService.getCurrentUser().getId());

        Category category = categoryService.findCategoryById(request.getCategoryId());

        if (user.getActive()) {
            Advertisement advertisement =
                    new Advertisement(
                            request.getTitle(),
                            request.getDescription(),
                            request.getPrice(),
                            getLocalDateTimeNow(),
                            getLocalDateTimeNow(),
                            false,
                            user,
                            category);

            return converter.convert(repository.save(advertisement));
        } else {

        throw new UserNotActiveException("You can't create advertisement when your account is not activated!");
    }
    }



    public List<AdvertisementDto> getAdvertisements() {
        return converter.convert(repository.findAll());
    }

    public List<AdvertisementUserDto> getAdvertisementsUser() {
        return advertisementUserDtoConverter.convert(repository.findAll());
    }

    public List<AdvertisementDto>getActiveAdvertisements() {
        return converter.convert(repository.findByIsArchivedFalse());
    }
    public List<AdvertisementUserDto>getActiveAdvertisementsUser() {
        return advertisementUserDtoConverter.convert(repository.findByIsArchivedFalse());
    }


    public List<AdvertisementUserDto>getArchivedAdvertisementsUser() {
        return advertisementUserDtoConverter.convert(repository.findByIsArchivedTrue());
    }


    public List<AdvertisementUserDto> getActiveAdvertisementsByCategoryIdV1(Long categoryId) {
        return advertisementUserDtoConverter.convert(repository.findByIsArchivedFalseAndCategoryId(categoryId));
    }

    //tuka sum
    public List<AdvertisementDto>getActiveAdvertisementsAddedByUser() {
        User user = userService.findUserById(userService.getCurrentUser().getId());
        return converter.convert(repository.
                findByIsArchivedFalseAndUserId(user.getId()));
    }

    public List<AdvertisementDto>getArchivedAdvertisementsAddedByUser() {
        User user = userService.findUserById(userService.getCurrentUser().getId());
        return converter.convert(repository.
                findByIsArchivedTrueAndUserId(user.getId()));
    }
    public AdvertisementDto updateAdvertisement(String id, UpdateAdvertisementRequest request) {

        User user = userService.findUserById(userService.getCurrentUser().getId());
        Advertisement advertisement=findAdvertisementByIdAndUser(id,user.getId());

        Category category= categoryService.findCategoryById(advertisement.getCategory().getId());
        Advertisement updateAdvertisement =
                new Advertisement(
                        advertisement.getId(),
                        request.getTitle(),
                        request.getDescription(),
                        request.getPrice(),
                        advertisement.getCreationDate(),
                        getLocalDateTimeNow(),
                        advertisement.getArchived(),
                        user,
                        category);
        return converter.convert(repository.save(updateAdvertisement));
    }

    public Advertisement findAdvertisementByIdAndUser(String id,Long user_id) {
        return repository.findAdvertisementByIdAndUserId(id,user_id)
                .orElseThrow(() ->
                        new NotFoundException
                                ("Advertisement couldn't found by id:  " + id));
    }




    public AdvertisementDto deleteAdvertisement(String id) {
        Advertisement advertisement = findAdvertisementById(id);
        if (advertisement.getArchived()) {
            repository.deleteById(id);
        } else {
            throw new
    AdvertisementNotArchivedException("You can't delete advertisement" +
                    " when the advertisement is not archived !");

        }
        return null;
    }

    public Advertisement findAdvertisementById(String id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException
                                ("Advertisement couldn't found by id:  " + id));
    }



    public List<Advertisement> findAdvertisementUserById(Long id) {
        return repository.findAdvertisementByUserId(id);
    }

    public List<AdvertisementDto> getAdvertisementsAddedByUser() {
        return   converter.convert(findAdvertisementUserById
                (userService.getCurrentUser().getId()));

    }

    public List<AdvertisementUserDto> getAdvertisementAddedByUser_V2() {
        return   advertisementUserDtoConverter.convert(findAdvertisementUserById
                (userService.getCurrentUser().getId()));

    }
    public AdvertisementDto getAdvertisementById(String id) {
        Advertisement advertisement=findAdvertisementById(id);
        return converter.convert(advertisement);
    }


    public AdvertisementUserDto getAdvertisementUserById(String id) {
        Advertisement advertisement=findAdvertisementById(id);
        return advertisementUserDtoConverter.convert(advertisement);
    }

    private LocalDateTime getLocalDateTimeNow() {
        return LocalDateTime.now();
    }




    public AdvertisementUserDto archiveAdvertisement(String adv_id) {
        Advertisement advertisement=findAdvertisementById(adv_id);

        changeArchiveAdvertisement(advertisement.getUser().getId(),adv_id, true);
        return null;
    }



    public AdvertisementDto activateAdvertisement(String adv_id) {
        Advertisement advertisement=findAdvertisementById(adv_id);

        changeArchiveAdvertisement(advertisement.getUser().getId(),adv_id, false);

        return null;
    }

    public AdvertisementUserDto archiveAdvertisementByUser(String adv_id) {
        User user = userService.findUserById(userService.getCurrentUser().getId());
        return changeArchiveAdvertisement(user.getId(), adv_id, true);

    }

//send email to admin
//    public void activateAdvertisementByUser(String adv_id) {
//        User user = userService.findUserById(userService.getCurrentUser().getId());
//        changeArchiveAdvertisement(user.getId(),adv_id, false);
//    }
    public AdvertisementUserDto changeArchiveAdvertisement(Long user_id,String adv_id, Boolean archived) {
        Advertisement advertisement=findAdvertisementByIdAndUser(adv_id,user_id);

        Advertisement archiveAdvertisement =
                new Advertisement(
                        advertisement.getId(),
                        advertisement.getTitle(),
                        advertisement.getDescription(),
                        advertisement.getPrice(),
                        advertisement.getCreationDate(),
                        getLocalDateTimeNow(),
                        archived,
                        advertisement.getUser(),
                        advertisement.getCategory()
                        );

        return advertisementUserDtoConverter.convert(repository.save(archiveAdvertisement));

    }

//catgory id
//    public List<AdvertisementDto> getAdvertisementsByCategoryName(String categoryName) {
//        // Retrieve the Category object with the given name
//        List<Category> category = categoryService.findCategoryByName(categoryName);
//        if (category == null) {
//            // If the Category does not exist, return an empty list of DTOs
//            return new ArrayList<>();
//        }
//
//        // Retrieve the list of Advertisement entities with the given Category
//        List<Advertisement> advertisements = repository.(category);
//
//        // Convert the list of Advertisement entities to a list of AdvertisementUserDto DTOs
//        return converter.convert(advertisements);
//    }
//    public List<AdvertisementDto> getAdvertisementsByCategoryName(Category categoryName) {
//        List<Advertisement> advertisements = repository.findByCategory(categoryName);
//
//        return converter.convert(advertisements);
//    }


}









