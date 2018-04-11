package me.kamili.rachid.restclientapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import me.kamili.rachid.restclientapp.model.GitHubProfile;
import me.kamili.rachid.restclientapp.utils.Constants;

public class ProfileActivity extends AppCompatActivity {

    private GitHubProfile gitHubProfile;

    private ImageView imageProfile;
    private TextView nameProfile;
    private TextView repoNumber;
    private TextView createdAt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        String profileJson = getIntent().getStringExtra(Constants.PROFILE_JSON);

        if (profileJson != null) {
            gitHubProfile = new Gson().fromJson(profileJson, GitHubProfile.class);
            bindViews();
            setDataToViews();
        }

    }

    private void bindViews() {
        imageProfile = findViewById(R.id.imageProfile);
        nameProfile = findViewById(R.id.nameProfile);
        repoNumber = findViewById(R.id.repoNumber);
        createdAt = findViewById(R.id.createdAt);
    }

    private void setDataToViews() {
        nameProfile.setText(gitHubProfile.getName() != null ? gitHubProfile.getName() : gitHubProfile.getLogin());
        repoNumber.setText(String.valueOf(gitHubProfile.getPublicRepos()));
        createdAt.setText(gitHubProfile.getCreatedAt());
        Glide.with(this).load(gitHubProfile.getAvatarUrl()).into(imageProfile);
    }

    public void showRepositories(View view) {
        // TODO: 4/10/2018 starting repositories activity
    }
}