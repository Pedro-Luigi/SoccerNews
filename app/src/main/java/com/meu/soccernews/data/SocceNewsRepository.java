package com.meu.soccernews.data;

import androidx.room.Room;

import com.google.gson.internal.LazilyParsedNumber;
import com.meu.soccernews.App;
import com.meu.soccernews.data.local.SoccerNewsDb;
import com.meu.soccernews.data.remote.SoccerNewsApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SocceNewsRepository {

    //region Constantes
    private static final String REMOTE_API_URL = "https://pedro-luigi.github.io/soccer-news-api/";
    private static final String LOCAL_DB_NAME = "soccer-news";
    //endregion

    //region Atributos: encapsulam o acesso a nossa API (Retrofit) e banco de dados local (Room).
    private SoccerNewsApi remoteApi;
    private SoccerNewsDb localDb;

    public SoccerNewsApi getRemoteApi() {
        return remoteApi;
    }

    public SoccerNewsDb getLocalDb() {
        return localDb;
    }
    //endregion

    //region Singleton: garante uma instância única dos atributos relacionados ao Retrofit e Room.
    private SocceNewsRepository (){
        remoteApi = new Retrofit.Builder()
                .baseUrl(REMOTE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SoccerNewsApi.class);

        localDb = Room.databaseBuilder(App.getInstance(), SoccerNewsDb.class, LOCAL_DB_NAME).build();
    }

    public static SocceNewsRepository getInstance(){
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final SocceNewsRepository INSTANCE = new SocceNewsRepository();
    }
    //endregion
}
