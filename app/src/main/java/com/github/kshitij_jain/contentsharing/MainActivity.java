package com.github.kshitij_jain.contentsharing;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Share Text Content
    public void shareTextOnClick(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "Share Text");
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent, "Share Text Via"));
    }

    // Share Binary Content
    public void shareBinaryOnClick(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        // Pass URI In Put Extras
        // Use Content Provider Or Media Store With Correct Permissions
        // intent.putExtra(Intent.EXTRA_STREAM, Uri.parse(R.mipmap.ic_launcher));
        intent.setType("image/jpeg");
        startActivity(Intent.createChooser(intent, "Share Image Via"));
    }

    // Share Multiple Pieces of Content
    public void shareMultiplePieces(View view) {
        ArrayList<Uri> uris = new ArrayList<>();
        uris.add(Uri.parse("Data 1"));
        uris.add(Uri.parse("Data 2"));
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND_MULTIPLE);
        intent.putParcelableArrayListExtra(Intent.EXTRA_TEXT, uris);
        intent.setType("image/*");
        startActivity(Intent.createChooser(intent, "Share images to.."));
    }
}
