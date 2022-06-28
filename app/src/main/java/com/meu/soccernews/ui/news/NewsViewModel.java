package com.meu.soccernews.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.meu.soccernews.domain.News;

import java.util.ArrayList;
import java.util.List;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public NewsViewModel() {
        this.news = new MutableLiveData<>();

        //TODO: REMOVER NOTICIAS MOCKADAS;
        List<News> news = new ArrayList<>();
        news.add(new News("São Paulo vence a Ferroviária no Brasileirão Feminino", "Com gol único de Shashá, Tricolor derrotou a Ferroviária e confirmou a classificação com 100% de aproveitamento"));
        news.add(new News("Brasileiro Feminino: Internacional e Corinthians empatam em 1 a 1", "Com o resultado as Gurias Coloradas permanecem na ponta da classificação, agora com 30 pontos. Já o Timão ficou na 4ª posição com 28 pontos."));
        news.add(new News("Pia convoca seleção para a Copa América de futebol feminino", "A técnica sueca Pia Sundhage divulgou nesta segunda-feira (6) a relação de convocadas para a edição 2022 da Copa América de futebol feminino, que será disputada entre os dias 8 e 30 de julho nas cidades colombianas de Armenia, Cali e Bucaramanga."));

        this.news.setValue(news);
    }

    public LiveData<List<News>> getNews() {
        return news;
    }
}