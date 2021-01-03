package com.example.civilizationlibrairy_aoe2.data.di;

import android.annotation.SuppressLint;
import android.content.Context;

import com.example.civilizationlibrairy_aoe2.R;
import com.example.civilizationlibrairy_aoe2.data.api.service.AoE2Service;
import com.example.civilizationlibrairy_aoe2.data.db.ProjectDatabase;
import com.example.civilizationlibrairy_aoe2.data.repository.civilization.CivilizationRepository;
import com.example.civilizationlibrairy_aoe2.data.repository.civilization.local.CivilizationLocalDataSource;
import com.example.civilizationlibrairy_aoe2.data.repository.civilization.remote.CivilizationRemoteDataSource;
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
    /* request */
    private static AoE2Service aoE2Service;

    /* use to make your request */
    private static Retrofit retrofit;

    /* use to transform Json response to Java object */
    private static Gson gson;

    /* use to realize request (on local or to remote information from API) */
    private static CivilizationRepository civilizationRepository;

    /* use to create civilizationRepository */
    private static ProjectDatabase projectDatabase;

    /* application context */
    @SuppressLint("StaticFieldLeak")
    private static Context applyContext;

    /* use to create the good ViewModel -> Home or Favorite according to your need*/
    private static ViewModelFactory viewModelFactory;

    public static ViewModelFactory getViewModelFactory(){
        if(viewModelFactory == null){
            String[] urls_civilization = applyContext.getResources().getStringArray(R.array.url_civilization);
            viewModelFactory = new ViewModelFactory(getCivilizationRepository(), Arrays.asList(urls_civilization));
        }
        return viewModelFactory;
    }

    public static CivilizationRepository getCivilizationRepository(){
        if(civilizationRepository == null){
            civilizationRepository = new CivilizationRepository(new CivilizationLocalDataSource(getProjectDatabase()), new CivilizationRemoteDataSource(getAoE2Service()));
        }
        return civilizationRepository;
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
