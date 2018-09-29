package com.tavares.tablet.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.tavares.tablet.model.Receitas;
import com.tavares.tablet.util.QueryUtils;

import java.util.List;

public class ReceitasLoader extends AsyncTaskLoader<List<Receitas>> {
  private final String url;

  public ReceitasLoader(Context context, String url) {
      super(context);
      this.url = url;
  }

  @Override
  protected void onStartLoading() {
      forceLoad();
  }

  @Override
  public List<Receitas> loadInBackground() {
      if (url.length() < 1) {
          return null;
      }
      return QueryUtils.fetchNewsData(url);
  }
}