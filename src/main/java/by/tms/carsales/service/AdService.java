package by.tms.carsales.service;

import by.tms.carsales.entity.Ad;
import by.tms.carsales.entity.car.Car;
import by.tms.carsales.entity.car.CarModel;
import by.tms.carsales.model.AddAdModel;
import by.tms.carsales.repository.AdRepository;
import by.tms.carsales.repository.CarRepository;
import by.tms.carsales.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;

@Service
public class AdService {

    @Autowired
    private AdRepository adRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ModelRepository modelRepository;

    public void save(AddAdModel adModel) throws IOException {
        Ad newAd = new Ad();
        Car newCar = new Car();
        newCar.setNumber(adModel.getCarNumber());
        newCar.setRunKm(adModel.getRunKm());
        newCar.setVolumeOfEngine(adModel.getVolumeOfEngine());
        newCar.setYearOfMade(adModel.getYearOfMade());
        if(modelRepository.findById(adModel.modelId).isPresent()) {
            CarModel carModel = modelRepository.findById(adModel.modelId).get();
            newCar.setCarModel(carModel);
        }
        carRepository.save(newCar);
        newAd.setCar(newCar);
        newAd.setDate(LocalDate.now());
        newAd.setUser(adModel.getUser());

        byte[] bArr = adModel.getFile().getBytes();
        newAd.setFile64(Base64.getEncoder().encodeToString(bArr));

        adRepository.save(newAd);
    }

    public List<CarModel> findAllModels(){
        return modelRepository.findAll();
    }

    public List<Ad> findAllAds(){
        return adRepository.findAll();
    }
}
