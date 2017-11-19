package id.devroom.score;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.setting) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void add3PointForTeamA(View view) {
        scoreTeamA += 3;
        displayPointForTeamA(scoreTeamA);
    }

    public void add2PointForTeamA(View view) {
        scoreTeamA += 2;
        displayPointForTeamA(scoreTeamA);
    }

    public void addPointForTeamA(View view) {
        scoreTeamA += 1;
        displayPointForTeamA(scoreTeamA);
    }

    public void add3PointForTeamB(View view) {
        scoreTeamB += 3;
        displayPointForTeamB(scoreTeamB);
    }

    public void add2PointForTeamB(View view) {
        scoreTeamB += 2;
        displayPointForTeamB(scoreTeamB);
    }

    public void addPointForTeamB(View view) {
        scoreTeamB += 1;
        displayPointForTeamB(scoreTeamB);
    }

    public void displayPointForTeamA(int score) {
        TextView scoreTeamATextView = findViewById(R.id.scoreTeamATextView);
        scoreTeamATextView.setText(String.valueOf(score));
    }

    public void displayPointForTeamB(int score) {
        TextView scoreTeamBTextView = findViewById(R.id.scoreTeamBTextView);
        scoreTeamBTextView.setText(String.valueOf(score));
    }

    public void resetScore(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayPointForTeamA(0);
        displayPointForTeamB(0);
    }
}
