package com.meu.soccernews.ui.favorites;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.meu.soccernews.data.SocceNewsRepository;
import com.meu.soccernews.domain.News;

import java.util.List;

public class FavoritesViewModel extends ViewModel {

    public FavoritesViewModel() {
        loadFavoriteNews();
    }

    public LiveData<List<News>> loadFavoriteNews() {
        return SocceNewsRepository.getInstance().getLocalDb().newsDao().loadFavoriteNews();
    }
    public void saveNews(News news){
        AsyncTask.execute(() -> SocceNewsRepository.getInstance().getLocalDb().newsDao().save(news));
    }


}