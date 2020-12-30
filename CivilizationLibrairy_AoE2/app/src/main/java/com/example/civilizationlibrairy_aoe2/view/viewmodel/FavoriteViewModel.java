package com.example.civilizationlibrairy_aoe2.view.viewmodel;

import com.example.civilizationlibrairy_aoe2.data.entity.CivilizationEntity;
import com.example.civilizationlibrairy_aoe2.data.repository.civilization.CivilizationRepository;
import com.example.civilizationlibrairy_aoe2.view.civilization.favorite.adapter.CivilizationFavoriteItemViewModel;
import com.example.civilizationlibrairy_aoe2.view.civilization.favorite.mapper.CivilizationEntityToCivilizationFavoriteItemView;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

public class FavoriteViewModel extends ViewModel {
    private final CivilizationRepository civilizationRepository;
    private final CivilizationEntityToCivilizationFavoriteItemView civilizationEntityToCivilizationFavoriteItemView;
    private final CompositeDisposable compositeDisposable;

    public FavoriteViewModel(CivilizationRepository repo) {
        this.civilizationRepository = repo;
        this.compositeDisposable = new CompositeDisposable();
        this.civilizationEntityToCivilizationFavoriteItemView = new CivilizationEntityToCivilizationFavoriteItemView();
    }

    private MutableLiveData<List<CivilizationFavoriteItemViewModel>> favoritesCivilizations;
    private final MutableLiveData<Boolean> isDataLoad = new MutableLiveData<>();
    private final MutableLiveData<Event<String>> civAdd = new MutableLiveData<>();
    private final MutableLiveData<Event<String>> civRem = new MutableLiveData<>();

    /**
     * Event when use a addCivilizationToFavoriteDatabase
     * @return :
     */
    public MutableLiveData<Event<String>> getCivAdd() {
        return civAdd;
    }

    /**
     * Event when use removeCivilizationToFavoriteDatabase
     * @return :
     */
    public MutableLiveData<Event<String>> getCivRem() {
        return civRem;
    }

    /**
     * Get favorites civilizations in database
     * @return : all favorites
     */
    public MutableLiveData<List<CivilizationFavoriteItemViewModel>> getFavoritesCivilizations() {
        isDataLoad.setValue(true);
        if (favoritesCivilizations == null) {
            favoritesCivilizations = new MutableLiveData<>();
            compositeDisposable.add(civilizationRepository.getAllFavoriteCivilizations()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new ResourceSubscriber<List<CivilizationEntity>>() {

                        @Override
                        public void onNext(List<CivilizationEntity> civilizationEntities) {
                            isDataLoad.setValue(false);
                            favoritesCivilizations.setValue(civilizationEntityToCivilizationFavoriteItemView.map(civilizationEntities));
                            System.out.println("BIND FAVORITES");
                        }

                        @Override
                        public void onError(Throwable e) {
                            e.printStackTrace();
                            isDataLoad.setValue(false);
                        }

                        @Override
                        public void onComplete() {
                            //Do Nothing
                            isDataLoad.setValue(false);
                        }
                    }));

        }
        return favoritesCivilizations;
    }

    /**
     * Get a specific favorite civilization
     * @param id : specific id to retrieve the civilization
     * @return : a civilization
     */
    public Single<CivilizationEntity> getAFavoriteCivilization(final String id){
        return civilizationRepository.getAFavoriteCivilization(id);
    }

    /**
     * Add a civilization to favorite
     * @param civilizationEntity : civilization to add
     */
    public void addCivilizationToFavoriteDatabase(final CivilizationEntity civilizationEntity) {
        compositeDisposable.add(civilizationRepository.addCivilizationToFavoriteDatabase(civilizationEntity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        civAdd.setValue(new Event<>(civilizationEntity.getId()));
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                }));
    }

    /**
     * Remove a civilization to favorite
     * @param id : id'civilization to remove
     */
    public void removeCivilizationToFavoriteDatabase(final String id) {
        compositeDisposable.add(civilizationRepository.deleteCivilizationToFavoriteDatabaseWithThisId(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        civRem.setValue(new Event<>(id));
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                }));
    }
}
