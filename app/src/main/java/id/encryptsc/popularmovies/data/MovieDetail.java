package id.encryptsc.popularmovies.data;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import id.encryptsc.popularmovies.R;

public class MovieDetail extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "movie";

    private Movies mMovies;
    TextView title;
    ImageView poster;
    TextView synopsis;
    TextView lang;
    TextView oriTitle;
    ImageView backdrop;
    TextView vc;
    TextView va;
    TextView rd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        if (getIntent().hasExtra(EXTRA_MOVIE)){
            mMovies = getIntent().getParcelableExtra(EXTRA_MOVIE);
        } else  {
            throw new IllegalArgumentException("Detail Activity Must Receive a Movie");
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        CollapsingToolbarLayout toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolbarLayout.setTitle(mMovies.getTitle());

        backdrop = (ImageView) findViewById(R.id.backdrop);
        title = (TextView) findViewById(R.id.movie_title);
        synopsis = (TextView) findViewById(R.id.movie_description);
        poster = (ImageView) findViewById(R.id.movie_poster);

        title.setText(mMovies.getTitle());
        synopsis.setText(mMovies.getSynopsis());
        Picasso.with(this)
                .load(mMovies.getPoster())
                .into(poster);
        Picasso.with(this)
                .load(mMovies.getBackdrop())
                .into(backdrop);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_share, menu);
        return true;
    }
}
