package id.encryptsc.popularmovies.data;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import id.encryptsc.popularmovies.R;

public class MovieDetail extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "movie";

    private Movies mMovies;
    String movieId;
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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_detail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        CollapsingToolbarLayout toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolbarLayout.setTitle(mMovies.getTitle());

        backdrop = (ImageView) findViewById(R.id.backdrop);
        title = (TextView) findViewById(R.id.movie_title);
        synopsis = (TextView) findViewById(R.id.movie_description);
        poster = (ImageView) findViewById(R.id.movie_poster);
        oriTitle = (TextView) findViewById(R.id.origin_title);
        lang = (TextView) findViewById(R.id.language);
        va = (TextView) findViewById(R.id.vote_average);
        vc = (TextView) findViewById(R.id.vote_count);
        rd = (TextView) findViewById(R.id.release_date);

        movieId = mMovies.getId();
        title.setText(mMovies.getTitle());
        synopsis.setText(mMovies.getSynopsis());
        lang.setText(mMovies.getLang());
        oriTitle.setText(mMovies.getOriginalTitle());
        va.setText(mMovies.getVa());
        vc.setText(mMovies.getVc());
        rd.setText(mMovies.getRd());
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
    private void shareMovie(String textToShare) {
        String mimeType = "text/plain";
        String title = "Share This Movie";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(title)
                .setText(textToShare)
                .startChooser();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_share){
            String message = "I Was Read a Popular Movie, See Detail at https://www.themoviedb.org/movie/"+movieId;
            shareMovie(message);
        }

        return super.onOptionsItemSelected(item);
    }
}
