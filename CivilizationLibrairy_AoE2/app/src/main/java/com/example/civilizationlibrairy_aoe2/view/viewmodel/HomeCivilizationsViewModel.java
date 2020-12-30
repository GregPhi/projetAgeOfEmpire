package com.example.civilizationlibrairy_aoe2.view.viewmodel;

import com.example.civilizationlibrairy_aoe2.data.api.list.CivilizationsList;
import com.example.civilizationlibrairy_aoe2.data.api.object.Civilization;
import com.example.civilizationlibrairy_aoe2.data.api.object.Unit;
import com.example.civilizationlibrairy_aoe2.data.entity.UnitEntity;
import com.example.civilizationlibrairy_aoe2.data.repository.civilization.CivilizationRepository;
import com.example.civilizationlibrairy_aoe2.data.repository.unit.UnitRepository;
import com.example.civilizationlibrairy_aoe2.data.repository.unit.mapper.UnitToUnitEntity;
import com.example.civilizationlibrairy_aoe2.view.civilization.home_all.adapter.CivilizationHomeItemViewModel;
import com.example.civilizationlibrairy_aoe2.view.civilization.home_all.mapper.CivilizationToCivilizationHomeItemViewModel;

import java.util.List;
import java.util.concurrent.ExecutionException;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class HomeCivilizationsViewModel extends ViewModel {
    private final CivilizationRepository civilizationRepository;
    private final UnitRepository unitRepository;
    private final CompositeDisposable compositeDisposable;
    private final CivilizationToCivilizationHomeItemViewModel civilizationToCivilizationHomeItemViewModel;
    private final UnitToUnitEntity unitToUnitEntity;
    private final MutableLiveData<List<CivilizationHomeItemViewModel>> civilizations = new MutableLiveData<>();
    private final MutableLiveData<CivilizationHomeItemViewModel> civilizationA = new MutableLiveData<>();
    private final MutableLiveData<UnitEntity> aUnit = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isDataLoad = new MutableLiveData<>();
    private final List<String> urls_civilization;

    public HomeCivilizationsViewModel(CivilizationRepository repo, UnitRepository unitRepository,List<String> urlC, List<String> urlU) {
        this.civilizationRepository = repo;
        this.unitRepository = unitRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.civilizationToCivilizationHomeItemViewModel = new CivilizationToCivilizationHomeItemViewModel();
        this.urls_civilization = urlC;
        this.unitToUnitEntity = new UnitToUnitEntity(urlU);
    }

    // --> Get all civilizations

    /**
     * Get all civilizations retrieve
     * @return : all civilizations
     */
    public MutableLiveData<List<CivilizationHomeItemViewModel>> getCivilizations() {
        return civilizations;
    }

    /**
     * Remote all civilizations
     */
    public void getAllCivilizations(){
        isDataLoad.postValue(true);
        compositeDisposable.clear();
        compositeDisposable.add(civilizationRepository.getAllCivilizations()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<CivilizationsList>() {
                    @Override
                    public void onSuccess(CivilizationsList civilizationsList) {
                        civilizations.setValue(civilizationToCivilizationHomeItemViewModel.map(civilizationsList.getCivilizationList(),urls_civilization));
                        isDataLoad.setValue(false);
                    }
                    @Override
                    public void onError(Throwable e) {
                        isDataLoad.setValue(false);
                        e.printStackTrace();
                    }
                }));
    }

    // --> Get a specific civilization

    /**
     * Get a specific civilization retrieve
     * @return : specific civilization
     */
    public MutableLiveData<CivilizationHomeItemViewModel> getACivilizations() {
        return civilizationA;
    }

    /**
     * Remote a specific civilization on using <code>id</code>
     * @param id : specific civilization's id
     */
    public void getACivilization(String id){
        isDataLoad.postValue(true);
        compositeDisposable.clear();
        compositeDisposable.add(civilizationRepository.getACivilization(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<Civilization>() {
                    @Override
                    public void onSuccess(Civilization civilization) {
                        civilizationA.setValue(civilizationToCivilizationHomeItemViewModel.map(civilization,urls_civilization));
                        isDataLoad.setValue(false);
                    }
                    @Override
                    public void onError(Throwable e) {
                        isDataLoad.setValue(false);
                    }
                }));
    }

    // --> Get a specific unit

    /**
     * Get the unit remote
     * @return : unit to observe
     */
    public MutableLiveData<UnitEntity> getUnit() {
        return aUnit;
    }

    /**
     * Get a unit with url_api
     * @param url_api : a specific url_api
     * @return : a UnitEntity
     * @throws ExecutionException :
     * @throws InterruptedException :
     */
    public UnitEntity getAUnit(String url_api) throws ExecutionException, InterruptedException {
        return unitRepository.getAUnit(url_api);
    }

    /**
     * Search a specific unit
     * @param id : id or name of a specific unit to remote
     * @return : specific unit
     */
    public Single<Unit> searchAnUnit(final String id){
        return unitRepository.searchAnUnit(id);
    }

    /**
     * Add a unit to database
     * @param unitEntity : a unit to add to the database
     */
    public void addUnitToDatabase(final UnitEntity unitEntity){
        unitRepository.addUnitToDatabase(unitEntity);
    }
}
