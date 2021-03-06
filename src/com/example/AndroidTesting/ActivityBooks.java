package com.example.AndroidTesting;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;
import android.widget.SearchView;
import com.example.AndroidTesting.adapters.BookAdapter;

public class ActivityBooks extends Activity implements SearchView.OnQueryTextListener {

    private ListView booksListView;
    private BookAdapter bookAdapter;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        bookAdapter = new BookAdapter(getApplicationContext());
        booksListView = (ListView) findViewById(R.id.ActivityBooks_List);
        booksListView.setAdapter(bookAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_myactivity, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setOnQueryTextListener(this);
        searchView.setSubmitButtonEnabled(false);
        searchView.setQueryHint("Title");
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        bookAdapter.getFilter().filter(newText);
        return true;
    }
}
