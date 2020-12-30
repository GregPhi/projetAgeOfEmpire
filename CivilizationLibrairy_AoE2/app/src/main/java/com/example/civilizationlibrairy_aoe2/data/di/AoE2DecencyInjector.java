package com.example.civilizationlibrairy_aoe2.data.di;

import android.content.Context;

import com.example.civilizationlibrairy_aoe2.R;
import com.example.civilizationlibrairy_aoe2.data.api.service.AoE2Service;
import com.example.civilizationlibrairy_aoe2.data.db.ProjectDatabase;
import com.example.civilizationlibrairy_aoe2.data.repository.civilization.CivilizationRepository;
import com.example.civilizationlibrairy_aoe2.data.repository.civilization.local.CivilizationLocalDataSource;
import com.example.civilizationlibrairy_aoe2.data.repository.civilization.mapper.CivilizationToCivilizationEntityMapper;
import com.example.civilizationlibrairy_aoe2.data.repository.civilization.remote.CivilizationRemoteDataSource;
import com.example.civilizationlibrairy_aoe2.data.repository.unit.UnitRepository;
import com.example.civilizationlibrairy_aoe2.data.repository.unit.local.UnitLocalDataSource;
import com.example.civilizationlibrairy_aoe2.data.repository.unit.remote.UnitRemoteDataSource;
import com.example.civilizationlibrairy_aoe2.view.viewmodel.ViewModelFactory;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;

import java.util.Arrays;

import androidx.room.Room;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class AoE2DecencyInjector {
    private static AoE2Service aoE2Service;
    private static Retrofit retrofit;
    private static Gson gson;
    private static CivilizationRepository civilizationRepository;
    private static UnitRepository unitRepository;
    private static ProjectDatabase projectDatabase;
    private static Context applyContext;
    private static ViewModelFactory viewModelFactory;

    public static ViewModelFactory getViewModelFactory(){
        if(viewModelFactory == null){
            String[] urls_civilization = applyContext.getResources().getStringArray(R.array.url_civilization);
            String[] urls_units = applyContext.getResources().getStringArray(R.array.url_unit);
            viewModelFactory = new ViewModelFactory(getCivilizationRepository(), getUnitRepository(), Arrays.asList(urls_civilization), Arrays.asList(urls_units));
        }
        return viewModelFactory;
    }

    public static CivilizationRepository getCivilizationRepository(){
        if(civilizationRepository == null){
            String[] urls_civilization = applyContext.getResources().getStringArray(R.array.url_civilization);
            civilizationRepository = new CivilizationRepository(new CivilizationLocalDataSource(getProjectDatabase()), new CivilizationRemoteDataSource(getAoE2Service()), new CivilizationToCivilizationEntityMapper(Arrays.asList(urls_civilization)));
        }
        return civilizationRepository;
    }

    public static UnitRepository getUnitRepository(){
        if(unitRepository == null){
            unitRepository = new UnitRepository(new UnitLocalDataSource(getProjectDatabase()), new UnitRemoteDataSource(getAoE2Service()));
        }
        return unitRepository;
    }

    public static AoE2Service getAoE2Service(){
        if(aoE2Service == null){
            aoE2Service = getRetrofit().create(AoE2Service.class);
        }
        return aoE2Service;
    }

    public static Retrofit getRetrofit() {
        if(retrofit == null){
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor)
                    .addNetworkInterceptor(new StethoInterceptor())
                    .build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(AoE2Service.URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(getGson()))
                    .build();
        }
        return retrofit;
    }

    public static Gson getGson() {
        if(gson == null){
            gson = new Gson();
        }
        return gson;
    }

    public static void setContext(Context context) {
        applyContext = context;
    }

    public static ProjectDatabase getProjectDatabase(){
        if(projectDatabase == null){
            projectDatabase = Room.databaseBuilder(applyContext, ProjectDatabase.class,"civilizations-database").build();
        }
        return projectDatabase;
    }
}
