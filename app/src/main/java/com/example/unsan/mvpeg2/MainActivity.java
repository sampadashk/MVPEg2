package com.example.unsan.mvpeg2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity implements MainInterface {
    TextView textView;
    Button button;
    ProgressBar progressBar;
    MainPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        presenter = new MainPresenterImpl(this, new GetQuoteInteractorImpl());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonClick();
            }
        });

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.INVISIBLE);

    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(GONE);
        textView.setVisibility(View.VISIBLE);

    }

    @Override
    public void setQuote(String quote) {
        textView.setText(quote);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

}
