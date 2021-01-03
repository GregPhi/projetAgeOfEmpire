package com.example.civilizationlibrairy_aoe2.view.viewmodel;

import com.example.civilizationlibrairy_aoe2.data.api.list.CivilizationsList;
import com.example.civilizationlibrairy_aoe2.data.api.object.Civilization;
import com.example.civilizationlibrairy_aoe2.data.repository.civilization.CivilizationRepository;
import com.example.civilizationlibrairy_aoe2.view.civilization.home_all.adapter.CivilizationHomeItemViewModel;
import com.example.civilizationlibrairy_aoe2.view.civilization.home_all.mapper.CivilizationToCivilizationHomeItemViewModel;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class HomeCivilizationsViewModel extends ViewModel {
    private final CivilizationRepository civilizationRepository;
    private final CompositeDisposable compositeDisposable;
    private final CivilizationToCivilizationHomeItemViewModel civilizationToCivilizationHomeItemViewModel;
    private final MutableLiveData<List<CivilizationHomeItemViewModel>> civilizations = new MutableLiveData<>();
    private final MutableLiveData<CivilizationHomeItemViewModel> civilizationA = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isDataLoad = new MutableLiveData<>();
    private final List<String> urls_civilization;

    public HomeCivilizationsViewModel(CivilizationRepository repo,List<String> urlC) {
        this.civilizationRepository = repo;
        this.compositeDisposable = new CompositeDisposable();
        this.civilizationToCivilizationHomeItemViewModel = new CivilizationToCivilizationHomeItemViewModel();
        this.urls_civilization = urlC;
    }

    // --> Get all civilizations

    /**
     * Remote all civilizations
     * @return : all civilizations
     */
    public MutableLiveData<List<CivilizationHomeItemViewModel>> getAllCivilizations(){
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
        return civilizations;
    }

    // --> Get a specific civilization

    /**
     * Remote a specific civilization on using <code>id</code>
     * @param id : specific civilization's id
     * @return : specific civilization
     */
    public MutableLiveData<CivilizationHomeItemViewModel> getACivilization(String id){
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
        return civilizationA;
    }
}
